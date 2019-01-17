import java.util.ArrayList;


class Person {
	public int age;
	private String name;
    private int birthday;
    private String gender;
    private boolean deceased;
    //Shows a Persons Parents
    private String parent1;
    private String parent2;
    public String place;
    public Person spouse;
    public int thisPopulation;
    private ArrayList <Integer> haves = new ArrayList <Integer>();
    private ArrayList <Integer> wants = new ArrayList <Integer>();
    private boolean married = false;
    public int IQ = bellCurve(100,15);
    public int income = bellCurve(53719,30000);
    public int points = 0;
    public int mill = bellCurve(50,25);


	public Person(int age, String name,String gender,int birthdate,String place, String parent1, String parent2) {
		this.name = name;
		this.age = age;
        this.birthday = birthdate;
        this.gender = gender;
        deceased = false;
        this.parent1 = parent1;
        this.parent2 = parent2;
        this.place = place;
        this.spouse = null;
        for(int i = 0; i < 10; i++){
            haves.add((int)(Math.random()*10));
            wants.add((int)(Math.random()*10));
        }
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

    public void setGender(String gender){
        this.gender = gender;
    }

    public String getGender(){
        return gender;
    }

    public int getBirthday(){
        return birthday;
    }

    public ArrayList <Integer> getHaves(){
        return haves;
    }
    public ArrayList <Integer> getWants(){
        return wants;
    }

    public boolean isDead(){
		return deceased;
	}

    public void markAsDeceased(){
        deceased = true;
    }

    public String getParent1(){
        return this.parent1;
    }

    public String getParent2(){
        return this.parent2;
    }

    public void setParent1(String newP){
        this.parent1 = newP;
    }

    public void setParent2(String newP){
        this.parent2 = newP;
    }
    public boolean isMarried(){
        return married;
    }

    public void gotMarriedTo(Person spouse){
        this.spouse = spouse;
    }

    public Person getSpouse(){
        if(spouse != null){
            return spouse;
        }else{
            return null;
        }
    }

     public static int bellCurve(int mean, int sd) {
		// make nombors gud
	    int i = mean - (3*sd);
	    int j = mean + (3*sd);
		int x = i;
		for(int c = i; c < j; c++) {
			double l = Math.random();
			if(l >= 0.5) {
				x++;
			}
		}
		return x;
     }

    public String getPlace(){
         return this.place;
     }
     public String changePlaceTo(String newPlace){
         this.place = newPlace;
         return ("Person " + this.name + "moved to " + newPlace);
     }
}