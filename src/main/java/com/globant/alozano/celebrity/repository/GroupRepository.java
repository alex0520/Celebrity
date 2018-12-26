package com.globant.alozano.celebrity.repository;

import com.globant.alozano.celebrity.model.Group;
import com.globant.alozano.celebrity.model.Person;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * The repository to manage the {@link Group} operations
 */
@RestResource(exported = false)
@Repository
public interface GroupRepository extends BaseRepository<Group, Integer>{
    
}
