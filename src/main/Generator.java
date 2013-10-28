package main;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
	private String[] lastnames={"Hauser","Hater","Spung","Sung","Zurt","Gulkl","Easdt","Somas","Lalito","Interilor","Someonename","Nutri"};
	private String[] address={"Straﬂe1","Straﬂe2","Straﬂe3","Straﬂe4","Straﬂe5","Straﬂe6","Straﬂe7","Straﬂe8","Straﬂe9","Straﬂe10","Straﬂe11","Straﬂe12"};
	private String[] zahlart={"mastercard","bar","kreditkarte","scheck","ueberweisung"};
	private static String year="";
	private static String month="";
	private static String day="";
	private static String fileDate="";
	private static String path="";
	private static String amount="";
	private static String type="";
	private static GregorianCalendar g= new GregorianCalendar();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		Generator ge= new Generator();
		
		ge.generateData();
		
		year=args[2];
		month=args[3];
		day=args[4];
		path=args[1];
		amount=args[5];
		type=args[0];
		ge.setDates();
		fileDate=year+month+day;
		int count = 0;
		
		for(int i=0;i<7;i++)
		{
		ge.writeAll();
		g.add(GregorianCalendar.DAY_OF_MONTH, 1);
		}
		System.out.println(type);
		
		
	}
	//Boot
	//BootsTyp
	//Kunde
	//Mietet 
	//Zahlart
	public void generateData()
	{
		int count=0;
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
		i = rand.nextInt(list.length);
		
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
	public String setDates()
	{
		
		
		 for(int i=0;i<Integer.parseInt(amount);i++){
			   year=g.get(GregorianCalendar.YEAR)+"";
			   month=g.get(GregorianCalendar.MONTH)+"";
			   day=g.get(GregorianCalendar.DAY_OF_MONTH)+"";
			   String var="";
			   if(month.length()<2){
			    var=month;
			    month="0"+var;
			   }
		 }
		
		return g.get(g.YEAR)+""+g.get(g.MONTH)+""+g.get(g.DAY_OF_MONTH);
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
	
	public void writeAll()
	{
		 try {
	          File file = new File("Zahlart_"+fileDate+".txt");
	          BufferedWriter output = new BufferedWriter(new FileWriter(file));
	          File file1 = new File("Mietet_"+fileDate+".txt");
	          BufferedWriter output1 = new BufferedWriter(new FileWriter(file1));
	          File file2 = new File("Kunde_"+fileDate+".txt");
	          BufferedWriter output2 = new BufferedWriter(new FileWriter(file2));
	          File file3 = new File("BootsTyp_"+fileDate+".txt");
	          BufferedWriter output3 = new BufferedWriter(new FileWriter(file3));
	          File file4 = new File("Boot_"+fileDate+".txt");
	          BufferedWriter output4 = new BufferedWriter(new FileWriter(file4));
      if(type.equals("Zahlart"))
      {
    	  output.write("Amount of rows: "+Zahlart.size());
    	  output.write("zID	beschreibung");
	    	output.write("\n");
	    for(Zahlart e:Zahlart)
	    {
	    	
	    	output.write(e.toString());
	    	output.write("\n");
	      
	    }
          
        output.close();
      }
        
      if(type.equals("Mietet"))
      {
    	  output.write("Amount of rows: "+Mietet.size());
    	  output.write("mId verleihStart dauer discount");
    	  output.write("\n");
    	  
        for(Mietet e:Mietet)
        {
        	
        	output1.write(e.toString());
        	output1.write("\n");
        }
	        
          
        output1.close();
      }
      
      if(type.equals("Kunde"))
      {
    	  output.write("Amount of rows: "+Kunde.size());
    	  output2.write("kId vorname nachname wohnort plz");
    	  output2.write("\n");
        for(Kunde e:Kunde)
        {
        	
        	output2.write(e.toString());
        	output2.write("\n");
          
        }
        output2.close();
      }
        
        if(type.equals("BootsTyp"))
        {
        	output.write("Amount of rows: "+BootsTyp.size());
        	output3.write("btId benennung gewicht schein laenge breite maxPerson");
	    	output3.write("\n");
	        for(BootsTyp e:BootsTyp)
	        {
	        	
	        	output3.write(e.toString());
	        	output3.write("\n");
	          
	        }
	      
	        output3.close();
        }
        
        if(type.equals("Boot"))
        {
        	output.write("Amount of rows: "+Boot.size());
        	output4.write("BootId Name BootType KostenProTag");
	    	output4.write("\n");
	        for(Boot e:Boot)
	        {
	        	output4.write(e.toString());
	        	output4.write("\n");
	          
	        }
	      
	        output4.close();
	        }
       } 	
       catch ( IOException e ) {
          e.printStackTrace();
       }
		
	}
}