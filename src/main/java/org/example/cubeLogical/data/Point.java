package org.example.cubeLogical.data;

public class Point {
    private String name;
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

}
