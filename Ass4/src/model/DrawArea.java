package model;


 
import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

import javax.swing.JComponent;
 

public class DrawArea extends JComponent {
 

  private Image image;
  private Graphics2D g2;
  private String savePath;
  private String openPath;
  private int currentAction=1;
  private boolean load = false;
  private Point start; 
  private Point end;
  private ArrayList<Shape>shapes=new ArrayList<Shape>();
  private ArrayList<Color>shapeStroke=new ArrayList<Color>();
  private DrawServiceImpl service=new DrawServiceImpl();
  public DrawArea() {
    
    /*
    addMouseListener(new MouseAdapter() {
      public void mousePressed(MouseEvent e) {
       
        oldX = e.getX();
        oldY = e.getY();
      }
    });
 
    addMouseMotionListener(new MouseMotionAdapter() {
      public void mouseDragged(MouseEvent e) {
     
        currentX = e.getX();
        currentY = e.getY();
 
        if (g2 != null) {
          g2.drawLine(oldX, oldY, currentX, currentY);
          repaint();
          oldX = currentX;
          oldY = currentY;
        }
      }
    });
  */
  }
  
 
  public void paint(Graphics g) {
  
      
      g2 = (Graphics2D) g;
      g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
      g2.setStroke(new BasicStroke(4));  
      for (int i = 0; i < shapes.size(); i++) {
       	g2.setPaint(shapeStroke.get(i)); 
       	g2.draw(shapes.get(i));
      	g2.fill(shapes.get(i));
		}
      
    if (load)
    {
     	Image img1 = Toolkit.getDefaultToolkit().getImage(openPath);
        g2.drawImage(img1, 0, 0, this);
        g2.setStroke(new BasicStroke(4));       
         for (int i = 0; i < shapes.size(); i++) {
        	// Grabs the next stroke from the color arraylist
         	g2.setPaint(shapeStroke.get(i)); 
         	g2.draw(shapes.get(i));
            
		}
    }
     
     
    //Guide shape used for drawing
    if (start != null && end != null){
    	
    	
    	Shape shape = null;
    	
    	if (currentAction==2)
    	{
    	shape = service.drawLine(start.x, start.y,
        		end.x, end.y);
    	} else if (currentAction==3)
    	{
    		shape = service.drawEllipse(start.x, start.y,
            		end.x, end.y);
    	} else if (currentAction==4)
    	{
    		shape = service.drawRectangle(start.x, start.y,
            		end.x, end.y);
    	}
    	g2.draw(shape);    
    	 
    }
  }
 

  /**
 * @return the image
 */
public Image getImage() {
	return image;
}


/**
 * @param image the image to set
 */
public void setImage(Image image) {
	this.image = image;
}


/**
 * @return the g2
 */
public Graphics2D getG2() {
	return g2;
}


/**
 * @param g2 the g2 to set
 */
public void setG2(Graphics2D g2) {
	this.g2 = g2;
}


/**
 * @return the savePath
 */
public String getSavePath() {
	return savePath;
}


/**
 * @param savePath the savePath to set
 */
public void setSavePath(String savePath) {
	this.savePath = savePath;
}


/**
 * @return the openPath
 */
public String getOpenPath() {
	return openPath;
}


/**
 * @param openPath the openPath to set
 */
public void setOpenPath(String openPath) {
	this.openPath = openPath;
}


/**
 * @return the currentAction
 */
public int getCurrentAction() {
	return currentAction;
}


/**
 * @param currentAction the currentAction to set
 */
public void setCurrentAction(int currentAction) {
	this.currentAction = currentAction;
}


/**
 * @return the load
 */
public boolean isLoad() {
	return load;
}


/**
 * @param load the load to set
 */
public void setLoad(boolean load) {
	this.load = load;
}


/**
 * @return the start
 */
public Point getStart() {
	return start;
}


/**
 * @param start the start to set
 */
public void setStart(Point start) {
	this.start = start;
}


/**
 * @return the end
 */
public Point getEnd() {
	return end;
}


/**
 * @param end the end to set
 */
public void setEnd(Point end) {
	this.end = end;
}


/**
 * @return the shapes
 */
public ArrayList<Shape> getShapes() {
	return shapes;
}


/**
 * @param shapes the shapes to set
 */
public void setShapes(ArrayList<Shape> shapes) {
	this.shapes = shapes;
}


/**
 * @return the shapeStroke
 */
public ArrayList<Color> getShapeStroke() {
	return shapeStroke;
}


/**
 * @param shapeStroke the shapeStroke to set
 */
public void setShapeStroke(ArrayList<Color> shapeStroke) {
	this.shapeStroke = shapeStroke;
}


/**
 * @return the service
 */
public DrawServiceImpl getService() {
	return service;
}


/**
 * @param service the service to set
 */
public void setService(DrawServiceImpl service) {
	this.service = service;
}



	public void addMyMouseActivity(MouseAdapter mouse){
		this.addMouseListener(mouse);
	}
	public void addMyMotionActivity(MouseMotionAdapter mouseM){
		this.addMouseMotionListener(mouseM);
	}
  
 
}