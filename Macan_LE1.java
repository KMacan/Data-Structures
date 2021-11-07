import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

//class containing the information of the convicts
class Record{
	private String name;
	private String crime;
	private int jailTime;
	private Record next;
	public Record(String name, String crime, int jailTime){
		this.name = name;
		this.crime = crime;
		this.jailTime = jailTime;
	}
	public String getName() {
		return name;
	}
	public String getCrime() {
		return crime;
	}
	public int getJailTime() {
		return jailTime;
	}
	public Record getNext() {
		return next;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setCrime(String crime) {
		this.crime = crime;
	}
	public void setJailTime(int time) {
		this.jailTime = time;
	}
	public void setNext(Record record) {
		this.next = record;
	}
}

abstract class ADT{
	abstract void enqueue(String name, String crime, int jailTime);
	abstract Record dequeue();
	abstract void poll(Record record);
	abstract Record front();
	abstract int size();
	abstract boolean isEmpty();
}

class PrioQueue extends ADT{
	//class variables
	public static Record front;
	public static Record back;
	public int countRecords;
	
	//constructor
	public PrioQueue(){
		front = null;
		back = null;
		countRecords = 0;
	}
	
	//inserts a record to the back of the priority queue
	public void enqueue(String name, String crime, int jailTime) {
		if(isEmpty()) {
			front = back = new Record(name, crime, jailTime);
		}
		Record current = back;
		current.setNext(new Record(name, crime, jailTime));
		back = current.getNext();
		countRecords++;		
	}
	public Record dequeue() {
		if(isEmpty()) {
			return null; //MUST REPLACE THIS
		}
		Record current = front;
		front = current.getNext(); 
		return current;
	}
	public void poll(Record record) {
		Record current = back;
		while(current.getJailTime() > ) {
			
		}
	}
	public Record front() {
		return front;
	}
	public int size() {
		return countRecords;
	}
	public boolean isEmpty() {
		if(size() == 0) {
			return true;
		} else {
			return false;
		}
	}
}

class FileHandler{
	public void writer(File file) {
		//writes into the file
		//while(!prioQueue.isEmpty()){}
		try {
			PrintWriter output = new PrintWriter(file);
			output.print("Jacob Winters"); //records.getName();
			output.append(", ");
			output.print("Rape");//records.getCrime();
			output.append(", ");
			output.print(5); //records.getJailTime();
			output.append(" years\n");
			output.close();
		} catch (IOException ex){
			System.out.printf("ERROR: %s\n", ex);
		}
	}
	
	public void reader(File file) {
		//reads the file
		//while(file.hasNextLine()){}
		try {
		Scanner scanner = new Scanner(file);
		scanner.useDelimiter(", ");
		String name = scanner.next();
		String crime = scanner.next();
		String jailTime = scanner.next();
		String [] jail = jailTime.split(" ");
		int time = Integer.parseInt(jail[0]);
		System.out.println(time);
		scanner.close();
		
		System.out.printf("%s, %s, %s\n", name, crime, jailTime);
		} catch (FileNotFoundException ex) {
			System.out.printf("ERROR: %s\n", ex);
		}
	}
}

public class Macan_LE1 {
	public static void main (String [] args) {
		//imports or creates a file
		File file = new File("crimerecords.txt");
		
		//writes into the file
		
		
		//reads the file
		
	}
}
