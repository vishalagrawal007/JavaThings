package Algorithms.Graph;/* * Copyright 2017 Autodesk, Inc. All Rights Reserved.
 *
 * This computer source code and related instructions and comments 
 * are the unpublished confidential and proprietary information of Autodesk, Inc. 
 * and are protected under applicable copyright and trade secret law.  
 * They may not be disclosed to, copied or used by any third party without the prior 
 * written consent of Autodesk, Inc.
 */

import java.util.LinkedList;

public class Graph {

    int totalNodes;
    LinkedList<Integer>[] nodes;

    //
    public Graph(int totalNodes) {
        this.totalNodes = totalNodes;
        nodes = new LinkedList[totalNodes];
        for (int i = 0; i < totalNodes; i++) {
            nodes[i] = new LinkedList<>();
        }
    }

    public LinkedList<Integer>[] getNodes() {
        return nodes;
    }

    public void addEdge(int src, int dest) {
        nodes[src].add(dest);
        //nodes[dest].add(src);
    }

    public void printGraph() {
        for (int i = 0; i < totalNodes; i++) {
            System.out.print(i + "->");
            for (int ele : nodes[i]) {
                System.out.print(ele + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(7);

        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
        g.addEdge(3, 5);
        g.addEdge(5, 6);
        //g.addEdge(6, 0);
        g.printGraph();
        DetectCycle dc = new DetectCycle();
        System.out.println(dc.hasCycleDirected(g, 0));
    }
}
