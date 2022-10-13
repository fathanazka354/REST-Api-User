package com.ltp.contacts.pojo;

import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.UUID;

public class Contact {

    private String id;
    @NotBlank(message = "Name can not blank")
    private String name;
    @NotBlank(message = "Number can not blank")
    private String phoneNumber;

//    @NotBlank(message = "age can not blank")
    private Integer age;

//    @NotBlank(message = "height can not blank")
    private Long height;

    private List<Siblings> siblings;

    public List<Siblings> getSiblings() {
        return siblings;
    }

    public void setSiblings(List<Siblings> siblings) {
        this.siblings = siblings;
    }

    private boolean alwaysDrunk;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Long getHeight() {
        return height;
    }

    public void setHeight(Long height) {
        this.height = height;
    }

    public boolean isAlwaysDrunk() {
        return alwaysDrunk;
    }

    public void setAlwaysDrunk(boolean alwaysDrunk) {
        this.alwaysDrunk = alwaysDrunk;
    }

    public Contact(String id, String name, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public Contact() {
        this.id = UUID.randomUUID().toString();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
