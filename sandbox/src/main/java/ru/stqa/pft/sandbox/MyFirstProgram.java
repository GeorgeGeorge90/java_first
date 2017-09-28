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
	