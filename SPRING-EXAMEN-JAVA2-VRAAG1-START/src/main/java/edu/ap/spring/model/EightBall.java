package edu.ap.spring.model;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.ap.spring.jpa.Question;
import edu.ap.spring.jpa.QuestionRepository;

@Component
public class EightBall {
	
	private QuestionRepository repository;
	
	@Autowired
	public void setQuestionRepository(QuestionRepository repository) {
		this.repository = repository;
	}
	
	private String[] answers = {"It is certain", 
								"Yes definitely", 
								"Most likely",
								"Outlook good",
								"Better not tell you now",
								"Cannot predict now",
								"Don't count on it", 
								"Outlook not so good"};
	
	public String getRandomAnswer(String question) {
		
		long lengthOfList = repository.count();	
		Question oldQuestion = repository.findByQuestion(question);
		
		String answer = "";
				
		if(lengthOfList < answers.length) {
			
			if(oldQuestion == null) {
				for(int i = 0; i < answers.length; i++) {
					int id = new Random().nextInt(answers.length);
					answer = (answers[id]);
					
					List<Question> answerList = repository.findByAnswer(answer);
					
					for(Question q: answerList) {
						System.out.println("test list: " + q.getAnswer());
					}
					
					if(answerList.size() == 0) {
						return answer;
						
					} 
				}
			} else {
				Question oldQ = repository.findByQuestion(question);
				answer = oldQ.getAnswer();
				return answer;
			}
			
			
		} else {
			int id = new Random().nextInt(answers.length);
			answer = (answers[id]);
			return answer;
		}
		return answer;
	}

	public String[] getAnswers() {
		return answers;
	}

	public void setAnswers(String[] answers) {
		this.answers = answers;
	}
}
