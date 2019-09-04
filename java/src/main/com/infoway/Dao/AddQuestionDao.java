package com.infoway.Dao;

import java.util.ArrayList;

import com.model.AddQuestion;
import com.model.MCQ;


public interface AddQuestionDao {

	public boolean insertFromExcel(ArrayList<MCQ> alist);
}
