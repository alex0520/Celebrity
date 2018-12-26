package com.globant.alozano.celebrity.service;

import com.globant.alozano.celebrity.exception.CelebrityException;
import com.globant.alozano.celebrity.model.Person;

import java.util.Optional;

/**
 * The interface that defines the applications services
 */
public interface ICelebrityService {

    Optional<Person> findTheCelebrityByBruteForce(Integer groupId) throws CelebrityException;
    Optional<Person> findTheCelebrityUsingAStack(Integer groupId);
}
