/*
Aufgabe: Abschlussarbeit
Name: Astrid Creuzburg
Matrikel: 240021
Datum: 03.02.2012
Hiermit versichere ich, dass ich diesen Code selbst geschrieben
habe. Er wurde nicht kopiert und auch nicht diktiert. */

import processing.core.*;

public class Sketchy extends PApplet // für Kompatibilität zw. Processing & Eclipse
{

private static final long serialVersionUID = 1L;
        
ControlPanel testPanel;
int currentColour = color(0); 							// momentan ausgewählte Farbe, Anfangsfarbe schwarz
int fillColour = color(0, 0, 0, 0);						// Anfangsfüllfarbe Transparent
Pencil pencil = new Pencil(currentColour, this);		// Aufrufen des Pencils mit der mom. Farbe
Rubber rubber = new Rubber(this);						// ..
Brush brush = new Brush(currentColour, 7, this);		// ..
Rectangle rect = new Rectangle(2, currentColour, this);
Circle circle = new Circle(2, currentColour, this);
Line line = new Line(2, currentColour, this);
Text text = new Text(currentColour, 15, this);

public void clearScreen() 								// Methode zum "Clear"-en des Bildschirmes
{
  fill(255);
  stroke(255);
  noSmooth();
  rect(102, 0, width-100, height);						// Übermalt Zeichenbereich mit weißem Rechteck
}														// Tricky ;)

public void setup()
{

// Aufrufen der Button-Icons
PImage imgPencil;
PImage imgBrush;
PImage imgRubber;
PImage imgClear;
PImage imgText;
PImage imgRect;
PImage imgEllipse;
PImage imgLine;
PImage nofill;
    
  size(900, 600);										// Programmgröße
  background(255);										// HG
  testPanel = new ControlPanel(this);					// Aufrufen des Control-Panels
  testPanel.drawPanel();
  PFont p;
  String filename = "Courier.vlw";						// Aufrufen der Font
  try 													// Try & Catch, falls Font nicht erreichbar
  {
      p = loadFont(filename);
      text.setFont(p);
  }
  catch (Exception e) 
  {
      System.err.println("Unable to open "+filename+": "+e.getMessage());
  }
  
  // Button-Icons einbinden
  imgPencil = loadImage("pencil.jpg");
  image(imgPencil, 12, 12);
  imgRubber = loadImage("rubber.jpg");
  image(imgRubber, 62, 12);
  imgBrush = loadImage("brush.jpg");
  image(imgBrush, 12, 62);
  imgRect = loadImage("rect.jpg");
  image(imgRect, 62, 62);
  imgEllipse = loadImage("ellipse.jpg");
  image(imgEllipse, 12, 112);
  imgLine = loadImage("line.jpg");
  image(imgLine, 62, 112);
  imgText = loadImage("text.jpg");
  image(imgText, 12, 162);
  imgClear = loadImage("clear.jpg");
  image(imgClear, 37, 212);
  nofill = loadImage("nofill.jpg");
  image(nofill, 62, 162);
  
  loadPixels(); // Speicherung in Pixel-Array
}

public void draw()
{
  if (mousePressed && mouseButton == LEFT)					// Bei Linker Maustaste..
  {
    if (mouseX <= 100)										// sofern Position der Maus über/gleich x=100
    {
      if (mouseY < 300)										// sofern Pos. der Maus über 300
      {
        testPanel.chooseState(mouseX, mouseY);
        int state = testPanel.getState();
        switch(state)										// Auswahl der Tools
        {
        case 0:
          break;
        case 1:
          rect.setActivation(false);						// Aktiviert nur Tool mit "true"
          pencil.setActivation(true);						// alle anderen Tools bleiben unaktiviert
          rubber.setActivation(false);
          brush.setActivation(false);
          circle.setActivation(false);
          line.setActivation(false);
          text.setActivation(false);
          break;											// break zum Stoppen des Vorganges		
        case 2:
          rect.setActivation(false);
          rubber.setActivation(true);
          pencil.setActivation(false);
          brush.setActivation(false);
          circle.setActivation(false);
          line.setActivation(false);
          text.setActivation(false);
          break;
        case 3:
          rect.setActivation(false);
          rubber.setActivation(false);
          pencil.setActivation(false);
          brush.setActivation(true);
          circle.setActivation(false);   
          line.setActivation(false);
          text.setActivation(false);
          break;
        case 4:
          rect.setActivation(true);
          rubber.setActivation(false);
          pencil.setActivation(false);
          brush.setActivation(false);  
          circle.setActivation(false);  
          line.setActivation(false); 
          text.setActivation(false);
          break;
        case 5:
          rect.setActivation(false);
          rubber.setActivation(false);
          pencil.setActivation(false);
          brush.setActivation(false);    
          circle.setActivation(true); 
          line.setActivation(false);
          text.setActivation(false);
          break;             
        case 6:
          rect.setActivation(false);
          rubber.setActivation(false);
          pencil.setActivation(false);
          brush.setActivation(false);    
          circle.setActivation(false); 
          line.setActivation(true);
          text.setActivation(false);
          break;
        case 7:
          rect.setActivation(false);
          rubber.setActivation(false);
          pencil.setActivation(false);
          brush.setActivation(false);    
          circle.setActivation(false); 
          line.setActivation(false);
          text.setActivation(true);
            break;
        case 8:
          rect.setBoolFill(false);
          circle.setBoolFill(false);
          line.setBoolFill(false);
          break;
        case 9:
          clearScreen();
          loadPixels();
          break;
        default:
          break;
        }
      }
      else if (mouseY >= 430 && mouseY <= 565 && mouseX >= 25 && mouseX <= 90)
      {											// Wenn Mauskoordinaten über einen bestimmten Bereich hinaus..
        currentColour = testPanel.getColour(mouseX, mouseY, currentColour);
        pencil.setColour(currentColour); 		// dann Farbauswahl und ersetzen der momentanen Farbe
        brush.setColour(currentColour);			// Speicherung der Farbauswahl
        rect.setColour(currentColour);
        circle.setColour(currentColour);
        line.setColour(currentColour);
        text.setColour(currentColour);

      }
    }
    else if (mouseX > 100)
    {
      if (pencil.getActivation())						// Wenn Tool aktiviert wird, dann..
      {
        pencil.drawPencil(mouseX, mouseY);
        loadPixels();									// Um das Gezeichnete auch im Pixel-Array zu speichern
      }
      else if (rubber.getActivation())
      {
        rubber.drawRubber(mouseX, mouseY);
        loadPixels();
      }
      else if (brush.getActivation())
      {
        brush.drawBrush(mouseX, mouseY);
        loadPixels();
      }
      else if (rect.getActivation() && !rect.getDrag())
      {
        rect.setStartX(mouseX);
        rect.setStartY(mouseY);
        rect.setWhile(true);										// Zur Veranschaulichung während dem Drag-Vorgang
        rect.setDrag(true);
      }
      else if (circle.getActivation() && !circle.getDrag())
      {
        circle.setStartX(mouseX);
        circle.setStartY(mouseY);
        circle.setWhile(true);
        circle.setDrag(true);
      }

      else if (line.getActivation() && !line.getDrag())
      {
        line.setStartX(mouseX);
        line.setStartY(mouseY);
        line.setWhile(true);
        line.setDrag(true);
      }
      else if (text.getActivation())
      {
        text.setX(mouseX);
        text.setY(mouseY);
      }
    }
  }
  else if (mousePressed && mouseButton == RIGHT) 			// bei rechtem Mausklick auf Farbauswahl
  {
    if (mouseY >= 430 && mouseY <= 565 && mouseX >= 25 && mouseX <= 90)
    {
      fillColour = testPanel.getColour(mouseX, mouseY, fillColour); // Festlegung der Fill-Farbe der Formen
      rect.setFill(true, fillColour);
      circle.setFill(true, fillColour);
      line.setFill(true, fillColour);
    }
  }
}

public void mouseDragged()
{
  if (mouseX > 100)
  {
    if (pencil.getActivation())
    {
      float prevX = pencil.getPrevX();					// Einsatz von PrevX,Y da sonst nur Punkte gezeichnet würden..
      float prevY = pencil.getPrevY();					
      if (prevX == 0 && prevY == 0)
      {
        pencil.drawPencil(mouseX, mouseY);
      }
      else
      {
        pencil.drawPencil(mouseX, mouseY);
        line(prevX, prevY, mouseX, mouseY);				// zeichnet nun zwischen den Punkten eine Linie
      }
      loadPixels();
    }
    else if (brush.getActivation())
    {
      float prevX = brush.getPrevX();
      float prevY = brush.getPrevY();
      if (prevX == 0 && prevY == 0)
      {
        brush.drawBrush(mouseX, mouseY);
      }
      else
      {
        brush.drawBrush(mouseX, mouseY);
        line(prevX, prevY, mouseX, mouseY);
      }
      loadPixels();
    }
    else if (rect.getActivation() && rect.getDrag())
    {
      rect.keepStart();										// Speichert Anfangspunkte..
      updatePixels();
      rect.setEndX(mouseX);									// Legt Endpunkte fest..
      rect.setEndY(mouseY);
      rect.drawRect();
    }
    else if (circle.getActivation() && circle.getDrag())
    {
      circle.keepStart();
      updatePixels();
      circle.setEndX(mouseX);
      circle.setEndY(mouseY);
      circle.drawCircle();
    }
    else if (line.getActivation() && line.getDrag())
    {
      line.keepStart();
      updatePixels();
      line.setEndX(mouseX);
      line.setEndY(mouseY);
      line.drawLine();
    }
  }
}

public void mouseReleased() 									// Um nicht bei jeder Mausbewegung durch
{																// "Gedrückthalten" zu zeichnen, keine
  if (rect.getActivation() && rect.getWhile())					// "direkte Zeichnung" während Draggen
  {																// nur bei Release
    updatePixels();
    rect.setEndX(mouseX);
    rect.setEndY(mouseY);
    rect.setWhile(false);
    rect.setDrag(false);
    rect.drawRect();
    loadPixels();
  }
  if (circle.getActivation() && circle.getWhile())
  {
    updatePixels();
    circle.setEndX(mouseX);
    circle.setEndY(mouseY);
    circle.setWhile(false);
    circle.setDrag(false);
    circle.drawCircle();
    loadPixels();
  }    
  if (line.getActivation() && line.getWhile())
  {
    updatePixels();
    line.setEndX(mouseX);
    line .setEndY(mouseY);
    line .setWhile(false);
    line.setDrag(false);
    line.drawLine();
    loadPixels();
  }
}

public void keyTyped()											// liest Tastatureingabe
{
  if (text.getActivation())
  {
    text.drawText(PApplet.parseChar(key));
    float x = text.get_X();
    x += 9;
    text.setX(x);
    loadPixels();
  }
}

  static public void main(String args[]) {
    PApplet.main(new String[] { "--bgcolor=#F0F0F0", "Sketchy" });
  }
}
