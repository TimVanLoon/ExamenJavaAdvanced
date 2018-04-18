package edu.ap.spring.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.ap.spring.jpa.Question;
import edu.ap.spring.jpa.QuestionRepository;
import edu.ap.spring.model.EightBall;

import java.awt.event.ActionEvent;

@Service
public class EventHandler {

	@Autowired
	private EightBall eightBall;
	
    private UI ui;
    private QuestionRepository repository;
    
    @Autowired
    public void setRepository(QuestionRepository repository) {
    		this.repository = repository;
    }
    
    @Autowired
    public void setUI(UI ui) {
    		this.ui = ui;
    }

    public void whenButtonClicked(ActionEvent actionEvent) {
    		
    	String questionText = ui.getQuestion().getText();
    	String answer = eightBall.getRandomAnswer(questionText);
    	
    	ui.getAnswerLabel().setText(answer);
    	
    	Question question = new Question(questionText, answer);
    	
    	try {
    		repository.save(question);
    		System.out.println(question.toString() + " saved in repository");
    	} catch(Exception e) {
    		
    	} finally {
    		System.out.println("Find all : ") ;
            repository.findAll().forEach(System.out::println);
    	}

       
        
    }
}

