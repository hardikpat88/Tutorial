package com.blog.hardikpat.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.blog.hardikpat.model.ClaimedEmailAddress;

@RepositoryRestResource(collectionResourceRel="ClaimedEmailAddress",path="ClaimedEmailAddress")
public interface ClaimedEmailAddressRepository extends CrudRepository<ClaimedEmailAddress,Integer>{

}
