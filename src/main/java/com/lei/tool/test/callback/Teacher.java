package com.lei.tool.test.callback;

public class Teacher {

    public void reply(CallBack cb, int a, int b) {
        System.out.println("老师收到学生的提问——>" + a + "+" + b + "=?");
        cb.answer(String.valueOf(a + b));
    }
} 