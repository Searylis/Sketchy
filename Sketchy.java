import processing.core.*; 
import processing.xml.*; 

import java.applet.*; 
import java.awt.Dimension; 
import java.awt.Frame; 
import java.awt.event.MouseEvent; 
import java.awt.event.KeyEvent; 
import java.awt.event.FocusEvent; 
import java.awt.Image; 
import java.io.*; 
import java.net.*; 
import java.text.*; 
import java.util.*; 
import java.util.zip.*; 
import java.util.regex.*; 

public class Sketchy extends PApplet {

ControlPanel testPanel;
int currentColour = color(0);
int fillColour = color(0,0,0,0);
Pencil pencil = new Pencil(currentColour);
Rubber rubber = new Rubber();
Brush brush = new Brush(currentColour, 7);
Rectangle rect = new Rectangle(2, currentColour);
Circle circle = new Circle(2, currentColour);
Line line = new Line(2, currentColour);
Text text = new Text(currentColour, 15);
PImage imgPencil;
PImage imgBrush;
PImage imgRubber;
PImage imgClear;
PImage imgText;
PImage imgRect;
PImage imgEllipse;
PImage imgLine;

public void clearScreen()
{
    fill(255);
    stroke(255);
    noSmooth();
    rect(102, 0, width-100, height);
}

public void setup()
{
  size(900, 600);
  background(255);
  testPanel = new ControlPanel();
  testPanel.drawPanel();
  PFont p = loadFont("Courier.vlw");
  text.setFont(p);
  
  imgPencil = loadImage("pencil.jpg");
  image(imgPencil, 12, 12);
  imgRubber = loadImage("rubber.jpg");
  image(imgRubber, 62, 12);
  imgBrush = loadImage("brush.jpg");
  image(imgBrush, 12, 62);
  imgRect = loadImage("rect.jpg");
  image(imgRect, 62, 62);
  imgEllipse = loadImage("ellipse.jpg");
  image(imgEllipse, 12, 112);
  imgLine = loadImage("line.jpg");
  image(imgLine, 62, 112);
  imgText = loadImage("text.jpg");
  image(imgText, 12, 162);
  
  imgClear = loadImage("clear.jpg");
  image(imgClear, 37, 212);
  
  loadPixels();
}

public void draw()
{
    if(mousePressed && mouseButton == LEFT)
    {
        if(mouseX <= 100)
        {
            if(mouseY < 300)
            {
                testPanel.chooseState(mouseX, mouseY);
                int state = testPanel.getState();
                switch(state)
                {
                    case 0:
                        break;
                    case 1:
                        rect.setActivation(false);
                        pencil.setActivation(true);
                        rubber.setActivation(false);
                        brush.setActivation(false);
                        circle.setActivation(false);
                        line.setActivation(false);
                        text.setActivation(false);
                        break;
                    case 2:
                        rect.setActivation(false);
                        rubber.setActivation(true);
                        pencil.setActivation(false);
                        brush.setActivation(false);
                        circle.setActivation(false);
                        line.setActivation(false);
                        text.setActivation(false);
                        break;
                    case 3:
                        rect.setActivation(false);
                        rubber.setActivation(false);
                        pencil.setActivation(false);
                        brush.setActivation(true);
                        circle.setActivation(false);   
                        line.setActivation(false);
                        text.setActivation(false);
                        break;
                    case 4:
                        rect.setActivation(true);
                        rubber.setActivation(false);
                        pencil.setActivation(false);
                        brush.setActivation(false);  
                        circle.setActivation(false);  
                        line.setActivation(false); 
                        text.setActivation(false);
                        break;
                    case 5:
                        rect.setActivation(false);
                        rubber.setActivation(false);
                        pencil.setActivation(false);
                        brush.setActivation(false);    
                        circle.setActivation(true); 
                        line.setActivation(false);
                        text.setActivation(false);
                        break;             
                      case 6:
                        rect.setActivation(false);
                        rubber.setActivation(false);
                        pencil.setActivation(false);
                        brush.setActivation(false);    
                        circle.setActivation(false); 
                        line.setActivation(true);
                        text.setActivation(false);
                        break;
                    case 7:
                        rect.setActivation(false);
                        rubber.setActivation(false);
                        pencil.setActivation(false);
                        brush.setActivation(false);    
                        circle.setActivation(false); 
                        line.setActivation(false);
                        text.setActivation(true);
                         break;
                    case 8:
                        rect.setBoolFill(false);
                        circle.setBoolFill(false);
                        line.setBoolFill(false);
                        break;
                    case 9:
                        clearScreen();
                        loadPixels();
                        break;
                    default:
                        break;
                }
            }
            else if(mouseY >= 430 && mouseY <= 565 && mouseX >= 25 && mouseX <= 90)
            {
                currentColour = testPanel.getColour(mouseX, mouseY, currentColour);
                pencil.setColour(currentColour);
                brush.setColour(currentColour);
                rect.setColour(currentColour);
                circle.setColour(currentColour);
                line.setColour(currentColour);
                text.setColour(currentColour);
                //put all other tools here
            }
        }
        else if(mouseX > 100)
        {
            if(pencil.getActivation())
            {
                pencil.drawPencil(mouseX, mouseY);
                loadPixels();
            }
            else if(rubber.getActivation())
            {
                rubber.drawRubber(mouseX, mouseY);
                loadPixels();
            }
            else if(brush.getActivation())
            {
                brush.drawBrush(mouseX, mouseY);
                loadPixels();
            }
            else if(rect.getActivation() && !rect.getDrag())
            {
                rect.setStartX(mouseX);
                rect.setStartY(mouseY);
                rect.setWhile(true);
                rect.setDrag(true);
            }
            else if(circle.getActivation() && !circle.getDrag())
            {
                circle.setStartX(mouseX);
                circle.setStartY(mouseY);
                circle.setWhile(true);
                circle.setDrag(true);
            }
            
        else if(line.getActivation() && !line.getDrag())
        {
                line.setStartX(mouseX);
                line.setStartY(mouseY);
                line.setWhile(true);
                line.setDrag(true);
           }
        else if(text.getActivation())
        {
                text.setX(mouseX);
                text.setY(mouseY);
           }
        }
    }
    else if(mousePressed && mouseButton == RIGHT)
    {
             if(mouseY >= 430 && mouseY <= 565 && mouseX >= 25 && mouseX <= 90)
            {
                fillColour = testPanel.getColour(mouseX, mouseY, fillColour);
                rect.setFill(true, fillColour);
                circle.setFill(true, fillColour);
                line.setFill(true, fillColour);
            }       
    }
}

public void mouseDragged()
{
    if(mouseX > 100)
    {
  if (pencil.getActivation())
  {
    float prevX = pencil.getPrevX();
    float prevY = pencil.getPrevY();
    if(prevX == 0 && prevY == 0)
    {
        pencil.drawPencil(mouseX, mouseY);
    }
   else
   {
        pencil.drawPencil(mouseX, mouseY);
        line(prevX, prevY, mouseX, mouseY);
    }
    loadPixels();
  }
  else if(brush.getActivation())
  {
      float prevX = brush.getPrevX();
      float prevY = brush.getPrevY();
      if (prevX == 0 && prevY == 0)
      {
        brush.drawBrush(mouseX, mouseY);
      }
      else
      {
        brush.drawBrush(mouseX, mouseY);
        line(prevX, prevY, mouseX, mouseY);
      }
      loadPixels();
    }
  else if(rect.getActivation() && rect.getDrag())
  {
      rect.keepStart();
      updatePixels();
      rect.setEndX(mouseX);
      rect.setEndY(mouseY);
      rect.drawRect();
  }
   else if(circle.getActivation() && circle.getDrag())
  {
      circle.keepStart();
      updatePixels();
      circle.setEndX(mouseX);
      circle.setEndY(mouseY);
      circle.drawCircle();
  }
  else if(line.getActivation() && line.getDrag())
  {
      line.keepStart();
      updatePixels();
      line.setEndX(mouseX);
      line.setEndY(mouseY);
      line.drawLine();
  } 
  }
}

public void mouseReleased()
{
    if(rect.getActivation() && rect.getWhile())
    {
        updatePixels();
        rect.setEndX(mouseX);
        rect.setEndY(mouseY);
        rect.setWhile(false);
        rect.setDrag(false);
        rect.drawRect();
        loadPixels();
    }
    if(circle.getActivation() && circle.getWhile())
    {
        updatePixels();
        circle.setEndX(mouseX);
        circle.setEndY(mouseY);
        circle.setWhile(false);
        circle.setDrag(false);
        circle.drawCircle();
        loadPixels();
    }    
    if(line.getActivation() && line.getWhile())
    {
        updatePixels();
        line.setEndX(mouseX);
        line.setEndY(mouseY);
        line.setWhile(false);
        line.setDrag(false);
        line.drawLine();
        loadPixels();
    }    
}

public void keyTyped()
{
    if(text.getActivation())
    {
        text.drawText(PApplet.parseChar(key));
        float x = text.getX();
        x += 9;
        text.setX(x);
        loadPixels();
    }
}

class Brush extends PixelClass
{   
    Brush(int _c, float _stroke)
    {
        super(_stroke, _c);
        prevX = 0;
        prevY = 0;
    }
    
