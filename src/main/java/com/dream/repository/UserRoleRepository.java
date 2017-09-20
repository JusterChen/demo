package com.dream.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;

import com.dream.model.UserRole;


@RepositoryRestResource
@Transactional
public interface UserRoleRepository extends PagingAndSortingRepository<UserRole, String>{

}
