package turanberlin.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import turanberlin.hrms.business.abstracts.UserService;
import turanberlin.hrms.core.utils.resultSystem.DataResult;
import turanberlin.hrms.entities.concretes.User;

@RestController
@RequestMapping("/api/users")
public class UsersController {

	UserService userService;

	@Autowired
	public UsersController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@GetMapping("/get/all")
	public DataResult<List<User>> getAll() {
		return this.userService.getAll();
	}
	
}
