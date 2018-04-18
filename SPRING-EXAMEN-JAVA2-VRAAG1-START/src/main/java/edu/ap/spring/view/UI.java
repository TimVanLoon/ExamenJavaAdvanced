package edu.ap.spring.view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.TransferHandler;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UI implements InitializingBean {
	
	@Autowired
	EventHandler eventHandler;
	
	private JFrame jFrame;
	private JLabel questionLabel;
	private JLabel answerLabel;
	private JLabel answerText;
	private JLabel spacer;
	private JTextField questionTextField;
	private JPanel controlPanel;
    private JButton btnAsk;
    
    public UI() {}
    
    public void setupUI() {
	    jFrame = new JFrame("Magic 8 Ball");
	    jFrame.setLayout(new FlowLayout());
	    	
	    controlPanel = new JPanel();
	    controlPanel.setLayout(new GridLayout(3, 2));

	    questionLabel = new JLabel("Question: ");
	    questionTextField = new JTextField(15);
	    questionTextField.setDragEnabled(true);
	
	    btnAsk = new JButton();
	    btnAsk.setText("Ask");
	    btnAsk.setTransferHandler(new TransferHandler("text"));
	    btnAsk.addActionListener(eventHandler::whenButtonClicked);
	    
	    answerLabel = new JLabel("Answer: ");
	    answerText = new JLabel();


		controlPanel.add(questionLabel);
		controlPanel.add(questionTextField);
		controlPanel.add(btnAsk);
		controlPanel.add(spacer = new JLabel(" "),"span, grow");
		controlPanel.add(answerLabel);
		controlPanel.add(answerText);

		jFrame.add(controlPanel);
		        
		jFrame.setSize(400, 400);
		jFrame.setLocationRelativeTo(null);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.pack();
		jFrame.setVisible(true);
    }

    public JFrame getjFrame() {
        return this.jFrame;
    }
    
    public JTextField getQuestion() {
    		return this.questionTextField;
    }

    public JButton getButton() {
        return btnAsk;
    }
    
    public JLabel getAnswerLabel() {
    	return this.answerText;
    }
	
	@Override
	public void afterPropertiesSet() throws Exception {
		System.setProperty("java.awt.headless", "false");
	}
}
