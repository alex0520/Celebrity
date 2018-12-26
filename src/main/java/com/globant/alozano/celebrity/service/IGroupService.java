package com.globant.alozano.celebrity.service;

import com.globant.alozano.celebrity.model.Person;

import java.util.List;
import java.util.Map;

public interface IGroupService {
    List<Person> findByGroupId(Integer groupId);

    Map<Person,List<Person>> findGroupRelationships(Integer groupId);
}
