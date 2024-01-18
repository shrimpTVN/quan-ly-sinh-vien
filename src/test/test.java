package test;

import java.util.ArrayList;

import javax.swing.UIManager;

import model.Tinh;
import view.AboutMeView;
import view.ThiSinhView;

public class test 
{
	public static void main(String[] args) {
		ThiSinhView  sv= new ThiSinhView();
		//new AboutMeView();
		try { 
			  
			 UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
	        } 
	        catch (Exception e) { 
	            System.out.println("Look and Feel not set"); 
	        } 
		// System.out.println("Yes");
		
	}
}
