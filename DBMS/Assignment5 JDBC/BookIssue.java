import java.sql.Date;


public class BookIssue {
	private Date issue_date;
	private int accession_no;
	private Date due_dt;
	private int member_id;
	
	/*
	 * To get issue_date
	 * @return issue_date
	 */
	public Date getIssue_date()
	{
		return issue_date;
	}
	
	/*
	 * To set issue_date
	 */
	public void setIssue_date(Date issue_date) 
	{
		this.issue_date = issue_date;
	}
	
	/*
	 * To get accession_no
	 * @return accession_no
	 */
	public int getAccession_no()
	{
		return accession_no;
	}
	
	/*
	 * To set accession_no
	 */
	public void setAccession_no(int accession_no) 
	{
		this.accession_no = accession_no;
	}
	
	/*
	 * To get due_dt
	 * @return due_dt
	 */
	public Date getDue_dt() 
	{
		return due_dt;
	}
	
	/*
	 * To set due_dt
	 */
	public void setDue_dt(Date due_dt) 
	{
		this.due_dt = due_dt;
	}
	
	/*
	 * To get member_id
	 * @return member_id
	 */
	public int getMember_id() 
	{
		return member_id;
	}
	
	/*
	 * To set member_id
	 */
	public void setMember_id(int member_id) 
	{
		this.member_id = member_id;
	}

}
