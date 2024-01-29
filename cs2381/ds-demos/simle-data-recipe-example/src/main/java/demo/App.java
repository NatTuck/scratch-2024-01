package demo;

public class App {

    public static void main(String[] args) {
        System.out.println("Hello World");
    }

    // Problem:
    // 
    // In the course syllabus, it gives a mapping
    // from number grades to letters.
    //
    // We want a method that takes a number
    // grade and determines if that grade
    // passes the class.

    /**
     * Given a number grade, figure out if
     * that's a passing grade.
     *
     * @param  grade  A number, 0-100, grade for course.  
     * @return        True if grade is passing.
     */
    static boolean doesPass(int grade) {
        return grade >= 60;
    }  



    // Given the dimentions of a rectangle 
    // to be drawn on the screen as doubles 
    // (width and height), 
    // calculate the area of the rectangle.

    /**
     * Calculate the area of a rectangle.
     * 
     * @param  width   In pixels, non-negative 
     * @param  height  In pixels, non-negative
     * @return         Area of rectangle, in pixels
     */    
    static double rectangleArea(double width, double height) {
        return width * height;
    }

    /**
     * Calculate the area of a Rect.
     * 
     * @param  xx  The rectangle.
     * @return     Area of rectangle, in pixels
     */
    static double rectArea(Rect xx) {
        return xx.width * xx.height;        
    }

    /**
     * Calculate the area of a Rect2.
     * 
     * @param  xx  The rectangle.
     * @return     The area in pixels.
     */
    static double rect2Area(Rect2 xx) {
        return xx.area(); 
    }
}

class Rect {
    double width;    // in pixels, non-negative
    double height;   // in pixels, non-negative

    Rect(double width, double height) {
        this.width = width;
        this.height = height;
    }
}

class Rect2 {
    final private double width;    // in pixels, non-negative
    final private double height;   // in pixels, non-negative

    Rect2(double width, double height) {
        this.width = width;
        this.height = height;
    }

    double area() {
        return width * height;
    }
}

