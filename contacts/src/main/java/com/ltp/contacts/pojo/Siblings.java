package com.ltp.contacts.pojo;

import javax.validation.constraints.NotBlank;

public class Siblings {
    @NotBlank(message = "Name Siblings cannot null")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
