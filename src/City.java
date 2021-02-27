
public class City {
	
	int id;
	double long_scale;
	double lat_scale;
	
	final static int vehicle =1;
	final static int dept =0;
	
	City(int id, double long_scale, double lat_scale){
		this.id = id;
		this.long_scale = long_scale;
		this.lat_scale = lat_scale;
	}
	
	int getId() {
		return id;
	}
	
	double getLong_scale() {
		return long_scale;
	}
	
	double getLat_scale() {
		return lat_scale;
	}
	
	int getVehicle() {
		return vehicle;
	}
	
	int getDept() {
		return dept;
	}
	
	public String toString() {
		return id + " " + long_scale + " " + lat_scale +"\n";
	}
	
	

}
