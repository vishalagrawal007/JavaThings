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

public class DFS {

    public void dfs(Graph graph, int s) {
        boolean visited[] = new boolean[graph.totalNodes];
        DFSUtil(graph, s, visited);
    }

    public void DFSUtil(Graph graph, int s, boolean[] visited) {
        visited[s] = true;
        System.out.print(s + " ");
        Iterator<Integer> it = graph.getNodes()[s].listIterator();
        while (it.hasNext()) {
            int n = it.next();
            if (visited[n] == false) {
                visited[n] = true;
                DFSUtil(graph, n, visited);
            }
        }
    }
}
