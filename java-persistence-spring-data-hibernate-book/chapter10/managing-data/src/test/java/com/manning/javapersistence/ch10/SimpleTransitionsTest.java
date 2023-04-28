package com.manning.javapersistence.ch10;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnitUtil;

import static org.junit.jupiter.api.Assertions.*;

public class SimpleTransitionsTest {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("ch10");

    @Test
    public void makePersistent() {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Item item = new Item("item 1");
            em.persist(item);
            em.detach(item);
            System.out.println(item.getId());
            em.getTransaction().commit();


        } catch (Exception e) {
            em.getTransaction().rollback();
            em.close();
            throw e;
        }


        EntityManager em1 = emf.createEntityManager();
        try {
            em1.getTransaction().begin();
            Item item = em1.find(Item.class, 1L);
            item.setName("entity2");
            em1.getTransaction().commit();


        } catch (Exception e) {
            em1.getTransaction().rollback();
            em1.close();
            throw e;
        }


    }

    @Test
    public void retrievePersistent() {
        Item item = new Item("some item");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(item);
        em.getTransaction().commit();
        em.close();

        em = emf.createEntityManager();
        em.getTransaction().begin();
        Item item1 = em.find(Item.class, 1L);
        Item item2 = em.find(Item.class, 1L);

        assertEquals(item1, item2);
        assertSame(item1, item2);
        assertEquals(item1.getId(), item1.getId());
        em.getTransaction().commit();
        em.close();
    }

    @Test
    public void retrievePersistentReference() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Item someItem = new Item();
        someItem.setName("Some Item");
        em.persist(someItem);
        em.getTransaction().commit();
        em.close();

        Long ITEM_ID = someItem.getId();

        em = emf.createEntityManager();
        em.getTransaction().begin();
//        Item notProxiedItem = em.find(Item.class, 1L);
            /*
               If the persistence context already contains an <code>Item</code> with the given identifier, that
               <code>Item</code> instance is returned by <code>getReference()</code> without hitting the database.
               Furthermore, if <em>no</em> persistent instance with that identifier is currently managed, a hollow
               placeholder will be produced by Hibernate, a proxy. This means <code>getReference()</code> will not
               access the database, and it doesn't return <code>null</code>, unlike <code>find()</code>.
             */
        Item item = em.getReference(Item.class, ITEM_ID);
        System.out.println(item.getClass());

            /*
               JPA offers <code>PersistenceUnitUtil</code> helper methods such as <code>isLoaded()</code> to
               detect if you are working with an uninitialized proxy.
            */
        PersistenceUnitUtil persistenceUtil =
                emf.getPersistenceUnitUtil();
//        Assertions.assertFalse(persistenceUtil.isLoaded(item));

            /*
               As soon as you call any method such as <code>Item#getName()</code> on the proxy, a
               <code>SELECT</code> is executed to fully initialize the placeholder. The exception to this rule is
               a method that is a mapped database identifier getter method, such as <code>getId()</code>. A proxy
               might look like the real thing but it is only a placeholder carrying the identifier value of the
               entity instance it represents. If the database record doesn't exist anymore when the proxy is
               initialized, an <code>EntityNotFoundException</code> will be thrown.
             */
         assertEquals("Some Item", item.getName());
            /*
               Hibernate has a convenient static <code>initialize()</code> method, loading the proxy's data.
             */
//         Hibernate.initialize(item);

        em.getTransaction().commit();
        em.close();

            /*
               After the persistence context is closed, <code>item</code> is in detached state. If you do
               not initialize the proxy while the persistence context is still open, you get a
               <code>LazyInitializationException</code> if you access the proxy. You can't load
               data on-demand once the persistence context is closed. The solution is simple: Load the
               data before you close the persistence context.
             */
//        Assertions.assertThrows(LazyInitializationException.class, () -> item.getName());
        System.out.println(item.getName());
    }


    @Test
    public void strangeBehavior() {
        //create an Item
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Item someItem = new Item("Some Item");
        em.persist(someItem);
        em.getTransaction().commit();
        em.close();
        Long ITEM_ID = someItem.getId();

        //Getting the Item and remove it
        em = emf.createEntityManager();
        em.getTransaction().begin();
        Item item = em.find(Item.class, ITEM_ID);
        assertNotSame(item, someItem);
        em.remove(item);

        assertFalse(em.contains(item));
        assertNull(item.getId());
        em.persist(item);

        em.getTransaction().commit();
        em.close();

        em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(item);

        em.getTransaction().commit();
        em.close();



    }
    @Test
    public void makeTransient() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Item someItem = new Item();
        someItem.setName("Some Item");
        em.persist(someItem);
        em.getTransaction().commit();
        em.close();
        Long ITEM_ID = someItem.getId();

        em = emf.createEntityManager();
        em.getTransaction().begin();
        Item item1 = em.find(Item.class, ITEM_ID);
//        assertTrue(em.contains(item1));
        em.remove(item1);
        assertFalse(em.contains(item1));
        assertNull(item1.getId());
//        item1.setId(null);
        em.persist(item1);

//        assertTrue(em.contains(item1));
        em.getTransaction().commit();
        em.close();

//        assertNull(item1.getId());
    }

    @Test
    public void makeTransientBook() {

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Item someItem = new Item();
        someItem.setName("Some Item");
        em.persist(someItem);
        em.getTransaction().commit();
        em.close();
        Long ITEM_ID = someItem.getId();

        em = emf.createEntityManager();
        em.getTransaction().begin();
            /*
               If you call <code>find()</code>, Hibernate will execute a <code>SELECT</code> to
               load the <code>Item</code>. If you call <code>getReference()</code>, Hibernate
               will attempt to avoid the <code>SELECT</code> and return a proxy.
             */
        Item item = em.find(Item.class, ITEM_ID);
        //Item item = em.getReference(Item.class, ITEM_ID);

            /*
               Calling <code>remove()</code> will queue the entity instance for deletion when
               the unit of work completes, it is now in <em>removed</em> state. If <code>remove()</code>
               is called on a proxy, Hibernate will execute a <code>SELECT</code> to load the data.
               An entity instance has to be fully initialized during life cycle transitions. You may
               have life cycle callback methods or an entity listener enabled
               (see <a href="#EventListenersInterceptors"/>), and the instance must pass through these
               interceptors to complete its full life cycle.
             */
        em.remove(item);

            /*
                An entity in removed state is no longer in persistent state, this can be
                checked with the <code>contains()</code> operation.
             */
        assertFalse(em.contains(item));

            /*
               You can make the removed instance persistent again, cancelling the deletion.
             */


        // hibernate.use_identifier_rollback was enabled, it now looks like a transient instance
        assertNull(item.getId());

            /*
               When the transaction commits, Hibernate synchronizes the state transitions with the
               database and executes the SQL <code>DELETE</code>. The JVM garbage collector detects that the
               <code>item</code> is no longer referenced by anyone and finally deletes the last trace of
               the data.
             */
        em.getTransaction().commit();
        em.close();

        em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(item);
//        item = em.find(Item.class, ITEM_ID);
//        assertNull(item);
        em.getTransaction().commit();
        em.close();
    }


}
