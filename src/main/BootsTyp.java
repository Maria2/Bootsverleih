/**
 * 
 */
package main;

/**
 * @author Maria
 *
 */
public class BootsTyp {

	/**
	 * @param args
	 */
	public static String btId;
	private String benennung; //name des typs => beschreibung
	private int gewicht;
	private boolean schein; // scheinplichtig
	private int laenge;
	private int breite;
	private int maxPerson; //pro Boot
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public BootsTyp(String btId, String benennung, int gewicht, boolean schein, int l, int b, int maxPer) {
		// TODO Auto-generated method stub
		
		this.btId= btId;
		this.benennung=benennung;
		this.gewicht=gewicht;
		this.schein=schein;
		this.laenge=l;
		this.breite=b;
		this.maxPerson=maxPer;
				
	}
	
	public String getID()
	{
		return btId;
	}
	
	public String toString()
	{
		
		return btId+" "+benennung+" "+gewicht+" "+schein+" "+laenge+" "+breite+" "+maxPerson+" ";
	}
	
}