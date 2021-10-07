class Star {
  int x;
  int y;
  color starColor;
  float startAlpha;
  float alpha;
  float diameter;

  Star(int x, int y, color col) {
    this.x = x;
    this.y = y;
    starColor = col;
    this.diameter = random(0.1, 3);
    this.startAlpha = random(1, 200);
    this.alpha = startAlpha;
  }
  
  void setAlpha(int alpha){
    this.alpha = constrain(alpha, startAlpha, 255);
  }

  void draw() {
    noStroke();
    fill(starColor, alpha);
    float blink = random(0, 0.8);
    ellipse(x, y, diameter + blink, diameter + blink);
  }
}
