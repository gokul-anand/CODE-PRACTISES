package com.visa.prj.entity;

import java.util.Arrays;

public class Question {
	private String question;
	private String acutalAnswer;
	private String guessedAnswer;
	private int life;
	
	
	public Question(String question, String acutalAnswer, String guessedAnswer, int life) {
		this.question = question;
		this.acutalAnswer = acutalAnswer;
		this.guessedAnswer = guessedAnswer;
		this.life = life;
	}
	public int getLife() {
		return life;
	}
	public void setLife(int life) {
		this.life = life;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAcutalAnswer() {
		return acutalAnswer;
	}
	public void setAcutalAnswer(String acutalAnswer) {
		this.acutalAnswer = acutalAnswer;
	}
	public String getGuessedAnswer() {
		return guessedAnswer;
	}
	public void setGuessedAnswer(String guessedAnswer) {
		this.guessedAnswer = guessedAnswer;
	}
	
	
}
