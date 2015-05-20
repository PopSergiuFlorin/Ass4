package view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.MenuBar;
import java.awt.event.ActionListener;
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

import javax.swing.JButton;

public class View extends JFrame{

	JFrame frame;

	JPanel panel;
	JButton btnUndo,btnRectangle,btnEllipse,btnLine,btnBrush,btnColour,btnClear;
	private JPanel panel_1;
	private JButton btnSave;
	private JButton btnLoad;
	/**
	 * Launch the application.
	 */
	public View(DrawArea drawArea)
	{
	
		setTitle("Paint");
	    setSize(720, 755);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    getContentPane().setLayout(new BorderLayout(0, 0));
	    
	    panel = new JPanel();
	     getContentPane().add(panel,BorderLayout.NORTH);
	    
	    btnUndo = new JButton("Undo");
	    btnUndo.setBounds(21, 30, 89, 23);
	    panel.add(btnUndo);
	    
	    btnRectangle = new JButton("Rectangle");
	    btnRectangle.setBounds(120, 30, 89, 23);
	    panel.add(btnRectangle);
	    
	    btnEllipse = new JButton("Ellipse");
	    btnEllipse.setBounds(219, 30, 89, 23);
	    panel.add(btnEllipse);
	    
	    btnLine = new JButton("Line");
	    btnLine.setBounds(318, 30, 89, 23);
	    panel.add(btnLine);
	    
	     btnBrush = new JButton("Brush");
	     btnBrush.setBounds(417, 30, 89, 23);
	     panel.add(btnBrush);
	     
	      btnColour = new JButton("Color");
	      btnColour.setBounds(516, 30, 67, 23);
	      panel.add(btnColour);
	      
	       btnClear = new JButton("Clear");
	       btnClear.setBounds(593, 30, 89, 23);
	       panel.add(btnClear);
	       
	       btnSave = new JButton("Save");
	       panel.add(btnSave);
	       
	       btnLoad = new JButton("Load");
	       panel.add(btnLoad);
	        
	         
	         panel_1 = new JPanel();
	         getContentPane().add(drawArea,BorderLayout.CENTER);
	         
	    setVisible(true);
	    
	}
	/**
	 * @return the btnSave
	 */
	public JButton getBtnSave() {
		return btnSave;
	}
	/**
	 * @param btnSave the btnSave to set
	 */
	public void setBtnSave(JButton btnSave) {
		this.btnSave = btnSave;
	}
	/**
	 * @return the btnLoad
	 */
	public JButton getBtnLoad() {
		return btnLoad;
	}
	/**
	 * @param btnLoad the btnLoad to set
	 */
	public void setBtnLoad(JButton btnLoad) {
		this.btnLoad = btnLoad;
	}
	/**
	 * @return the panel_1
	 */
	public JPanel getPanel_1() {
		return panel_1;
	}
	/**
	 * @param panel_1 the panel_1 to set
	 */
	public void setPanel_1(JPanel panel_1) {
		this.panel_1 = panel_1;
	}

	/**
	 * @return the frame
	 */
	public JFrame getFrame() {
		return frame;
	}
	/**
	 * @param frame the frame to set
	 */
	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
	/**
	 * @return the drawArea
	 */
	
	/**
	 * @return the panel
	 */
	public JPanel getPanel() {
		return panel;
	}
	/**
	 * @param panel the panel to set
	 */
	public void setPanel(JPanel panel) {
		this.panel = panel;
	}
	/**
	 * @return the btnUndo
	 */
	public JButton getBtnUndo() {
		return btnUndo;
	}
	/**
	 * @param btnUndo the btnUndo to set
	 */
	public void setBtnUndo(JButton btnUndo) {
		this.btnUndo = btnUndo;
	}
	/**
	 * @return the btnRectangle
	 */
	public JButton getBtnRectangle() {
		return btnRectangle;
	}
	/**
	 * @param btnRectangle the btnRectangle to set
	 */
	public void setBtnRectangle(JButton btnRectangle) {
		this.btnRectangle = btnRectangle;
	}
	/**
	 * @return the btnEllipse
	 */
	public JButton getBtnEllipse() {
		return btnEllipse;
	}
	/**
	 * @param btnEllipse the btnEllipse to set
	 */
	public void setBtnEllipse(JButton btnEllipse) {
		this.btnEllipse = btnEllipse;
	}
	/**
	 * @return the btnLine
	 */
	public JButton getBtnLine() {
		return btnLine;
	}
	/**
	 * @param btnLine the btnLine to set
	 */
	public void setBtnLine(JButton btnLine) {
		this.btnLine = btnLine;
	}
	/**
	 * @return the btnBrush
	 */
	public JButton getBtnBrush() {
		return btnBrush;
	}
	/**
	 * @param btnBrush the btnBrush to set
	 */
	public void setBtnBrush(JButton btnBrush) {
		this.btnBrush = btnBrush;
	}
	/**
	 * @return the btnColour
	 */
	public JButton getBtnColour() {
		return btnColour;
	}
	/**
	 * @param btnColour the btnColour to set
	 */
	public void setBtnColour(JButton btnColour) {
		this.btnColour = btnColour;
	}
	/**
	 * @return the btnClear
	 */
	public JButton getBtnClear() {
		return btnClear;
	}
	/**
	 * @param btnClear the btnClear to set
	 */
	public void setBtnClear(JButton btnClear) {
		this.btnClear = btnClear;
	}

	public void addButtonActionListener(ActionListener listener){
		btnLine.addActionListener(listener);
		btnEllipse.addActionListener(listener);
		btnRectangle.addActionListener(listener);
		btnBrush.addActionListener(listener);
		btnColour.addActionListener(listener);
		btnUndo.addActionListener(listener);
		btnSave.addActionListener(listener);
		btnLoad.addActionListener(listener);
		btnClear.addActionListener(listener);
	}
}
