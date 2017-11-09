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
import java.util.PriorityQueue;

public class Dijkstra {

    public int minDistance(int[] dist, boolean[] spt){

        int min = Integer.MAX_VALUE, index = -1;

        for(int i=0;i<dist.length;i++){
            if(spt[i]==false && dist[i]<=min){
                min = dist[i];
                index = i;
            }
        }
        return index;
    }

    void printSolution(int dist[], int n)
    {
        System.out.println("Vertex   Distance from Source");
        for (int i = 0; i < dist.length; i++)
            System.out.println(i+" tt "+dist[i]);
    }

    public void shortestPath(int[][] graph, int src, int length){

        int[] dist = new int[length];

        boolean[] spt = new boolean[length];
        for(int i=0;i<length;i++){
            dist[i]=Integer.MAX_VALUE;
            spt[i]=false;
        }
        dist[src] = 0;

        for(int i=0;i<length;i++){
            int u = minDistance(dist,spt);
            spt[u]=true;
            for(int v=0;v<graph[u].length;v++){
                if(!spt[v] && graph[u][v]!=0 && dist[u] != Integer.MAX_VALUE && dist[u]+graph[u][v] < dist[v]){
                    dist[v]=dist[u]+graph[u][v];
                }
            }
        }

        printSolution(dist,length);
    }

    public static void main (String[] args)
    {
        /* Let us create the example graph discussed above */
        int graph[][] = new int[][]{{0, 4, 0, 0, 0, 0, 0, 8, 0},
                {4, 0, 8, 0, 0, 0, 0, 11, 0},
                {0, 8, 0, 7, 0, 4, 0, 0, 2},
                {0, 0, 7, 0, 9, 14, 0, 0, 0},
                {0, 0, 0, 9, 0, 10, 0, 0, 0},
                {0, 0, 4, 14, 10, 0, 2, 0, 0},
                {0, 0, 0, 0, 0, 2, 0, 1, 6},
                {8, 11, 0, 0, 0, 0, 1, 0, 7},
                {0, 0, 2, 0, 0, 0, 6, 7, 0}
        };
        Dijkstra dijkstra = new Dijkstra();
        dijkstra.shortestPath(graph,0,9);
    }
}
