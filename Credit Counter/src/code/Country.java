package code;

import java.io.File;
import java.io.IOException;
import java.nio.charset.MalformedInputException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

public class Country {
	//Total number of countries:225
	//Africa:51, Asia:40, Europe:67, NorthAmerica:32, SouthAmerica:14, Ocenia:21
	private String filename = "C:\\Users\\Abel Fekadu\\eclipse-workspace\\Credit Counter\\Countries";
	final private File countries = new File(filename);
	
	private ArrayList<String> Africa1;//12
	private ArrayList<String> Africa2;//34
	private ArrayList<String> AfricaS;//5
	private ArrayList<String> Asia1;//37
	private ArrayList<String> AsiaS;//3
	private ArrayList<String> Europe1;//25
	private ArrayList<String> Europe2;//38
	private ArrayList<String> EuropeS;//4
	private ArrayList<String> NorthAmerica1;//29
	private ArrayList<String> NorthAmericaS;//3
	private ArrayList<String> SouthAmerica1;//14
	private ArrayList<String> Ocenia1;//12
	private ArrayList<String> OceniaS;//9
	private Vector<ArrayList<String>> AllZones;
	
	final private int decoy = populateLists();
	final private HashMap<String,Integer> HMAfrica1 = parseArrayListToHashMap(Africa1);
	final private HashMap<String,Integer> HMAfrica2 = parseArrayListToHashMap(Africa2);
	final private HashMap<String,Integer> HMAfricaS= parseArrayListToHashMap(AfricaS);
	final private HashMap<String,Integer> HMAsia1 = parseArrayListToHashMap(Asia1);
	final private HashMap<String,Integer> HMAsiaS = parseArrayListToHashMap(AsiaS);
	final private HashMap<String,Integer> HMEurope1 = parseArrayListToHashMap(Europe1);
	final private HashMap<String,Integer> HMEurope2 = parseArrayListToHashMap(Europe2);
	final private HashMap<String,Integer> HMEuropeS = parseArrayListToHashMap(EuropeS);
	final private HashMap<String,Integer> HMNorthAmerica1 = parseArrayListToHashMap(NorthAmerica1);
	final private HashMap<String,Integer> HMNorthAmericaS = parseArrayListToHashMap(NorthAmericaS);
	final private HashMap<String,Integer> HMSouthAmerica1 = parseArrayListToHashMap(SouthAmerica1);
	final private HashMap<String,Integer> HMOcenia1 = parseArrayListToHashMap(Ocenia1);
	final private HashMap<String,Integer> HMOceniaS = parseArrayListToHashMap(OceniaS);
	
	private String country;
	private double callRateOfCountry;
	private int codeOfCountry;
	
	public Country() {}
	
	public Country(String country) {
		this.country = country;
		callRateOfCountry = callRateForCountry(country);
		codeOfCountry = codeForCountry(country);
	}
	
	private void initializeLists() {
		Africa1 = new ArrayList<String>();
		Africa2 = new ArrayList<String>();
		AfricaS = new ArrayList<String>();
		Asia1 = new ArrayList<String>();
		AsiaS = new ArrayList<String>();
		Europe1 = new ArrayList<String>();
		Europe2 = new ArrayList<String>();
		EuropeS = new ArrayList<String>();
		NorthAmerica1 = new ArrayList<String>();
		NorthAmericaS = new ArrayList<String>();
		SouthAmerica1 = new ArrayList<String>();
		Ocenia1 = new ArrayList<String>();
		OceniaS = new ArrayList<String>();
		AllZones = new Vector<ArrayList<String>>();
	}
	
	private int populateLists() {
		initializeLists();
		Africa1 = fileToArrayList(getFilesofZone(1)[0]);
		Africa2 = fileToArrayList(getFilesofZone(1)[1]);
		AfricaS = fileToArrayList(getFilesofZone(1)[2]);
		Asia1 = fileToArrayList(getFilesofZone(2)[0]);
		AsiaS = fileToArrayList(getFilesofZone(2)[1]);
		Europe1 = fileToArrayList(getFilesofZone(3)[0]);
		Europe2 = fileToArrayList(getFilesofZone(3)[1]);
		EuropeS = fileToArrayList(getFilesofZone(3)[2]);
		NorthAmerica1 = fileToArrayList(getFilesofZone(4)[0]);
		NorthAmericaS = fileToArrayList(getFilesofZone(4)[1]);
		SouthAmerica1 = fileToArrayList(getFilesofZone(5)[0]);
		Ocenia1 = fileToArrayList(getFilesofZone(6)[0]);
		OceniaS = fileToArrayList(getFilesofZone(6)[1]);
		AllZones.add(Africa1);AllZones.add(Africa2);AllZones.add(AfricaS);
		AllZones.add(Asia1);AllZones.add(AsiaS);AllZones.add(Europe1);
		AllZones.add(Europe2);AllZones.add(EuropeS);AllZones.add(NorthAmerica1);
		AllZones.add(NorthAmericaS);AllZones.add(SouthAmerica1);
		AllZones.add(Ocenia1);AllZones.add(OceniaS);
		return 0;
	}
	
	 ArrayList<String> fileToArrayList(File file) {
		ArrayList<String> list = new ArrayList<String>();
		int skip = 0;
		try {
			for(String line : Files.readAllLines(Paths.get(file.getAbsolutePath()))){
				if(skip==0) {skip++;continue;}
				list.add(line);
			}
		} 
		catch(MalformedInputException mie) {
			System.out.println("MalformedInputException@: "+Paths.get(file.getAbsolutePath()));
		}
		catch (IOException e) {
			System.out.println("IOException");
		}
		catch(NumberFormatException nfe) {
			System.out.println("NumberFormatException");
		}
		return list;
	}
	
