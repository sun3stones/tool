package com.lei.tool.test.callback;

public class Student implements CallBack {

    private Teacher mTeacher;

    public Student(Teacher mTeacher) {
        this.mTeacher = mTeacher;
    }

    public void ask(int a, int b) {
        System.out.println("学生发出提问：" + a + "+" + b + "=?");
        mTeacher.reply(Student.this, a, b);
    }

    @Override
    public void answer(String result) {
        System.out.println("老师公布的答案是——>" + result);
    }

}  