    public void drawBrush(float posX, float posY)
    {
        super.drawPixel(posX, posY);
        smooth();
        point(posX, posY);
        prevX = posX;
        prevY = posY;
    }
}
class Circle extends Shape
{
    public Circle(float _stroke, int _c)
    {
        super(_stroke, _c);
    }
    
    public void drawCircle()
    {
        super.drawShape();
        float xCoord = (endX - startX)/2.0f + startX;
        float yCoord = (endY - startY)/2.0f + startY;
        float w = abs(endX - startX);
        float h = abs(endY - startY);
        ellipse(xCoord, yCoord, w, h);
    }
}
class ColorTable
{
    private int nColumns = 2;
    private int nLines = 5;
    private int[] colours = new int[nColumns*nLines];
    private float xPos;
    private float yPos;
    private float squareSize;   
    private float xMax = nColumns*squareSize+(nColumns-1)*15;
    private float yMax = nLines*squareSize+(nLines-1)*15;
    
    public ColorTable(float _x, float _y)
     {
        xPos = _x;
        yPos = _y;
        fillColours();
        squareSize = 15;
        }
        
    public void fillColours()
    {
        colours[0] = color(0xff000000);
        colours[1] = color(0xffffffff);
        colours[2] = color(0xffff0000);
        colours[3] = color(0xffff00ff);
        colours[4] = color(0xffffff00);
        colours[5] = color(255,127,39);
        colours[6] = color(0xff00ff00);
        colours[7] = color(0xff00ffff);
        colours[8] = color(128,0,255);
        colours[9] = color(0xff0000ff);
    }
    
