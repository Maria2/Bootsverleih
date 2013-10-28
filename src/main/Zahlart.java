package main;

public class Zahlart {

	/**
	 * @param args
	 */
	
	private String zID;
	private String beschreibung; // bar, ...
	

	public Zahlart(String zID,String beschreibung) {
		// TODO Auto-generated method stub
		this.zID=zID;
		this.beschreibung=beschreibung;
		
	}
	
	public String toString()
	{
		
		return zID+" "+beschreibung+" ";
	}
	

}
