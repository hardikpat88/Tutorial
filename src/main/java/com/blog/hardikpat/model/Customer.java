package com.blog.hardikpat.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@EqualsAndHashCode
@Entity
@Table(name="Customer")
@Setter
@Getter
@JsonIdentityInfo(generator = ObjectIdGenerators.UUIDGenerator.class, property="custId")
public class Customer implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator="guid")
	@GenericGenerator(name="guid",strategy="guid")
	@Column(columnDefinition="CHAR(50)")
	private String custId;
	
	private String firstName;
	
	private String middleName;
	
	private String lastName;
	
	private Timestamp createdDate;
	
	@OneToMany(mappedBy="owner",cascade=CascadeType.ALL)
	//@JsonIgnore
	private List<PostalAddress> postalAddresses;
	
	@OneToMany(mappedBy="customer",cascade=CascadeType.ALL)
	//@JsonIgnore
	private List<ClaimedEmailAddress> claimedEmailAddress = new ArrayList<ClaimedEmailAddress>();
	
	/*private List<Credentials> credentials;
	
	private List<ActionToken> actionTokens;
	
	private List<ValidatedEmailAddress> validatedEmailAddresses;*/
	
	private int active;
}
