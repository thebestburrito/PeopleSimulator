class Person {
	public int age;
	private String name;
    private int birthdate;
    private String gender;
    public int idNumber;

    static int idCounter = 0;


	public Person(int age, String name,String gender,int birthdate) {
		idCounter++;
        this.name = name;
		this.age = age;
        this.birthdate = birthdate;
        this.gender = gender;
        this.idNumber = idCounter;
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

    public int getBirthday() {
        return birthdate;
    }

    public String getGender(){
    return gender;
    }

    public void setGender(String gender){
        this.gender = gender;
    }
}
