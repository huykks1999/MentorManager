package com.vti.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Converter;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.vti.Enum.ClassStatus;
import com.vti.Enum.RequestStatus;
import com.vti.entity.Converter.RequestStatusConverter;

@Entity
@Table(catalog = "mentormanagement", name = "classrequest")
public class ClassRequest implements Serializable {
	
	@Column(name = "RequestId")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Short id;
	
	@ManyToOne
	@JoinColumn(name = "ClassId", nullable = false)
	private Class classId;
	
	@Column(name = "RequestStatus")
	@Convert(converter = RequestStatusConverter.class)
	private RequestStatus requestStatus;
	
	@ManyToOne
	@JoinColumn(name = "RequestMentorId", nullable = false)
	private Mentor mentorId;
	
	public ClassRequest() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(Short id) {
		this.id = id;
	}

	public Class getClassId() {
		return classId;
	}

	public void setClassId(Class classId) {
		this.classId = classId;
	}

	public RequestStatus getRequestStatus() {
		return requestStatus;
	}

	public void setRequestStatus(RequestStatus requestStatus) {
		this.requestStatus = requestStatus;
	}

	public Mentor getMentorId() {
		return mentorId;
	}

	public void setMentorId(Mentor mentorId) {
		this.mentorId = mentorId;
	}

	@Override
	public String toString() {
		return "ClassRequest [id=" + id + ", classId=" + classId.getClassName() + ", requestStatus=" + requestStatus + ", mentorId="
				+ mentorId + "]";
	}
	
	

}
