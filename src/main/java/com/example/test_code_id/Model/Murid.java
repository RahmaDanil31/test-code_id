package com.example.test_code_id.Model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "murid")
public class Murid {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "time_create")
    private Date time_create;

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

    public Date getTime_create() {

        if(time_create==null)
            return new Date();

        return time_create;
    }

    public void setTime_create(Date time_create) {
        this.time_create = time_create;
    }
}
