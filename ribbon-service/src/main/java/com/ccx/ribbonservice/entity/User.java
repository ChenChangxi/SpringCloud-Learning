package com.ccx.ribbonservice.entity;

/**
 * @program: com.ccx.ribbonservice.entity
 * @description: 这是微服务信息传递的实体
 * @authhor: ChenChangxi
 * @create: 2019-11-26 19:06
 **/


public class User {

    private String name;

    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
