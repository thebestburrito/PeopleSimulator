import java.util.*;

class Society{
	//this declares a new instance variable... an ArrayList for people
	List<Person> people = new ArrayList<Person>();

    public Time time = new Time(1, 1, 0, 0);
	public int population;
	//these names came from https://nameberry.com/unisex-names
	private String[] firstNames = {"Avery","Riley","Jordan","Angel","Parker","Sawyer","Peyton","Quinn","Blake","Hayden","Taylor","Dakota","Reese","Zion","Remmington","Amari","Phoenix","Kendall","Harley","Rylan","Marley","Dallas"};
	private String[] lastNames = {"Hill","Carson","Ware","McMahon","Murray","Smith","Jones","Robinson","Morris","Brown","Meyers","Reed","Schmidt","Estrada","Huang","Patel","Gupta","Gomez","Ramirez","Thomas","Jordan","Samson","Samuels","Evans","Butts","Wright","Black","White"};

	Society(int numPeople){
		population = numPeople;
		String fullName;
        String gender;
		for(int i = 0; i < numPeople; i++){
			fullName = firstNames[(int)(Math.random()*firstNames.length)] + " " + lastNames[(int)(Math.random()*lastNames.length)];
			int randomIndex = (int)(Math.random()*2);
            if(randomIndex >= 1){
                gender = "female";
            }
            else{
                gender = "male";
            }
            people.add(new Person((int)(Math.random()*100),fullName, gender,time.getDayCount()));
		}
	}

    public void cycleDay()
    {
        time.incrementTime();
        //hey folks put your daily methods in here
        addPerson(people.get((int)(Math.random()*population)), people.get((int)(Math.random()*population)));



    }


    public void addPerson(Person p1, Person p2){
        String lastName;
        String gender;
        if((p1.getGender() == "female" && p2.getGender() == "male")||(p1.getGender() == "male" && p2.getGender() == "female")){
        if(p1.getGender().equals("male")){
            String name = p1.getName();
            int space = name.indexOf(" ") + 1;
            lastName = name.substring(space, name.length());
        }
        else{
            String name = p2.getName();
            int space = name.indexOf(" ") + 1;
            lastName = name.substring(space, name.length());
        }
        int randomIndex = (int)(Math.random()*2);
            if(randomIndex >= 1){
            gender = "female";
            }
            else{
            gender = "male";
            }
        String fullName = firstNames[(int)(Math.random()*firstNames.length)] + " " + lastName;
        population++;
        people.add(new Person(0, fullName, gender,time.getDayCount()));
        System.out.println(p1.getName() + " and "+ p2.getName()+ " had...");
        System.out.println(fullName + " born on "+ time.dateToString());
        }
  }

    //for generating a bell curve for various aspects of the people in the society such as IQ
    public static long bellCurve(int mean, int sd) {
	    int i = mean - (3*sd);
	    int j = mean + (3*sd);
		int x = i;
		for(int c = i; c < j; c++) {
			double l = Math.random();
			if(l >= 0.5) {
				x++;
			}
		}
		return x;
	}

    public Person getOldestPerson () {
      int loc = 0; //location used in return statement
      int age = 0;
       for(int i = 0; i < this.population; i++){ //for each position in the people array, compares age to the age variable then records the position of the highest.
          if(this.people.get(i).olderThan(age)){
            age = this.people.get(i).getAge();
            loc = i;
      }
    }
    return this.people.get(loc); //returns the location of the person
  }

    //Removes people
    public void removePeople(int amount){
        for(int i = 0; i < amount; i++){
            int index = (int)(Math.random()*population);
            people.remove(index);
            population--;
        }
    }
    //Creates and changes weather
    public void makeDisaster(){
       // Disasters {"tornado", "hurricane", "flood", "earthquake", "tsunami", "wildfires"};

        //Tornado Chance Maker
        int torIndex = (int)(Math.random()*400);
        if(time.getSeason().equals("spring")){
            torIndex += 10;
        }
        else if(time.getSeason().equals("summer")){
            torIndex += 5;
        }
        if(torIndex >= 399){
            int level = (int)(Math.random()*3);
            if(level == 0){
                removePeople(5);
                System.out.println("A weak tornado has hit, killing 5 people!");
            }
            else if(level == 1){
                removePeople(15);
                System.out.println("A significant tornado has hit, killing 15 people!");
            }
            else{
                removePeople(25);
                System.out.println("A violent tornado has hit, killing 25 people!");
            }
        }

        //Hurricane Chance Maker
        int hurIndex = (int)(Math.random()*400);
        if(time.getSeason().equals("fall")){
            hurIndex += 10;
        }
        else if(time.getSeason().equals("summer")){
            hurIndex += 5;
        }
        if(hurIndex >= 400){
            int level = (int)((Math.random()*5) + 1);
            int amount = 5 * level;
            removePeople(amount);
            System.out.println("A catagory " + level + " hurricane has hit, killing" + amount + " people!");
        }

        //Flood Chance Maker
        int floIndex = (int)(Math.random()*400);
        if(time.getSeason().equals("spring")){
            floIndex += 10;
        }
        else if(time.getSeason().equals("summer")){
            floIndex += 5;
        }
        else if(time.getSeason().equals("fall")){
            floIndex += 5;
        }
        if(floIndex >= 399){
            int amount = (int)(Math.random()*6);
            removePeople(amount);
            System.out.println("A flood has happened, killing " + amount + " people!");
        }

        //Earthquake Chance Maker
        int earIndex = (int)(Math.random()*2000);
        double level = (Math.random()*6) + 2.5;
        int killLevel = 0;
        if(level >= 8){
            earIndex += 0;
            killLevel = 100;
        }
        else if(level >= 7 && level < 8){
            earIndex += 1500;
            killLevel = 10;
        }
        else if(level >= 6 && level < 7){
            earIndex += 1600;
            killLevel = 2;
        }
        else if(level >= 5 && level < 6){
            earIndex += 1700;
            killLevel = 1;
        }
        else if(level >= 4 && level < 5){
            earIndex += 2000;
            killLevel = 0;
        }
        else if(level < 4){
            earIndex -= 2000;
            killLevel = 0;
        }
        if(earIndex >= 1999){
            int levelAmount = (int)(Math.random()*6);
            int amount = levelAmount * killLevel;
            removePeople(amount);
            System.out.println("A " + earIndex + "earthquake has hit, killing " + amount + " people!");
        }
    }

}
