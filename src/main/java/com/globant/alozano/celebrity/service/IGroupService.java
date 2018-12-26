package com.globant.alozano.celebrity.service;

import com.globant.alozano.celebrity.model.Group;
import com.globant.alozano.celebrity.model.Person;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * The interface that defines the {@link Group} services
 */
public interface IGroupService {
    Optional<Group> findById(Integer groupId);

    List<Person> findPeopleInAGroup(Integer groupId);

    Map<Person,List<Person>> findGroupRelationships(Integer groupId);

    Boolean personKnowsPerson(Integer personId, Integer anotherPersonId, Integer groupId);
}
