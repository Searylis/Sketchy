import processing.core.*;

public class ControlPanel							// Klasse des Kontrollfeldes
{
  private int state;
  private int bgColor;
  private ColorTable cTable; 
  private float xLength;
  private float yLength;
  private float buttonLength;
  private PApplet parent;

  public ControlPanel(PApplet p)
  {
    parent = p;
    bgColor = parent.color(0xffaeaeae);
    state = 0;
    cTable = new ColorTable(25, 430, parent); 
    xLength = 100;
    yLength = 600;
    buttonLength = 25;
  }

  public void chooseState(float _x, float _y)
  {
    int xChoice = (int) Math.floor(_x/12.5f); 			// rundet den Wert
    int yChoice = (int) Math.floor(_y/12.5f);

    if (xChoice == 1 || xChoice == 2)					// Festlegung des States
    {
      if (yChoice == 1 || yChoice == 2)
        state = 1;
      else if (yChoice == 5 || yChoice == 6)
        state = 3;
      else if (yChoice == 9 || yChoice == 10)
        state = 5;
      else if (yChoice == 13 || yChoice == 14)
        state = 7;
    }
    else if (xChoice == 5 || xChoice == 6)
    {
      if (yChoice == 1 || yChoice == 2)
        state = 2;
      else if (yChoice == 5 || yChoice == 6)
        state = 4;
      else if (yChoice == 9 || yChoice == 10)
        state = 6;
      else if (yChoice == 13 || yChoice == 14)
        state = 8;
    }
    else if (xChoice == 3 || xChoice == 4)
    {
      if (yChoice == 17 || yChoice == 18)
        state = 9;
    }
  }

  public int getState()										// Return für State für Switch
  {
    return state;
  }

  public int getColour(float _x, float _y, int _c)
  {
    float xColour = _x-cTable.get_X();
    float yColour = _y-cTable.get_Y();
    return cTable.getColour(xColour, yColour, _c);
  }

  public void drawButtons()
  {
          parent.fill(0xffffffff);
    float something = 25/2;
    float somethingelse = 25/2; 
    float yEnd = 0;
    for (int i = 0; i < 4; i++)
    {
      for (int j = 0; j < 2; j++)
      {
        float xSquare = somethingelse+buttonLength*2*j;
        float ySquare = something+buttonLength*2*i;
        parent.rect(xSquare, ySquare, buttonLength, buttonLength);
        yEnd = ySquare;
      }
    }      
    parent.rect(25/2+25, yEnd+buttonLength*2, buttonLength, buttonLength);
  }

  public void drawPanel() 
  {
          parent.fill(bgColor);
          parent.stroke(bgColor);
          parent.rect(0, 0, xLength, yLength);
          parent.stroke(0);
          parent.line(xLength, 0, xLength, yLength);
          drawButtons();
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