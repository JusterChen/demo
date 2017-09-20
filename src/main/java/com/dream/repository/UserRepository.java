package com.dream.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.transaction.annotation.Transactional;

import com.dream.model.User;


@RepositoryRestResource
@Transactional
public interface UserRepository extends PagingAndSortingRepository<User, String>{
	
	@RestResource(path="findByUserName",rel="findByUserName")
	User findByUserName(@Param("userName") String userName);

}
