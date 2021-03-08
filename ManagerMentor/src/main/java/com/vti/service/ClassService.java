package com.vti.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vti.dto.ClassDTOCreateAndView;
import com.vti.dto.ClassDTOUpdate;
import com.vti.entity.Admin;
import com.vti.entity.Class;
import com.vti.repository.IAdminRepository;
import com.vti.repository.IClassRepository;

@Service
public class ClassService implements IClassService {

//	@Autowired
//	private ModelMapper mapper;

	@Autowired
	private ClassService classService;

	@Autowired
	private IClassRepository classRepository;

	/**
	 * 
	 * this method use to get all class and map to ClassDTO
	 * 
	 * @return list<ClassDTO>
	 * @Description:
	 * @author: LQHuy
	 * @create_date: Mar 4, 2021
	 * @version: 1.0
	 * @modifer: LQHuy
	 * @modifer_date: Mar 4, 2021
	 *
	 */
	@Override
	public List<ClassDTOCreateAndView> getAllClass() {
		List<ClassDTOCreateAndView> ClassDTO = new ArrayList<ClassDTOCreateAndView>();
		List<Class> classE = classRepository.findAll();
		for (Class class1 : classE) {
			ClassDTO.add(classService.toDtoCreateAndView(class1));
		}

		return ClassDTO;
	}

	/**
	 * 
	 * this method use to get a ClassDTO by id
	 * 
	 * @param id
	 * @return ClassDTO
	 * @Description:
	 * @author: LQHuy
	 * @create_date: Mar 4, 2021
	 * @version: 1.0
	 * @modifer: LQHuy
	 * @modifer_date: Mar 4, 2021
	 *
	 */
	@Override
	public ClassDTOCreateAndView findClassById(Short id) {
		return ClassService.toDtoCreateAndView(classRepository.findById(id).get());
	}

	/**
	 * 
	 * this method use to create class
	 * 
	 * @param classCreate
	 * @Description:
	 * @author: LQHuy
	 * @create_date: Mar 4, 2021
	 * @version: 1.0
	 * @modifer: LQHuy
	 * @modifer_date: Mar 4, 2021
	 *
	 */
	@Override
	public void createClass(ClassDTOCreateAndView classCreate) {
		classRepository.save(classService.toEntity(classCreate));
	}

	/**
	 * 
	 * this method use to update information of class
	 * 
	 * @param classUpdate
	 * @Description:
	 * @author: LQHuy
	 * @create_date: Mar 4, 2021
	 * @version: 1.0
	 * @modifer: LQHuy
	 * @modifer_date: Mar 4, 2021
	 *
	 */
	@Override
	public void updateClass(ClassDTOUpdate classUpdate) {
		classRepository.save(classService.toEntity(classUpdate));
	}

	/**
	 * 
	 * this method use to delete Class
	 * 
	 * @param id
	 * @Description:
	 * @author: LQHuy
	 * @create_date: Mar 4, 2021
	 * @version: 1.0
	 * @modifer: LQHuy
	 * @modifer_date: Mar 4, 2021
	 *
	 */
	@Override
	public void deleteClass(Short id) {
		classRepository.delete(classRepository.findById(id).get());
	}

	/**
	 * 
	 * this method use to map object ClassDTOUpdate to object class
	 * 
	 * @param ClassDTO
	 * @return
	 * @Description:
	 * @author: LQHuy
	 * @create_date: Mar 4, 2021
	 * @version: 1.0
	 * @modifer: LQHuy
	 * @modifer_date: Mar 4, 2021
	 * @return Class
	 *
	 */
	public Class toEntity(ClassDTOUpdate ClassDTO) {

		ModelMapper modelMapper = new ModelMapper();
//		Class classE = new Class();
		return modelMapper.map(ClassDTO, Class.class);

	}

	/**
	 * 
	 * this method use to map object Class to object ClassDTOCreateAndView
	 * 
	 * @param classE
	 * @return
	 * @Description:
	 * @author: LQHuy
	 * @create_date: Mar 4, 2021
	 * @version: 1.0
	 * @modifer: LQHuy
	 * @modifer_date: Mar 4, 2021
	 * @return ClassDTO
	 *
	 */
	public static ClassDTOUpdate toDtoUpdate(Class classE) {
		ModelMapper modelMaper = new ModelMapper();
		return modelMaper.map(classE, ClassDTOUpdate.class);
	}
	
	
	/**
	 * 
	 * this method use to map object Class to object ClassDTOCreateAndView
	 * 
	 * @param ClassDTO
	 * @return
	 * @Description:
	 * @author: LQHuy
	 * @create_date: Mar 6, 2021
	 * @version: 1.0
	 * @modifer: LQHuy
	 * @modifer_date: Mar 6, 2021
	 * @return: Class
	 *
	 */
	public Class toEntity(ClassDTOCreateAndView ClassDTO) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(ClassDTO, Class.class);
	}
	
	
	/**
	 * 
	 * this method use to map object ClassDTOCreateAndView to object class
	 * 
	 * @param classE
	 * @return
	 * @Description:
	 * @author: LQHuy
	 * @create_date: Mar 6, 2021
	 * @version: 1.0
	 * @modifer: LQHuy
	 * @modifer_date: Mar 6, 2021
	 * @return: ClassDTOCreateAndView
	 *
	 */
	public static ClassDTOCreateAndView toDtoCreateAndView(Class classE) {
		ModelMapper modelMaper = new ModelMapper();
		return modelMaper.map(classE, ClassDTOCreateAndView.class);
	}

	/**
	 * 
	 * 
	 * 
	 * @return
	 * @Description:
	 * @author: LQHuy
	 * @create_date: Mar 6, 2021
	 * @version: 1.0
	 * @modifer: LQHuy
	 * @modifer_date: Mar 6, 2021
	 *
	 */
	@Override
	public boolean existsByClassName(String className) {
		return classRepository.existsByClassName(className);
	}

	/**
	 * 
	 * 
	 * 
	 * @param className
	 * @return
	 * @Description:
	 * @author: LQHuy
	 * @create_date: Mar 6, 2021
	 * @version: 1.0
	 * @modifer: LQHuy
	 * @modifer_date: Mar 6, 2021
	 *
	 */
	@Override
	public Class findClassByClassName(String className) {
		// TODO Auto-generated method stub
		return classRepository.findByClassName(className);
	}
	

}
