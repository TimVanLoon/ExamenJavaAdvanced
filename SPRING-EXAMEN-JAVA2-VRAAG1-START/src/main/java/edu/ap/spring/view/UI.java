package edu.ap.spring.view;

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
import org.springframework.stereotype.Component;

@Component
public class UI implements InitializingBean {
	
	private JFrame jFrame;
	private JLabel questionLabel;
	private JTextField questionTextField;
	private JPasswordField userPass;
	private JPanel controlPanel;
    private JButton btnAsk;
    
    public UI() {}
    
    public void setupUI() {
	    jFrame = new JFrame("Magic 8 Ball");
	    jFrame.setLayout(new FlowLayout());
	    	
	    controlPanel = new JPanel();
	    controlPanel.setLayout(new GridLayout(3, 2));

	    questionLabel = new JLabel("Question : ");
	    questionTextField = new JTextField(15);
	    questionTextField.setDragEnabled(true);

	    btnAsk = new JButton();
	    btnAsk.setText("Ask");
	    btnAsk.setTransferHandler(new TransferHandler("text"));

		controlPanel.add(questionLabel);
		controlPanel.add(questionTextField);
		controlPanel.add(btnAsk);

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
    
    public JTextField getUserName() {
    		return this.userName;
    }
    
    public JPasswordField getPassword() {
		return this.userPass;
    }

    public JButton getButton() {
        return btnAddUser;
    }
	
	@Override
	public void afterPropertiesSet() throws Exception {
		System.setProperty("java.awt.headless", "false");
	}
}
