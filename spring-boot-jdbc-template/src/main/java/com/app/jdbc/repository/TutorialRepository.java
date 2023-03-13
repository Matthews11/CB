package com.app.jdbc.repository;

import java.util.List;

import com.app.jdbc.model.TutorialModel;

public interface TutorialRepository {

	int save(TutorialModel book);

	int update(TutorialModel book);

	TutorialModel findById(long id);

	int delteById(long id);

	List<TutorialModel> findAll();
	
	List<TutorialModel> findByPublished(boolean published);

	List<TutorialModel> findByTitleContainning(String title);

	int deleteAll();
	
	

}
