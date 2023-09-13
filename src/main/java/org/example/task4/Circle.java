package org.example.task4;

class Circle extends Shape {
  public Circle (double radius) {
    setArea(Math.pow(radius, 2 ) * Math.PI);
  }
}