/* * Copyright 2017 Autodesk, Inc. All Rights Reserved.
 *
 * This computer source code and related instructions and comments 
 * are the unpublished confidential and proprietary information of Autodesk, Inc. 
 * and are protected under applicable copyright and trade secret law.  
 * They may not be disclosed to, copied or used by any third party without the prior 
 * written consent of Autodesk, Inc.
 */
package Algorithms.Greedy;

import java.util.ArrayList;

public class ActivitySelection {

    public static void printActivities(int[] s, int[] f, int n){
        ArrayList<Integer> activities = new ArrayList<>();
        int i=0,j=0;
        activities.add(i);
        for(j=1;j<n;j++){
            if(s[j]>=f[i]){
                activities.add(j);
                i=j;
            }
        }
        System.out.println(activities);
    }


    public static void main(String[] args) {
        int s[] =  {1, 3, 0, 5, 8, 5};
        int f[] =  {2, 4, 5, 7, 9, 9};
        int n = s.length;

        printActivities(s,f,n);
    }
}
