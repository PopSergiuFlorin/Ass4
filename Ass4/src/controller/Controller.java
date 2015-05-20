package controller;

import java.awt.Color;
import java.awt.Point;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileNameExtensionFilter;

import model.DrawArea;
import model.DrawServiceImpl;
import view.View;

public class Controller {
	
	private DrawArea drawArea=new DrawArea();
	private View view=new View(drawArea);
	private Color color=Color.BLACK;
	DrawServiceImpl service=new DrawServiceImpl();
	
	public Controller()
	{
		view.addButtonActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (e.getSource()==view.getBtnBrush()){
					drawArea.setCurrentAction(1);
				
				}
				if (e.getSource()==view.getBtnLine()){
					drawArea.setCurrentAction(2);
				}
				if (e.getSource()==view.getBtnEllipse()){
					drawArea.setCurrentAction(3);
				}
				if (e.getSource()==view.getBtnRectangle()){
					drawArea.setCurrentAction(4);
				}
				if(e.getSource()==view.getBtnColour()){
					color = JColorChooser.showDialog(null, "Pick a Stroke", Color.BLACK);
				}
				if(e.getSource()==view.getBtnSave()){
					
					
					 JFileChooser chooser = new JFileChooser();
					    FileNameExtensionFilter filter = new FileNameExtensionFilter(
					        "PNG Images", "png");
					    chooser.setFileFilter(filter);
					    int returnVal = chooser.showSaveDialog(view);
					    if(returnVal == JFileChooser.APPROVE_OPTION) {
					    	System.out.println(chooser.getSelectedFile().getPath());
					    	

					    	drawArea.setSavePath(chooser.getSelectedFile().getPath());
					    	service.saveImage(drawArea.getSavePath(),drawArea.getG2(), drawArea);
					    }
					
					
					
					}
				if(e.getSource()==view.getBtnLoad()){
					
					 JFileChooser chooser = new JFileChooser();
					    FileNameExtensionFilter filter = new FileNameExtensionFilter(
					        "PNG Images", "png");
					    chooser.setFileFilter(filter);
					    int returnVal = chooser.showOpenDialog(view);
					    if(returnVal == JFileChooser.APPROVE_OPTION) {

					    	drawArea.setOpenPath(chooser.getSelectedFile().getPath());
					    	 drawArea.setLoad(true);
							 drawArea.repaint();
					    }
					
					
			
				}
				if(e.getSource()==view.getBtnClear()){
					drawArea.getShapes().clear();
					drawArea.getShapeStroke().clear();
					drawArea.repaint();
					drawArea.setLoad(false);
				}
				if(e.getSource()==view.getBtnUndo()){
					if (drawArea.getShapes().size()>1 && 
								drawArea.getShapeStroke().size()>1 
									)
					{
						drawArea.getShapes().remove(drawArea.getShapes().size()-1);
						drawArea.getShapeStroke().remove(drawArea.getShapeStroke().size()-1);
						
					} else 
					{
						drawArea.getShapes().clear();
						drawArea.getShapeStroke().clear();
							
					}
					drawArea.repaint();
				}
				
			}
		});
		
		drawArea.addMyMouseActivity(new MouseAdapter() {
		      public void mousePressed(MouseEvent e){
		    	  if(drawArea.getCurrentAction() != 1)
		    	  {
		    		  drawArea.setStart(new Point(e.getX(), e.getY()));
		    		  drawArea.setEnd(drawArea.getStart());
		    		  drawArea.repaint();
		    
		    	  }
		      }
		      public void mouseReleased(MouseEvent e){
		    	  
		    	  if(drawArea.getCurrentAction()!=1){
		    	  
		    	  Shape shape = null; 
		    	  if(drawArea.getCurrentAction()==2)
		    	  {
		    		  shape=service.drawLine(drawArea.getStart().x,
		    				  drawArea.getStart().y,
		    				  e.getX(),
		    				  e.getY());
		    	  }
		    	  else if(drawArea.getCurrentAction()==3)
		    	  {	    		  
                		shape = service.drawEllipse(drawArea.getStart().x,
		    				  drawArea.getStart().y,
                				e.getX(), e.getY());        	
		    	  }
		    	  else if(drawArea.getCurrentAction()==4)
		    	  {	    		  
                		shape = service.drawRectangle(drawArea.getStart().x,
		    				  drawArea.getStart().y,
                				e.getX(), e.getY());        	
		    	  }
		    	  
		    	  
		    	  drawArea.getShapes().add(shape);
		    	  drawArea.getShapeStroke().add(color);
		    	  drawArea.setStart(null);
		    	  drawArea.setEnd(null);
		    	  
		    	  drawArea.repaint();
		    	  }		    	  
		      }
		});
		drawArea.addMyMotionActivity(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent e){
			if (drawArea.getCurrentAction()==1){	
				int x = e.getX();
				int y = e.getY();
				
				Shape shape=null;  
				shape = service.drawBrush(x,y,3,3);
				
				drawArea.getShapes().add(shape);
				drawArea.getShapeStroke().add(color);
			
			}
			drawArea.setEnd(new Point(e.getX(),e.getY()));
			drawArea.repaint();
			}
		});
	}
	
	public static void main(String args[])
	{
		Controller c=new Controller();
		c.view.setVisible(true);
	}

}
