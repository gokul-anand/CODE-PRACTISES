package com.visa.prj.dao;

import com.visa.prj.entity.Question;

public class QuestionDao {
	public static Question getQuestion() {
		String question = "What is the highest moutain?";
		String answer= "Everest";
		String guessedAnswer = answer;
		Question questionObj = new Question(question,answer,guessedAnswer.replaceAll(".", "*"),5);
		
		return questionObj;
	}
}
