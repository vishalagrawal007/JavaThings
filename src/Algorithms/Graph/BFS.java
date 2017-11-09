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
import java.util.LinkedList;

public class BFS {

    public void bfs(Graph graph,int s) {
        boolean[] visited = new boolean[graph.totalNodes];
        int[] depth = new int[graph.totalNodes];
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(s);
        visited[s] = true;
        int level = 0;
        depth[s] = level;
        while (queue.size() != 0) {
            s = queue.poll();
            System.out.println(s + " " + depth[s]);
            Iterator<Integer> it = graph.getNodes()[s].listIterator();
            level = depth[s] + 1;
            while (it.hasNext()) {
                s = it.next();
                if (!visited[s]) {
                    queue.add(s);
                    visited[s] = true;
                    depth[s] = level;
                }
            }
        }
    }
}
