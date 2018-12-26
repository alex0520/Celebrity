package com.globant.alozano.celebrity.model;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@Entity(name = "group")
public class Group implements Serializable {

    private static final long serialVersionUID = 4986215456796862575L;

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

    @OneToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name="person_group",
            joinColumns={@JoinColumn(name="group_id", referencedColumnName="id")},
            inverseJoinColumns={@JoinColumn(name="person_id", referencedColumnName="id")})
    private List<Person> personList;

}
