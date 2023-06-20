package casestudyjdbc;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Scanner;

public class MainApp {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub

		Collection c1=new Collection();
		Scanner sc=new Scanner(System.in);
		int ch=0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//System.out.println("load driver");
		Connection con = null;
		try {
			con = DriverManager.getConnection(  
					"jdbc:oracle:thin:@localhost:1521:orcl","system","root123");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}  
		//System.out.println("connected");		  
		
		String s="select * from coin";
		
		Statement stmt = null;
		try {
			stmt = con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ResultSet rs = null;
		try {
			rs = stmt.executeQuery(s);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		c1.connectdb(rs);
		try {
			rs.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		while(ch!=9)
		{
			
			System.out.println("1.Add Coin");
			System.out.println("2.Display Coin");
			System.out.println("3.Add from file");
			System.out.println("4.Search");
			System.out.println("5.sort");
			System.out.println("6.Database operation");
			System.out.println("9.exit");
			System.out.println("Enter Your Choice");
			ch=sc.nextInt();
			switch(ch)
			{
					case 1:
					{
						c1.addCoin();
					}
					break;
					case 2:
					{
						c1.display();
					}
					break;
					case 3:
					{
						
						c1.addFile();
						c1.display();

					}
					break;
					case 4:
					{
						c1.search();
					}
					break;
					case 5:
					{
						c1.sortList();
						c1.display();
					}
					break;
					case 6:
					{
						boolean rs1 = false;
						String s1=null;
						int c=0;
						while(c!=6)
						{
						System.out.println("Enter Your Choice");
						System.out.println("1.Insert");
						System.out.println("2.update");
						System.out.println("3.delete");
						System.out.println("6.exit");
						c=sc.nextInt();
						switch(c)
						{
						case 1:
						{
							
							System.out.println("Enter country");
							String coutry=sc.next();
							System.out.println("Enter denomination");
							int deno=sc.nextInt();
							System.out.println("Enter year of menitin YYYY Format");
							int year=sc.nextInt();
							System.out.println("Enter current value");
							int value=sc.nextInt();
							System.out.println("Enter date");
							int day =sc.nextInt();
							int month =sc.nextInt();
							int year1 =sc.nextInt();
							Date date1=new Date(day, month, year1);
							
							
							
						 s1="insert into coin(country,denomination,yearofminting,currentvalue,acquireddate) values(?,?,?,?,?)";
						//String s="insert into coin values("+coutry+","+deno+","+year+","+value+","+date+");";
						 try {
							PreparedStatement pstmt=con.prepareStatement(s1);
							pstmt.setString(1, coutry);
							pstmt.setInt(2, deno);
							pstmt.setInt(3, year);
							pstmt.setInt(4, value);
							pstmt.setDate(5, date1);
							pstmt.execute(s1);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						//if(rs1)
						
						System.out.println("insert successfully");
						

						
						}
						break;
						case 2:
						{
							
						}
						break;
						case 3:
						{
							System.out.println("which country u want to delete");
							String contry=sc.next();
							s1="delete from coin where country='"+contry+"'";
							stmt.executeUpdate(s1);
							System.out.println("Delete Sucessfully");
							
								}
						break;
						case 6:break;
						}
					}


					}
					break;
					case 9:
						break;
			}		
		}
	
	}
}
