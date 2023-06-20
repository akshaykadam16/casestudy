package casestudyjdbc;




import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import oracle.jdbc.OracleResultSet;

public class Collection implements Comparator<Coin>{
	List<Coin> coin=new ArrayList<Coin>();
	public Collection()
	{
		
	}
	public void addCoin()
	{
		Scanner sc=new Scanner(System.in);
		// TODO Auto-generated constructor stub
		
		System.out.println("enter Coin information");
		//room=new ArrayList<Room>();
		Coin cc1;
		
			cc1=new Coin();
			cc1.addCoinList();
			coin.add(cc1);
		
	}
	public void display()
	{
		
		for(int i=0;i<coin.size();i++)
		{
			Object o=coin.get(i);
			
			if(o instanceof Coin)
			{
				System.out.println(i+"Coin Information");
				
				((Coin) o).displayCoin();
			}
				
		}
		
	}
	
	
	public void addFile()
	{
		Path pathToFile = Paths.get("coin.csv"); 
		System.out.println("load file");
		try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)) 
		{ 
			// read the first line from the text file
			String line = br.readLine();
			// loop until all lines are read 
			while (line != null)
			{ 
				
				 String[] attributes = line.split(","); 
				Coin c1 = createCoin(attributes);
			
				coin.add(c1);
				
				line = br.readLine();
				}
			}
		catch (IOException ioe) 
		{ 
				ioe.printStackTrace();
		}
		return;
		/*FileInputStream fin = null;
		Coin c2=new Coin();
		try {
			fin = new FileInputStream("coin.csv");
			//System.out.println("file open");
			BufferedInputStream bin=new BufferedInputStream(fin);
			ObjectInputStream oin = new ObjectInputStream(bin);
			
			 c2 = (Coin)oin.readObject();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("country name:"+c2.getCountry());*/
	}
	
	private static Coin createCoin(String[] metadata) 
	{
		String country = metadata[0]; 
	
		int denomination = Integer.parseInt(metadata[1]);
		int yearofminting= Integer.parseInt(metadata[2]);
		int currentvalue= Integer.parseInt(metadata[3]);
		LocalDate aquireddate = LocalDate.parse(metadata[4]);
		
		
		
		
	 return new Coin(country,denomination,yearofminting,currentvalue,aquireddate);
	
	}
		
			public void search()
			{
				Scanner sc=new Scanner(System.in);
				int ch=0;
				while(ch!=9)
				{
				System.out.println("which attribute You want to search");
				System.out.println("1.Enter Country name");
				System.out.println("2.Enter denomination");
				System.out.println("3.Enter year of minting");
				System.out.println("4.Enter Current value");
				
				System.out.println("9.exit");
				ch=sc.nextInt();
				switch(ch)
				{
				case 1:
				{
				
						System.out.println("Enter Country name You want to search");
						String cname=sc.next();
						
						for(int i=0;i<coin.size();i++)
						{
							Object o=coin.get(i);
							
							if(o instanceof Coin)
							{
								if(cname.equals(((Coin) o).getCountry()))
									{
										((Coin) o).displayCoin();
										
									}
								
							}	
								
						}
				}
				
				break;
				case 2:
					{
							System.out.println("Enter denomination You want to search");
							int dname=sc.nextInt();
							
							for(int i=0;i<coin.size();i++)
							{
								Object o=coin.get(i);
								
								if(o instanceof Coin)
								{
									if(dname==((Coin) o).getDenomination())
										{
											((Coin) o).displayCoin();
											
										}
									
								}	
									
							}
					}
				break;
				case 3:
				{
					System.out.println("Enter year of minting You want to search");
					int year=sc.nextInt();
					
					for(int i=0;i<coin.size();i++)
					{
						Object o=coin.get(i);
						
						if(o instanceof Coin)
						{
							if(year==(((Coin) o).getYearofminting()))
								{
									((Coin) o).displayCoin();
									
								}
							
						}	
							
					}
				}
				break;
				case 4:
				{
					System.out.println("Enter current value You want to search");
					int value=sc.nextInt();
					
					for(int i=0;i<coin.size();i++)
					{
						Object o=coin.get(i);
						
						if(o instanceof Coin)
						{
							if(value==(((Coin) o).getCurrentvalue()))
								{
									((Coin) o).displayCoin();
									
								}
							
						}	
							
					}
					
				}
				break;
				case 9:
					break;
				}
			}
		}
			public void sortList()
			{
				Collections.sort(coin, new Collection());
				System.out.println("your list will be sorted");
				
				
			}
			@Override
			public int compare(Coin o1, Coin o2) {
				// TODO Auto-generated method stub
				if(o1.currentvalue>o2.currentvalue)
					return 1;
				if(o1.currentvalue<o2.currentvalue)
					return -1;
				else 
					return 0;
				
			}
			
			public void connectdb(ResultSet rs)
				{
			
				try {
					while(rs.next())
					{
						String country=rs.getString(1);
						int denomination=rs.getInt(2);
						int yearofminting=rs.getInt(3);
						int currentvalue=rs.getInt(4);
						//LocalDate  aquireddate= rs.getDate(5).toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
						 LocalDate aquireddate = LocalDate.now();
//.ofEpochSecond(rs.getDate(5).getDate()).atZone(ZoneId.systemDefault()).toLocalDate();
						//String aquireddate=date.toString();
						
						 Coin c=new Coin(country,denomination,yearofminting,currentvalue,aquireddate);
						 coin.add(c);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
				
				}
			

}		

