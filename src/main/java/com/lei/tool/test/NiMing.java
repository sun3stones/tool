package com.lei.tool.test;

public class NiMing {
    private int size = 5;

    public Object makeInner(int localVar) {
        final int finalLocalVar = localVar;
        return new Object() {
            // 使用匿名内部类
            public String toString() {
                return "OuterSize=" + size + "\nfinalLocalVar=" + finalLocalVar;

            }

        };

    }

    /**
     * @param args
     */
    public static void main(String args[]) {
        Object obj = new NiMing().makeInner(47);
        System.out.println(obj.toString());

    }
}