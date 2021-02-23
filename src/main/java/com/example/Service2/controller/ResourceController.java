/**
 * 
 */
package com.example.Service2.controller;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.Service2.domain.Resource;

/**
 * @author jatin
 *
 */
@RestController
public class ResourceController {

	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/getResource1")
	public ResponseEntity<Resource> getResource(@RequestParam(name = "id") Long id) {
		ResponseEntity<Resource> responseEntity = null;
		String resourceUrl = "http://localhost:8010/service1/getResource1";
		responseEntity = restTemplate.getForEntity(resourceUrl + "?id=" + id, Resource.class);
		return responseEntity;
	}

	@PostMapping("/submitResource1")
	public ResponseEntity<Resource> submitResource(@RequestBody Resource resource) {
		String resourceUrl = "http://localhost:8010/service1/insertResource";

		HttpEntity<Resource> request = new HttpEntity<>(resource);
		ResponseEntity<Resource> response = restTemplate.exchange(resourceUrl, HttpMethod.POST, request,
				Resource.class);
		return response;
	}

	@PutMapping("/updateResource1/{id}")
	public ResponseEntity<?> updateResource(@PathParam(value = "id") Long id, @RequestBody Resource newResource) {
		String resourceUrl = "http://localhost:8010/service1/updateResource/{id}";
		System.out.println(newResource);
		HttpEntity<Resource> request = new HttpEntity<>(newResource);
		ResponseEntity<Resource> response = restTemplate.exchange(resourceUrl, HttpMethod.PUT, request, Resource.class,
				new Object[] { id });

		return response;
	}

	/**
	 * @return the restTemplate
	 */
	public RestTemplate getRestTemplate() {
		return restTemplate;
	}
}
