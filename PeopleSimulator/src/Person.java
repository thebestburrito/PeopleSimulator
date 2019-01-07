class Person {
	public int age;
	private String name;
    private int birthday;
    private String gender;
    //This references one of the 25 personality types on a 5x5 grid with Lawfulness on one side and
    //Morality along the other.
    private int personalityNumber;
    private String personalityString = "";

	public Person(int age, String name, String gender, int personalityNumber) {
		this.name = name;
		this.age = age;
        this.gender = gender;
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

    public String getGender(){
    return gender;
    }

    public void setGender(String gender){
        this.gender = gender;
    }

    public int getPersonalityNumber() {
        return personalityNumber;
    }

    public String getPersonality() {
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
    public void setPersonality(String personality) {
        this.personalityString = personalityString;
    }

    public static int generatePersonalityNumber() {
        double a = (Math.random() * 100);
        boolean isLawful;
        boolean isSocial;
        boolean is1Neutral;
        boolean isRebel;
        boolean isChaotic;
        if (a >= 0 && a <= 0.0625) {
            isLawful = true;
            isSocial = false;
            is1Neutral = false;
            isRebel = false;
            isChaotic = false;
            return 0;
        } else if (a > 0.0625 && a <= 0.4000) {
            isSocial = true;
            isLawful = false;
            is1Neutral = false;
            isRebel = false;
            isChaotic = false;
            return 1;
        } else if (a > 0.4000 && a <= 2.1000) {
            is1Neutral = true;
            isLawful = false;
            isSocial = false;
            isRebel = false;
            isChaotic = false;
            return 2;
        } else if (a > 2.1000 && a <= 2.4375) {
            isRebel = true;
            isLawful = false;
            isSocial = false;
            is1Neutral = false;
            isChaotic = false;
            return 3;
        } else if (a > 2.4375 && a <= 2.5000) {
            isChaotic = true;
            isLawful = false;
            isSocial = false;
            is1Neutral = false;
            isRebel = false;
            return 4;
        } else if (a > 2.5000 && a <= 2.8375) {
            isLawful = true;
            isSocial = false;
            is1Neutral = false;
            isRebel = false;
            isChaotic = false;
            return 5;
        } else if (a > 2.8375 && a <= 4.6600) {
            isSocial = true;
            isLawful = false;
            is1Neutral = false;
            isRebel = false;
            isChaotic = false;
            return 6;
        } else if (a > 4.6600 && a <= 13.8400) {
            is1Neutral = true;
            isLawful = false;
            isSocial = false;
            isRebel = false;
            isChaotic = false;
            return 7;
        } else if (a > 13.8400 && a <= 15.6625) {
            isRebel = true;
            isLawful = false;
            isSocial = false;
            is1Neutral = false;
            isChaotic = false;
            return 8;
        } else if (a > 15.6625 && a <= 16.0000) {
            isChaotic = true;
            isLawful = false;
            isSocial = false;
            is1Neutral = false;
            isRebel = false;
            return 9;
        } else if (a > 16.0000 && a <= 17.7000) {
            isLawful = true;
            isSocial = false;
            is1Neutral = false;
            isRebel = false;
            isChaotic = false;
            return 10;
        } else if (a > 17.7000 && a <= 26.8800) {
            isSocial = true;
            isLawful = false;
            is1Neutral = false;
            isRebel = false;
            isChaotic = false;
            return 11;
        } else if (a > 26.8800 && a <= 73.1200) {
            is1Neutral = true;
            isLawful = false;
            isSocial = false;
            isRebel = false;
            isChaotic = false;
            return 12;
        } else if (a > 73.1200 && a <= 82.3000) {
            isRebel = true;
            isLawful = false;
            isSocial = false;
            is1Neutral = false;
            isChaotic = false;
            return 13;
        } else if (a > 82.3000 && a <= 84.0000) {
            isChaotic = true;
            isLawful = false;
            isSocial = false;
            is1Neutral = false;
            isRebel = false;
            return 14;
        } else if (a > 84.0000 && a <= 84.3375) {
            isLawful = true;
            isSocial = false;
            is1Neutral = false;
            isRebel = false;
            isChaotic = false;
            return 15;
        } else if (a > 84.3375 && a <= 86.1600) {
            isSocial = true;
            isLawful = false;
            is1Neutral = false;
            isRebel = false;
            isChaotic = false;
            return 16;
        } else if (a > 86.1600 && a <= 95.3400) {
            is1Neutral = true;
            isLawful = false;
            isSocial = false;
            isRebel = false;
            isChaotic = false;
            return 17;
        } else if (a > 95.3400 && a <= 97.1625) {
            return 18;
            isRebel = true;
            isLawful = false;
            isSocial = false;
            is1Neutral = false;
            isChaotic = false;
        } else if (a > 97.1625 && a <= 97.5000) {
            return 19;
            isChaotic = true;
            isLawful = false;
            isSocial = false;
            is1Neutral = false;
            isRebel = false;
        } else if (a > 97.5000 && a <= 97.5625) {
            return 20;
            isLawful = true;
            isSocial = false;
            is1Neutral = false;
            isRebel = false;
            isChaotic = false;
        } else if (a > 97.5625 && a <= 97.9000) {
            return 21;
            isSocial = true;
            isLawful = false;
            is1Neutral = false;
            isRebel = false;
            isChaotic = false;
        } else if (a > 97.9000 && a <= 99.6000) {
            return 22;
            is1Neutral = true;
            isLawful = false;
            isSocial = false;
            isRebel = false;
            isChaotic = false;
        } else if (a > 99.6000 && a <= 99.9375) {
            return 23;
            isRebel = true;
            isLawful = false;
            isSocial = false;
            is1Neutral = false;
            isChaotic = false;
        } else {
            return 24;
            isChaotic = true;
            isLawful = false;
            isSocial = false;
            is1Neutral = false;
            isRebel = false;
        }
    }
}