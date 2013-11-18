import processing.core.*;

public class Rubber extends PixelClass
{
  float rubberSize;

  Rubber(PApplet p)
  {
    parent = p;
    rubberSize = 20;
    pixelColour = parent.color(255);
    weight = 1;
  }

  public void drawRubber(float posX, float posY)
  {
    super.drawPixel(posX, posY);
    float xStart = posX - rubberSize/2;
    float yStart = posY - rubberSize/2;
    if(xStart <= 100)
    {
            xStart = 101;
    }
    parent.rect(xStart, yStart, rubberSize, rubberSize);
  }
}