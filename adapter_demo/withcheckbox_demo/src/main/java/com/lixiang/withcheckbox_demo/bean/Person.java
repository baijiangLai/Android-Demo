package com.lixiang.withcheckbox_demo.bean;

import java.io.Serializable;

/**
 * @author laibaijiang
 * @date 2023/3/28
 */
public class Person implements Serializable {
    private String name;
    private String number;
    private boolean checkStatus;

    public Person(String name, String number) {
        super();
        this.name = name;
        this.number = number;
        this.checkStatus = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public boolean getCheckStatus() {
        return checkStatus;
    }

    public void setCheckStatus(boolean checkStatus) {
        this.checkStatus = checkStatus;
    }

}
