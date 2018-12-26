package com.globant.alozano.celebrity.repository;

import com.globant.alozano.celebrity.model.Person;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * The repository to manage the {@link Person} operations
 */
@RestResource(exported = false)
@Repository
public interface PersonRepository extends BaseRepository<Person, Integer> {
    @Query(value = "SELECT p.* FROM person p JOIN person_relationship pr ON pr.known_person_id = p.id WHERE pr.person_id = ?#{[0]} AND pr.group_id = ?#{[1]}", nativeQuery = true)
    List<Person> findRelatedPersons(Integer personId, Integer groupId);

    @Query(value = "SELECT count(*) FROM person_relationship pr WHERE pr.person_id = ?#{[0]} AND pr.known_person_id = ?#{[1]} AND pr.group_id = ?#{[2]}", nativeQuery = true)
    Integer countPersonRelationToAnotherPerson(Integer personId, Integer anotherPersonId, Integer groupId);
}
