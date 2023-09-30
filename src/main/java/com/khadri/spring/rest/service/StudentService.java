package com.khadri.spring.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.khadri.spring.rest.entity.Student;

public class StudentService {

	@Autowired
	RestTemplate restTemplate;

	public void callService() {

		ResponseEntity<Student> responseEntity = restTemplate.getForEntity(
				"http://localhost:8080/A2022_Spring_REST_ResponseEntity_Producer/get/student", Student.class);

		HttpHeaders headers = responseEntity.getHeaders();

		System.out.println("Response Entity headers start");
		headers.entrySet().forEach((entry) -> {
			String key = entry.getKey();
			List<String> listOfvalues = entry.getValue();
			System.out.println("key = " + key + " values= " + listOfvalues);
		});
		System.out.println("Response Entity headers end");

		System.out.println("Response Entity Body " + responseEntity.getBody());

		System.out.println("Response Entity Status Code: " + responseEntity.getStatusCode());
		System.out.println("Response Entity Status Code Value: " + responseEntity.getStatusCodeValue());
	}
}
