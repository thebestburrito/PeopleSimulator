class Person {
	public int age;
	private String name;
    private int birthday;
    private String gender;
    private boolean deceased;

	public Person(int age, String name,String gender,int birthdate) {
		this.name = name;
		this.age = age;
        this.birthday = birthdate;
        this.gender = gender;
        deceased = false;
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

    public boolean isDead(){
		return deceased;
	}

     public void markAsDeceased(){
    deceased = true;
  }
}