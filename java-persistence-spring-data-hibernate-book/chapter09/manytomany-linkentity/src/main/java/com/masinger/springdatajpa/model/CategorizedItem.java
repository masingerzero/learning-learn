
package com.masinger.springdatajpa.model;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "CATEGORY_ITEM")
@org.hibernate.annotations.Immutable
public class CategorizedItem {

    @Embeddable
    public static class Id implements Serializable {

        @Column(name = "CATEGORY_ID")
        private Long categoryId;

        @Column(name = "ITEM_ID")
        private Long itemId;


        public void setCategoryId(Long categoryId) {
            this.categoryId = categoryId;
        }

        public Id() {
        }

        public Id(Long categoryId, Long itemId) {
            this.categoryId = categoryId;
            this.itemId = itemId;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Id id = (Id) o;
            return Objects.equals(categoryId, id.categoryId) &&
                    Objects.equals(itemId, id.itemId);
        }

        @Override
        public int hashCode() {
            return Objects.hash(categoryId, itemId);
        }
    }

    @EmbeddedId
    private Id id = new Id();

    @Column(updatable = false)
    @NotNull
    private String addedBy;

    @Column(updatable = false)
    @NotNull
    @CreationTimestamp
    private LocalDateTime addedOn;

    @ManyToOne
    @JoinColumn(
            name = "CATEGORY_ID",
            insertable = false, updatable = false)
    private Category category;

    @ManyToOne
    @JoinColumn(
            name = "ITEM_ID",
            insertable = false, updatable = false)
    private Item item;

    public CategorizedItem() {
    }

    public CategorizedItem(String addedByUsername,
                           Category category,
                           Item item) {

        // Set fields
        this.addedBy = addedByUsername;
        this.category = category;
        this.item = item;

        // Set identifier values
        this.id.categoryId = category.getId();
        this.id.itemId = item.getId();

        // Guarantee referential integrity if made bidirectional
        category.addCategorizedItem(this);
        item.addCategorizedItem(this);
    }

    public Id getId() {
        return id;
    }

    public String getAddedBy() {
        return addedBy;
    }

    public LocalDateTime getAddedOn() {
        return addedOn;
    }

    public Category getCategory() {
        return category;
    }

    public Item getItem() {
        return item;
    }
}
