import processing.core.*;

public class PixelClass										// Klasse zum Zeichnen von Pixeln
{
  protected int pixelColour;
  protected float weight;
  protected boolean activated;
  protected float prevX;
  protected float prevY;
  protected PApplet parent;

  PixelClass() {
  }

  PixelClass(float _stroke, int _c, PApplet p)
  {
          parent = p;
    weight = _stroke;
    pixelColour = _c;
    activated = false;
  }

  public void drawPixel(float posX, float posY)
  {
    parent.fill(pixelColour);							// Klasse hat .. fill, stroke, strokeWeight, Smooth
    parent.stroke(pixelColour);
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