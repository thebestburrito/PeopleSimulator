import java.util.ArrayList;

class Person {
	//Array Lists
    private ArrayList <Integer> commonTraits = new ArrayList <Integer>();
    private ArrayList <Integer> haves = new ArrayList <Integer>();
    private ArrayList <Integer> wants = new ArrayList <Integer>();

    //Bank Accounts
    public BankAccount acct;

    //Booleans
    private boolean deceased;
    private boolean depressed;
    private boolean isChaotic;
    private boolean isEvil;
    private boolean isGood;
    private boolean isImpure;
    private boolean isLawful;
    private boolean isMoral;
    private boolean isRebel;
    private boolean isSocial;
    private boolean is1Neutral;
    private boolean is2Neutral;
    private boolean married = false;
    private boolean optimistic;

    //Doubles
    public double yearsMarried = 0;

    //Integers
    public int age;
    private int birthdate;
    public int daysMarried = 0;
    private int friendCount;
    private int happiness;
    public int idCounter = 0;
    public int idNumber;
    public int income;
    public int IQ = bellCurve(100,15);
    public int mill = bellCurve(50,25);
    public int numOfTimesDivorced = 0;
    private int personalityNumber;
    public int points = 0;
    public int thisPopulation;

    //People
    public Person friend;
    public Person spouse;

    //Strings
    private String gender;
    private String name;
    private String parent1;  //Shows a Persons Parents
    private String parent2;  //Shows a Persons Parents
    private String personalityString = "";  // What the personality Number is called
    public String place;

	public Person(int age, String name, String gender, int birthdate, String place, String parent1, String parent2) {
            this.name = name;
            this.age = age;
            this.depressed = Math.random() < 0.15;
            this.optimistic = Math.random() < 0.15;
            this.happiness = 60;  //start at 60 bc 50 felt too sad for a normal person
            this.birthdate = birthdate;
            this.gender = gender;
            this.personalityNumber = generatePersonalityNumber();
            this.deceased = false;
            this.income = calcIncome();
            this.parent1 = parent1;
            this.parent2 = parent2;
            this.place = place;
            this.spouse = null;
            acct = new BankAccount(); // creates a new bank account for each person
            for (int i = 0; i < 10; i++) {
                haves.add((int)(Math.random()*10));
                wants.add((int)(Math.random()*10));
            }
            for (int i = 0; i < 10; i++) {
                commonTraits.add((int)(Math.random()*4));
            }
        setHappiness();
    }

    //Array Lists
    public ArrayList <Integer> getCommonTraits() {
        return commonTraits;
    }

    public ArrayList <Integer> getHaves() {
        return haves;
    }

    public ArrayList <Integer> getWants() {
        return wants;
    }

    //Boolean
    public boolean getDepressed() {
        if (age < 11) {
            depressed = false;
        }
        return depressed;
    }

    public boolean getOptimistic() {
        if (depressed == true) {
            optimistic = false;
        }
        return optimistic;
    }

    /**
    * @param booleanName the boolean you want to find out.
    * @return whether or not the boolean is true or false.
    */
    public boolean getPersonalityBoolean(String booleanName) {
        if (booleanName == "isLawful") {
            return  isLawful;
        } else if (booleanName == "isSocial") {
            return isSocial;
        } else if (booleanName == "is1Neutral") {
            return is1Neutral;
        } else if (booleanName == "isRebel") {
            return isRebel;
        } else if (booleanName == "isChaotic") {
            return isChaotic;
        } else if (booleanName == "isGood") {
            return isGood;
        } else if (booleanName == "isMoral") {
            return isMoral;
        } else if (booleanName == "is2Neutral") {
            return is2Neutral;
        } else if (booleanName == "isImpure") {
            return isImpure;
        } else if (booleanName == "isEvil") {
            return isEvil;
        } else {
            return false;
        }
    }

    public boolean isDead() {
        return deceased;
    }

    public boolean isMarried() {
        return married;
    }

    //public boolean isFriendsWith(Person friend){
        //if()
    // }

    public boolean olderThan(int otherAge) {
        if (age > otherAge) {
            return true;
        } else {
            return false;
        }
    }

    //double
    public double getYearsMarried() {
        return Math.floor((this.getDaysMarried()) / 365);
    }

    //Integer
    public static int bellCurve(int mean, int sd) {
        // make nombors gud
        int i = mean - (3*sd);
        int j = mean + (3*sd);
        int x = i;
        for (int c = i; c < j; c++) {
            double l = Math.random();
            if (l >= 0.5) {
                x++;
            }
        }
        return x;
    }

    public int calcIncome() {
        if (age >= 20) {
            if (IQ > 100 && IQ < 115) {
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
            }   //age affecting income
        }
        else if(age > 15 && age < 20){
            income = bellCurve(10000,2000);
        } else if(age < 15){
            income = 0;
        }
        return Math.abs(income);
    }

