package edu.ap.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import edu.ap.spring.model.EightBall;
import edu.ap.spring.view.UI;

@SpringBootApplication
public class EightBallApplication {
	
	@Autowired
	UI ui;
	
	@Autowired
	EightBall eightBall;
	
	public static void main(String[] args) {
		new SpringApplicationBuilder(EightBallApplication.class).headless(false).run(args);
	}
	
	@Bean
	CommandLineRunner runOnStartup() {
		return (args) -> {
			ui.setupUI();
			String answer1 = eightBall.getRandomAnswer("kysymykset3");
    		String answer2 = eightBall.getRandomAnswer("kysymykset3");
    		String answer4 = eightBall.getRandomAnswer("kysymykset3");
    		String answer5 = eightBall.getRandomAnswer("kysymykset3");
    		String answer6 = eightBall.getRandomAnswer("kysymykset3");
    		String answer7 = eightBall.getRandomAnswer("kysymykset3");
    		String answer8 = eightBall.getRandomAnswer("kysymykset3");
    		
    		System.out.println(answer1+answer2+answer4+answer5+answer6+answer7+answer8);
		};
	}
}