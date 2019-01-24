package com.example.mohammedzaman.cloudvisionapidemo;


import android.graphics.Color;
import android.graphics.Point;

import java.util.List;

public class Square {
    public List<Point> getVertices() {
        return vertices;
    }

    public void setVertices(List<Point> vertices) {
        this.vertices = vertices;
    }

    private java.util.List<Point> vertices;

    public int getThickness() {
        return thickness;
    }

    public void setThickness(int thickness) {
        this.thickness = thickness;
    }

    private int thickness;

    public Square(List<Point> vertices,int thickness){
        this.vertices = vertices;
        this.thickness = thickness;
    }

    public Square() {
        this(null, 0);
    }



}