    public void drawTable()
    {
        float poneis = xPos;
        float malditos = yPos;  
        for(int i = 0; i < 5; i++)
        {
            for(int j = 0; j < 2; j++)
            {
                int c = colours[i*2+j];
                fill(c);
                float xSquare = poneis+30*j;
                float ySquare = malditos+30*i;
                rect(xSquare, ySquare, squareSize, squareSize);
            }
        }      
    }
    
    public int getColour(float _x, float _y, int _c)
    {
        int xColour = (int) _x/15;
        int yColour = (int) _y/15;
        
        if(xColour%2 == 0 && yColour%2 == 0) 
            return colours[yColour + xColour/2];
        else
            return _c;
    }
    
    public float getXMax()
    {
        return xMax;
    }
    
    public float getYMax()
    {
        return yMax;
    }
    
    public float getX()
    {
        return xPos;
    }
    
    public float getY()
    {
        return yPos;
    }
}

class ControlPanel
{
    private int state;
    private int bgColor;
    private ColorTable cTable; //colour table - Has all the available colours
    private float xLength;
    private float yLength;
    private float buttonLength;
    
    public ControlPanel()
    {
        bgColor = (0xffaeaeae);
        state = 0;
        cTable = new ColorTable(25, 430); //ColorTable is a class
        xLength = 100;
        yLength = 600;
        buttonLength = 25;
    }
    
