package ru.stqa.pft.sandbox;

class Point { int x, y;

    Point(int x, int y) {

        this.x = x;

        this.y = y;

    }

    double distance(int x, int y) {

        int dx = this.x - y;

        int dy = this.y - y;

        return Math.sqrt(dx*dx + dy*dy);

    }

    double distance(Point p) {

        return distance(p.x, p.y);

    } }


