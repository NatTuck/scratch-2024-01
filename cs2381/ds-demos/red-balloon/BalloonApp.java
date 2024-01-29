import world.*;
import image.*;

public class BalloonApp {
    public static void main(String[] args) {
        var d0 = 0;
        var world0 = new LaunchWorld(d0);
        world0.bigBang();
    }
}

class LaunchWorld extends World {
    // double xx;  // pixels
    // double yy;  // pixels
    double dist;   // pixels moved, in both x and y

    LaunchWorld(double dist0) {
        this.dist = dist0;
    }

    @Override
    public Scene onDraw() {
        var xx = 100 + 50 * Math.sin(dist / 50);
        var yy = dist;

        var bg = new EmptyScene(600, 600);
        var balloon = new FromFile("./balloon.jpg");
        return bg.placeImage(balloon, xx, 500 - yy);
    }

    @Override
    public LaunchWorld onTick() {
        return new LaunchWorld(dist + 2);
    }
}