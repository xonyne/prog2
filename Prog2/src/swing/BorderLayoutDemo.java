package swing;
	import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.awt.Toolkit;

	public class BorderLayoutDemo {
	public static boolean RIGHT_TO_LEFT = false;
	JWindow window;
	 
	public BorderLayoutDemo()
	{
		createAndShowGUI();
	}
	
	public void createAndShowGUI(){
		window = new JWindow();
		Toolkit tk = Toolkit.getDefaultToolkit();
		int xSize = ((int) tk.getScreenSize().getWidth());
		int ySize = ((int) tk.getScreenSize().getHeight());
		window.setSize(xSize,ySize);
		window.setVisible(true);
		window.setLayout(new BorderLayout());
		addComponentsToPane();
	}
	
	 public void addComponentsToPane() {
         
	        if (!(window.getLayout() instanceof BorderLayout)) {
	        	window.add(new JLabel("Container doesn't use BorderLayout!"));
	            return;
	        }
	         
	        if (RIGHT_TO_LEFT) {
	        	window.setComponentOrientation(
	                    java.awt.ComponentOrientation.RIGHT_TO_LEFT);
	        }
	         
	        JButton button = new JButton("Button 1 (PAGE_START)");
	        button.setPreferredSize(new Dimension(0, 200));
	        window.add(button, BorderLayout.PAGE_START);
	         
	        //Make the center component big, since that's the
	        //typical usage of BorderLayout.
	        button = new JButton("Button 2 (CENTER)");
	        button.setPreferredSize(new Dimension(200, 100));
	        window.add(button, BorderLayout.CENTER);
	         
	        button = new JButton("Button 3 (LINE_START)");
	        window.add(button, BorderLayout.LINE_START);
	         
	        button = new JButton("Long-Named Button 4 (PAGE_END)");
	        window.add(button, BorderLayout.PAGE_END);
	         
	        button = new JButton("5 (LINE_END)");
	        window.add(button, BorderLayout.LINE_END);
	    }
	
	public static void main(String[] args)
	{
		 /* Use an appropriate Look and Feel */
        try {
            //UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        } catch (InstantiationException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        /* Turn off metal's use bold fonts */
        UIManager.put("swing.boldMetal", Boolean.FALSE);
         
        //Schedule a job for the event dispatch thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new BorderLayoutDemo();
            }
        });
	}
}
