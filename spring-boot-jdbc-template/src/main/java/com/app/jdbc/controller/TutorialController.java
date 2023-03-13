package com.app.jdbc.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.jdbc.model.TutorialModel;
import com.app.jdbc.repository.TutorialRepository;

@RestController
@RequestMapping("/api")
public class TutorialController {

	private final TutorialRepository repo;
	
	public TutorialController(TutorialRepository repo) {
		this.repo=repo;
	}
	
	@GetMapping("/all")
	public List<TutorialModel> all(){
		return repo.findAll();
	}
	
	@GetMapping("/{id}")
	public TutorialModel findById(@PathVariable ("id") long id) {
		TutorialModel book =repo.findById(id);
		return book;
	}
	
	@PostMapping("/save")
	public int save(@RequestBody TutorialModel book) {
		return repo.save(book);
	}
	
	@PutMapping("/update")
	public int update(@RequestBody TutorialModel book) {
		return repo.update(book);
	}
	
	@DeleteMapping("/delete/{id}")
	public int delete(@PathVariable long id) {
		return repo.delteById(id);
	} 
	
}
