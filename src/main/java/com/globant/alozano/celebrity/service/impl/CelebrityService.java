package com.globant.alozano.celebrity.service.impl;

import com.globant.alozano.celebrity.exception.CelebrityException;
import com.globant.alozano.celebrity.model.Group;
import com.globant.alozano.celebrity.model.Person;
import com.globant.alozano.celebrity.service.ICelebrityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;

@Service
public class CelebrityService implements ICelebrityService {

    @Autowired
    private GroupService groupService;

    @Override
    public Optional<Person> findTheCelebrityByBruteForce(Integer groupId) throws CelebrityException{
        Optional<Group> optionalGroup = groupService.findById(groupId);
        if(!optionalGroup.isPresent()){
            throw new CelebrityException("The group not exists");
        }
        Map<Person, List<Person>> groupRelationships = groupService.findGroupRelationships(groupId);
        Map<Person, List<Person>> personEmptyRelationships = groupRelationships.entrySet().stream().filter(o -> o.getValue().isEmpty()).collect(Collectors.toMap(o -> o.getKey(), o -> o.getValue()));
        if(personEmptyRelationships.isEmpty()){
            throw new CelebrityException("There is not a celebrity in this group");
        } else if(personEmptyRelationships.keySet().size() > 1){
            throw new CelebrityException("There is more than one celebrity in this group");
        } else {
            Set<Person> celebrities = personEmptyRelationships.keySet();
            return Optional.of(celebrities.iterator().next());
        }
    }

    @Override
    public Optional<Person> findTheCelebrityUsingAStack(Integer groupId) {
        List<Person> peopleInAGroup = groupService.findPeopleInAGroup(groupId);
        Stack<Person> peopleStack = new Stack<>();
        peopleInAGroup.forEach(o -> peopleStack.push(o));
        while (peopleStack.size() > 1) {

            Person person = peopleStack.pop();
            Person anotherPerson= peopleStack.pop();

            if (groupService.personKnowsPerson(person.getId(), anotherPerson.getId(), groupId)) {
                peopleStack.push(anotherPerson);
            }
            else {
                peopleStack.push(person);
            }
        }

        Person celebrity = peopleStack.pop();

        for (Person p : peopleInAGroup) {
            if (p != celebrity && (groupService.personKnowsPerson(celebrity.getId(), p.getId(), groupId) ||
                    !groupService.personKnowsPerson(p.getId(), celebrity.getId(), groupId)))
                throw new CelebrityException("There is not a celebrity in this group");
        }

        return Optional.of(celebrity);
    }
}
