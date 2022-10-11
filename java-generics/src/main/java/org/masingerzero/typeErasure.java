package org.masingerzero;

class TypeErasureTest{
    public static void main(String[] args) {
//        List aList = new ArrayList();
//
//        aList.add(3);
//        aList.add("hello");
//
//        int i = (int)aList.get(0);


//        for (Method m : Integer.class.getMethods())
//            if (m.getName().equals("compareTo"))
//                System.out.println(m.toGenericString());

        MyNode mn = new MyNode(5);
        NodeX n = mn;
        n.setData("hello!");
        Integer data = mn.getData();


    }


}

class NodeX<T> {
    private T data;
    public NodeX(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}

class MyNode extends NodeX<Integer> {

    public MyNode(Integer data) {
        super(data);
    }

//    @Override
//    public void setData(Integer data) {
//        System.out.println("MyNode.setData");
//        super.setData(data);
//    }
}