import java.util.ArrayList;

class Person {
	public int age;
	private String name;
    private String gender;
    private int personalityNumber;
    private String personalityString = "";  // What the personality Number is called
    public boolean isLawful;       //Boolean set 1) Top row
    public boolean isSocial;       //       |
    public boolean is1Neutral;     //       |
    public boolean isRebel;        //       |
    public boolean isChaotic;      //       V
    public boolean isGood;         //Boolean set 2) Left side
    public boolean isMoral;        //       |
    public boolean is2Neutral;     //       |
    public boolean isImpure;       //       |
    public boolean isEvil;         //       V
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

	public Person(int age, String name, String gender, int birthdate, String place) {
		this.name = name;
		this.age = age;
        this.gender = gender;
        this.personalityNumber = generatePersonalityNumber();
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

    public void setGender(String gender){
        this.gender = gender;
    }

    public String getGender(){
        return gender;
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

        public int getPersonalityNumber() {
        return personalityNumber;
    }

    public String getPersonalityString() {
        return personalityString;
    }

    /**
     * @param personalityNumber the personalityNumber to set
     */
    public void setPersonalityNumber(int personalityNumber) {
        this.personalityNumber = personalityNumber;
    }

    /**
     * @param personality The string personality to set
     */
    public void setPersonalityString(String personalityString) {
        this.personalityString = personalityString;
    }

    /**
     * @param personalityBoolean The desired boolean to change (isGood, isMoral, is2Neutral, isImpure, isEvil, isLawful, isSocial, is1Neutral, isRebel, isChaotic)
     * @param trueOrFalse What you want to change the boolean to
     */
    public void setPersonalityBoolean(String personalityBoolean, boolean trueOrFalse) {
        if (personalityBoolean == "isLawful") {
            isLawful = trueOrFalse;
        } else if (personalityBoolean == "isSocial") {
            isSocial= trueOrFalse;
        } else if (personalityBoolean == "is1Neutral") {
            is1Neutral= trueOrFalse;
        } else if (personalityBoolean == "isRebel") {
            isRebel= trueOrFalse;
        } else if (personalityBoolean == "isChaotic") {
            isChaotic = trueOrFalse;
        } else if (personalityBoolean == "isGood") {
            isGood = trueOrFalse;
        } else if (personalityBoolean == "isMoral") {
            isMoral = trueOrFalse;
        } else if (personalityBoolean == "is2Neutral") {
            is2Neutral = trueOrFalse;
        } else if (personalityBoolean == "isImpure") {
            isImpure = trueOrFalse;
        } else if (personalityBoolean == "isEvil") {
            isEvil = trueOrFalse;
        }
    }

    public static int generatePersonalityNumber() {
        double a = (Math.random() * 100);

        if (a >= 0 && a <= 0.0625) {
            Person.setPersonalityBoolean("isLawful", true);
            Person.setPersonalityBoolean("isGood", true);
            Person.setPersonalityString("Lawful Good");
            return 0;
        } else if (a > 0.0625 && a <= 0.4000) {
            Person.setPersonalityBoolean("isSocial", true);
            Person.setPersonalityBoolean("isGood", true);
            Person.setPersonalityString("Social Good");
            return 1;
        } else if (a > 0.4000 && a <= 2.1000) {
            Person.setPersonalityBoolean("is1Neutral", true);
            Person.setPersonalityBoolean("isGood", true);
            Person.setPersonalityString("Neutral Good");
            return 2;
        } else if (a > 2.1000 && a <= 2.4375) {
            Person.setPersonalityBoolean("isRebel", true);
            Person.setPersonalityBoolean("isGood", true);
            Person.setPersonalityString("Rebel Good");
            return 3;
        } else if (a > 2.4375 && a <= 2.5000) {
            Person.setPersonalityBoolean("isChaotic", true);
            Person.setPersonalityBoolean("isGood", true);
            Person.setPersonalityString("Chaotic Good");
            return 4;
        } else if (a > 2.5000 && a <= 2.8375) {
            Person.setPersonalityBoolean("isLawful", true);
            Person.setPersonalityBoolean("isMoral", true);
            Person.setPersonalityString("Lawful Moral");
            return 5;
        } else if (a > 2.8375 && a <= 4.6600) {
            Person.setPersonalityBoolean("isSocial", true);
            Person.setPersonalityBoolean("isMoral", true);
            Person.setPersonalityString("Social Moral");
            return 6;
        } else if (a > 4.6600 && a <= 13.8400) {
            Person.setPersonalityBoolean("is1Neutral", true);
            Person.setPersonalityBoolean("isMoral", true);
            Person.setPersonalityString("Neutral Moral");
            return 7;
        } else if (a > 13.8400 && a <= 15.6625) {
            Person.setPersonalityBoolean("isRebel", true);
            Person.setPersonalityBoolean("isMoral", true);
            Person.setPersonalityString("Rebel Moral");
            return 8;
        } else if (a > 15.6625 && a <= 16.0000) {
            Person.setPersonalityBoolean("isChaotic", true);
            Person.setPersonalityBoolean("isMoral", true);
            Person.setPersonalityString("Chaotic Moral");
            return 9;
        } else if (a > 16.0000 && a <= 17.7000) {
            Person.setPersonalityBoolean("isLawful", true);
            Person.setPersonalityBoolean("is2Neutral", true);
            Person.setPersonalityString("Lawful Neutral");
            return 10;
        } else if (a > 17.7000 && a <= 26.8800) {
            Person.setPersonalityBoolean("isSocial", true);
            Person.setPersonalityBoolean("is2Neutral", true);
            Person.setPersonalityString("Social Neutral");
            return 11;
        } else if (a > 26.8800 && a <= 73.1200) {
            Person.setPersonalityBoolean("is1Neutral", true);
            Person.setPersonalityBoolean("is2Neutral", true);
            Person.setPersonalityString("True Neutral");
            return 12;
        } else if (a > 73.1200 && a <= 82.3000) {
            Person.setPersonalityBoolean("isRebel", true);
            Person.setPersonalityBoolean("is2Neutral", true);
            Person.setPersonalityString("Rebel Neutral");
            return 13;
        } else if (a > 82.3000 && a <= 84.0000) {
            Person.setPersonalityBoolean("isChaotic", true);
            Person.setPersonalityBoolean("is2Neutral", true);
            Person.setPersonalityString("Chaotic Neutral");
            return 14;
        } else if (a > 84.0000 && a <= 84.3375) {
            Person.setPersonalityBoolean("isLawful", true);
            Person.setPersonalityBoolean("isImpure", true);
            Person.setPersonalityString("Lawful Impure");
            return 15;
        } else if (a > 84.3375 && a <= 86.1600) {
            Person.setPersonalityBoolean("isSocial", true);
            Person.setPersonalityBoolean("isImpure", true);
            Person.setPersonalityString("Social Impure");
            return 16;
        } else if (a > 86.1600 && a <= 95.3400) {
            Person.setPersonalityBoolean("is1Neutral", true);
            Person.setPersonalityBoolean("isImpure", true);
            Person.setPersonalityString("Neutral Impure");
            return 17;
        } else if (a > 95.3400 && a <= 97.1625) {
            Person.setPersonalityBoolean("isRebel", true);
            Person.setPersonalityBoolean("isImpure", true);
            Person.setPersonalityString("Rebel Impure");
            return 18;
        } else if (a > 97.1625 && a <= 97.5000) {
            Person.setPersonalityBoolean("isChaotic", true);
            Person.setPersonalityBoolean("isImpure", true);
            Person.setPersonalityString("Chaotic Impure");
            return 19;
        } else if (a > 97.5000 && a <= 97.5625) {
            Person.setPersonalityBoolean("isLawful", true);
            Person.setPersonalityBoolean("isEvil", true);
            Person.setPersonalityString("Lawful Evil");
            return 20;
        } else if (a > 97.5625 && a <= 97.9000) {
            Person.setPersonalityBoolean("isSocial", true);
            Person.setPersonalityBoolean("isEvil", true);
            Person.setPersonalityString("Social Evil");
            return 21;
        } else if (a > 97.9000 && a <= 99.6000) {
            Person.setPersonalityBoolean("is1Neutral", true);
            Person.setPersonalityBoolean("isEvil", true);
            Person.setPersonalityString("Neutral Evil");
            return 22;
        } else if (a > 99.6000 && a <= 99.9375) {
            Person.setPersonalityBoolean("isRebel", true);
            Person.setPersonalityBoolean("isEvil", true);
            Person.setPersonalityString("Rebel Evil");
            return 23;
        } else {
            Person.setPersonalityBoolean("isChaotic", true);
            Person.setPersonalityBoolean("isEvil", true);
            Person.setPersonalityString("Chaotic Evil");
            return 24;
        }
    }
}