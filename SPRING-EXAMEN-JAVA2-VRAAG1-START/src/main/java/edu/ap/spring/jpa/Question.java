package edu.ap.spring.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Question {

	 @Id
	 @GeneratedValue
	 private Long id;
	
	@Column
	private String question;
	
    @Column
    private String answer;
	
    public Question(String question, String answer) {
    	this.question = question;
    	this.answer = answer;
    }
    
	public Question() {
		
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	
	
}
