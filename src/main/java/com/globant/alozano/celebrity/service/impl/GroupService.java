package com.globant.alozano.celebrity.service.impl;

import com.globant.alozano.celebrity.model.Group;
import com.globant.alozano.celebrity.model.Person;
import com.globant.alozano.celebrity.repository.GroupRepository;
import com.globant.alozano.celebrity.repository.PersonRepository;
import com.globant.alozano.celebrity.service.IGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GroupService implements IGroupService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private GroupRepository groupRepository;


    @Override
    public Optional<Group> findById(Integer groupId) {
        return groupRepository.findById(groupId);
    }

    @Override
    public List<Person> findPeopleInAGroup(Integer groupId) {
        Optional<Group> optionalGroup = findById(groupId);
        if (optionalGroup.isPresent()) {
            Group group = optionalGroup.get();
            return group.getPersonList().stream().sorted().collect(Collectors.toList());
        } else {
            return Collections.EMPTY_LIST;
        }
    }

    @Override
    public Map<Person, List<Person>> findGroupRelationships(Integer groupId) {
        List<Person> people = findPeopleInAGroup(groupId);
        Map<Person, List<Person>> groupRelationships = people
                .stream()
                .collect(Collectors.toMap(o -> o, o -> personRepository.findRelatedPersons(o.getId(), groupId)));
        return groupRelationships;
    }

    @Override
    public Boolean personKnowsPerson(Integer personId, Integer anotherPersonId, Integer groupId) {
        return personRepository.countPersonRelationToAnotherPerson(personId, anotherPersonId, groupId) > 0;
    }
}
