package com.blog.hardikpat.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@EqualsAndHashCode
@Entity
@Table(name="PostalAddress")
@Getter
@Setter
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property="id")
public class PostalAddress implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int Id;
	
	
	private String streetNo;
	
	
	private String street;
	
	
	private String addressLine1;
	
	
	private String addressLine2;
	
	
	private String city;
	
	
	private String zipcode;
	
	
	private String country;
	
	
	private Timestamp createdDate;
	
	//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property="owner")
	@ManyToOne
	@JoinColumn
	private Customer owner;

}
