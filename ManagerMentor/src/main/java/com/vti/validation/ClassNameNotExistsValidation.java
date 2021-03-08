/**
 * @author: LQHuy
 * @create_date: Mar 6, 2021
 * @TODO
 * @ClassNameNotExistsValidation
 */
package com.vti.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vti.entity.Class;
import com.vti.repository.IClassRepository;
import com.vti.service.ClassService;


/**
 * @author Administrator
 *
 */
@Component
public class ClassNameNotExistsValidation implements ConstraintValidator<ClassNameNotExists, String> {

	@Autowired
	private IClassRepository classRepository;
	
	@Autowired
	private ClassService classService;
	
	/**
	 * 
	 * 
	 * 
	 * @param constraintAnnotation
	 * @Description:
	 * @author: LQHuy
	 * @create_date: Mar 6, 2021
	 * @version: 1.0
	 * @modifer: LQHuy
	 * @modifer_date: Mar 6, 2021
	 *
	 */
	@Override
	public void initialize(ClassNameNotExists constraintAnnotation) {
	}
	
	/**
	 * 
	 * this method use to validation class name not exists
	 * 
	 * @param value
	 * @param context
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
	public boolean isValid(String className, ConstraintValidatorContext context) {
		if(className == null || className.isEmpty()) {
			return false;
		}
		
		Class c = classRepository.findByClassName(className);
		
		
		if(c == null){
			return true;
		}
		
		return false;
		
//		return !classService.existsByClassName(className);
	}

}
