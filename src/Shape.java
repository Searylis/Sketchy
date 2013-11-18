import processing.core.*;

public class Shape								// Papa-Klasse von allen Formen
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
  protected PApplet parent;

  public Shape() {
  }

  public Shape(float _stroke, int _line, PApplet p)
  {
    parent  = p;
    weight = _stroke;
    lineColour = _line;
    activated = false;
    hasFill = false;
    dragBool = false;
  }

  public void drawShape()
  {
    if (hasFill) parent.fill(fillColour);
    else parent.fill(0, 0, 0, 0);
    parent.stroke(lineColour);
    parent.strokeWeight(weight);
    parent.noSmooth();
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
    float keepX = startX;							// Speicherung von den Startpunkten
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