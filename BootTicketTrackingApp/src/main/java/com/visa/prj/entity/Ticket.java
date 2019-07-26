package com.visa.prj.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Ticket {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ticket_id")
	private Long id;
	private String description;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private Date loggedDate;
	
	@ManyToOne
	@JoinColumn(name="rasised_by")
	private Employee raisedBy;
	
	@ManyToOne
	@JoinColumn(name="resolved_by")
	private Employee resolvedBy;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private Date resolvedOn;
	private String resolveInfo;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getLoggedDate() {
		return loggedDate;
	}
	public void setLoggedDate(Date loggedDate) {
		this.loggedDate = loggedDate;
	}
	public Employee getRaisedBy() {
		return raisedBy;
	}
	public void setRaisedBy(Employee raisedBy) {
		this.raisedBy = raisedBy;
	}
	public Employee getResolvedBy() {
		return resolvedBy;
	}
	public void setResolvedBy(Employee resolvedBy) {
		this.resolvedBy = resolvedBy;
	}
	public Date getResolvedOn() {
		return resolvedOn;
	}
	public void setResolvedOn(Date resolvedOn) {
		this.resolvedOn = resolvedOn;
	}
	public String getResolveInfo() {
		return resolveInfo;
	}
	public void setResolveInfo(String resolveInfo) {
		this.resolveInfo = resolveInfo;
	}
	
	

}
