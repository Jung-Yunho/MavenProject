package com.newlecture.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.newlecture.entity.Note;

public interface NoteDao {
	@Select("select * from Note" + 
			"		limit ${(page-1)*15},15")
	List<Note> getList(@Param("page") Integer page);
	Note get(Integer id);
}
