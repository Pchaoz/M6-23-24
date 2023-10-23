package CompressorEloi;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CompresorMain {

	public static void main(String[] args) {
		
		Scanner kyb = new Scanner(System.in);
		Queue<String> queue = new LinkedList<String>();
		
		int cases = 0;
		String input = "";
		
		cases = kyb.nextInt();
		kyb.nextLine();
		
		for (int i = 0; i < cases; i++) {
			input = kyb.nextLine();
			
			for (int y = 0; y < input.length(); y++) {
				queue.add(String.valueOf(input.charAt(y)));
			}
			
			String toCheck = "";
			int times = 1;
			String result = "";
			
			while(!queue.isEmpty()) {
				toCheck = queue.poll();
				
				if (toCheck.equals(queue.peek())) {
					times++;
				}else {
					result = result + times + toCheck;
					times = 1;
				}
			}
			System.out.println(result);
		}
	}

}
