import processing.core.*;

public class Pencil extends PixelClass
{ 
        Pencil(int _c, PApplet p) 
        {
                parent = p;
                pixelColour = _c;
                weight = 2;
        }

        public void drawPencil(float posX, float posY)
        {
                super.drawPixel(posX, posY);
                parent.point(posX, posY);
                prevX = posX;						// siehe Brush
                prevY = posY;
        }
}