    public void chooseState(float _x, float _y)
    {
        int xChoice = (int) floor(_x/12.5f);
        int yChoice = (int) floor(_y/12.5f);
        
        if(xChoice == 1 || xChoice == 2)
        {
            if(yChoice == 1 || yChoice == 2)
                state = 1;
            else if(yChoice == 5 || yChoice == 6)
                state = 3;
            else if(yChoice == 9 || yChoice == 10)
                state = 5;
            else if(yChoice == 13 || yChoice == 14)
                state = 7;
        }
        else if(xChoice == 5 || xChoice == 6)
        {
            if(yChoice == 1 || yChoice == 2)
                state = 2;
            else if(yChoice == 5 || yChoice == 6)
                state = 4;
            else if(yChoice == 9 || yChoice == 10)
                state = 6;
            else if(yChoice == 13 || yChoice == 14)
                state = 8;            
        }
        else if(xChoice == 3 || xChoice == 4)
        {
            if(yChoice == 17 || yChoice == 18)
                state = 9;
        }
    }
    
    public int getState()
    {
        return state;
    }
    
    public int getColour(float _x, float _y, int _c)
    {
        float xColour = _x-cTable.getX();
        float yColour = _y-cTable.getY();
        return cTable.getColour(xColour, yColour, _c);
    }
    
    public void drawButtons()
    {
        fill(0xffffffff);
        float poneis = 25/2;
        float malditos = 25/2; 
        float yEnd = 0;
        for(int i = 0; i < 4; i++)
        {
            for(int j = 0; j < 2; j++)
            {
                float xSquare = malditos+buttonLength*2*j;
                float ySquare = poneis+buttonLength*2*i;
                rect(xSquare, ySquare, buttonLength, buttonLength);
                yEnd = ySquare;
            }
        }      
        rect(25/2+25,yEnd+buttonLength*2,buttonLength,buttonLength);        
    }
    
    public void drawPanel() //draw the control Panel
    {
          fill(bgColor);
          stroke(bgColor);
          rect(0, 0, xLength, yLength);
          stroke(0,0);
          line(xLength, 0, xLength ,yLength);
          drawButtons();
          stroke(0);
          cTable.drawTable();
    }

    public float getColourXMax()
    {
        return cTable.getXMax();
    }

    public float getColourYMax()
    {
        return cTable.getYMax();
    }
}

class Line extends Shape
{
    public Line(float _stroke, int _c)
    {
        super(_stroke, _c);
    }
    
    public void drawLine()
    {
        super.drawShape();
       line(startX, startY, endX, endY);
    }
}


class Pencil extends PixelClass
{ 

    
    public Pencil(int _c) 
    {
        prevX = 0;
        prevY = 0;
        pixelColour = _c;
        weight = 2;
    }
    
    public void drawPencil(float posX, float posY)
    {
        super.drawPixel(posX, posY);
        point(posX, posY);
        prevX = posX;
        prevY = posY;
    }
}
class PixelClass
{
    protected int pixelColour;
    protected float weight;
    protected boolean activated;
    protected float prevX;
    protected float prevY;
    
    public PixelClass() {}
    
    public PixelClass(float _stroke, int _c)
    {
        weight = _stroke;
        pixelColour = _c;
        activated = false;
    }
    
