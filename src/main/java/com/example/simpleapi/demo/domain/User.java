package com.example.simpleapi.demo.domain;

import java.lang.Integer;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class User {

    @Column(name="id")
    private Integer id;

    @Column(name="name")
    private String name;

    //constructor
    public User(){
    }

    public User(String name) {
        this.name = name;
    }

    public User(Integer id, String name){
        this.id = id;
        this.name = name;
    }

    //setter & getter
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}