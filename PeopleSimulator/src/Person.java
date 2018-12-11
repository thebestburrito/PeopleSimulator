class Person {
	public int age;
	private String name;

	public Person(int age, String name) {
		this.name = name;
		this.age = age;
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

}