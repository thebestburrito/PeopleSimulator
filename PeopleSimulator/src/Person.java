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