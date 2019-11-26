package com.ccx.streamdriver.stream.entity;

/**
 * @program: com.ccx.streamdriver.stream.entity
 * @description: 这是定义的消息发送对象，发送方向接收方发送User对象
 * @authhor: ChenChangxi
 * @create: 2019-11-24 21:25
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
