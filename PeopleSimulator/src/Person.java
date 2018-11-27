class Person {
	private int age;
	private String name;

	public Person(int age, String name) {
		this.name = name;
		this.age = age;
	}

	public Person() {
		name = "Brad";
		age = 37;
	} //hewwo
	

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

}
