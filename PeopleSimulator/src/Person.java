import java.util.*;
class Person {
	public int age;
	private String name;
    public String place;
    public int thisPopulation;
	public Person(int age, String name,String place) {
        this.name = name;
		this.age = age;
       // String place
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
     public int getPopulationOf(String findPlaceName){

        if(this.place.equals(findPlaceName)){
            //now we want to count every occurance of this specific place
            thisPopulation++;
        }
        return thisPopulation;
     }
     public String changePlaceTo(String newPlace){
         this.place = newPlace;
         return ("Person " + this.name + "moved to " + newPlace);
     }

    //  public int getPopulationOf(int indexOfPlacesArray){

    //     // for(int b = 0; b < totalcurrentpop; b++ ){
    //         if(this.place.equals(places.getNumber(indexOfPlacesArray))){
    //             //now we want to count every occurance of this specific place
    //             thisPopulation++;
    //         }
    //    // }
    //      return thisPopulation;
    //  }

}