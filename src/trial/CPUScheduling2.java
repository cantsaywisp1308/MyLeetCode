package trial;
import java.util.*;
import java.io.*;

public class CPUScheduling2 {
	
	public static class Task {
	    int pid;
	    int arrivalTime;
	    int burstTime;
	    int startTime;
	    int endTime;

	    public Task(int pid, int arrivalTime, int burstTime) {
	        this.pid = pid;
	        this.arrivalTime = arrivalTime;
	        this.burstTime = burstTime;
	    }
	}
	
	public static class Scheduler {
	    ArrayList<Task> tasks;
	    Queue<Task> readyQueue = new LinkedList<>();

	    public Scheduler(ArrayList<Task> tasks) {
	        this.tasks = tasks;
	    }

	    public void fcfs() {
	        int currentTime = 0;
	        for (Task task : tasks) {
	            if (task.arrivalTime > currentTime) {
	                currentTime = task.arrivalTime;
	            }
	            task.startTime = currentTime;
	            task.endTime = currentTime + task.burstTime;
	            currentTime = task.endTime;
	            System.out.println("Task " + task.pid + " is running from " + task.startTime + " to " + task.endTime);
	        }
	    }

	    public void rr(int timeQuantum) {
	        int currentTime = 0;
	        while (!tasks.isEmpty() || !readyQueue.isEmpty()) {
	            while (!tasks.isEmpty() && tasks.get(0).arrivalTime <= currentTime) {
	                readyQueue.add(tasks.remove(0));
	            }
	            if (readyQueue.isEmpty()) {
	                System.out.println("Idle at time " + currentTime);
	                currentTime++;
	            } else {
	                Task task = readyQueue.poll();
	                System.out.println("Task " + task.pid + " is running from " + currentTime + " to " + (currentTime + timeQuantum));
	                task.burstTime -= timeQuantum;
	                if (task.burstTime > 0) {
	                    currentTime += timeQuantum;
	                    readyQueue.add(task);
	                } else {
	                    currentTime += timeQuantum + task.burstTime;
	                    task.endTime = currentTime;
	                }
	            }
	        }
	    }

	    public void sjf() {
	        int currentTime = 0;
	        ArrayList<Task> remainingTasks = new ArrayList<>(tasks);
	        while (!remainingTasks.isEmpty()) {
	            ArrayList<Task> eligibleTasks = new ArrayList<>();
	            for (Task task : remainingTasks) {
	                if (task.arrivalTime <= currentTime) {
	                    eligibleTasks.add(task);
	                }
	            }
	            if (eligibleTasks.isEmpty()) {
	                System.out.println("Idle at time " + currentTime);
	                currentTime++;
	            } else {
	                Collections.sort(eligibleTasks, (t1, t2) -> t1.burstTime - t2.burstTime);
	                Task shortestJob = eligibleTasks.get(0);
	                remainingTasks.remove(shortestJob);
	                shortestJob.startTime = currentTime;
	                shortestJob.endTime = currentTime + shortestJob.burstTime;
	                currentTime = shortestJob.endTime;
	                System.out.println("Task " + shortestJob.pid + " is running from " + shortestJob.startTime + " to " + shortestJob.endTime);
	            }
	        }
	    }
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if (args.length != 3) {
            System.out.println("Usage: java CPU_Scheduler input_file [FCFS|RR|SJF] [time_quantum]");
            System.exit(1);
        }

        String inputFileName = args[0];
        String algorithm = args[1];
        int timeQuantum = Integer.parseInt(args[2]);
        ArrayList<Task> tasks = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFileName))) {
            int numProcesses = Integer.parseInt(reader.readLine());
            for (int i = 0; i < numProcesses; i++) {
                String[] taskInfo = reader.readLine().split(" ");
                int pid = Integer.parseInt(taskInfo[0]);
                int arrivalTime = Integer.parseInt(taskInfo[1]);
                int burstTime = Integer.parseInt(taskInfo[2]);
                tasks.add(new Task(pid, arrivalTime, burstTime));
            }
        } catch (IOException e) {
            System.err.println("Error reading input file: " + e.getMessage());
            System.exit(1);
        }

        Scheduler scheduler = new Scheduler(tasks);
        if (algorithm.equals("FCFS")) {
            scheduler.fcfs();
        } else if (algorithm.equals("RR")) {
            scheduler.rr(timeQuantum);
        } else if (algorithm.equals("SJF")) {
            scheduler.sjf();
        } else {
            System.out.println("Invalid scheduling algorithm.");
            System.exit(1);
        }
	}

}
