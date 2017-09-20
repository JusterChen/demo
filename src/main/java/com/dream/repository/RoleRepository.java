package com.dream.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;

import com.dream.model.Role;


@RepositoryRestResource
@Transactional
public interface RoleRepository extends PagingAndSortingRepository<Role, String>{

}
