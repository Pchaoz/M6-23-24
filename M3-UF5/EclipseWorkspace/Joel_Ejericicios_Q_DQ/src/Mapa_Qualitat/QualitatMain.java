package Mapa_Qualitat;


import java.util.PriorityQueue;
import java.util.Scanner;

public class QualitatMain {

	public static void main(String[] args) {
		
		Scanner kyb = new Scanner(System.in);
		
		int cases;
		int tasks;
		String input;
		String result;
		
		PriorityQueue<Task> QueueDependences = new PriorityQueue<Task>();
		
		//CODE STARTS
		
		cases = kyb.nextInt();
		
		for (int i = 0; i < cases; i++) {
			result = "";
			tasks = kyb.nextInt();
			kyb.nextLine();
			
			for (int y = 0; y < tasks; y++) {
				
				input = kyb.nextLine();
				
				String[] splitDependences = input.split("-");
				if (splitDependences.length > 1) {
					String[] dependences = splitDependences[1].split(",");
					QueueDependences.add(new Task(splitDependences[0], dependences.length, dependences));
				}else {
					QueueDependences.add(new Task(splitDependences[0], 0, null));
				}
			}
			while (!QueueDependences.isEmpty()) {
				Task a = QueueDependences.poll();
				if (a.priority == 0 ) {
					result = result + " " + a.name;
				}else {
					if (a.CheckDependences(result)) {
						result = result + " " + a.name;
					}else {
						a.priority++;
						QueueDependences.add(a);
						System.err.println("ME HE QUEDADO ATASCADO AAAAAAAAAAAAAAAAAAAAA");
					}
				}
				
			}
			System.out.println(result);
		}

	}
	public static class Task implements Comparable<Task> {
		
		private String name;
		private String[] dependences;
		private int priority;
		
		
		public Task(String name, int prio, String[] dependences) {
			this.name = name;
			this.priority = prio;
			this.dependences = dependences;
		}
		
		@Override
		public int compareTo(Task task) {
			return Integer.compare(this.priority, task.priority);
		}

		@Override
		public String toString() {
			
			return "Nom: " + this.name + " Prioritat: " + this.priority;
		}
		
		public boolean CheckDependences (String check) {
			
			String [] a = check.split("\\s+");
			
			for (int i = 0; i < a.length; i++) {
				boolean hasDependence = false;
				for (int y = 0; y < dependences.length; y++) {
					
					if (a[i].equals(this.dependences[y])) {
						hasDependence = true;
					}
				}
				if (!hasDependence)	{
					return false;
				}
			}
			return true;
		}
	}
}

