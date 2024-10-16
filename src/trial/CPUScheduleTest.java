package trial;

import java.util.*;

import trial.CPUScheduling.Task;

public class CPUScheduleTest {

	public static class Task {
		int pid;
		int arrivalTime;
		int burstTime;
		int waitingTime;
		int completionTime;

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

		public Task(int pid, int arrivalTime, int burstTime, int waitingTime, int completionTime) {
			super();
			this.pid = pid;
			this.arrivalTime = arrivalTime;
			this.burstTime = burstTime;
			this.waitingTime = waitingTime;
			this.completionTime = completionTime;
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
		Task task1 = new Task(0, 0, 12);
		Task task2 = new Task(1, 0, 1);
		Task task3 = new Task(2, 0, 2);
		Task task4 = new Task(3, 0, 1);
		Task task5 = new Task(4, 0 ,5);

		List<Task> tasks = new ArrayList<Task>();
		tasks.add(task1);
		tasks.add(task2);
		tasks.add(task3);
		tasks.add(task4);
		tasks.add(task5);
		TestRR(tasks, 1);
	}

	public static void simulateFCFS(List<Task> tasks) {
		// Implement FCFS scheduling logic here
		System.out.println("PID	ArrivalTime	StartTime	EndTime	RunningTime	WaitingTime");
		int endTime = 0;
		int waitTime = 0;
		int startTime = 0;
		for (Task task : tasks) {
			task.setCompletionTime(startTime + task.getBurstTime());
			waitTime = startTime - task.getArrivalTime();
			task.setWaitingTime(waitTime);
			System.out.println(task.getPid() + "		" + task.getArrivalTime() + "		" + startTime + "	"
					+ task.getCompletionTime() + "		" + task.getBurstTime() + "		" + task.getWaitingTime());
			startTime += task.getBurstTime();
		}
		System.out.println("Average waiting time: " + computeAverageWaitingTime(tasks));

	}

	public static void simulateSJF(List<Task> tasks) {
		// Implement RR scheduling logic here
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

				System.out.println(shortestJob.pid + " " + shortestJob.arrivalTime + " " + startTime + " " + endTime
						+ " " + shortestJob.burstTime + " " + shortestJob.waitingTime);

				currentTime = endTime;
			}
		}
	}

	public static void TestRR(List<Task> tasks, int timeQuantum) {
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

	public static int getArrivalTime(Process process, List<Task> tasks) {
		for (Task task : tasks) {
			if (task.getPid() == process.getId()) {
				return task.getArrivalTime();
			}
		}
		return -1;
	}

	public static void simulateRR(List<Process> tasks, int timeQuantum) {
		// Implement RR scheduling logic here

	}

	public static List<Task> sort(List<Task> tasks) {
		for (int i = 0; i < tasks.size() - 1; i++) {
			for (int j = i + 1; j < tasks.size(); j++) {
				if (tasks.get(i).getWaitingTime() > tasks.get(j).getWaitingTime()) {
					Task temp = tasks.get(i);
					tasks.set(i, tasks.get(j));
					tasks.set(j, temp);
				}
			}
		}
		return tasks;
	}

	public static double computeAverageWaitingTime(List<Task> tasks) {
		// Implement waiting time and average waiting time calculation
		double sum = 0;
		for (Task task : tasks) {
			sum += task.getWaitingTime();
		}
		return sum / tasks.size();
	}
}
