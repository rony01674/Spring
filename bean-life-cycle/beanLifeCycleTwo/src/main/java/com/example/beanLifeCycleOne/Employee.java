package com.example.beanLifeCycleOne;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Employee implements InitializingBean, DisposableBean {

    private Long id;
    private String position;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Init method after properties are set");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Spring Clean Up! Employee is cleaned up now.");
    }
}
