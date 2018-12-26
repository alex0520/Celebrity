package com.globant.alozano.celebrity.repository;

import com.globant.alozano.celebrity.model.Group;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

@RestResource(exported = false)
@Repository
public interface GroupRepository extends BaseRepository<Group, Integer>{
    
}
