package _06_frogger;

import processing.core.PApplet;

public class Frogger extends PApplet {

    @Override
    public void settings() {
        size(800, 600);
    }

    @Override
    public void setup() {

    }

    @Override
    public void draw() {

    }
    static public void main(String[] passedArgs) {
        //PApplet.main(Frogger.class.getName());

        String str = "   This test is easy!       ";
        
        System.out.println(str.length());
        
        str = str.trim();
        
        System.out.println(str.length());
        System.out.println(str);
        
    }
}
