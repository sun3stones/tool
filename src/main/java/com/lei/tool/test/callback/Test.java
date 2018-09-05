package com.lei.tool.test.callback;

public class Test {

    public static void main(String[] args) {
        Teacher teacher = new Teacher();
        Student student = new Student(teacher);
        student.ask(3, 5);
    }
}  