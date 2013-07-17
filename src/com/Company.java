/**
 * 
 */
package com;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author sankulka
 *
 */

@Table(name = "company")
@Entity
public class Company implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "created_on")
	private String createdOn;
	
	@Column(name = "updated_on")
	private String updatedOn;
	
	@Column(name = "version")
	private long version;	
}
