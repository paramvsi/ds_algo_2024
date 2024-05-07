package sheet.searching_and_sorting;


import java.util.*;

public class S18JobSchedulingAlgo {

    public static void scheduleJobs(List<Job> jobs) {
        jobs.sort(Comparator.comparingInt(job -> job.arrivalTime));

        PriorityQueue<Job> pq = new PriorityQueue<>(Comparator.comparingInt(job -> job.burstTime));
        int currentTime = 0;

        for (Job job : jobs) {
            if (job.arrivalTime > currentTime) {
                currentTime = job.arrivalTime;
            }
            System.out.println("Job " + job.id + " starts at " + currentTime);
            currentTime += job.burstTime;
            System.out.println("Job " + job.id + " finishes at " + currentTime);
        }
    }

    public static void main(String[] args) {
        List<Job> jobs = new ArrayList<>();
        jobs.add(new Job(1, 0, 5));
        jobs.add(new Job(2, 1, 3));
        jobs.add(new Job(3, 2, 8));
        scheduleJobs(jobs);
    }

    static class Job {
        int id;
        int arrivalTime;
        int burstTime;

        public Job(int id, int arrivalTime, int burstTime) {
            this.id = id;
            this.arrivalTime = arrivalTime;
            this.burstTime = burstTime;
        }
    }
}

