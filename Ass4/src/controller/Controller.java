package controller;

import model.DrawArea;
import view.View;

public class Controller {
	
	private DrawArea drawArea;
	private View view;
	
	public Controller()
	{
		drawArea=new DrawArea();
		view=new View(drawArea);
		view.show();
	}
	
	public static void main(String args[])
	{
		new Controller();
	}

}