    public int calcIQ() {
        if(Math.random() < 0.4) {
            /* hardWorking */
            IQ = IQ + 10;
        } else if (Math.random() < 0.14) {
            /* Temp Education */
            IQ = IQ - 15;
        } else if(Math.random() < 0.39) {
            /* Practice an Art */
            IQ = IQ + 5;
        } else if(Math.random() < 0.22) {
            /* Exercise */
            IQ = IQ + 5;
        } else if(Math.random() < 0.35) {
            /* Has connections/mentors */
            IQ = IQ + 20;
        }
        return IQ;
    }

    public int generatePersonalityNumber() {
        double a = (Math.random() * 100);

        if (a >= 0 && a <= 0.0625) {
            setPersonalityBoolean("isLawful", true);
            setPersonalityBoolean("isGood", true);
            setPersonalityString("Lawful Good");
            return 0;
        } else if (a > 0.0625 && a <= 0.4000) {
            setPersonalityBoolean("isSocial", true);
            setPersonalityBoolean("isGood", true);
            setPersonalityString("Social Good");
            return 1;
        } else if (a > 0.4000 && a <= 2.1000) {
            setPersonalityBoolean("is1Neutral", true);
            setPersonalityBoolean("isGood", true);
            setPersonalityString("Neutral Good");
            return 2;
        } else if (a > 2.1000 && a <= 2.4375) {
            setPersonalityBoolean("isRebel", true);
            setPersonalityBoolean("isGood", true);
            setPersonalityString("Rebel Good");
            return 3;
        } else if (a > 2.4375 && a <= 2.5000) {
            setPersonalityBoolean("isChaotic", true);
            setPersonalityBoolean("isGood", true);
            setPersonalityString("Chaotic Good");
            return 4;
        } else if (a > 2.5000 && a <= 2.8375) {
            setPersonalityBoolean("isLawful", true);
            setPersonalityBoolean("isMoral", true);
            setPersonalityString("Lawful Moral");
            return 5;
        } else if (a > 2.8375 && a <= 4.6600) {
            setPersonalityBoolean("isSocial", true);
            setPersonalityBoolean("isMoral", true);
            setPersonalityString("Social Moral");
            return 6;
        } else if (a > 4.6600 && a <= 13.8400) {
            setPersonalityBoolean("is1Neutral", true);
            setPersonalityBoolean("isMoral", true);
            setPersonalityString("Neutral Moral");
            return 7;
        } else if (a > 13.8400 && a <= 15.6625) {
            setPersonalityBoolean("isRebel", true);
            setPersonalityBoolean("isMoral", true);
            setPersonalityString("Rebel Moral");
            return 8;
        } else if (a > 15.6625 && a <= 16.0000) {
            setPersonalityBoolean("isChaotic", true);
            setPersonalityBoolean("isMoral", true);
            setPersonalityString("Chaotic Moral");
            return 9;
        } else if (a > 16.0000 && a <= 17.7000) {
            setPersonalityBoolean("isLawful", true);
            setPersonalityBoolean("is2Neutral", true);
            setPersonalityString("Lawful Neutral");
            return 10;
        } else if (a > 17.7000 && a <= 26.8800) {
            setPersonalityBoolean("isSocial", true);
            setPersonalityBoolean("is2Neutral", true);
            setPersonalityString("Social Neutral");
            return 11;
        } else if (a > 26.8800 && a <= 73.1200) {
            setPersonalityBoolean("is1Neutral", true);
            setPersonalityBoolean("is2Neutral", true);
            setPersonalityString("True Neutral");
            return 12;
        } else if (a > 73.1200 && a <= 82.3000) {
            setPersonalityBoolean("isRebel", true);
            setPersonalityBoolean("is2Neutral", true);
            setPersonalityString("Rebel Neutral");
            return 13;
        } else if (a > 82.3000 && a <= 84.0000) {
            setPersonalityBoolean("isChaotic", true);
            setPersonalityBoolean("is2Neutral", true);
            setPersonalityString("Chaotic Neutral");
            return 14;
        } else if (a > 84.0000 && a <= 84.3375) {
            setPersonalityBoolean("isLawful", true);
            setPersonalityBoolean("isImpure", true);
            setPersonalityString("Lawful Impure");
            return 15;
        } else if (a > 84.3375 && a <= 86.1600) {
            setPersonalityBoolean("isSocial", true);
            setPersonalityBoolean("isImpure", true);
            setPersonalityString("Social Impure");
            return 16;
        } else if (a > 86.1600 && a <= 95.3400) {
            setPersonalityBoolean("is1Neutral", true);
            setPersonalityBoolean("isImpure", true);
            setPersonalityString("Neutral Impure");
            return 17;
        } else if (a > 95.3400 && a <= 97.1625) {
            setPersonalityBoolean("isRebel", true);
            setPersonalityBoolean("isImpure", true);
            setPersonalityString("Rebel Impure");
            return 18;
        } else if (a > 97.1625 && a <= 97.5000) {
            setPersonalityBoolean("isChaotic", true);
            setPersonalityBoolean("isImpure", true);
            setPersonalityString("Chaotic Impure");
            return 19;
        } else if (a > 97.5000 && a <= 97.5625) {
            setPersonalityBoolean("isLawful", true);
            setPersonalityBoolean("isEvil", true);
            setPersonalityString("Lawful Evil");
            return 20;
        } else if (a > 97.5625 && a <= 97.9000) {
            setPersonalityBoolean("isSocial", true);
            setPersonalityBoolean("isEvil", true);
            setPersonalityString("Social Evil");
            return 21;
        } else if (a > 97.9000 && a <= 99.6000) {
            setPersonalityBoolean("is1Neutral", true);
            setPersonalityBoolean("isEvil", true);
            setPersonalityString("Neutral Evil");
            return 22;
        } else if (a > 99.6000 && a <= 99.9375) {
            setPersonalityBoolean("isRebel", true);
            setPersonalityBoolean("isEvil", true);
            setPersonalityString("Rebel Evil");
            return 23;
        } else {
            setPersonalityBoolean("isChaotic", true);
            setPersonalityBoolean("isEvil", true);
            setPersonalityString("Chaotic Evil");
            return 24;
        }
    }

