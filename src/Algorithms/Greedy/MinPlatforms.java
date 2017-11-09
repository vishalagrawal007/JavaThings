/* * Copyright 2017 Autodesk, Inc. All Rights Reserved.
 *
 * This computer source code and related instructions and comments 
 * are the unpublished confidential and proprietary information of Autodesk, Inc. 
 * and are protected under applicable copyright and trade secret law.  
 * They may not be disclosed to, copied or used by any third party without the prior 
 * written consent of Autodesk, Inc.
 */
package Algorithms.Greedy;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MinPlatforms {

    public int minPlats(int[] arr, int[] dep){

        int n=6,plat=1,result=1;
        int i=1, j=0;
        while(i<n && j<n){
            if(arr[i]<dep[j]){
                plat++;
                i++;
                if(plat>result) result = plat;
            }
            else {
                plat--;
                j++;
            }
        }
        return result;
    }

    public static void test(List<Integer> list){
        return;
    }

    public static void main(String[] args) {
        MinPlatforms min = new MinPlatforms();
        int[] arr = new int[]{900, 940, 950, 1100, 1500, 1800};
        int[] dep = new int[]{910, 1200, 1120, 1130, 1900, 2000};
        Arrays.sort(arr);
        Arrays.sort(dep);
        System.out.println(min.minPlats(arr,dep));

        List<Integer> list1 = new LinkedList< Integer>();
        LinkedList<Integer> list2 = new LinkedList<>();
        ArrayList<Integer> list3 = new ArrayList<>();
    }
}
