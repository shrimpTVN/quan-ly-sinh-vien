package controller;

import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import view.ThiSinhView;

public class ThiSinhListener implements ActionListener
{
	private ThiSinhView thiSinhView;


	public ThiSinhListener(ThiSinhView thisinhView) {
	
		this.thiSinhView = thisinhView;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String src=e.getActionCommand();

		
		//JOptionPane.showMessageDialog(thisinhView,"Ban da nhan nut: " +src);
		switch (src)
		{
		 case "Add":
			 thiSinhView.clearData();
			 thiSinhView.setUpdateButton(false);
			 break;
			 
		 case "Save":
			
			 if (e.getSource() instanceof JButton)
				 thiSinhView.pushData();
			 else
			 if ( e.getSource() instanceof JMenuItem)
					thiSinhView.saveFile(); 
			 break;
			 
		 case "Update":
			 thiSinhView.setUpdateButton(true);
			 thiSinhView.updateData();
			 break;
			 
		 case "Delete":
			 thiSinhView.deleteData();
			 break;
			 
		 case "Cancle":
			 JButton button = (JButton) e.getSource();
			 String name= button.getName();
				
			 if (name.equals("CancleButton2"))
				thiSinhView.clearData();
			 else
				 if (name.equals("CancleButton1"))
				{
					thiSinhView.printAllData();
				}
			break;
			
		 case "Filter":	
				thiSinhView.timKiem();
				break;
		 case "About Me":
			 thiSinhView.showAboutMe();
			 break;
		 case "Exit":
			 thiSinhView.thucHienExit();
			 break;
		 case "Open":
			 thiSinhView.openFile();
			 break;
		 case "Close":
			 thiSinhView.closeFile();
			 break;
		 case "New":
		 	thiSinhView.newFile();
		 	break;
		}
		
		
	}

	
}
