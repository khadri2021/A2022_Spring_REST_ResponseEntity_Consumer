package com.khadri.spring.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.khadri.spring.rest.service.StudentService;

@RestController
public class ConsumerRestController {

	@Autowired
	private StudentService service;

	@GetMapping("/consume/student")
	public void invoke() {
		service.callService();
	}

}
