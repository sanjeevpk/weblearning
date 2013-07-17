package com;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;


/**
 * @author sankulka
 *
 */

@MappedSuperclass
public class BaseEntity implements Serializable{

	private static final long serialVersionUID = -3450042257820757027L;
	
	/*@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;*/
	
	@Column(name = "created_by")
	private String createdBy;
	
	@Column(name = "updated_by")
	private String updatedBy;
	
	@Version
	@Column(name = "version")
	private long version;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "created_on")
	private Date createdOn;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "updated_on")
	private Date updatedOn;
	
	@Temporal(TemporalType.TIME)
	@Column(name = "created_time")
	private Date createdTime;
	
	@Temporal(TemporalType.TIME)
	@Column(name = "updated_time")
	private Date updated_time;

/*	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}*/

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public long getVersion() {
		return version;
	}

	public void setVersion(long version) {
		this.version = version;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Date getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public Date getUpdated_time() {
		return updated_time;
	}

	public void setUpdated_time(Date updated_time) {
		this.updated_time = updated_time;
	}
}
