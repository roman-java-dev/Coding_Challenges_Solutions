package org.example.task4;

public abstract class Shape implements Comparable<Shape> {
  public double area;
  
  public void setArea(double area) {
    this.area = area;
  }
  
  public double getArea() {
    return area;
  }


  @Override
  public int compareTo(Shape o) {
      return Double.compare(area, o.getArea());
  }
}