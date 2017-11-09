package Algorithms.Graph;/* * Copyright 2017 Autodesk, Inc. All Rights Reserved.
 *
 * This computer source code and related instructions and comments 
 * are the unpublished confidential and proprietary information of Autodesk, Inc. 
 * and are protected under applicable copyright and trade secret law.  
 * They may not be disclosed to, copied or used by any third party without the prior 
 * written consent of Autodesk, Inc.
 */


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class TopoSort {

    public Deque<Integer> topoSort(Graph graph){
        Deque<Integer> sortedStack = new ArrayDeque<>();
        boolean[] visited = new boolean[graph.totalNodes];
        for(int i=0;i<visited.length;i++){
            visited[i]=false;
        }
        for(int i=0;i<graph.totalNodes;i++){
            if(visited[i]==false)
            topoSortUtil(graph,sortedStack,visited,i);
        }
        return sortedStack;
    }

    private void topoSortUtil(Graph graph, Deque<Integer> sortedStack, boolean[] visited, int vertex) {

        visited[vertex]=true;
        Iterator<Integer> it = graph.getNodes()[vertex].listIterator();
        while(it.hasNext()){
            int child = it.next();
            if(visited[child]==false){
                topoSortUtil(graph,sortedStack,visited,child);
            }
        }
        sortedStack.offerFirst(vertex);
    }

}
