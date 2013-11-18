import processing.core.*;

public class ColorTable
{
  private int nColumns = 2;
  private int nLines = 5;
  private int[] colours = new int[nColumns*nLines];
  private float xPos;
  private float yPos;
  private float squareSize;   
  private float xMax = nColumns*squareSize+(nColumns-1)*15;
  private float yMax = nLines*squareSize+(nLines-1)*15;
  private PApplet parent;

  public ColorTable(float _x, float _y, PApplet p)
  {
          parent = p;
    xPos = _x;
    yPos = _y;
    fillColours();
    squareSize = 15;
  }

  public void fillColours()								// Farbauswahl
  {
    colours[0] = parent.color(0xff000000);
    colours[1] = parent.color(0xffffffff);
    colours[2] = parent.color(0xffff0000);
    colours[3] = parent.color(0xffff00ff);
    colours[4] = parent.color(0xffffff00);
    colours[5] = parent.color(255, 127, 39);
    colours[6] = parent.color(0xff00ff00);
    colours[7] = parent.color(0xff00ffff);
    colours[8] = parent.color(128, 0, 255);
    colours[9] = parent.color(0xff0000ff);
  }

  public void drawTable()
  {
    float something = xPos;
    float somethingelse = yPos;  
    for (int i = 0; i < 5; i++)
    {
      for (int j = 0; j < 2; j++)						// Zeichnet Quadrate für die Buttons
      {
        int c = colours[i*2+j];
        parent.fill(c);
        float xSquare = something+30*j;
        float ySquare = somethingelse+30*i;
        parent.rect(xSquare, ySquare, squareSize, squareSize);
      }
    }
  }

  public int getColour(float _x, float _y, int _c)
  {
    int xColour = (int) _x/15;
    int yColour = (int) _y/15;

    if (xColour%2 == 0 && yColour%2 == 0) 
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

  public float get_X()
  {
    return xPos;
  }

  public float get_Y()
  {
    return yPos;
  }
}