class Reflection {
/*
  // HSB colors
  color[] barColors = {
    color(285, 96.6, 23.1), 
    color(312, 100, 42.7), 
    color(340, 66.9, 60.4), 
    color(11, 60.8, 62), 
    color(340, 66.9, 60.4), 
    color(312, 100, 42.7), 
    color(285, 96.6, 23.1)
  };
*/
  // RGB colors
  color[] barColors = {
    color(45, 2, 59), 
    color(109, 0, 88), 
    color(154, 51, 86), 
    color(158, 79, 62), 
    color(154, 51, 86), 
    color(109, 0, 88), 
    color(45, 2, 59)
  };

  int numReflectionBars;
  float sunRadius;
  float topX;
  float topY;
  float topWidth;
  float bottomY;
  float maxHeight;
  float speed;
  ArrayList<Rectangle> lowerBars;
  
  Reflection(float sunRadius, int numBars, float topX, float topY, float speed){
    this.sunRadius = sunRadius;
    this.topX = topX;
    this.topY = topY;
    this.speed = speed;

    initialize(numBars);
  }
  
  void initialize(int numBars){
    this.numReflectionBars = numBars;
    
    topWidth = 2 * (sunRadius + sunRadius/3);
    maxHeight = 10;
    bottomY = topY + (numBars * 2 * maxHeight);
    lowerBars = new ArrayList<Rectangle>();
    
    // Setup bottom relection bars
    float x = topX;
    float y = topY;
    float w = topWidth;
    float h = maxHeight;
    for ( int i = 0; i < numReflectionBars; i++ ) {   
      y += (bottomY - topY) / numBars;
      x += sunRadius / 16;
      w -= 2 * (sunRadius / 16);

      Rectangle r = new Rectangle(x, y, w, h);
      lowerBars.add(r);
    }
  }
  
  void draw(){
    strokeWeight(1);
    
    for ( Rectangle bar : lowerBars ) {
      for ( int i = (int)bar.x; i < bar.x + bar.w; i++ ) {
        float alphaMax = -255 - (bar.y - topY);
        float alphaMin =  255 + (bar.y - topY);
        float alpha = map(i, bar.x, bar.x + bar.w, alphaMin, alphaMax);
        float step = map(i, bar.x, bar.x + bar.w, 0, 1);
        color lc = interpolateColor(barColors, step);
    
        stroke(lc, 255 - abs(alpha));
        line(i, bar.y, i, bar.y + bar.h);
      }
      
      bar.y += speed;
      bar.x += speed;
      bar.w -= 2 * speed;

      if( bar.y > bottomY ) {
        // Bar at bottom, reset to top
        
        bar.x = topX;
        bar.y = topY + maxHeight;
        bar.w = topWidth;
        bar.h = 1;
      } else if( bar.y > bottomY - maxHeight ) {
        // Bar near bottom
        
        bar.h -= speed;
      } else if( bar.h < maxHeight ) {
        // Bar height just reset and at top
        
        bar.y -= speed;
        bar.h += speed;
      }
    }
  }
}
