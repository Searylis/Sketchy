import processing.core.*;

public class Text
{
  protected int textColour;
  protected float posX;
  protected float posY;
  private PFont courier;
  private int fontSize;
  protected boolean activated;
  protected PApplet parent;

  public Text(int _c, int _f, PApplet p)
  {
          parent = p;
    textColour = _c;
    fontSize = _f;
  }
  
  public void setFont(PFont _p)
  {
    courier = _p; 
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
    parent.textFont(courier, fontSize);
    parent.fill(textColour);
    parent.text(c, posX, posY);
  }

  public void setActivation(boolean b)
  {
    activated = b;
  }

  public boolean getActivation()
  {
    return activated;
  }
  
  public float get_X()
  {
    return (float) posX;
  }
}
