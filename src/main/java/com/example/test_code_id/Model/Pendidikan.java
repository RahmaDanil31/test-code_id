package com.example.test_code_id.Model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "pendidikan")
public class Pendidikan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "id_murid")
    private Integer Idmurid;

    @Column(name = "status")
    private String status;

    @Column(name = "time_create")
    private Date time_create;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdmurid() {
        return Idmurid;
    }

    public void setIdmurid(Integer idmurid) {
        Idmurid = idmurid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
