package main;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.UUID;

public class Generator {

	
	/**
	 * @param args
	 */
	private ArrayList<Boot> Boot = new ArrayList<Boot>();
	private ArrayList<Zahlart> Zahlart = new ArrayList<Zahlart>();
	private ArrayList<Mietet> Mietet = new ArrayList<Mietet>();
	private ArrayList<Kunde> Kunde = new ArrayList<Kunde>();
	private ArrayList<BootsTyp> BootsTyp = new ArrayList<BootsTyp>();
	private String[] firstnames={"Maria","Abi","Anil","Michi","Merve","Eric","Viktor","Susanne","Claudia","Marina","Rolf","Tobias"};
	private String[] lastnames={"Hasler","Hater","Spung","Sung","Zurt","Gulkl","Easdt","Dummhaus","Intelligentses","Interilor","Someonename","Heytro"};
	private String[] address={"Straﬂe1","Straﬂe2","Straﬂe3","Straﬂe4","Straﬂe5","Straﬂe6","Straﬂe7","Straﬂe8","Straﬂe9","Straﬂe10","Straﬂe11","Straﬂe12"};
	private String[] zahlart={"mastercard","bar","kreditkarte","scheck","ueberweisung"};

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Generator g= new Generator();
		g.generateData();
		WriteToFile wtf = new WriteToFile();
		wtf.writeAll();
	}
	//Boot
	//BootsTyp
	//Kunde
	//Mietet 
	//Zahlart
	public void generateData()
	{
		for(int i=1; i<40; i++)
		{
			//int BootId,String Name, int BootType, int KostenProTag
			Boot b=new Boot(generateIds(),generateStrings(firstnames)+" "+generateStrings(lastnames),generateIds(),generateNumbers(2,30,99));
			Boot.add(b);
			//int zID,String beschreibung
			Zahlart z= new Zahlart(generateIds(),generateStrings(zahlart));
			Zahlart.add(z);
			// String btId, String benennung, int gewicht, boolean schein, int l, int b, int maxPer
			BootsTyp bt = new BootsTyp(generateIds(),generateStrings(firstnames),generateNumbers(2,30,99),true,generateNumbers(2,30,99),generateNumbers(2,30,99),generateNumbers(2,30,99));
			BootsTyp.add(bt);
			//int kId, String vorname, String nachname, String wohnort, int plz
			Kunde k = new Kunde(generateIds(),generateStrings(firstnames),generateStrings(lastnames),generateStrings(address),generateNumbers(4, 9, 1));
			Kunde.add(k);
			// int mId, String verleihStart, int dauer, int discount
			Mietet m = new Mietet(generateIds(),generateDates(),generateNumbers(2, 30, 1),generateNumbers(2, 20, 5));
			Mietet.add(m);
		}
		
	}
	
	public String generateStrings(String[] list)
	{
		String s="";
		int i;
		Random rand = new Random();
		i = rand.nextInt(list.length-1);
		
		s= list[i];
		
		return s;
	
	}
	
	public String generateIds()
	{
		
	     // creating UUID      
	      UUID uid = UUID.fromString("38400000-8cf0-11bd-b23e-10b96e4ef00d");     
	        
	      // checking the value of random UUID
	      return uid.randomUUID()+"";
		
	}
	
	public int generateNumbers(int lenght, int max, int min)
	{
		int[] numb=new int[max-1];
		int x=0;
		for(int i=1; i<lenght; i++)
		{
			numb[i]=randBetween(min, max);
			x=i;
		}
		
		return numb[x];
	}
		
	public String generateDates()
	{
		String date;
		
		GregorianCalendar gc = new GregorianCalendar();
        int year = randBetween(1900, 2010);
        gc.set(gc.YEAR, year);
        int dayOfYear = randBetween(1, gc.getActualMaximum(gc.DAY_OF_YEAR));
        gc.set(gc.DAY_OF_YEAR, dayOfYear);
		
        date=gc.get(gc.YEAR) + "-" + gc.get(gc.MONTH) + "-" + gc.get(gc.DAY_OF_MONTH);
        return date;
	}
	
	public static int randBetween(int start, int end) {
        return start + (int)Math.round(Math.random() * (end - start));
    }