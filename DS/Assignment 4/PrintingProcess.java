import java.util.Collections;
import java.util.InputMismatchException;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author Akshat
 *
 */
public class PrintingProcess {

	// printQueue holds the jobs according to their job
	private PriorityQueue<Integer> printQueue;
	// size variable holds the size of queue
	private int size;
	private static Scanner sc;

	/**
	 * initializing queue
	 * @param printQueue
	 * @param size
	 */
	public PrintingProcess(PriorityQueue<Integer> printQueue, int size) {
		super();
		this.printQueue = printQueue;
		this.size = size;
	}

	/**
	 * get the printQueue
	 * 
	 * @return print queue
	 */
	public PriorityQueue<Integer> getPrintQueue() {
		return printQueue;
	}

	/**
	 * set the job queue
	 * 
	 * @param jobQueue
	 */
	public void setPrintQueue(PriorityQueue<Integer> jobQueue) {
		this.printQueue = jobQueue;
	}

	/**
	 * get the size of queue
	 * 
	 * @return size of queue
	 */
	public int getSize() {
		return size;
	}

	/**
	 * set the size of queue
	 * 
	 * @param size
	 */
	public void setSize(int size) {
		this.size = size;
	}

	/**
	 * is use to take input from user and check
	 * 
	 * @param check
	 *            is variable on the basis of which function check the input, if
	 *            check is 0 then it checks for no of jobs and if it is 1 then
	 *            it checks for priority of jobs
	 * @return
	 */
	private static int userInput(int check) {
		int number = 0;
		sc = new Scanner(System.in);
		if (check == 0) {
			try {
				number = sc.nextInt();
				return number;
			} catch (InputMismatchException e) {
				System.out.println("\nEnter only integer");
				number = userInput(check);
			}
		} else if (check == 1) {
			try {
				number = sc.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("\nEnter only integer");
				number = userInput(check);
			}
			if (number > 0 && number < 5) {
				return number;
			} else {
				System.out
						.println("\nPriorities are only between 1 and 4. Kindly enter correct value ");
				number = userInput(check);
			}
		}
		return number;
	}

	/**
	 * this function is use to initialize the job queue and to insert job in
	 * queue
	 * 
	 */
	public void jobInsertion() {
		int noOfJob, jobNumber;
		System.out.println("\nEnter the no of jobs");
		noOfJob = userInput(0);
		this.printQueue = new PriorityQueue<Integer>(noOfJob,
				Collections.reverseOrder());
		System.out.println("Priorities are : \n 1. UnderGraduates"
				+ "\n 2. Graduates" + "\n 3. Professor" + "\n 4. ChairPerson");
		for (int count = 0; count < noOfJob; count++) {
			System.out.println("\nEnter the priority of job");
			jobNumber = userInput(1);
			this.printQueue.add(jobNumber);
			this.size++;
		}
	}

	/**
	 * this function is use to add job in the current queue.
	 * 
	 */
	public void addJob() {
		System.out.println("Priorities are : 1. UnderGraduates"
				+ "\n 2. Graduates" + "\n 3. Professor" + "\n 4. ChairPerson");
		System.out.println("\nEnter the priority of job");
		int jobNumber = userInput(1);
		this.printQueue.add(jobNumber);
		this.size++;
	}

	/**
	 * this function shows the current print job to be processed
	 * 
	 */
	public void currentJob() {
		if (this.size == 0)
			System.out.println("\nQueue is empty.No jobs are in queue");
		else
			System.out.println("\nCurrent job to  be serviced is: "
					+ this.printQueue.peek());
	}

	/**
	 * this function service the current job
	 * 
	 */
	public void serviceJob() {
		if (this.size == 0)
			System.out.println("\nQueue is empty.No jobs are in queue");
		else {
			System.out.println("\nCurrent job serviced is: "
					+ this.printQueue.poll());
			this.size--;
		}
	}

}
