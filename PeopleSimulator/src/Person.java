class Person {
	public int age;
	private String name;
    private int birthday;
    private String gender;
    private boolean deceased;
    private String parent1;
    private String parent2;

	public Person(int age, String name,String gender,int birthdate, String parent1, String parent2){
		this.name = name;
		this.age = age;
        this.birthday = birthdate;
        this.gender = gender;
        deceased = false;
        this.parent1 = parent1;
        this.parent2 = parent2;
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

    public String getParent1(){
        return parent1;
    }

    public String getParent2(){
        return parent2;
    }
}