	private HashMap<String,Integer> parseArrayListToHashMap(ArrayList<String> list){
		HashMap<String,Integer> map = new HashMap<String, Integer>();
		for(String line: list) {
			String countryName=""; String countryCode=""; boolean flag = true; ;			
			for(int i = 0; i < line.length(); ++i) {
				if(line.charAt(i)=='(') {flag=false;continue;}
				if(line.charAt(i)!='('&&flag) {
					countryName+=line.charAt(i);
					continue;
				}
				if(line.charAt(i) == ')') {break;}
				countryCode+=line.charAt(i);
			}
		countryName = countryName.substring(0,countryName.length()-1);
		map.put(countryName, new Integer(countryCode));
		}
		return map;
	}

	//TODO:assign correct rates
	private double callRateForCountry(String country) {
		double retVal = 0;
	
		if(HMAfrica1.containsKey(country)) {retVal = 9.36;}
		else if(HMAfrica2.containsKey(country)) {retVal = 10.29;}
		else if(HMAfricaS.containsKey(country)) {retVal = 23.00;}
		else if(HMAsia1.containsKey(country)) {retVal = 7.50;}
		else if(HMAsiaS.containsKey(country)) {retVal = 23.00;}
		else if(HMEurope1.containsKey(country)) {retVal = 7.19;}
		else if(HMEurope2.containsKey(country)) {retVal = 8.63;}
		else if(HMEuropeS.containsKey(country)) {retVal = 23.00;}
		else if(HMNorthAmerica1.containsKey(country)) {retVal = 7.19;}
		else if(HMNorthAmericaS.containsKey(country)) {retVal = 23.00;}
		else if(HMSouthAmerica1.containsKey(country)) {retVal = 7.36;}
		else if(HMOcenia1.containsKey(country)) {retVal = 8.95;}
		else if(HMOceniaS.containsKey(country)) {retVal = 23.00;}
			
		return retVal;
	}
	
	private int codeForCountry(String country) {
		int code = 0;
		if(HMAfrica1.containsKey(country)) {code = HMAfrica1.get(country);}
		else if(HMAfrica2.containsKey(country)) {code = HMAfrica2.get(country);}
		else if(HMAfricaS.containsKey(country)) {code = HMAfricaS.get(country);}
		else if(HMAsia1.containsKey(country)) {code = HMAsia1.get(country);}
		else if(HMAsiaS.containsKey(country)) {code = HMAsiaS.get(country);}
		else if(HMEurope1.containsKey(country)) {code = HMEurope1.get(country);}
		else if(HMEurope2.containsKey(country)) {code = HMEurope2.get(country);}
		else if(HMEuropeS.containsKey(country)) {code = HMEuropeS.get(country);}
		else if(HMNorthAmerica1.containsKey(country)) {code = HMNorthAmerica1.get(country);}
		else if(HMNorthAmericaS.containsKey(country)) {code = HMNorthAmericaS.get(country);}
		else if(HMSouthAmerica1.containsKey(country)) {code = HMSouthAmerica1.get(country);}
		else if(HMOcenia1.containsKey(country)) {code = HMOcenia1.get(country);}
		else if(HMOceniaS.containsKey(country)) {code = HMOceniaS.get(country);}
		
		return code;
	}
	
	private File[] getFilesofZone(int zone) {
		return new File(filename+"\\"+getFolderofZone(zone)).listFiles();
	}
	
	private String getFolderofZone(int zone) {
		zone = (zone> 0) ? --zone : 0;
		return countries.list()[zone];
	}
	
	//Getters and Setters
	public String getFileName() {
		return filename;
	}
	public ArrayList<String> getAfrica() {
		ArrayList<String> africa = new ArrayList<String>();
		africa.addAll(AllZones.get(0));
		africa.addAll(AllZones.get(1));
		africa.addAll(AllZones.get(2));
		return africa;
	}
	public ArrayList<String> getAsia(){
		ArrayList<String> asia = new ArrayList<String>();
		asia.addAll(AllZones.get(3));
		asia.addAll(AllZones.get(4));
		return asia;
	}
	public ArrayList<String> getEurope(){
		ArrayList<String> europe = new ArrayList<String>();
		europe.addAll(AllZones.get(5));
		europe.addAll(AllZones.get(6));
		europe.addAll(AllZones.get(7));
		return europe;
	}
	public ArrayList<String> getNorthAmerica(){
		ArrayList<String> north = new ArrayList<String>();
		north.addAll(AllZones.get(8));
		north.addAll(AllZones.get(9));
		return north;
	}
	public ArrayList<String> getSouthAmerica(){
		ArrayList<String> south = new ArrayList<String>();
		south.addAll(AllZones.get(10));
		return south;
	}
	public ArrayList<String> getOcenia(){
		ArrayList<String> ocenia = new ArrayList<String>();
		ocenia.addAll(AllZones.get(11));
		ocenia.addAll(AllZones.get(12));
		return ocenia;
	}
	public Vector<ArrayList<String>> getAllZones(){
		return AllZones;
	}
	public String getCountry() {
		return country;
	}
	public double getCallRateOfCountry() {
		return callRateOfCountry;
	}
	public int getCodeOfCountry() {
		return codeOfCountry;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public void setcallRateOfCountry(double callRateOfCountry) {
		this.callRateOfCountry = callRateOfCountry;
	}
	public void setCodeOfCountry(int codeOfCountry) {
		this.codeOfCountry = codeOfCountry;
	}	
	
}
