import processing.core.*;

public class Circle extends Shape
{
  public Circle(float _stroke, int _c, PApplet p)
  {
    super(_stroke, _c, p);
  }

  public void drawCircle()
  {
    super.drawShape();
    float xCoord = (endX - startX)/2.0f + startX;
    float yCoord = (endY - startY)/2.0f + startY;
    float w = Math.abs(endX - startX);					// nur absolute Werte 
    float h = Math.abs(endY - startY);					// Abstand zwischen Endpunkt und Startpunkt
    parent.ellipse(xCoord, yCoord, w, h);				// für Festlegung von Width&Height der Ellipse
  }
}
