package com.lei.tool.test;

public class MyOuter2 {
    public static int x = 100;
    public int z = 1;

    public static class MyInner {
        private String y = "Hello!";

        public void innerMethod() {
            MyOuter2 m = new MyOuter2();
            System.out.println(m.z);
            System.out.println("x=" + x);
            System.out.println("y=" + y);
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        MyOuter2.MyInner si = new MyOuter2.MyInner();// 静态内部类不通过外部实例就可以创建对象；与类变量可以通过类名访问相似
        si.innerMethod();
        // TODO Auto-generated method stub
    }
}