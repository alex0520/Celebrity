package com.globant.alozano.celebrity.repository;

import com.globant.alozano.celebrity.model.Person;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@RestResource(exported = false)
@Repository
public interface PersonRepository extends BaseRepository<Person, Integer> {
    @Query(value = "SELECT p.* FROM person p JOIN person_relationship pr ON pr.known_person_id = p.id WHERE pr.person_id = ?#{[0]} AND pr.group_id = ?#{[1]}", nativeQuery = true)
    List<Person> findRelatedPersons(Integer personId, Integer groupId);
}
