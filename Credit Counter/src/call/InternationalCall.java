package call;

import code.Country;
import code.Day;

public class InternationalCall extends Call {

	final private Day day = new Day();
	
	private int code;
	private double rate;
	private String country;
	private Country countryObj;
	
	public InternationalCall(String country) {
		this.country = country;
		countryObj = new Country(country);
		rate = countryObj.getCallRateOfCountry();
		code = countryObj.getCodeOfCountry();
	}

	@Override
	public double rate() {
		// TODO Auto-generated method stub
		return 0;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public int getCode() {
		return code;
	}

	public String getCountry() {
		return country;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public void setCountry(String country) {
		this.country = country;
	}


}

