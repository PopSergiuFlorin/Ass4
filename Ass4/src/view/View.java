package view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.border.EmptyBorder;

import model.DrawArea;

public class View {

	JFrame frame;
	DrawArea drawArea;

	/**
	 * Launch the application.
	 */
	public View(DrawArea drawArea)
	{
		this.drawArea=drawArea;
	}
	/**
	 * Create the frame.
	 */
	public void show() {
		
		JFrame frame = new JFrame();
	    Container content = frame.getContentPane();
	    content.setLayout(new BorderLayout());
	    content.add(drawArea, BorderLayout.CENTER);
	    frame.setSize(600, 600);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setVisible(true);

		
	}

	
}
