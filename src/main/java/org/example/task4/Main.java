package org.example.task4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        double side = 3.0;
        double radius = 1.0;
        double base = 5.0;
        double height = 2.0;
        double width = 3.0;

        List<Shape> shapes = new ArrayList<>();
        shapes.add(new Rectangle(width, height));
        shapes.add(new Square(side));
        shapes.add(new Circle(radius));
        shapes.add(new Triangle(base, height));

        Collections.sort(shapes);

        for (Shape shape : shapes) {
            System.out.println(shape.getClass().getSimpleName()
                    + " area is: " + String.format("%.1f",shape.getArea()));
        }
    }
}
