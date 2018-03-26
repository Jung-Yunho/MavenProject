package com.newlecture.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.newlecture.dao.NoteDao;
import com.newlecture.entity.Note;

public class NoteService {

	@Autowired
	private NoteDao noteDao;
	
	public List<Note> getNoteList(Integer page) {
		
		//noteDao = new MyBatisNoteDao();
		
		return noteDao.getList(page);
	}

	public Note getNote(Integer id) {
		
		//noteDao = new MyBatisNoteDao()();
		
		return noteDao.get(id);
	}
	
}
