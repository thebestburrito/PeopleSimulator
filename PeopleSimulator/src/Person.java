class Person {
	public int age;
	private String name;
    private String gender;

	public Person(int age, String name, String gender) {
		this.name = name;
		this.age = age;
        this.gender = gender;
	}

	public Person() {
		this.name = "Brad";
		this.age = 37;
	}
    //hmmmm?
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