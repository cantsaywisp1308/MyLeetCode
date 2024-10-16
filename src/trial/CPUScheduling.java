package trial;
import java.io.FileNotFoundException;
import java.util.*;


import java.io.*;

public  class CPUScheduling {
	
	public static class Task {
	    int pid;
	    int startTime;
		int arrivalTime;
	    int burstTime;
	    int waitingTime;
	    int completionTime;
	    
	    public int getStartTime() {
			return startTime;
		}


		public void setStartTime(int startTime) {
			this.startTime = startTime;
		}

	    public int getPid() {
			return pid;
		}



		public void setPid(int pid) {
			this.pid = pid;
		}



		public int getArrivalTime() {
			return arrivalTime;
		}



		public void setArrivalTime(int arrivalTime) {
			this.arrivalTime = arrivalTime;
		}



		public int getBurstTime() {
			return burstTime;
		}



		public void setBurstTime(int burstTime) {
			this.burstTime = burstTime;
		}



		public int getWaitingTime() {
			return waitingTime;
		}



		public void setWaitingTime(int waitingTime) {
			this.waitingTime = waitingTime;
		}



		public int getCompletionTime() {
			return completionTime;
		}



		public void setCompletionTime(int completionTime) {
			this.completionTime = completionTime;
		}



		public Task(int pid, int arrivalTime, int burstTime) {
	        this.pid = pid;
	        this.arrivalTime = arrivalTime;
	        this.burstTime = burstTime;
	        this.waitingTime = 0;
	        this.completionTime = 0;
	    }
		
		public Task(int pid, int arrivalTime, int startTime, int endTime, int burstTime) {
	        this.pid = pid;
	        this.arrivalTime = arrivalTime;
	        this.startTime = startTime;
	        this.burstTime = burstTime;
	        this.waitingTime = 0;
	        this.completionTime = endTime;
	    }
	}
	
	public static class Process {
		int id;
		int startTime;
		int endTime;
		int runningTime;

