package com.blog.hardikpat.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.blog.hardikpat.model.PostalAddress;

@RepositoryRestResource(collectionResourceRel="PostalAddress",path="PostalAddress")
public interface PostalAddressRepository extends CrudRepository<PostalAddress,Integer> {

}