    public int getAge() {
        return age;
    }

    public int getBirthday() {
        return birthdate;
    }

    public int getDaysMarried() {
        return daysMarried/2;       //returns days married (taking half of the number makes it way easier for me lol)
    }

    public int getFriendCount() {
        return friendCount;
    }

    public int getHappiness() {
        return happiness;
    }

    public int getNumOfTimesDivorced() {
        return numOfTimesDivorced;
    }

    public int getPersonalityNumber() {
        return personalityNumber;
    }

    //People
    public Person getFriend() {
        if (friend != null) {
            return friend;
        } else {
            return null;
        }
    }

    public Person getSpouse() {
        if (spouse != null) {
            return spouse;
        } else {
            return null;
        }
    }

    //String
    public String changePlaceTo(String newPlace) {
        this.place = newPlace;
        return ("Person " + this.name + "moved to " + newPlace);
    }

    public String getName() {
        return name;
    }

    public String getParent1() {
        return this.parent1;
    }

    public String getParent2() {
        return this.parent2;
    }

    public String getPersonalityString() {
        return personalityString;
    }

    public String getPlace() {
            return this.place;
    }

    //Void
    public void addDayMarried() {    //adds 1 to days married
        daysMarried ++;
    }

    public void addTimeDivorced() {
        numOfTimesDivorced++;
    }

    public void becameFriendsWith(Person friend) {
        this.friend = friend;
    }

    public void changeHappiness(int percentChange) {
        happiness += percentChange;
    }

    public String getGender() {
        return gender;
    }

    public void gotDivorcedFrom(Person spouse) {
        //this is pretty sad :(, it divorces people
        //and sets their spouse to nothingness...
        this.spouse.married = false;
        this.spouse.addTimeDivorced();
        this.spouse.daysMarried = 0;
        this.spouse.changeHappiness(20);
        this.spouse = null;
    }

    public void gotMarriedTo(Person spouse) {
        this.spouse = spouse;
    }

    public void hadBirthday() {
        age++;
    }

    public void markAsDeceased() {
        deceased = true;
    }

    public void setGender (String gender) {
        this.gender = gender;
    }

    public void setHappiness() {
        if (depressed == true && age > 11) {
            happiness = (int) Math.floor(Math.random() * 30) + 6;
            if (happiness < 10) {
                happiness += (int) Math.floor(Math.random() * 8);
            }
        }
        if (optimistic == true) {
            happiness += (int) Math.floor(Math.random() * 10) + 5;
        }
        if (income < 53500 && age > 20) {
            happiness -= (int) Math.floor(Math.random() * 10);
        }
        if (income > 58000 && age > 20) {
            happiness += (int) Math.floor(Math.random() * 15);
        }

        if (married == true) {
            happiness += (int) Math.floor(Math.random() * 25) + 5;
        }
        if(happiness > 100) {
            happiness = 100;
        }
    }

    public void setParent1(String newP) {
        this.parent1 = newP;
    }

    public void setParent2(String newP) {
        this.parent2 = newP;
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

    public void updateFriendCount() {
        friendCount++;
    }
}