		public Process(int id, int startTime, int endTime, int runningTime) {
			super();
			this.id = id;
			this.startTime = startTime;
			this.endTime = endTime;
			this.runningTime = runningTime;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public int getStartTime() {
			return startTime;
		}

		public void setStartTime(int startTime) {
			this.startTime = startTime;
		}

		public int getEndTime() {
			return endTime;
		}

		public void setEndTime(int endTime) {
			this.endTime = endTime;
		}

		public int getRunningTime() {
			return runningTime;
		}

		public void setRunningTime(int runningTime) {
			this.runningTime = runningTime;
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if (args.length < 2) {
            System.out.println("Usage: proj2 input_file [FCFS|RR|SJF] [time_quantum]");
            System.exit(1);
        }

        String inputFileName = args[0];
        String schedulingAlgorithm = args[1];
        int timeQuantum = args.length > 2 ? Integer.parseInt(args[2]) : 0;

        List<Task> tasks = readTasks(inputFileName);

        if (schedulingAlgorithm.equals("FCFS")) {
            simulateFCFS(tasks);
        } else if (schedulingAlgorithm.equals("RR")) {
            if (timeQuantum <= 0) {
                System.out.println("Time quantum must be greater than 0 for RR scheduling.");
                System.exit(1);
            }
            simulateRR(tasks, timeQuantum);
        } else if (schedulingAlgorithm.equals("SJF")) {
            simulateSJF(tasks);
        } else {
            System.out.println("Unknown scheduling algorithm.");
            System.exit(1);
        }
	}
	
	public static List<Task> readTasks(String filename) {
		List<Task> tasks = new ArrayList<>();

        try {
            File file = new File(filename);
            Scanner scanner = new Scanner(file);

            // Read the number of processes
            int numProcesses = scanner.nextInt();

            // Read task information for each process
            for (int i = 0; i < numProcesses; i++) {
                int pid = scanner.nextInt();
                int arrivalTime = scanner.nextInt();
                int burstTime = scanner.nextInt();
                tasks.add(new Task(pid, arrivalTime, burstTime));
            }

            // Close the scanner
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return tasks;
    }

	public static void simulateFCFS(List<Task> tasks) {
        // Implement FCFS scheduling logic here
		System.out.println("PID	ArrivalTime	StartTime	EndTime	RunningTime	WaitingTime");
		int endTime = 0;
		int waitTime = 0;
		int startTime = 0;
		for(Task task: tasks) {
			task.setCompletionTime(startTime + task.getBurstTime());
			waitTime = startTime - task.getArrivalTime();
			task.setWaitingTime(waitTime);
			System.out.println(task.getPid() + "		" + task.getArrivalTime() +"		" + startTime +"	" 
					+ task.getCompletionTime() + "		" + task.getBurstTime() + "		" + task.getWaitingTime());
			startTime += task.getBurstTime();
		}
		System.out.println("Average waiting time: " + computeAverageWaitingTime(tasks));
		
    }


    public static void simulateSJF(List<Task> tasks) {
        // Implement RR scheduling logic here
    	int n = tasks.size();
    	Queue<Task> readyQueue = new PriorityQueue<>((task1, task2) -> task1.burstTime - task2.burstTime);
        int currentTime = 0;
        double totalWaitingTime = 0;

        System.out.println("SJF:");
        System.out.println("PID Arrival Time Start Time End Time Running Time Waiting Time");

        while (!tasks.isEmpty() || !readyQueue.isEmpty()) {
            // Add newly arrived tasks to the ready queue
            while (!tasks.isEmpty() && tasks.get(0).arrivalTime <= currentTime) {
                Task newTask = tasks.remove(0);
                readyQueue.add(newTask);
            }

            if (readyQueue.isEmpty()) {
                System.out.println(currentTime + " Idle");
                currentTime++;
            } else {
                Task shortestJob = readyQueue.poll();
                int startTime = currentTime;
                int endTime = startTime + shortestJob.burstTime;

                shortestJob.waitingTime = startTime - shortestJob.arrivalTime;
                totalWaitingTime += shortestJob.waitingTime;

                System.out.println(shortestJob.pid + " " + shortestJob.arrivalTime + " " + startTime + " " + endTime + " " + shortestJob.burstTime + " " + shortestJob.waitingTime);

                currentTime = endTime;
                
            }
        }
        double averageWaitingTime = totalWaitingTime / (double)n;
        System.out.println("Average Waiting Time: " + averageWaitingTime);
    }
    
    public static List<Task> sort(List<Task> tasks) {
    	for(int i = 0 ; i < tasks.size()-1;i++) {
    		for(int j = i +1; j < tasks.size();j++) {
    			if(tasks.get(i).getWaitingTime() > tasks.get(j).getWaitingTime()) {
    				Task temp = tasks.get(i);
    				tasks.set(i, tasks.get(j));
    				tasks.set(j, temp);
    			}
    		}
    	}
    	return tasks;
    }

    public static void simulateRR(List<Task> tasks, int timeQuantum) {
        // Implement RR scheduling logic here
    	Map<Integer, Integer> pidEndTime = new HashMap<Integer, Integer>();
		Map<Integer, Integer> pidArrivalTime = new HashMap<Integer, Integer>();
		Map<Integer, Integer> pidRunningTime = new HashMap<Integer, Integer>();
		for (Task task : tasks) {
			pidArrivalTime.put(task.getPid(), task.getArrivalTime());
		}
		Queue<Process> processes = new LinkedList<Process>();
		int order = 0;
		int startTime = 0;
		int endTime = 0;
		while (!tasks.isEmpty()) {

			if (tasks.get(order).getBurstTime() > timeQuantum) {
				endTime = startTime + timeQuantum;
				processes.add(new Process(tasks.get(order).getPid(), startTime, endTime, timeQuantum));
				tasks.get(order).setBurstTime(tasks.get(order).getBurstTime() - timeQuantum);
				startTime = endTime;
				order++;

			} else if (tasks.get(order).getBurstTime() <= timeQuantum) {
				endTime = startTime + tasks.get(order).getBurstTime();
				processes.add(
						new Process(tasks.get(order).getPid(), startTime, endTime, tasks.get(order).getBurstTime()));
				tasks.remove(order);
				startTime = endTime;
			}
			if (order >= tasks.size()) {
				order = 0;
			}
		}
		System.out.println("RR (Time quantum = " + timeQuantum + "):");
		System.out.println("PID 	StartTime EndTime RunningTime");
		for (Process process : processes) {
			System.out.println(process.getId() + "	" + process.getStartTime() + "		" + process.getEndTime()
					+ "	" + process.getRunningTime());
		}

		System.out.println("RR (Time quantum = " + timeQuantum + "):");
		System.out.println("PID ArrivalTime	StartTime EndTime RunningTime");

		for (Process process : processes) {
			pidEndTime.put(process.getId(), process.getEndTime());
			pidRunningTime.put(process.getId(),
					pidRunningTime.getOrDefault(process.getId(), 0) + process.getRunningTime());
		}
		Map<Integer, Integer> pidWaitingTime = new HashMap<Integer, Integer>();
		for (Map.Entry<Integer, Integer> entry : pidEndTime.entrySet()) {
			pidWaitingTime.put(entry.getKey(), pidEndTime.get(entry.getKey()) - pidRunningTime.get(entry.getKey())
					- pidArrivalTime.get(entry.getKey()));
		}
		Set<Integer> id = new HashSet<Integer>(pidEndTime.keySet());
		int[][] matrix = new int[id.size()][5];
		for (int i = 0; i < id.size(); i++) {
			matrix[i][0] = i;
			matrix[i][1] = pidArrivalTime.get(i);
			matrix[i][2] = pidRunningTime.get(i);
			matrix[i][3] = pidEndTime.get(i);
			matrix[i][4] = pidWaitingTime.get(i);
		}
		int waitTime = 0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + "	");
			}
			waitTime += matrix[i][4];
			System.out.println();
		}
		System.out.println("Average Waiting Time: " + ((double) waitTime / (double) matrix.length));
    }

    public static double computeAverageWaitingTime(List<Task> tasks) {
        // Implement waiting time and average waiting time calculation
    	double sum = 0;
    	for(Task task: tasks) {
    		sum += task.getWaitingTime();
    	}
    	return sum/tasks.size();
    }

}
