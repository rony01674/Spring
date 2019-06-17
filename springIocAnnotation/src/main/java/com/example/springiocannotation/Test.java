package com.example.springiocannotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(StudentConfig.class);
        Student student = context.getBean(Student.class);
        Student student2 = context.getBean(Student.class);
        student.setName("Asaduzzaman Rony");
        student2.setName("Asaduzzaman Rony");
        System.out.println(student);
        System.out.println(student2);
    }
}
