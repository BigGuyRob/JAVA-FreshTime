package application;

import java.util.InputMismatchException;

/**
 * Location class contains logic relating towards storing and displaying location information
 * @author Rob Reid
 *
 */
public class Location implements Comparable{
	private double longitude;
	private double latitude;
	
	public Location(double lon, double lat) {
		this.longitude = lon;
		this.latitude = lat;
	}

	/**
	 * compareTo method compares to location objects to see if they are equal
	 * @param o - Object type object to be compared to location 
	 * @return int - -1 if objects could not be compared, 1 if equal, 0 if not equal locations
	 */
	@Override
	public int compareTo(Object o) {
		Location l = new Location(-1,-1);
		try {
			l = (Location) o;
		}catch (InputMismatchException e) {
			//The object was not a location and could not be cast
			return -1;
		}
		
		if(l.getLongitude() == -1 && l.getLatitude() == -1) {
			//return that objects could not be compared or that something happened
			return -1;
		}
		
		if(l.getLongitude() == this.longitude && l.getLatitude() == this.latitude) {
			//Return 1 if equal
			return 1;
		}else {
			//Return 0 if locations are not equal
			return 0;
		}
	}
	
	public double getLongitude() {
		return this.longitude;
	}
	
	public double getLatitude() {
		return this.latitude;
	}
	
	public String toString() {
		return this.longitude + "," + this.latitude; 
	}
	
}
