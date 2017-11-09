/* * Copyright 2017 Autodesk, Inc. All Rights Reserved.
 *
 * This computer source code and related instructions and comments 
 * are the unpublished confidential and proprietary information of Autodesk, Inc. 
 * and are protected under applicable copyright and trade secret law.  
 * They may not be disclosed to, copied or used by any third party without the prior 
 * written consent of Autodesk, Inc.
 */
package Algorithms.Greedy;

public class JobSequencing {

    public static class Job{
        char title;
        int dead;
        int profit;

        public Job(char title, int dead, int profit){
            this.title = title;
            this.dead = dead;
            this.profit = profit;
        }
    }

    public int maxProfitJob(boolean[] picked, Job[] jobs, int slot){
        int index = -1, profit = 0;
        for(int i=0;i<jobs.length;i++){
            if(jobs[i].dead>=slot && picked[i]==false && jobs[i].profit>=profit){
                profit = jobs[i].profit;
                index = i;
            }
        }
        return index;
    }

    public StringBuilder sequencing(Job[] jobs){
        int slotLength = 0;
        for(Job job:jobs){
            if(job.dead>=slotLength){
                slotLength = job.dead;
            }
        }
        boolean[] slots = new boolean[slotLength+1];
        boolean[] picked = new boolean[jobs.length];
        int profit = 0;
        for(int i=slotLength;i>0;i--){
            int index = maxProfitJob(picked,jobs,i);
            if(index>=0){
                slots[i]=true;
                profit += jobs[index].profit;
                picked[index]=true;
            }
        }
        StringBuilder pickedJobs = new StringBuilder("");
        for(int i=0;i<picked.length;i++){
            if(picked[i]){
                pickedJobs.append(jobs[i].title);
            }
        }
        System.out.println("profit = "+profit);
        return pickedJobs;
    }

    public static void main(String[] args) {

        char[] titles = new char[]{'a','b','c','d'};
        int[] dead = new int[]{2,1,2,3};
        int[] profit = new int[]{100,19,27,15};

        Job[] jobs = new Job[4];
        for(int i=0;i<4;i++){
            jobs[i]=new Job(titles[i],dead[i],profit[i]);
        }

        JobSequencing sequence = new JobSequencing();

        System.out.println("Jobs picked = "+sequence.sequencing(jobs));
    }
}
