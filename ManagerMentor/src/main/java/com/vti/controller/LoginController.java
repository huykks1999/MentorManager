package com.vti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vti.entity.Admin;

@RestController
@RequestMapping(value="Login")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class LoginController {

//	@Autowired
//	private IMenteeService service;
//	
//	@GetMapping()
//	public ResponseEntity<?> getMenteeAndLogin(@RequestParam(value = "MenteeName")String MenteeName,@RequestParam(value = "passWord")String passWord){
//		Mentee Mentee = service.getMenteeAndLogin(MenteeName, passWord);
//		return new ResponseEntity<Admin>(Mentee,HttpStatus.OK);
//	}
}