/* * Copyright 2017 Autodesk, Inc. All Rights Reserved.
 *
 * This computer source code and related instructions and comments
 * are the unpublished confidential and proprietary information of Autodesk, Inc.
 * and are protected under applicable copyright and trade secret law.
 * They may not be disclosed to, copied or used by any third party without the prior
 * written consent of Autodesk, Inc.
 */
package Algorithms.Graph;

import java.util.Iterator;

public class DetectCycle {

    public boolean hasCycleDirected(Graph graph,int s) {
        boolean[] visited = new boolean[graph.totalNodes];
        boolean[] recStack = new boolean[graph.totalNodes];
        for (int i = 0; i < visited.length; i++) {
            visited[i] = false;
        }
        return hasDirectedCycleUtil(graph,s, visited, recStack);
    }

    private boolean hasDirectedCycleUtil(Graph graph, int node, boolean[] visited, boolean[] recStack) {
        visited[node] = true;
        recStack[node] = true;

        Iterator<Integer> it = graph.getNodes()[node].listIterator();
        while (it.hasNext()) {
            int child = it.next();
            if (!visited[child] && hasDirectedCycleUtil(graph,child, visited, recStack)) {
                return true;
            } else if (recStack[child]) return true;
        }
        recStack[node] = false;
        return false;

    }

    public boolean hasCycleUndirected(Graph graph, int s) {
        boolean[] visited = new boolean[graph.totalNodes];
        boolean[] recStack = new boolean[graph.totalNodes];
        for (int i = 0; i < visited.length; i++) {
            visited[i] = false;
        }
        return hasUndirectedCycleUtil(graph,s,-1, visited, recStack);
    }

    private boolean hasUndirectedCycleUtil(Graph graph, int node, int parent, boolean[] visited, boolean[] recStack) {
        visited[node] = true;
        recStack[node] = true;

        Iterator<Integer> it = graph.getNodes()[node].listIterator();
        while (it.hasNext()) {
            int child = it.next();
            if(child == parent) continue;
            if (!visited[child] && hasUndirectedCycleUtil(graph,child,node, visited, recStack)) {
                return true;
            } else if (recStack[child]) return true;
        }
        recStack[node] = false;
        return false;
    }
}
