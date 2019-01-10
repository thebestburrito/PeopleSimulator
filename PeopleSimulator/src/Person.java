import java.util.*;
class Person {
	public int age;
	private String name;
    public String place;
    public int thisPopulation;
	public Person(int age, String name,String place) {
        this.name = name;
		this.age = age;
        this.place = place;
	}
	public Person() {
		this.name = "Brad";
		this.age = 37;
	}
	public boolean olderThan(int otherAge) {
		if (age > otherAge) {
			return true;
		} else {
			return false;
		}

	}
	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public void hadBirthday() {
		age++;
	}

    //-----------------------------------------------------------------
    //Places

    public String getPlace(){
         return this.place;
     }
     public String changePlaceTo(String newPlace){
         this.place = newPlace;
         return ("Person " + this.name + "moved to " + newPlace);
     }

}