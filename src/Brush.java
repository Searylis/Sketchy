import processing.core.*;

// Dicker Pinsel
public class Brush extends PixelClass
{   
  Brush(int _c, float _stroke, PApplet p)
  {
    super(_stroke, _c, p);
  }

  public void drawBrush(float posX, float posY)
  {
    super.drawPixel(posX, posY);
    parent.smooth();
    parent.point(posX, posY);
    prevX = posX;						// Speichert zuerst prevX,Y als posX,Y
    prevY = posY;
  }
}
