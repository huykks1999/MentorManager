package com.vti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vti.repository.IAdminRepository;

@Service
public class AdminService implements IAdminService {
	@Autowired
	private IAdminRepository AdminRepository;

	@Override
	public boolean isGroupExistsByID(short id) {
		return AdminRepository.existsById(id);
	}

	@Override
	public boolean isGroupExistsByName(String name) {

		return AdminRepository.existsByUsername(name);
	}
}
