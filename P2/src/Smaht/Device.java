/**
 * 
 */
package Smaht;

/**
 * @author williammccolgan
 * This is the abstract device. Extended to such specific devices as Radiator
 */
public abstract class Device {

	private String Name;
	private String Manufacturer;
	private Room room;
	private Powerstate powerstate;
	
	
	
	
	public Device(String name, String manufacturer, Room room, Powerstate powerstate) {
		super();
		this.setName(name);
		this.setManufacturer(manufacturer);
		this.setRoom(room);
		this.setPowerstate(powerstate);
	}




	public String getName() {
		return Name;
	}




	public void setName(String name) {
		Name = name;
	}




	public String getManufacturer() {
		return Manufacturer;
	}




	public void setManufacturer(String manufacturer) {
		Manufacturer = manufacturer;
	}




	public Room getRoom() {
		return room;
	}




	public void setRoom(Room room) {
		this.room = room;
	}




	public Powerstate getPowerstate() {
		return powerstate;
	}




	public void setPowerstate(Powerstate powerstate) {
		this.powerstate = powerstate;
	}
	
	/**
	 * Print details to console
	 */
	public void showAll() {
		System.out.println("NAME          :"+ getName());
		System.out.println("MANUFACTURER  :"+ getManufacturer());
		System.out.println("ROOM          :"+ getRoom());
		System.out.println("POWERSTATE    :"+ getPowerstate());
	}
	public abstract String status();
}
