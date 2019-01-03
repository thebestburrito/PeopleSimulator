import java.util.ArrayList;

class Society {
    ArrayList < Person > people = new ArrayList < Person > ();

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
        findTheLove(people.get((int)(Math.random()*population)),people.get((int)(Math.random()*population)));


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

//takes parameters of two people, compares their haves and wants, and if at least both people have one match for each other, they have found love!
public void findTheLove(Person a, Person b){
    double loveA = 0;
    double loveB = 0;
    double compatibility = 0;
    ArrayList<Integer> currentHavesA = new ArrayList<Integer>();
 if(a.getAge() > 18 && b.getAge() > 18){
     for(int i = 0; i < a.getHaves().size(); i++){
         if(a.getWants().indexOf(b.getHaves().get(i)) > 0){
             System.out.println("contains" + a.getWants() + b.getHaves());
         }
     }

	// for(int i = 0; i < a.getHaves().size(); i++){
    //     if(a.getWants().get(i) == b.getHaves().get(i)){
    //         loveA++;
    //     }
    //     if(b.getWants().get(i) == a.getHaves().get(i)){
    //         loveB++;
    //     }
    // }
    // if(loveB == 0 || loveA == 0){
    //     compatibility = 0;
    // }else{
    //     compatibility = (loveA+loveB)/2;
    // }
    // if(compatibility > .9){
    //     System.out.println(a.getName()+ a.getHaves() + a.getWants() + a.getAge()+" and " + b.getName() + b.getHaves()+ b.getWants() + b.getAge() + " love eachother! with " + compatibility + "%");
    // }else{
    //     System.out.println(a.getName()+ a.getHaves() + a.getWants() + a.getAge() +  " and " + b.getName() + b.getHaves()+ b.getWants()+ b.getAge() + " have no love :( with " + compatibility+ "%");
    // }
 }
else{
    System.out.println(a.getName() + " " + a.getAge() + " and " + b.getName() + " " +b.getAge() + " had a conflict of ages");
}
}
}