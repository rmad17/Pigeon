package org.pigeon.main;


import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import javax.swing.JTextField;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;


public final class MainFrame extends JFrame{

	/**
	 * 
	 */
	
	//JComboBox mbtype;
	JTextField email,passwd,ims,oms;
	//JPanel centre;
	final JMenuBar mainMenuBar;	
	final JMenu emailMenu,editMenu;
	final JMenuItem preferencesEditMenu,newMessageemailMenu,quitemailMenu;

	private final class ItemAction implements ActionListener	
	{
		@Override
		public void actionPerformed(ActionEvent ae)
		{
			String getItem=ae.getActionCommand();
			if(getItem.equals("Quit"))
				System.exit(1);
			if(getItem.equals("New Message"))
			{
                 		ComposeMail mail = new ComposeMail();
             			mail.pack();
            			mail.setVisible(true);
            			
            }
			if(getItem.equals("Preferences"))
			{
				Config conf=new Config();
				conf.pack();
				conf.setSize(600,400);
				conf.setLocation(300,300);
				conf.setVisible(true);
			}

		}
	}
	
	
	private MainFrame()
	{
		super("Emails? Use Me!");
		mainMenuBar=new JMenuBar();
		emailMenu=new JMenu("Email");
		editMenu=new JMenu("Edit");
		newMessageemailMenu=new JMenuItem("New Message");
		quitemailMenu=new JMenuItem("Quit");
		preferencesEditMenu=new JMenuItem("Preferences");
		mainMenuBar.add(emailMenu);
		mainMenuBar.add(editMenu);
		emailMenu.add(newMessageemailMenu);
		emailMenu.add(quitemailMenu);
		editMenu.add(preferencesEditMenu);
		setJMenuBar(mainMenuBar);
		newMessageemailMenu.addActionListener(new ItemAction());
		quitemailMenu.addActionListener(new ItemAction());
		preferencesEditMenu.addActionListener(new ItemAction());
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		
		MainFrame mainframe=new MainFrame();
		
		mainframe.setSize(400,300);
		mainframe.setLocation(100,100);
		//mainframe.pack();
		mainframe.setVisible(true);

	}

}
