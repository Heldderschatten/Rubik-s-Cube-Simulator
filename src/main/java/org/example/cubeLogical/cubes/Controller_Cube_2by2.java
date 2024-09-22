package org.example.cubeLogical.cubes;

import org.example.cubeLogical.data.*;

import java.util.HashMap;
import java.util.Map;

public class Controller_Cube_2by2 implements IlogicalCubes {
    private Graph g;
    private int[] possibleMovesIntger = {1,2,3,4,5,6};
    private Map<String, Integer> possibleMovesStringToInt = new HashMap<>();

    public Controller_Cube_2by2() {
        System.out.println("Controller_Cube_2by2.Controller_Cube_2by2");
        possibleMovesStringToInt.put("U",1);
        possibleMovesStringToInt.put("D",2);
        possibleMovesStringToInt.put("R",3);
        possibleMovesStringToInt.put("L",4);
        possibleMovesStringToInt.put("F",5);
        possibleMovesStringToInt.put("B",6);
    }

    @Override
    public void start() {
        System.out.println("Controller_Cube_2by2.start");
        g = new Graph(2);

        Point p1 = new Point(1);
        Point p2 = new Point(2);
        Point p3 = new Point(3);
        Point p4 = new Point(4);
        Point p5 = new Point(5);
        Point p6 = new Point(6);
        Point p7 = new Point(7);
        Point p8 = new Point(8);

        Node n0 = new Node(p1);
        Node n1 = new Node(p2);
        Node n2 = new Node(p3);
        Node n3 = new Node(p4);
        Node n4 = new Node(p5);
        Node n5 = new Node(p6);
        Node n6 = new Node(p7);
        Node n7 = new Node(p8);

        g = new Graph(8);
        g.addNode(n0);
        g.addNode(n1);
        g.addNode(n2);
        g.addNode(n3);
        g.addNode(n4);
        g.addNode(n5);
        g.addNode(n6);
        g.addNode(n7);


        g.addPath(1,0,1);
        g.addPath(2,1,1);
        g.addPath(3,2,1);
        g.addPath(0,3,1);

        g.addPath(7,4,2);
        g.addPath(4,5,2);
        g.addPath(5,6,2);
        g.addPath(6,7,2);

        g.addPath(4,0,3);
        g.addPath(0,1,3);
        g.addPath(5,4,3);
        g.addPath(1,5,3);

        g.addPath(6,2,4);
        g.addPath(2,3,4);
        g.addPath(7,6,4);
        g.addPath(3,7,4);

        g.addPath(3,0,5);
        g.addPath(7,3,5);
        g.addPath(0,4,5);
        g.addPath(4,7,5);

        g.addPath(5,1,6);
        g.addPath(1,2,6);
        g.addPath(6,5,6);
        g.addPath(2,6,6);
    }
    @Override
    public boolean doStep(int step) {
        System.out.println("Controller_Cube_2by2.doStep");
        for(int i : possibleMovesIntger){
            if(i == step){
                g.turn(step);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean doStep(String step) {
        System.out.println("Controller_Cube_2by2.doStep");
        return doStep(possibleMovesStringToInt.get(step));
    }

    @Override
    public Point[] getPoints() {
        System.out.println("Controller_Cube_2by2.getPoints");
        Point[] points = new Point[8];
        int counter = 0;
        for(Node n : g.getNodes()){
            points[counter] = n.getPoint();
            counter++;
        }
        return points;

    }
}
