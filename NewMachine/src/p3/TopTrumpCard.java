/**
 * 
 */
package p3;

import java.util.Objects;

/**
 * Author William McColgan 40387482
 */
public class TopTrumpCard {

	private String name;
	private String RealName;
	private String ImgName;
	private Category cat;
	private int speed;
	private int strength;
	private int agility;
	private int intelligence;
	private String bio;
	
	// default constructor
	//public TopTrumpCard(){
	//}
	
	//Constructor with fields
	
	/**
	 * @param name
	 * @param realName
	 * @param imgName
	 * @param cat
	 * @param speed
	 * @param strength
	 * @param agility
	 * @param intelligence
	 * @param bio
	 */
	public TopTrumpCard(String name, String realName, String imgName, Category cat, int speed, int strength,
			int agility, int intelligence, String bio) {
		super();
		this.setName(name);
		this.setRealName(realName);
		this.setImgName(imgName); 
		this.setCat(cat);
		this.setSpeed(speed);
		this.setStrength(strength);
		this.setAgility(agility);
		this.setIntelligence(intelligence);
		this.setBio(bio);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) throws IllegalArgumentException {
		if (name.length()>0 && name.length()<=30) {
		this.name = name;
	}else {
		throw new IllegalArgumentException("invalid name");
		}
	}

	public String getRealName() {
		return RealName;
	}

	public void setRealName(String realName) throws IllegalArgumentException {
		if (realName.length()>0 && realName.length()<=30 ) {
		this.RealName = realName;
	}else {
		throw new IllegalArgumentException("invalid name");}
		}

	public String getImgName() {
		if(ImgName.length()>5 && ImgName.length()<=30 && ImgName.contains(".jpg")) {
	
		return ImgName;
	}else {
		throw new IllegalArgumentException("invalid img name");}
	}

	public void setImgName(String imgName) {
		ImgName = imgName;
	}

	public Category getCat() {
		return cat;
	}

	public void setCat(Category cat) {
		this.cat = cat;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) throws IllegalArgumentException {
		
		if(speed >=0 && speed <=100 ) {
		
		this.speed = speed;
	} else {
		throw new IllegalArgumentException("not a valid speed");}
		}
	

	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) throws IllegalArgumentException{
		
		
		if(strength >=0 && strength <=100 ) {
	
		this.strength = strength;
	}else {

		throw new IllegalArgumentException("not a valid strength");}
	}
		
	public int getAgility() {
		return agility;
	}

	public void setAgility(int agility) throws IllegalArgumentException{
		if(agility>=0 && agility<=100) {
		
		this.agility = agility;
	}else {
		throw new IllegalArgumentException("Not a valid agility");}
		
	}

	public int getIntelligence() {
		return intelligence;
	}

	public void setIntelligence(int intelligence) throws IllegalArgumentException{
		
		if(intelligence>=0 && intelligence <=100) {

			this.intelligence = intelligence;

		}else {
			throw new IllegalArgumentException("Not a valid intelligence");
		}
		
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) throws IllegalArgumentException{
		
			this.bio = bio;
		}
	

	@Override
	public String toString() {
		return "TopTrumpCard [name=" + name + ", RealName=" + RealName + ", ImgName=" + ImgName + ", cat=" + cat
				+ ", speed=" + speed + ", strength=" + strength + ", agility=" + agility + ", intelligence="
				+ intelligence + ", bio=" + bio + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(ImgName, RealName, agility, bio, cat, intelligence, name, speed, strength);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TopTrumpCard other = (TopTrumpCard) obj;
		return Objects.equals(ImgName, other.ImgName) && Objects.equals(RealName, other.RealName)
				&& agility == other.agility && Objects.equals(bio, other.bio) && cat == other.cat
				&& intelligence == other.intelligence && Objects.equals(name, other.name) && speed == other.speed
				&& strength == other.strength;
	}
	
	public void displayAll() {
	
		System.out.println("Name:\t\t\t"+name);
		System.out.println("Real Name:\t\t"+RealName);
		System.out.println("Image Name:\t\t"+ImgName);
		System.out.println("Category:\t\t"+cat);
		System.out.println("Speed:\t\t\t"+speed);
		System.out.println("Strength:\t\t\t"+strength);
		System.out.println("Agility:\t\t\t"+agility);
		System.out.println("Intelligence:\t\t\t"+intelligence);
		System.out.println("Bio:\t\t\t"+bio);
		System.out.println("---------------------------------");	
		System.out.println();	
		
		
	}
	
	public void displaySummary() {
	
		System.out.println(name+" / "+RealName+" ("+cat+")");
		System.out.println("sp: "+speed+" | st: "+strength+" | ag: "+agility+" | in: "+intelligence);
		System.out.println("---------------------------------");	
		System.out.println();	
		
	}
	
	public int getMaxID() {
		return agility;
		
	}
	
	public int getStatScore(int statChoice) {
		return statChoice;
	
	}

	
}
