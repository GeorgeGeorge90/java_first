package ru.stqa.pft.sandbox;

import ru.stqa.pft.sandbox.Square;

public class MyFirstProgram {

  public static void main(String[] args) {
    hello("world");
    hello("office");
    hello("neighbor");

    Square s = new Square(5);
    System.out.println("Площадь квадрата со стороной " + s.l + " = " + s.area());

    Rectangle r = new Rectangle(15, 18);
    System.out.println("Площадь прямоугольника со сторонами " + r.a + " и " + r.b + " = " + r.area());
  }

  public static void hello(String somebody) {
    System.out.println("Hello, " + somebody + "!");
  }

}

  class Point {
  public static void main(String args[]) {

    Point p1 = new Point(0, 0);

    Point p2 = new Point(30, 40);

    System.out.println("p1 = " + pi.x + ", " + p1.y);

    System.out.println("p2 = " + p2.x + ", " + p2.y);

    System.out.println("p1.distance(p2) = " + p1.distance(p2));

    System.out.println("p1.distance(60, 80) = " + p1.distance(60, 80));

  } }
