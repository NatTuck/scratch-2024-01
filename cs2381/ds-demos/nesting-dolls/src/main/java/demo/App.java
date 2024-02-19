package demo;

import image.*;
import world.*;

public class App {

    public static void main(String[] args) {
        var d0 = new Doll("blue", null);
        var d1 = new Doll("pink", d0);
        var d2 = new Doll("red", d1);
        var d3 = new Doll("orange", d2);
        var d4 = new Doll("yellow", d3);
        var d5 = new Doll("green", d4);
        var w0 = new DollWorld(d5);
        w0.bigBang();
    }
}

record Doll(String color, Doll /* or null */ inner) {
    int depth() {
        if (inner == null) {
            return 1;
        }     
        else {
            return 1 + inner.depth();
        }

    }

    Image draw() {
        var img = new Circle(20 * depth(), "solid", color);
        if (inner == null) {
            return img;
        }
        else {
            return img.overlay(inner.draw());
        }
    }
}

class DollWorld extends World {
    final Doll doll;

    DollWorld(Doll d0) {
        this.doll = d0;
    }

    @Override
    public Scene onDraw() {
        var bg = new EmptyScene(800, 600);
        var fg = doll.draw();
        return bg.placeImage(fg, 400, 300);
    }
}


