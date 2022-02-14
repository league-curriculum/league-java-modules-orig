package _05_Minesweeper;

import processing.core.PApplet;
import processing.core.PConstants;

public class Button {
    static PApplet processing;
    String label;
    int x, y, w, h;

    public Button(String label, int x, int y, int buttonWidth, int buttonHeight) {
        this.label = label;
        this.x = x;
        this.y = y;
        this.w = buttonWidth;
        this.h = buttonHeight;
    }

    static void initialize(PApplet p) {
        processing = p;
    }

    void draw() {
        processing.pushStyle();

        if (mouseIsOver()) {
            processing.fill(0xFCF000);
        } else {
            processing.fill(218);
        }

        processing.stroke(141);
        processing.rect(x, y, w, h, 10);
        processing.textAlign(PConstants.CENTER, PConstants.CENTER);
        processing.textSize(32);
        processing.fill(0);
        processing.text(label, x + (w / 2), y + (h / 3));

        processing.popStyle();
    }

    boolean mouseIsOver() {
        if (processing.mouseX > x       &&
            processing.mouseX < (x + w) &&
            processing.mouseY > y       &&
            processing.mouseY < (y + h))
        {
            return true;
        }

        return false;
    }
}
