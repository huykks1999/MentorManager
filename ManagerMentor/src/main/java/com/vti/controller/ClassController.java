package com.vti.controller;

import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.codec.Base64;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vti.dto.ClassDTOCreateAndView;
import com.vti.dto.ClassDTOUpdate;
import com.vti.entity.Class;
import com.vti.repository.IClassRepository;
import com.vti.service.ClassService;
import com.vti.service.IClassService;
import com.vti.utils.ValidationUtils;
import com.vti.validation.IdExists;

/**
 * @author Administrator
 *
 */
/**
 * @author Administrator
 *
 */
@RestController
@RequestMapping(value = "api/v1/class")
@Validated
public class ClassController {

	@Autowired
	private IClassRepository classRepository;

	@Autowired
	private ClassService classService;

	/**
	 * 
	 * this class use to get all class
	 * 
	 * @return
	 * @Description:
	 * @author: LQHuy
	 * @create_date: Mar 4, 2021
	 * @version: 1.0
	 * @modifer: LQHuy
	 * @modifer_date: Mar 4, 2021
	 * @return ResponseEntity<?>
	 *
	 */
	@GetMapping
	public ResponseEntity<?> GetAllClass() {
//		testGetall();

	

		return new ResponseEntity<List<ClassDTOCreateAndView>>(classService.getAllClass(), HttpStatus.OK);
	}

	/**
	 * 
	 * this method use tp get class by id
	 * 
	 * @param id
	 * @return
	 * @Description:
	 * @author: LQHuy
	 * @create_date: Mar 4, 2021
	 * @version: 1.0
	 * @modifer: LQHuy
	 * @modifer_date: Mar 4, 2021
	 * @return ResponseEntity<?>
	 *
	 */
	@GetMapping(value = "/{id}")
	public ResponseEntity<?> GetClassById(@PathVariable(name = "id") Short id) {
		return new ResponseEntity<ClassDTOCreateAndView>(classService.findClassById(id), HttpStatus.OK);
	}

	/**
	 * 
	 * this method use to create class
	 * 
	 * @param classCreate
	 * @return
	 * @Description:
	 * @author: LQHuy
	 * @create_date: Mar 4, 2021
	 * @version: 1.0
	 * @modifer: LQHuy
	 * @modifer_date: Mar 4, 2021
	 * @return ResponseEntity<?>
	 *
	 */
	@PostMapping
	public ResponseEntity<?> CreateClass(@RequestBody @Valid ClassDTOCreateAndView classCreate) {
		classService.createClass(classCreate);
		return new ResponseEntity<String>("Create sucessful", HttpStatus.CREATED);
	}

	/**
	 * 
	 * This method use to update class
	 * 
	 * @param classUpdate
	 * @return
	 * @throws Exception
	 * @Description:
	 * @author: LQHuy
	 * @create_date: Mar 4, 2021
	 * @version: 1.0
	 * @modifer: LQHuy
	 * @modifer_date: Mar 4, 2021
	 * @return ResponseEntity<?>
	 *
	 */
	@PutMapping
	public ResponseEntity<?> UpdateClass(@RequestBody @Valid ClassDTOUpdate classUpdate) throws Exception {
		classService.updateClass(classUpdate);
		return new ResponseEntity<String>("Update sucessful", HttpStatus.OK);
	}

	/**
	 * 
	 * This method use to delete class
	 * 
	 * @param id
	 * @return
	 * @Description:
	 * @author: LQHuy
	 * @create_date: Mar 4, 2021
	 * @version: 1.0
	 * @modifer: LQHuy
	 * @modifer_date: Mar 4, 2021
	 * @return ResponseEntity<?>
	 *
	 */
	@DeleteMapping
	public ResponseEntity<?> DeleteClass(@RequestParam @IdExists Short id) {
		classService.deleteClass(id);
		return new ResponseEntity<String>("Delete sucessful", HttpStatus.OK);
	}

}
