package com.globant.alozano.celebrity.repository;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

/**
 * A base repository to define the common methods that all project's repositories must have
 *
 * @param <T> The entity type
 * @param <ID> The entity's key type
 */
@NoRepositoryBean
interface BaseRepository<T, ID extends Serializable> extends PagingAndSortingRepository<T, ID> {
    Optional<T> findById(ID id);

    List<T> findAll();
}