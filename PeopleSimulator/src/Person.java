import java.util.ArrayList;


class Person {
	public int age;
	private String name;
    private boolean depressed;
    private boolean optimistic;
    private int happiness;
    private int birthdate;
    private String gender;
    public int idNumber;
    public String place;
    public Person spouse;
    public int thisPopulation;
    private ArrayList <Integer> haves = new ArrayList <Integer>();
    private ArrayList <Integer> wants = new ArrayList <Integer>();
    private boolean married = false;
    public int IQ = bellCurve(100,15);
    public int income;
    public int points = 0;
    public int mill = bellCurve(50,25);
    public int idCounter = 0;
    public BankAccount acct;


	public Person(int age, String name,String gender,int birthdate, String place) {
		idCounter++;
        this.name = name;
		this.age = age;
        this.depressed = Math.random() < 0.15;
        this.optimistic = Math.random() < 0.15;
        this.happiness = 60;  //start at 60 bc 50 felt too sad for a normal person
        this.birthdate = birthdate;
        this.gender = gender;
        this.idNumber = idCounter;
        acct = new BankAccount(); // creates a new bank account for each person
        this.place = place;
        this.spouse = null;
        for(int i = 0; i < 10; i++){
            haves.add((int)(Math.random()*10));
            wants.add((int)(Math.random()*10));
        }
        int maybeIncome = bellCurve(53719,30000);
        this.income = maybeIncome > 0 ? maybeIncome : 0; //if statement making the income 0 if it falls onto a negative
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
        percentChange += happiness;
    }
    public String getGender(){
        return gender;
    }
    public void setGender(String gender){
        this.gender = gender;
    }

    public int getBirthday(){
        return birthdate;
    }

    public ArrayList <Integer> getHaves(){
        return haves;
    }
    public ArrayList <Integer> getWants(){
        return wants;
    }

    public boolean isMarried(){
        return married;
    }

    public void gotMarriedTo(Person spouse){
        married = true;
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

    public int calcIQ() {
        if(Math.random() < 0.4){
            /* hardWorking */
            IQ = IQ + 10;
        } else if (Math.random() < 0.14){
            /* Temp Education */
            IQ = IQ - 15;
        } else if(Math.random() < 0.39){
            /* Practice an Art */
            IQ = IQ + 5;
        } else if(Math.random() < 0.22){
            /* Exercise */
            IQ = IQ + 5;
        } else if(Math.random() < 0.35){
            /* Has connections/mentors */
            IQ = IQ + 20;
        }
        return IQ;
    }

    public int calcIncome(){
        if(IQ > 100 && IQ < 115){
            points = IQ - 100; /* Points above average for average people */
            if(Math.random() > 0.75){
                 income = income + (4262 * points);
            } else if(Math.random() < 0.75){
                income = income + (2002 * points);
            }
        } else if(IQ > 115 && IQ < 130){
            points = IQ - 100; /* Points above average for smarter than average people */
            if(Math.random() > 0.75){
                 income = income + (8362 * points);
            } else if(Math.random() < 0.75){
                income = income + (4802 * points);
            }
        } else if(IQ > 130){
            points = IQ - 100; /* Points above average for gifted IQ's */
            if(Math.random() > .60){
                income = income + (8066 * points);
            }
            income = income + (5956 * points);
        } else if(IQ < 100){
            points = 100 - IQ; /* Points below average for dumb people */
            income = income - (1502 * points);
        }  else if(mill >= 60){
            /* Millionare */
            if(bellCurve(100,25) < 60){
            income = income + bellCurve(1250000,500000);
            } else if((bellCurve(100,25) > 60)){
            income = income + bellCurve(5505000,2500000);
            }
        }
        return Math.abs(income); //makes income's value absolute so that it can not return a negative
    }

    public String getPlace(){
         return this.place;
     }
     public String changePlaceTo(String newPlace){
         this.place = newPlace;
         return ("Person " + this.name + "moved to " + newPlace);
     }
}
