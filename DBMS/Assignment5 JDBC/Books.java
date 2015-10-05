
public class Books {
	private int accession_no;
	private String status;
	
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
	 * To get status
	 * @return status
	 */
	public String getStatus()
	{
		return status;
	}
	
	/*
	 * To set status
	 */
	public void setStatus(String status) 
	{
		this.status = status;
	}
	
	@Override
	public String toString()
	{
		return "Books [status=" + status
				+ "]";
	}
}
