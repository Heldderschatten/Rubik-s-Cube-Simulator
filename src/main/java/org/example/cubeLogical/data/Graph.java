package org.example.cubeLogical.data;
import org.example.cubeLogical.data.*;
public class Graph {

    private int n;
    private int numberOfNodes = 0;
    private int[][] adjacencylists;
    private Node[] nodes;

    public Graph(int n) {
        System.out.println("Graph.Graph");
        this.n = n;
        this.adjacencylists = new int[n][n];
        nodes = new Node[n];
        System.out.println("Der Graph ist " + n + " Knoten groß");
    }

    public boolean addNode(Node theNode) {
        System.out.println("Graph.addNode");
        if (numberOfNodes < n) {
            nodes[numberOfNodes] = theNode;
            numberOfNodes++;
            return true;
        } else {
            return false;
        }
    }

    public boolean addNode(Node theNode, int index) {
        System.out.println("Graph.addNode");
        if (index < n && index >= 0) {
            nodes[index] = theNode;
            return true;
        } else {
            return false;
        }
    }

    public boolean addPath(int start, int end, int wight) {
        System.out.println("Graph.addPath");
        if (start < n && start >= 0 && end < n && end >= 0) {
            adjacencylists[start][end] = wight;
            System.out.println("Path Create from: " + start + " to " + end + " whight: " + wight);
            return true;
        } else {
            System.out.println("Error--create Path failed");
            return false;
        }
    }

    public Node[] getNodes() {
        System.out.println("Graph.getNodes");
        return nodes;
    }

    public void turn(int wight) {
        System.out.println("Graph.turn");
        System.out.println("Go step:" + wight);
        int counter = 0;
        int firstStart = -1;
        int firstEnd = -1;
        boolean found = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (adjacencylists[i][j] == wight) {
                    found = true;
                    firstStart = i;
                    firstEnd = j;
                    break;
                }
            }
            if (found) {
                break;
            }
        }
        if (firstStart < 0 || firstEnd < 0) {
            return;
        }
        int end = -1;
        for (int i = 0; i < n; i++) {
            if (adjacencylists[firstStart][i] == wight) {
                end = i;
                break;
            }
        }
        turnTwo(firstStart,wight,firstStart, true);

    }

    private void turnTwo(int start, int wight, int firstStart, boolean firstTime) {
        System.out.println("Graph.turnTwo");
        int end = -1;
        for (int i = 0; i < n; i++) {
            if (adjacencylists[start][i] == wight) {
                end = i;
                break;
            }
        }
        if(end == -1){
            System.out.print("ERROR -1 in: ");
            System.out.println("Graph.turnTwo with:");
            System.out.println("start = " + start + ", wight = " + wight + ", firstStart = " + firstStart + ", firstTime = " + firstTime);
            return;
        }
        Point p = nodes[start].getPoint();
        System.out.println(p.getName());
        if(start != firstStart || firstTime){
            turnTwo(end, wight,firstStart,false);
        }
        nodes[end].setPoint(p);
    }
}
