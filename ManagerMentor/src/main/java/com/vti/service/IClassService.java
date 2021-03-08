package com.vti.service;

import java.util.List;

import com.vti.dto.ClassDTOCreateAndView;
import com.vti.dto.ClassDTOUpdate;
import com.vti.entity.Class;

public interface IClassService {
	
	List<ClassDTOCreateAndView> getAllClass();
	
	ClassDTOCreateAndView findClassById(Short id);
	
	void createClass(ClassDTOCreateAndView classCreate);
	
	void updateClass(ClassDTOUpdate classUpdate);
	
	void deleteClass(Short id);
	
	boolean existsByClassName(String className);	
	
	public Class findClassByClassName(String className);
}
