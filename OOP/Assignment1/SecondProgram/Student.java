package SecondProgram;
/**
 * @author Akshat
 *
 */
public class Student extends Person 
{
	private int studentId;
	private String[] cources;
	
	/**
	 * @param uid
	 * @param name
	 * @param studentId
	 */
	public Student(int uid,String name,int studentId){
		super(uid,name);
		this.studentId=studentId;
	}
	
	/**
	 * @return
	 */
	public int getStudentId(){
		return studentId;
	}
	
	/**
	 * @param studentId
	 */
	public void setStudentId(int studentId){
		this.studentId=studentId;
	}
	
	/**
	 * @return
	 */
	public String[] getCource(){
		return cources;
	}
	
	/**
	 * @param cources
	 */
	public void setCources(String[] cources){
		this.cources=cources;
	}
	
	public String toString(){
		return super.toString()+", StudentID "+studentId;
	}
}
