package com.example.beanLifeCycleOne;

import org.springframework.context.support.GenericXmlApplicationContext;

import java.sql.SQLOutput;

public class SimpleBean {
    private static final String DEFAULT_NAME = "Mr. Rony";
    private String name = null;
    private int age = Integer.MIN_VALUE;
    private OtherBean otherBean;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setOtherBean(OtherBean otherBean) {
        this.otherBean = otherBean;
    }

    @Override
    public String toString() {
        return "SimpleBean{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", otherBean=" + otherBean +
                '}';
    }

    public void init(){
        System.out.println("Initializing Bean");
        if(name == null){
            System.out.println("Using default name");
            name = DEFAULT_NAME;
        }

        if(age == Integer.MIN_VALUE){
            throw new IllegalArgumentException("You must set the age property of any beans of type "+ SimpleBean.class);
        }

        if(otherBean.getDepName() == null){
            System.out.println("use default value");
            otherBean.setDepName("Admin");
        }
    }

    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();

        context.load("classpath:applicationConfig.xml");
        context.refresh();// Refresh the ApplicationContext after XML config file loaded.

        SimpleBean simpleBean1 = (SimpleBean) context.getBean("simpleBean1");
        SimpleBean simpleBean2 = (SimpleBean) context.getBean("simpleBean2");

        System.out.println(simpleBean1);
        System.out.println(simpleBean2);
    }
}
