package org.example.cubeLogical.data;

import javafx.scene.paint.Color;

public class Point {
    private String name;
    private Color color = Color.BLACK;

    public Point(String name){
        this.name = name;
        System.out.println("create point:" + name);
    }
    public Point(int ID){
        this.name = "P" + ID;
        System.out.println("create point:" + this.name);
    }
    public String getName() {
        System.out.println("Point.getName");
        return this.name;
    }

    public Point(String name, Color color) {
        this.name = name;
        this.color = color;
    }
    public Point(int ID, Color color) {
        this.name = "P" + ID;
        this.color = color;
    }


    public Color getColor() {
        return color;
    }
}
