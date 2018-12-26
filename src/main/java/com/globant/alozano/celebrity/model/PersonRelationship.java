package com.globant.alozano.celebrity.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity(name = "person_relationship")
public class PersonRelationship implements Serializable {

    private static final long serialVersionUID = -6943687812748163684L;

    @Id
    @ManyToOne
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    private Person person;

    @Id
    @ManyToOne
    @JoinColumn(name = "known_person_id", referencedColumnName = "id")
    private Person knownPerson;

    @NotNull
    @Column(name = "creation_date")
    private Date creationDate;

}
