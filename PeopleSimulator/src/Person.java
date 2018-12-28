class Person {
	public int age;
	private String name;
    private int birthday;
    private String gender;

    /* This references one of the 25 personality types on a 5x5 grid with Lawfulness on one side and
    Morality along the other. */
    private int personalityNumber;


	public Person(int age, String name, String gender, int personalityNumber) {
		this.name = name;
		this.age = age;
        this.personalityNumber = personalityNumber;
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

    public int getPersonalityNumber() {
        return personalityNumber;
    }

    /**
     * @param personalityNumber the personalityNumber to set
     */
    public void setPersonalityNumber(int personalityNumber) {
        Person.this.personalityNumber = personalityNumber;
    }

    public static int generatePersonalityNumber() {
        double a = (Math.random() * 100);
        if (a >= 0 && a <= 0.0625) {
            return 0;
        } else if (a > 0.0625 && a <= 0.4000) {
            return 1;
        } else if (a > 0.4000 && a <= 2.1000) {
            return 2;
        } else if (a > 2.1000 && a <= 2.4375) {
            return 3;
        } else if (a > 2.4375 && a <= 2.5000) {
            return 4;
        } else if (a > 2.5000 && a <= 2.8375) {
            return 5;
        } else if (a > 2.8375 && a <= 4.6600) {
            return 6;
        } else if (a > 4.6600 && a <= 13.8400) {
            return 7;
        } else if (a > 13.8400 && a <= 15.6625) {
            return 8;
        } else if (a > 15.6625 && a <= 16.0000) {
            return 9;
        } else if (a > 16.0000 && a <= 17.7000) {
            return 10;
        } else if (a > 17.7000 && a <= 26.8800) {
            return 11;
        } else if (a > 26.8800 && a <= 73.1200) {
            return 12;
        } else if (a > 73.1200 && a <= 82.3000) {
            return 13;
        } else if (a > 82.3000 && a <= 84.0000) {
            return 14;
        } else if (a > 84.0000 && a <= 84.3375) {
            return 15;
        } else if (a > 84.3375 && a <= 86.1600) {
            return 16;
        } else if (a > 86.1600 && a <= 95.3400) {
            return 17;
        } else if (a > 95.3400 && a <= 97.1625) {
            return 18;
        } else if (a > 97.1625 && a <= 97.5000) {
            return 19;
        } else if (a > 97.5000 && a <= 97.5625) {
            return 20;
        } else if (a > 97.5625 && a <= 97.9000) {
            return 21;
        } else if (a > 97.9000 && a <= 99.6000) {
            return 22;
        } else if (a > 99.6000 && a <= 99.9375) {
            return 23;
        } else {
            return 24;
        }
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
}