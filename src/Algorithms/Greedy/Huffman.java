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

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Huffman {

    public class MinHeap{
        char a;
        int freq;
        MinHeap left,right;

        public MinHeap(char a, int freq){
            this.a = a;
            this.freq = freq;
        }

        public MinHeap(char a, int freq, MinHeap left, MinHeap right){
            this.a = a;
            this.freq = freq;
            this.left = left;
            this.right = right;
        }

        public MinHeap getLeft() {
            return left;
        }

        public MinHeap getRight() {
            return right;
        }
    }


    public void decode(MinHeap root,String str){

        if(root==null) return;

        if (root.a=='$'){
            decode(root.left,str+"0");
            decode(root.right,str+"1");
        }
        else System.out.println(root.a + " - "+ str);
    }

    public MinHeap encode(char[] a, int[] freq, int size){

        MinHeap left, right, top;

        Comparator<MinHeap> comparator = new Comparator<MinHeap>() {
            @Override
            public int compare(MinHeap o1, MinHeap o2) {
                return o1.freq-o2.freq;
            }
        };
        Queue<MinHeap> minHeapQueue = new PriorityQueue<>(size,comparator);
        for(int i=0;i<size;i++){
            minHeapQueue.add(new MinHeap(a[i],freq[i]));
        }
        while(minHeapQueue.size() != 1){

            left = minHeapQueue.remove();
            right = minHeapQueue.remove();
            top = new MinHeap('$',left.freq+right.freq,left,right);
            minHeapQueue.add(top);
        }

        return minHeapQueue.poll();
    }

    public static void main(String[] args) {
        char arr[] = { 'a', 'b', 'c', 'd', 'e', 'f' };
        int freq[] = { 5, 9, 12, 13, 16, 45 };
        int size = arr.length;

        Huffman huffman = new Huffman();
        huffman.decode(huffman.encode(arr,freq,size),"");
    }
}
