import processing.core.*;

public class Rectangle extends Shape
{
  public Rectangle(float _stroke, int _c, PApplet p)
  {
    super(_stroke, _c, p);
  }

  public void drawRect()
  {
    super.drawShape();
    float diffX = endX-startX;
    float diffY = endY-startY;
    parent.rect(startX, startY, diffX, diffY); // diffX,Y für Differenz von End- und Startpunkt
  }
}