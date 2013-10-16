package org.pigeon.main;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import java.awt.Insets;
import java.io.FileNotFoundException;
import java.io.OutputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.FileOutputStream;
import java.io.FileInputStream;

public class Config extends JFrame 
{
	int c=0;
	String[] receive={"IMAP","POP"};
	String[] send={"SMTP","Sendmail"};
	final JButton backButton,cancelButton,forwardButton;
	final JTextField userFullName,userEmail,userPasswd,receivesv,receiveport,userID,sendsv,sendport;
	JPanel leftPanel,identityRightPanel,receiveRightPanel,sendRightPanel,bottomPanel,rpanel1,rpanel2,rpanel3,rpanel4;
	final JComboBox receiveType,sendType;
	JLabel identityLabel,receiveLabel,sendLabel,name,emailid,passwd,receivesvtype,receivesvLabel,receiveportLabel,userIDLabel,sendsvTypeLabel,sendsvLabel,sendportLabel;	

	
	private class ButtonAction implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent ae)
		{
			String button=ae.getActionCommand();
			if(button.equals("Cancel"))
				System.exit(0);
			if(button.equals("Forward"))
			{
				c++;
				if(c==1)
				{	
					backButton.setVisible(true);
					identityLabel.setFont(new Font("Arial", Font.PLAIN, 15));
					receiveLabel.setFont(new Font("Arial", Font.BOLD, 16));
					sendLabel.setFont(new Font("Arial", Font.PLAIN, 15));
					rpanel1.removeAll();
					rpanel2.removeAll();
					rpanel3.removeAll();
					rpanel4.removeAll();
					rpanel1.add(receivesvtype,BorderLayout.WEST);
					rpanel1.add(receiveType,BorderLayout.CENTER);
					rpanel2.add(receivesvLabel,BorderLayout.WEST);
					rpanel2.add(receivesv,BorderLayout.CENTER);
					rpanel3.add(receiveportLabel,BorderLayout.WEST);
					rpanel3.add(receiveport,BorderLayout.CENTER);
					rpanel4.add(userIDLabel,BorderLayout.WEST);
					rpanel4.add(userID,BorderLayout.CENTER);
					
					
					identityRightPanel.add(rpanel1);
					identityRightPanel.add(rpanel2);
					identityRightPanel.add(rpanel3);
					identityRightPanel.add(rpanel4);
					identityRightPanel.setLayout(new BoxLayout(identityRightPanel,BoxLayout.Y_AXIS));
					add(identityRightPanel,BorderLayout.CENTER);
					
				}
				if(c==2)
				{
					forwardButton.setText("Apply");
					
					identityLabel.setFont(new Font("Arial", Font.PLAIN, 15));
					receiveLabel.setFont(new Font("Arial", Font.PLAIN, 15));
					sendLabel.setFont(new Font("Arial", Font.BOLD, 16));
					
					rpanel1.removeAll();
					rpanel2.removeAll();
					rpanel3.removeAll();
					rpanel4.removeAll();
					rpanel1.add(sendsvTypeLabel,BorderLayout.WEST);
					rpanel1.add(sendType,BorderLayout.CENTER);
					rpanel2.add(sendsvLabel,BorderLayout.WEST);
					rpanel2.add(sendsv,BorderLayout.CENTER);
					rpanel3.add(sendportLabel,BorderLayout.WEST);
					rpanel3.add(sendport,BorderLayout.CENTER);
					
					identityRightPanel.add(rpanel1);
					identityRightPanel.add(rpanel2);
					identityRightPanel.add(rpanel3);
					identityRightPanel.add(rpanel4);
					identityRightPanel.setLayout(new BoxLayout(identityRightPanel,BoxLayout.Y_AXIS));
					add(identityRightPanel,BorderLayout.CENTER);
				}
			}
			if(button.equals("Go Back"))
			{
				c--;
				if(c==0)
				{
					backButton.setVisible(false);
					
					identityLabel.setFont(new Font("Arial", Font.BOLD, 16));
					receiveLabel.setFont(new Font("Arial", Font.PLAIN, 15));
					sendLabel.setFont(new Font("Arial", Font.PLAIN, 15));
					
					rpanel1.removeAll();
					rpanel2.removeAll();
					rpanel3.removeAll();
					rpanel4.removeAll();
					rpanel1.add(name,BorderLayout.WEST);
					rpanel1.add(userFullName,BorderLayout.CENTER);
					rpanel2.add(emailid,BorderLayout.WEST);
					rpanel2.add(userEmail,BorderLayout.CENTER);
					rpanel3.add(passwd,BorderLayout.WEST);
					rpanel3.add(userPasswd,BorderLayout.CENTER);
			    	identityRightPanel.add(rpanel1,BorderLayout.NORTH);
					identityRightPanel.add(rpanel2,BorderLayout.CENTER);
					identityRightPanel.add(rpanel3,BorderLayout.SOUTH);
					identityRightPanel.setLayout(new BoxLayout(identityRightPanel,BoxLayout.Y_AXIS));
					add(identityRightPanel,BorderLayout.CENTER);
				}
				
				if(c==1)
				{
					forwardButton.setText("Forward");
					backButton.setVisible(true);
					identityLabel.setFont(new Font("Arial", Font.PLAIN, 15));
					receiveLabel.setFont(new Font("Arial", Font.BOLD, 16));
					sendLabel.setFont(new Font("Arial", Font.PLAIN, 15));
					rpanel1.removeAll();
					rpanel2.removeAll();
					rpanel3.removeAll();
					rpanel4.removeAll();
					rpanel1.add(receivesvtype,BorderLayout.WEST);
					rpanel1.add(receiveType,BorderLayout.CENTER);
					rpanel2.add(receivesvLabel,BorderLayout.WEST);
					rpanel2.add(receivesv,BorderLayout.CENTER);
					rpanel3.add(receiveportLabel,BorderLayout.WEST);
					rpanel3.add(receiveport,BorderLayout.CENTER);
					rpanel4.add(userIDLabel,BorderLayout.WEST);
					rpanel4.add(userID,BorderLayout.CENTER);
					
					
					identityRightPanel.add(rpanel1);
					identityRightPanel.add(rpanel2);
					identityRightPanel.add(rpanel3);
					identityRightPanel.add(rpanel4);
					identityRightPanel.setLayout(new BoxLayout(identityRightPanel,BoxLayout.Y_AXIS));
					add(identityRightPanel,BorderLayout.CENTER);
				}
			}
			
			if(button.equals("Apply"))
			{
				String cb1,cb2,userFullNameValue,userEmailValue,userPasswdValue,receivesvValue,receiveportValue,userIDValue,sendsvValue,sendportValue;
				
				 
				try {
					FileOutputStream fos;
					fos = new FileOutputStream("config.tmp");
				
			      ObjectOutputStream oos = new ObjectOutputStream(fos);

			      oos.writeInt(12345);
			     
			      cb1=(String)receiveType.getSelectedItem();
			      cb2=(String)sendType.getSelectedItem();
			      userFullNameValue=userFullName.getText(); 
			      userEmailValue=userEmail.getText();
			      userPasswdValue=userPasswd.getText();
			      receivesvValue=receivesv.getText();
			      receiveportValue=receiveport.getText();
			      userIDValue=userID.getText();
			      sendsvValue=sendsv.getText();
			      sendportValue=sendport.getText();
			      oos.writeObject(userFullNameValue);
			      oos.writeObject(userEmailValue);
			      oos.writeObject(userPasswdValue);
			      oos.writeObject(cb1);
			      oos.writeObject(receivesvValue);
			      oos.writeObject(receiveportValue);
			      oos.writeObject(userIDValue);
			      oos.writeObject(cb2);
			      oos.writeObject(sendsvValue);
			      oos.writeObject(sendportValue);

			      //oos.writeObject(new Date());
			      oos.close();
					} 
				catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					}
				
			/*	try{
					FileInputStream fis = new FileInputStream("config.tmp");
			        ObjectInputStream ois = new ObjectInputStream(fis);

			        int i = ois.readInt();
			        String today = (String) ois.readObject();
			        sendsv.setText(today);
			        ois.close();
					}
				catch(FileNotFoundException fnfe)
				{
				
				}	
				catch(Exception e)
				{
					
				}*/
			     
			}
		}
	}
	
	
	public Config()
	{
		super("Configure your mail account");	
		backButton=new JButton("Go Back");
		backButton.setVisible(false);
		cancelButton=new JButton("Cancel");
		forwardButton=new JButton("Forward");
		userFullName=new JTextField(30);
		userEmail=new JTextField(30);
		userPasswd=new JTextField(30);
		receivesv=new JTextField(30);
		receiveport=new JTextField(10);
		userID=new JTextField(30);
		sendsv=new JTextField(30);
		sendport=new JTextField(10);
		leftPanel=new JPanel();
		identityRightPanel=new JPanel();
		rpanel1=new JPanel();
		rpanel2=new JPanel();
		rpanel3=new JPanel();
		rpanel4=new JPanel();
		receiveRightPanel=new JPanel();
		sendRightPanel=new JPanel();
		bottomPanel=new JPanel();
		receiveType=new JComboBox(receive);
		receiveType.setEditable(false);
		receiveType.setSelectedIndex(0);
		sendType=new JComboBox(send);
		sendType.setEditable(false);
		sendType.setSelectedIndex(0);
		identityLabel=new JLabel("1. Identity");
		identityLabel.setFont(new Font("Arial", Font.BOLD, 16));
		receiveLabel=new JLabel("2. Receiving Mail");
		receiveLabel.setFont(new Font("Arial", Font.PLAIN, 15));
		sendLabel=new JLabel("3. Sending Mail");
		sendLabel.setFont(new Font("Arial", Font.PLAIN, 15));
		name=new JLabel("Name");
		name.setFont(new Font("Arial", Font.PLAIN, 15));
		emailid=new JLabel("Email");
		emailid.setFont(new Font("Arial", Font.PLAIN, 15));
		passwd=new JLabel("Password");
		passwd.setFont(new Font("Arial", Font.PLAIN, 15));
		receivesvtype=new JLabel("Server Type");
		receivesvtype.setFont(new Font("Arial", Font.PLAIN, 15));
		sendsvTypeLabel=new JLabel();
		sendsvTypeLabel.setFont(new Font("Arial", Font.PLAIN, 15));
		receivesvLabel=new JLabel("Server URL");
		receivesvLabel.setFont(new Font("Arial", Font.PLAIN, 15));
		receiveportLabel=new JLabel("Port:");
		receiveportLabel.setFont(new Font("Arial", Font.PLAIN, 15));
		userIDLabel=new JLabel("Username");
		userIDLabel.setFont(new Font("Arial", Font.PLAIN, 15));
		sendsvLabel=new JLabel("Server URL");
		sendsvLabel.setFont(new Font("Arial", Font.PLAIN, 15));
		sendportLabel=new JLabel("Port:");
		sendportLabel.setFont(new Font("Arial", Font.PLAIN, 15));
		setLayout(new BorderLayout());
//		identityRightPanel.setLayout(new GridLayout(3,2));
		//rpanel1.add()
		rpanel1.add(name,BorderLayout.WEST);
		rpanel1.add(userFullName,BorderLayout.CENTER);
		rpanel2.add(emailid,BorderLayout.WEST);
		rpanel2.add(userEmail,BorderLayout.CENTER);
		rpanel3.add(passwd,BorderLayout.WEST);
		rpanel3.add(userPasswd,BorderLayout.CENTER);
    	identityRightPanel.add(rpanel1,BorderLayout.NORTH);
		identityRightPanel.add(rpanel2,BorderLayout.CENTER);
		identityRightPanel.add(rpanel3,BorderLayout.SOUTH);
		identityRightPanel.setLayout(new BoxLayout(identityRightPanel,BoxLayout.Y_AXIS));
		leftPanel.add(identityLabel,BorderLayout.PAGE_START);
		leftPanel.add(receiveLabel,BorderLayout.LINE_START);
		leftPanel.add(sendLabel,BorderLayout.PAGE_END);
		leftPanel.setLayout(new BoxLayout(leftPanel,BoxLayout.Y_AXIS));
		bottomPanel.add(backButton,BorderLayout.WEST);
		bottomPanel.add(cancelButton,BorderLayout.CENTER);
		bottomPanel.add(forwardButton,BorderLayout.EAST);
		add(leftPanel,BorderLayout.WEST);
		add(identityRightPanel,BorderLayout.CENTER);
		add(bottomPanel,BorderLayout.SOUTH);
		cancelButton.addActionListener(new ButtonAction());
		forwardButton.addActionListener(new ButtonAction());
		backButton.addActionListener(new ButtonAction());
	}
}
