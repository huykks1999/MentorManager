/**
 * @author: LQHuy
 * @create_date: Mar 7, 2021
 * @TODO
 * @IdExistsValidation
 */
package com.vti.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.vti.entity.Class;
import com.vti.repository.IClassRepository;

/**
 * @author Administrator
 *
 */
public class IdExistsValidation implements ConstraintValidator<IdExists, Short> {

	@Autowired
	private IClassRepository classRepository;

	/**
	 * 
	 * 
	 * 
	 * @param value
	 * @param context
	 * @return
	 * @Description:
	 * @author: LQHuy
	 * @create_date: Mar 7, 2021
	 * @version: 1.0
	 * @modifer: LQHuy
	 * @modifer_date: Mar 7, 2021
	 *
	 */
	@Override
	public boolean isValid(Short id, ConstraintValidatorContext context) {
		
		return classRepository.existsById(id);
	}

}
