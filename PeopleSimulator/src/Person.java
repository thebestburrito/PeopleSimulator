import java.util.ArrayList;


class Person {
	public int age;
	private String name;
    private boolean depressed;
    private boolean optimistic;
    private int happiness;
    private int birthday;
    private String gender;
    public String place;
    public Person spouse;
    public int thisPopulation;
    public int daysMarried = 0;
    public double yearsMarried = 0;
    public int numOfTimesDivorced = 0;
    private ArrayList <Integer> haves = new ArrayList <Integer>();
    private ArrayList <Integer> wants = new ArrayList <Integer>();
    private boolean married = false;
    public int IQ = bellCurve(100,15);
    public int income = bellCurve(53719,30000);
    public int points = 0;
    public int mill = bellCurve(50,25);
	public Person(int age, String name,String gender,int birthdate,String place) {
		this.name = name;
		this.age = age;
        this.depressed = Math.random() < 0.15;
        this.optimistic = Math.random() < 0.15;
        this.happiness = 60;  //start at 60 bc 50 felt too sad for a normal person
        this.birthday = birthdate;
        this.gender = gender;
        this.place = place;
        this.spouse = null;
        for(int i = 0; i < 10; i++){
            haves.add((int)(Math.random()*10));
            wants.add((int)(Math.random()*10));
        }
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
    public boolean getDepressed(){
        if(age < 11){
            depressed = false;
        }
        return depressed;
    }
    public boolean getOptimistic(){
        if(depressed == true){
            optimistic = false;
        }
        return optimistic;
    }
    public int getHappiness(){
        //change these to while loops later when we merge if you can
        return happiness;
    }
    public int setHappiness(){
        if(depressed == true && age > 11){
            happiness = (int) Math.floor(Math.random() * 30) + 6;
            if(happiness < 10){
                happiness += (int) Math.floor(Math.random() * 8);
            }
        }
        if(optimistic == true) {
            happiness += (int) Math.floor(Math.random() * 10) + 5;
        }
        if(income < 53500 && age > 20){
            happiness -= (int) Math.floor(Math.random() * 10);
        }
        if(income > 58000 && age > 20){
            happiness += (int) Math.floor(Math.random() * 15);
        }
        if(married == true){
            happiness += (int) Math.floor(Math.random() * 25) + 5;
        }

       return happiness;
    }
    public void changeHappiness(int percentChange){
        happiness += percentChange;
    }
    public String getGender(){
        return gender;
    }
    public void setGender(String gender){
        this.gender = gender;
    }

    public int getBirthday(){
        return birthday;
    }

    public double getYearsMarried(){
        return Math.floor((this.getDaysMarried()) / 365);
    }

    public int getNumOfTimesDivorced(){
        return numOfTimesDivorced;
    }

    public void addTimeDivorced(){
        numOfTimesDivorced++;
    }

    public int getDaysMarried(){
        return daysMarried/2;       //returns days married (taking half of the number makes it way easier for me lol)
    }

    public void addDayMarried(){    //adds 1 to days married
       daysMarried ++;
    }

    public ArrayList <Integer> getHaves(){
        return haves;
    }
    public ArrayList <Integer> getWants(){
        return wants;
    }

    public boolean isMarried(){
        if(this.spouse != null){
            return true;
        }else{
            return false;
        }
    }

    public void gotMarriedTo(Person spouse){  //this is pretty cool, it sets a person as an attribute of spouse of a person
        this.spouse = spouse;
        this.spouse.married = true;
    }

    public void gotDivorcedFrom(Person spouse){  //this is pretty sad :(, it divorces people and sets their spouse to nothingness...
        this.spouse.married = false;
        this.spouse.addTimeDivorced();
        this.spouse.daysMarried = 0;
        this.spouse.changeHappiness(20);
        this.spouse = null;

    }

    public Person getSpouse(){    //gets spouse if there is spoud. if not, then they are lonely (null)
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