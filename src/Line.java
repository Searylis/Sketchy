import processing.core.*;

public class Line extends Shape
{
  public Line(float _stroke, int _c, PApplet p)
  {
    super(_stroke, _c, p);
  }

  public void drawLine()
  {
    super.drawShape();
    parent.line(startX, startY, endX, endY);		// Linie zwischen gespeichertem Startpunkt und Endpunkt
  }
}