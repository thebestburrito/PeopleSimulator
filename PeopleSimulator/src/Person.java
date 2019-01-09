class Person {
	public int age;
	private String name;
    private boolean depressed;
    private int happiness;


	public Person(int age, String name) {
		this.name = name;
		this.age = age;
        this.depressed = Math.random() < 0.15;
        this.happiness = 50;

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
    public boolean getDepressed(){
        if(age < 11){
            depressed = false;
        }
        return depressed;
    }
    public int getHappiness(){
        //change these to while loops later when we merge if you can
        if(depressed == true && age > 11){
            happiness -= (int) Math.floor(Math.random() * 36);
        }


        return happiness;
    }
}