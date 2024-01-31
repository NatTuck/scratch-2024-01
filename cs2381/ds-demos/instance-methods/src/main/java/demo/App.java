package demo;

// Advantages to objects + instance methods:
//  - We're telling the compiler what our numbers mean.
//    - It can pick the right methods to call.
//    - That's going to be less bugs and more consice code.
//  - Can have multiple methods.

import java.util.List;

public class App {
    public static void main(String[] args) {
        List<Shape> shapes = List.of(
            new Circle(2), 
            new Rectangle(1, 4),
            new Square(4));

        for (Shape sh : shapes) {
            System.out.println(sh.area());
        }
    }
}

/*
abstract class Shape {
    abstract double area(); 
}
*/
interface Shape {
    double area(); 
}

/**
 * A Rectangle.
 * 
 * @author Nat Tuck
 */
class Rectangle implements Shape {
    final double width; // units?
    final double height;
    final double area;

    /**
     * Construct our Rectangle.
     * 
     * @param  width     Non-negative. Units?
     * @param  height    Non-negative.
     */
    Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
        this.area = width * height;
    }

    /**
     * Get area.
     * 
     * @return   The area */
    public double area() {
        return area;
    }
}


// extends Shape (class): A Circle is a kind of Shape
//  - can only inherit from one class
//  - can't extend class with record, because it already does
// implements Shape (interface): A Circle acts like a Shape
//  - can implement many interfaces
//  - records can implement interfaces

// Vehicle:
//  - goForward
//  - goBackwards
//  - turnLeft

// Is a Car a vehicle?
// Is a Horse a vehicle?

class Circle implements Shape {
    double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    // Calculate the area of a circle.
    public double area() {
        return Math.PI * Math.pow(radius, 2.0);   
    }
}

class Square implements Shape {
    double width;

    Square(double width) {
        this.width = width;
    }

    // Calculate the area of a square.
    public double area() {
        return width * width;   
    }
}

/*
class Octagon extends Shape {
    double sideLength;

    Octagon(double sl) {
        this.sideLength = sl;
    }
}
*/