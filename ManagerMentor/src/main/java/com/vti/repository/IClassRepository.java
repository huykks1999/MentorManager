package com.vti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vti.entity.Class;

@Repository
public interface IClassRepository extends JpaRepository<Class, Short> {
	
	/**
	 * 
	 * this method use to find a class by className
	 * 
	 * @param className
	 * @return Class
	 * @Description:
	 * @author: LQHuy
	 * @create_date: Mar 4, 2021
	 * @version: 1.0
	 * @modifer: LQHuy
	 * @modifer_date: Mar 4, 2021
	 * @return Class
	 *
	 */
	public Class findByClassName(String className);
	
	
	/**
	 * 
	 * this method use to check class exists by ClassName
	 * 
	 * @param className
	 * @return
	 * @Description:
	 * @author: LQHuy
	 * @create_date: Mar 6, 2021
	 * @version: 1.0
	 * @modifer: LQHuy
	 * @modifer_date: Mar 6, 2021
	 * @return: boolean
	 *
	 */
	public boolean existsByClassName(String className);
	
	
	/**
	 * 
	 * this method use to check class exists by id
	 * 
	 * @param id
	 * @return
	 * @Description:
	 * @author: LQHuy
	 * @create_date: Mar 7, 2021
	 * @version: 1.0
	 * @modifer: LQHuy
	 * @modifer_date: Mar 7, 2021
	 *
	 */
	public boolean existsById(Short id);
	
	
}
