/* * Copyright 2017 Autodesk, Inc. All Rights Reserved.
 *
 * This computer source code and related instructions and comments 
 * are the unpublished confidential and proprietary information of Autodesk, Inc. 
 * and are protected under applicable copyright and trade secret law.  
 * They may not be disclosed to, copied or used by any third party without the prior 
 * written consent of Autodesk, Inc.
 */
package Algorithms.Graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class DijkstraWithAdjList {

    public static class GraphByAdjList{

        int V;
        List<Node>[] nodes;

        public int getV() {
            return V;
        }

        public List<Node>[] getNodes() {
            return nodes;
        }

        public GraphByAdjList(int v){
            this.V = v;
            nodes = new ArrayList[V];
            for(int i=0;i<V;i++){
                nodes[i] = new ArrayList<>();
            }
        }

        public void addEdge(int src, int dest, int weight){
            nodes[src].add(new Node(dest,weight));
            //nodes[dest].add(new Node(src,weight));
        }
        public List<Node> getEdges(int src){
            return nodes[src];
        }

        public class Node{
            public int getVertex() {
                return vertex;
            }

            public void setVertex(int vertex) {
                this.vertex = vertex;
            }

            public int getWeight() {
                return weight;
            }

            public void setWeight(int weight) {
                this.weight = weight;
            }

            int vertex;
            int weight;

            public Node(){
            }

            public Node(int vertex, int w){
                this.vertex = vertex;
                this.weight = w;
            }
        }
    }

    public class Pair{

        int vertex;
        int dist;

        public Pair(int v, int d){
            vertex = v;
            dist = d;
        }

        public int getVertex() {
            return vertex;
        }

        public void setVertex(int vertex) {
            this.vertex = vertex;
        }

        public int getDist() {
            return dist;
        }

        public void setDist(int dist) {
            this.dist = dist;
        }
    }

    public void dijkstra(GraphByAdjList graph,int src){
        Pair[] pairs = new Pair[graph.getNodes().length];
        boolean[] visited = new boolean[graph.nodes.length];
        for(int i=0;i<graph.getNodes().length;i++){
            pairs[i] = new Pair(i,Integer.MAX_VALUE);
        }
        pairs[src].dist = 0;

        PriorityQueue<Pair> queue = new PriorityQueue<>(graph.getNodes().length, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o1.dist-o2.dist;
            }
        });

        queue.add(pairs[src]);
        while(!queue.isEmpty()){
            Pair curr = queue.remove();
            visited[curr.getVertex()]=true;
            List<GraphByAdjList.Node> edges = graph.getNodes()[curr.getVertex()];
            for(GraphByAdjList.Node child : edges){
                if(visited[child.getVertex()]==true) continue;
                if(pairs[child.getVertex()].getDist() > curr.getDist() + child.getWeight()){
                    pairs[child.getVertex()].setDist(curr.getDist() + child.getWeight());
                }
                queue.add(pairs[child.getVertex()]);
            }
        }
        for(Pair pair : pairs){
            System.out.println(pair.getVertex() + " - "+pair.getDist());
        }
    }

    public static void main(String[] args) {
        GraphByAdjList graph = new GraphByAdjList(4);
        graph.addEdge(1,0,51);
        graph.addEdge(1,2,9);
        graph.addEdge(0,3,20);
        graph.addEdge(3,1,10);
        graph.addEdge(0,1,111);
        graph.addEdge(2,3,2);
        DijkstraWithAdjList d = new DijkstraWithAdjList();
        d.dijkstra(graph,0);
    }
}
