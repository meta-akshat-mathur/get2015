package SecondProgram;
public class Person {
	private int uid;
	private String name;
	
	/**
	 * @param uid
	 * @param name
	 */
	public Person(int uid,String name){
		this.uid=uid;
		this.name=name;
	}
	/**
	 * @ returns UID of Person
	 */
	public int getUid(){
		return uid;
	}
	
	/**
	 * @param Setting UID  
	 */
	public void setUid(int uid){
		this.uid=uid;
	}
	
	/**
	 * @returns the Name of Person
	 */
	public String getName(){
		return this.name;
	}
	
	/**
	 * @param Setting up name
	 */
	public void setName(String name){
		this.name=name;
	}
	
	public String toString(){
		return "Name "+name+",uid "+uid;
	}
}