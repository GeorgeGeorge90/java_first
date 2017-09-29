package ru.stqa.pft.sandbox;

class Point { int х, у;

    Point(int х, int у) {

        this.x = х;

        this.y = y;

    }

    double distance(int х, int у) {

        int dx = this.x - х;

        int dy = this.у - у;

        return Math.sqrt(dx*dx + dy*dy);

    }

    double distance(Point p) {

        return distance(p.x, p.y);

    } }

