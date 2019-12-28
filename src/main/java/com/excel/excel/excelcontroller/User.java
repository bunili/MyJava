package com.excel.excel.excelcontroller;

/**
 * @author : yaobiao
 * @Description:
 * @time : 2019/12/15 18:50
 */
public class User {
    private String name;
    private String age;

    public User(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public User() {
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }
}
