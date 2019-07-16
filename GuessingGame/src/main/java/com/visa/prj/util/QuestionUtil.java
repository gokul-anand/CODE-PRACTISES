package com.visa.prj.util;

import com.visa.prj.dao.QuestionDao;
import com.visa.prj.entity.Question;

public class QuestionUtil {
	public static Question guessChar(Question q,String c) {
		c.toLowerCase();
		if (q.getAcutalAnswer().contains(c)) {
			String s ="";
			String guessedAnswer = q.getGuessedAnswer();
			String actualAnswer = q.getAcutalAnswer().toLowerCase();
			for(int i =0; i<guessedAnswer.length(); i++)
			{
				if (actualAnswer.charAt(i)==c.charAt(0)) {
					s += c;
				}
				else {
					s+= guessedAnswer.charAt(i);
				}
			
			}
			q.setGuessedAnswer(s);
		}
		else {
			q.setLife( q.getLife() - 1 );
		}
		
		return q;
	}
	
	public boolean isEnded(Question q) {
		return q.getLife() <= 0;
	}
	
	
}
