package org.pigeon.main;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

public class ComposeMail extends JFrame{	

	JPanel fromPanel,toPanel,ccPanel,subjectPanel,topPanel,userText,bottomPanel;
	JTextField to,cc,subject;
	JTextArea mailText;
	JLabel from,userId,tf1,tf2,tf3;
	JButton send,cancel;

	private final class Send implements ActionListener 
	{
		@Override
		public void actionPerformed(ActionEvent ae)
		{
					String action=ae.getActionCommand();
					if(action.equals("Send"))
					{
						//System.exit(0);
						//mainframe.setVisible(true);
						//mail.setVisible(false);
					}
					if(action.equals("Cancel"))
					{
						System.exit(0);
					}
		}	
	}
	public ComposeMail()
	{
		super("Compose Mail");
		fromPanel=new JPanel();
		toPanel=new JPanel();
		ccPanel=new JPanel();
		subjectPanel=new JPanel();
		topPanel=new JPanel();
		userText=new JPanel();
		bottomPanel=new JPanel();
		to=new JTextField(50);
		cc=new JTextField(50);
		subject=new JTextField(45);
		mailText=new JTextArea(50,50);
		from=new JLabel("From");
		userId=new JLabel("foo@mail.com");
		tf1=new JLabel("To");
		tf2=new JLabel("Cc");
		tf3=new JLabel("Subject");
		send=new JButton("Send");
		cancel=new JButton("Cancel");

		setLayout(new BorderLayout());
		topPanel.setLayout(new GridLayout(4,1,1,4));
		fromPanel.add(from,BorderLayout.WEST);
		fromPanel.add(userId,BorderLayout.CENTER);
		toPanel.add(tf1,BorderLayout.WEST);
		toPanel.add(to,BorderLayout.CENTER);
		ccPanel.add(tf2,BorderLayout.WEST);
		ccPanel.add(cc,BorderLayout.CENTER);
		subjectPanel.add(tf3,BorderLayout.WEST);
		subjectPanel.add(subject,BorderLayout.CENTER);
		topPanel.add(fromPanel);
		topPanel.add(toPanel);
		topPanel.add(ccPanel);
		topPanel.add(subjectPanel);
		userText.add(mailText,BorderLayout.CENTER);
		bottomPanel.add(send,BorderLayout.WEST);
		bottomPanel.add(cancel,BorderLayout.EAST);
		//userText.add(send,BorderLayout.SOUTH);
		//add(fromPanel,BorderLayout.NORTH);
		add(topPanel,BorderLayout.NORTH);
		add(userText,BorderLayout.CENTER);
		add(bottomPanel,BorderLayout.SOUTH);
		send.addActionListener(new Send());
		cancel.addActionListener(new Send());
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	
	}	
	

	public static void main(String args[])
	{
		ComposeMail mail=new ComposeMail();
		mail.pack();
		mail.setSize(650,600);
		mail.setLocation(300,400);
		mail.setVisible(true);	

	}
	

}
