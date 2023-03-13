package com.app.jdbc.repository.impl;

import java.util.List;

import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.app.jdbc.model.TutorialModel;
import com.app.jdbc.repository.TutorialRepository;
@Service
public class JdbcTutorialRepository implements TutorialRepository{

	private final JdbcTemplate template;
	
	public JdbcTutorialRepository(JdbcTemplate template) {
		this.template=template;
	}
	
	@Override
	public int save(TutorialModel book) {
		return template.update("INSERT INTO tutorials (title,description,published) VALUES(?,?,?)",
				new Object[] {book.getTitle(),book.getDescripcion(),book.isPublished()});
	}

	@Override
	public int update(TutorialModel book) {
		return template.update("UPDATE tutorials SET title=?,description=?,published=? where id=?",
				new Object[] {book.getTitle(),book.getDescripcion(),book.isPublished(),book.getId()});
	}

	@Override
	public TutorialModel findById(long id) {
		 try {
			 TutorialModel book = template.queryForObject("SELECT * FROM tutorials where id=?", BeanPropertyRowMapper.newInstance(TutorialModel.class),id);
			 return book;
		 } catch (IncorrectResultSizeDataAccessException e) {
			return null;
		}
	}

	@Override
	public int delteById(long id) {
		
		return template.update("DELETE FROM tutorials where id=?",id);
	}

	@Override
	public List<TutorialModel> findByPublished(boolean published) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TutorialModel> findByTitleContainning(String title) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteAll() {
		return template.update("DELETE FROM tutorials");
	}

	@Override
	public List<TutorialModel> findAll() {  
		return template.query("SELECT * FROM tutorials",BeanPropertyRowMapper.newInstance(TutorialModel.class));
	}

}
