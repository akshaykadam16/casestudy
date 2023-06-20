package casestudyjdbc;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.Scanner;



public class Coin {
	String country;
	int denomination;
	int yearofminting;
	int currentvalue;
	LocalDate aquireddate;
	
	public Coin(String country, int denomination, int yearofminting, int currentvalue, LocalDate aquireddate) {
		super();
		this.country = country;
		this.denomination = denomination;
		this.yearofminting = yearofminting;
		this.currentvalue = currentvalue;
		this.aquireddate = aquireddate;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public int getDenomination() {
		return denomination;
	}
	public void setDenomination(int denomination) {
		this.denomination = denomination;
	}
	public int getYearofminting() {
		return yearofminting;
	}
	public void setYearofminting(int yearofminting) {
		this.yearofminting = yearofminting;
	}
	public int getCurrentvalue() {
		return currentvalue;
	}
	public void setCurrentvalue(int currentvalue) {
		this.currentvalue = currentvalue;
	}
	public LocalDate getAquireddate() {
		return aquireddate;
	}
	public void setAquireddate(LocalDate aquireddate) {
		this.aquireddate = aquireddate;
	}
	public Coin() {
	
		// TODO Auto-generated constructor stub
	}
	public void addCoinList()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter country");
		String coutry=sc.next();
		System.out.println("Enter denomination");
		int deno=sc.nextInt();
		System.out.println("Enter year of menitin YYYY Format");
		int year=sc.nextInt();
		System.out.println("Enter current value");
		int value=sc.nextInt();
		System.out.println("Enter Acquired Date yyyy-mm-dd format");
		String date1=sc.next();
		LocalDate date = LocalDate.parse(date1);
		country=coutry;
		denomination=deno;
		yearofminting=year;
		currentvalue=value;
		aquireddate=date;
	}
	public void displayCoin()
	{
		System.out.println("Coin Country is:\t"+this.country);
		System.out.println("Coin Denomination is:\t"+this.denomination);
		System.out.println("Coin Year of Minting is:\t"+this.yearofminting);
		System.out.println("Coin Current value is:\t"+this.currentvalue);
		System.out.println("Coin Acquired Date is:\t"+this.aquireddate);
		
		
		
	}

	


}
