package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Name;
import com.example.demo.repository.BasicCRUD;

@RestController
public class NameController {

	@Autowired
	BasicCRUD basicCRUD;

	@PostMapping(path = "/add")
	public Name addName(@RequestBody Map<String, String> map) {
		Name name = new Name();
		name.setName(map.get("name"));
		return basicCRUD.save(name);
	}

	@GetMapping(path = "/get")
	public List<Name> getName() {
		return basicCRUD.findAll();
	}

	@PutMapping(path = "/update")
	public Name updateName(@RequestBody Map<String, String> map) throws Exception {
		Integer id = Integer.parseInt(map.get("id"));
		Name name = basicCRUD.getOne(id);
		name.setName(map.get("newname"));
		return basicCRUD.save(name);
	}

	@DeleteMapping(path = "/delete")
	public String deleteName(@RequestBody Map<String, String> map) {
		Integer id = Integer.parseInt(map.get("id"));
		Name name = basicCRUD.getOne(id);
		try {
			basicCRUD.delete(name);
		} catch (IllegalArgumentException e) {
			return "notFound";
		}
		return "deleted";
	}
}
