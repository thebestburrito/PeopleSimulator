class Person {
	public int age;
	private String name;
    private int birthday;
    private String gender;
    public int accountNumber;

	public Person(int age, String name,String gender,int birthday, int accountNumber) {
		this.name = name;
		this.age = age;
        this.birthday = birthday;
        this.gender = gender;
        this.accountNumber = accountNumber;
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
}