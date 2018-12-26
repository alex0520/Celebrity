package com.globant.alozano.celebrity.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity(name = "person")
public class Person implements Serializable {

    private static final long serialVersionUID = -8456461313908587872L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;

    @Column(name = "name")
    @NotNull
    private String name;

    @NotNull
    @Column(name = "creation_date")
    private Date creationDate;

}
