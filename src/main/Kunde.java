package main;

public class Kunde {

	/**
	 * @param args
	 */
	
	private String kId;
	private String vorname;
	private String nachname;
	private String wohnort;
	private int plz;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public Kunde(String kId, String vorname, String nachname, String wohnort, int plz) {
		// TODO Auto-generated method stub
		
		this.kId=kId;
		this.vorname=vorname;
		this.nachname=nachname;
		this.wohnort=wohnort;
		this.plz=plz;
	}
	
	public String toString()
	{
		return kId+"	"+vorname+"		"+nachname+"	"+wohnort+"		"+plz+"		";
	}

}
