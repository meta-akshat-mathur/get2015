import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.mysql.jdbc.Connection;

public class MainClass 
{
	private static Scanner sc;
	private static Scanner scanner;
	//Main function
	public static void main(String[] args)
	{
		do
		{
			System.out.println("1.To Fetch all the books published by an author");
			System.out.println("2.To issue a book");
			System.out.println("3.To delete all those books which were not issued in last 1 year");
			System.out.println("4.To Exit");
			int choice = userInput();   				
			switch(choice)
			{
				case 1:
					executeQueryUsingPreparedStatement(choice);
					break;
				case 2:
					executeQueryUsingPreparedStatement(choice);
					break;
				case 3:
					String query3 = "SET SQL_SAFE_UPDATES=0;";
					executeQueryUsingStatement(query3);
					break;
				case 4:
					sc.close();
					System.exit(0);
					break;
				default:
					System.out.println("Invalid option");
					break;
			}
		}
		while(true);
	}
	
	
	private static int userInput() {
		int number = 0;
		scanner = new Scanner(System.in);
		try {
			number = scanner.nextInt();
			return number;
		} catch (InputMismatchException e) {
			System.out.println("\nEnter only integer");
			number = userInput();
		}
		return number;
	}
	
	/**
	 * To get index for prepared statement
	 * @return index value
	 */
	private static String getIndex()
	{
		sc = new Scanner(System.in);
		String index = sc.next();		//holds index
		return index;
		
	}
	/**
	 * To get query for choice 
	 * @return query
	 */
	private static String getQuery1()
	{
		String query = "select title_name from authors INNER JOIN title_author ON title_author.author_id=authors.author_id "
				+ "INNER JOIN titles ON titles.title_id=title_author.title_id WHERE au_fname=?;";
		return query;
	}
	/**
	 * To get query for choice 2
	 * @return query
	 */
	private static String getQuery2()
	{
		String query = "SELECT status FROM titles AS t INNER JOIN books AS b ON b.title_id=t.title_id WHERE title_name=?;";
		return query;
	}
	
	/**
	 * If choice =1, Fetch all the books published by author,
	 *	given the name of the author
	 *	Else if choice =2,Given the name of the book, to be issued by an
	 *	existing member.Return flag to indicate whether the book has been
	 *  issued or not
	 * @param choice
	 */
	@SuppressWarnings("resource")
	private static void executeQueryUsingPreparedStatement(int choice)
	{
		Scanner sc = new Scanner(System.in);
		Connection con = null;
		ResultSet rs = null;				//To hold resultset
		PreparedStatement ps = null;			//To hold prepared statement
		ConnectionUtil conUtil = new ConnectionUtil();			//Creating object of ConnectionUtil
		con = (Connection) conUtil.getConnection();			//To hold connection
		String query = (choice==1) ? getQuery1():getQuery2();		//getting required query
		try 
		{
			ps = con.prepareStatement(query);
			
			if(choice==1)
			{
				System.out.println("Enter author_name");
				/* set variable in prepared statement */
				ps.setString(1, getIndex());
				rs = ps.executeQuery();
				while (rs.next())
				{
					Titles t = new Titles();			//Object of titles class
					t.setTitleName(rs.getString("title_name"));
					System.out.println(t.getTitleName());
				}
			}
			else
			{
				System.out.println("Enter book_title");
				/* set variable in prepared statement */
				ps.setString(1, getIndex());
				
				// ps.setString(1,name);
				rs = ps.executeQuery();
				while (rs.next())
				{
					Books b = new Books();			//Object of books class
					b.setStatus(rs.getString("status"));
					System.out.println(b.getStatus());
					
					if(b.getStatus().equalsIgnoreCase("UnBooked"))
					{
						System.out.println("Enter member_id");
						int m_id = userInput();
						String q = "SELECT member_id from members where member_id "
								+ "NOT IN (SELECT member_id FROM book_issue) AND member_id=?;";
						ps = con.prepareStatement(q);
						/* set variable in prepared statement */
						ps.setInt(1, m_id);
						rs  = ps.executeQuery();
						if(rs.next())
						{
							BookIssue bi = new BookIssue();
							bi.setMember_id(m_id);
							
							System.out.println("Enter accession_no of this book");
							int a_no = sc.nextInt(); 
							bi.setAccession_no(a_no);
							
							ps = con.prepareStatement("INSERT INTO book_issue (accession_no, member_id) VALUES (?, ?);");
							/* set variable in prepared statement */
							ps.setInt(1,bi.getAccession_no());
							ps.setInt(2,bi.getMember_id());
							int flag=ps.executeUpdate();
							
							if(flag==1)
								System.out.println("Flag = "+flag+ " Book with accession_no "+ bi.getAccession_no()+" Issued to "+bi.getMember_id());
							else 
								System.out.println("Flag = "+flag+ " Book not Issued");
						}
						else
							System.out.println("You have already issued a book :\n please return previous book first\n");
					}
					else
						System.out.println("Book is issued to someone else");
				}
			}	
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		} 
		finally 
		{
			/* close connection */
			try 
			{
				if (con != null)
				{
					con.close();
				}
				if (ps != null)
				{
					ps.close();
				}
			}
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
	}
	/*
	 * Delete all those books which were not issued in last 1 year 
	 * and return the number of books deleted
	 * @param query
	 */
	private static void executeQueryUsingStatement(String query) 
	{
		Connection con = null;				//To hold connection
		ResultSet rs = null;				//To hold resultset
		Statement stmt = null;				//To hold statement
		ConnectionUtil conUtil = new ConnectionUtil();
		con = (Connection) conUtil.getConnection();
		try 
		{
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);

			String query1 = "DELETE FROM books WHERE books.accession_no NOT IN (SELECT bi.accession_no FROM book_issue AS bi WHERE bi.issue_date BETWEEN DATE_SUB(NOW(), INTERVAL 365 DAY) AND NOW());";
			int b = stmt.executeUpdate(query1);
			System.out.println(b +" number of rows deleted");
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		} 
		finally 
		{
			// close connection 
			try 
			{
				if (con != null)
				{
					con.close();
				}
				if (stmt != null) 
				{
					stmt.close();
				}
				if (rs != null) 
				{
					rs.close();
				}

			} catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
	}
}
