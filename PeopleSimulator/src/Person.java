class Person {
	public int age;
	private String name;
    private boolean depressed;
    private int happiness;
    public int income; //comment this out at the end
    public boolean married;
    public boolean divorced;

	public Person(int age, String name) {
		this.name = name;
		this.age = age;
        this.depressed = Math.random() < 0.15;
        this.happiness = 50;
        this.income = 10000; //comment this out at the end
        this.married = true;
        this.divorced = true;
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
        if(income < 11000){
            happiness -= (int) Math.floor(Math.random() * 15);
        }
        if(married == true){
            happiness += (int) Math.floor(Math.random() * 30);
        }
        if(divorced == true){
            happiness -= (int) Math.floor(Math.random() * 15);
        }
        if(income > 2400000){
            happiness += (int) Math.floor(Math.random() * 20);
        }
        

        return happiness;
    }
}