    public void drawPixel(float posX, float posY)
    {
        fill(pixelColour);
        stroke(pixelColour);
        strokeWeight(weight);
        noSmooth();
    }
    
    public void setActivation(boolean b)
    {
        activated = b;
    }
    
    public boolean getActivation()
    {
        return activated;
    }
    
    public void setColour(int c)
    {
        pixelColour = c;
    }
    
    public float getPrevX()
    {
        return prevX;
    }
    
    public float getPrevY()
    {
        return prevY;
    }
}
class Rectangle extends Shape
{
    public Rectangle(float _stroke, int _c)
    {
        super(_stroke, _c);
    }
    
    public void drawRect()
    {
        super.drawShape();
        float diffX = endX-startX;
        float diffY = endY-startY;
        rect(startX, startY, diffX, diffY);
    }
}
class Rubber extends PixelClass
{
    float rubberSize;
    
    Rubber()
    {
        rubberSize = 20;
        pixelColour = color(255);
        weight = 1;
    }
    
    public void drawRubber(float posX, float posY)
    {
        super.drawPixel(posX, posY);
        float xStart = posX - rubberSize/2;
        float yStart = posY - rubberSize/2;
        rect(xStart, yStart, rubberSize, rubberSize);
    }
}

class Shape
{
  protected int lineColour;
  protected float startX;
  protected float startY;
  protected float endX;
  protected float endY;
  protected float weight;
  protected int fillColour;
  protected boolean hasFill;
  protected boolean activated;
  protected boolean whileDraw;
  protected boolean dragBool;

  public Shape() {
  }

  public Shape(float _stroke, int _line)
  {
    weight = _stroke;
    lineColour = _line;
    activated = false;
    hasFill = false;
    dragBool = false;
  }

  public void drawShape()
  {
    if (hasFill) fill(fillColour);
    else fill(0, 0, 0, 0);
    stroke(lineColour);
    strokeWeight(weight);
    noSmooth();
  }

  public void setActivation(boolean b)
  {
    activated = b;
  }

  public boolean getActivation()
  {
    return activated;
  }

  public void setColour(int c)
  {
    lineColour = c;
  }

  public void setFill(boolean b, int c)
  {
    hasFill = true;
    fillColour = c;
  }

  public void keepStart()
  {
    float keepX = startX;
    float keepY = startY;
    startX = keepX;
    startY = keepY;
  }

  public void setStartX(float _x)
  {
    startX = _x;
  }
  public void setStartY(float _y)
  {
    startY = _y;
  } 

  public void setEndX(float _x)
  {
    endX = _x;
  }

  public void setEndY(float _y)
  {
    endY = _y;
  }

  public void setWhile(boolean b)
  {
    whileDraw = b;
  }

  public boolean getWhile()
  {
    return whileDraw;
  }
  
  public void setDrag(boolean b)
  {
    dragBool = b;
  }

  public boolean getDrag()
  {
    return dragBool;
  }
  
  public void setBoolFill(boolean b)
  {
      hasFill = b;
  }
}
class Text
{
  protected int textColour;
  protected float posX;
  protected float posY;
  private PFont courier;
  private int fontSize;
  protected boolean activated;

  public Text(int _c, int _f)
  {
    textColour = _c;
    fontSize = _f;
  }
  
  public void setFont(PFont _p)
  {
    courier = _p; 
  }

  public float getX()
  {
    return posX;
  }

  public void setX(float _x)
  {
    posX = _x;
  }

  public void setY(float _y)
  {
    posY = _y;
  }

  public void setColour(int _c)
  {
    textColour = _c;
  }

  public void drawText(char c)
  {
    textFont(courier, fontSize);
    fill(textColour);
    text(c, posX, posY);
  }

  public void setActivation(boolean b)
  {
    activated = b;
  }

  public boolean getActivation()
  {
    return activated;
  }
}

  static public void main(String args[]) {
    PApplet.main(new String[] { "--bgcolor=#F0F0F0", "Sketchy" });
  }
}
