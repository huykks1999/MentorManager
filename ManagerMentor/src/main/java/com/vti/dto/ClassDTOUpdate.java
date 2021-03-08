package com.vti.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.vti.Enum.ClassStatus;
import com.vti.Enum.TeachingForm;
import com.vti.entity.Class;
import com.vti.entity.Converter.ClassStatusConverter;
import com.vti.entity.Converter.TeachingFormConverter;
import com.vti.validation.IdExists;

public class ClassDTOUpdate {
	
	@NotNull(message = "{ClassDTO.Id.NotBlank}")
	@IdExists
	private Short id;
	
	@NotBlank(message = "{ClassDTO.ClassName.NotBlank}")
	@Length(max = 30, message = "{ClassDTO.ClassName.MaxLength}")
	private String className;

	@NotNull(message = "{ClassDTO.StartDate.NotBlank}")
	private Date startDate;

	@NotNull(message = "{ClassDTO.EndDate.NotBlank}")
	private Date endDate;
	
	@Length(max = 100, message = "{ClassDTO.Description.NotBlank}")
	@NotBlank(message = "{ClassDTO.Description.MaxLength}")
	private String Description;

	@NotNull(message = "{ClassDTO.ClassStatus.NotBlank}")
	private ClassStatus classStatus;

	@NotNull(message = "{ClassDTO.StudentNumber.NotBlank}")
	private int studentNumber;

	@NotNull(message = "{ClassDTO.TeachingForm.NotBlank}")
	private TeachingForm teachingForm;

	public Short getId() {
		return id;
	}

	public void setId(Short id) {
		this.id = id;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public ClassStatus getClassStatus() {
		return classStatus;
	}

	public void setClassStatus(ClassStatus classStatus) {
		this.classStatus = classStatus;
	}

	public int getStudentNumber() {
		return studentNumber;
	}

	public void setStudentNumber(int studentNumber) {
		this.studentNumber = studentNumber;
	}

	public TeachingForm getTeachingForm() {
		return teachingForm;
	}

	public void setTeachingForm(TeachingForm teachingForm) {
		this.teachingForm = teachingForm;
	}

	@Override
	public String toString() {
		return "ClassDto [id=" + id + ", className=" + className + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", Description=" + Description + ", classStatus=" + classStatus + ", studentNumber=" + studentNumber
				+ ", teachingForm=" + teachingForm + "]";
	}
	
	
	
}
