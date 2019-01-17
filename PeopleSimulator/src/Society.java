import java.util.*;

class Society {
 ArrayList < Person > people = new ArrayList < Person > ();
List<Place> places = new ArrayList<Place>();
 public Time time = new Time(1, 1, 0, 0);
 public int population;
 public int totalPopulation;
 //these names came from https://nameberry.com/unisex-names
 private String[] firstNames = {
  "Avery",
  "Riley",
  "Jordan",
  "Angel",
  "Parker",
  "Sawyer",
  "Peyton",
  "Quinn",
  "Blake",
  "Hayden",
  "Taylor",
  "Dakota",
  "Reese",
  "Zion",
  "Remmington",
  "Amari",
  "Phoenix",
  "Kendall",
  "Harley",
  "Rylan",
  "Marley",
  "Dallas"
 };
 private String[] lastNames = {
  "Hill",
  "Carson",
  "Ware",
  "McMahon",
  "Murray",
  "Smith",
  "Jones",
  "Robinson",
  "Morris",
  "Brown",
  "Meyers",
  "Reed",
  "Schmidt",
  "Estrada",
  "Huang",
  "Patel",
  "Gupta",
  "Gomez",
  "Ramirez",
  "Thomas",
  "Jordan",
  "Samson",
  "Samuels",
  "Evans",
  "Butts",
  "Wright",
  "Black",
  "White"
 };
 private String[] placeNames = {"burg", "ton", "burgh", "town", " City", "ville", " Center"," Lake", "wood","ford","land","house","hill","bridge"," Creek", "boro"};

	//these names came from https://nameberry.com/unisex-names
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
            for(int j = 0; j < 5; j++){
            places.add(new Place(lastNames[(int)(Math.random()*lastNames.length)]+placeNames[(int)(Math.random()*placeNames.length)]));
            }
            people.add(new Person((int)(Math.random()*100),fullName, gender,time.getDayCount(), places.get((int)(Math.random()*places.size())).getPlace(), "unknown", "unknown"));
		}
	}

    public void cycleDay()
    {
        time.incrementTime();
        findTheLove(people.get((int)(Math.random() * population)), people.get((int)(Math.random() * population)));
        //hey folks put your daily methods in here
        addPerson(people.get((int)(Math.random()*population)), people.get((int)(Math.random()*population)));
        makeDisaster();
    }

    //Makes new person
    public void addPerson(Person p1, Person p2){
        String lastName;
        String gender;
        //Make sure hetro and not dead
        if(((p1.getGender() == "female" && p2.getGender() == "male")||(p1.getGender() == "male" && p2.getGender() == "female"))&&(p1.isDead() == false)&&(p2.isDead() == false)){
        //Gets last name
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
        //Sets gender
        int randomIndex = (int)(Math.random()*2);
            if(randomIndex >= 1){
            gender = "female";
            }
            else{
            gender = "male";
            }
        //Makes and adds the person to the array
        String fullName = firstNames[(int)(Math.random()*firstNames.length)] + " " + lastName;
        population++;
        people.add(new Person(0, fullName, gender,time.getDayCount(), places.get((int) (Math.random()*places.size())).getPlace(), p1.getName(), p2.getName()));
        }

  //Start

  }

 //for generating a bell curve for various aspects of the people in the society such as IQ
 public static long bellCurve(int mean, int sd) {
  int i = mean - (3 * sd);
  int j = mean + (3 * sd);
  int x = i;
  for (int c = i; c < j; c++) {
   double l = Math.random();
   if (l >= 0.5) {
    x++;
   }
  }
  return x;
 }

 //takes parameters of two people
 public void findTheLove(Person a, Person b) {
  double loveA = 0;
  double loveB = 0;
  double compatibility = 0;
   if (a.getAge() > 18 && b.getAge() > 18) {               //makes sure they're at least 18 ;)
    for (int i = 0; i < a.getHaves().size(); i++) {
     if (a.getWants().get(i) == b.getHaves().get(i)) {      //compares their haves and wants they were born with to find love
      loveA++;
     }
     if (b.getWants().get(i) == a.getHaves().get(i)) {
      loveB++;
     }
    }
    if (loveB == 0 || loveA == 0) {                   //can't divide by 0!
     compatibility = 0;
    } else if (loveA == 0 || loveB == 0) {            //averages their connections to come up with a random percent which I called compatibility
     compatibility = 0;
    } else {
     compatibility = (loveA + loveB) / 2;
    }
    if (compatibility >= 2) {
     a.gotMarriedTo(b);
     b.gotMarriedTo(a);
    }
   }
  }

    //Removes people
    public void removePeople(int amount){
        for(int i = 0; i < amount; i++){
            int index = (int)(Math.random()*population);
            people.get(index).markAsDeceased();
            population--;
        }
    }
    //Disaster Variable to Show Disaster
    String disaster = "none";
    //Creates and changes weather
    public void makeDisaster(){
        int change = 0;
       //Disasters {"tornado", "hurricane", "flood", "earthquake", "tsunami", "wildfires"};

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
            int kill = (int)(Math.random()*6);
            if(level == 0){
                removePeople(kill);
                disaster = "small tornado";
                change = 1;
            }
            else if(level == 1){
                removePeople(kill * 2);
                disaster = "medium tornado";
                change = 1;
            }
            else{
                removePeople(kill * 3);
                disaster = "large tornado";
                change = 1;
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
            int amount = (int)(Math.random()*4) * level;
            removePeople(amount);
            disaster = "hurricane, level: " + level;
            change = 1;
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
            disaster = "flood";
            change = 1;
        }

        //Earthquake Chance Maker
        int earIndex = (int)(Math.random()*2000);
        double level = Math.round(((Math.random()*6) + 2.5) * 100D) / 100D;
        int killLevel = 0;
        if(level >= 8){
            earIndex += 0;
            killLevel = 100;
        }
        else if(level >= 7 && level < 8){
            earIndex += 10;
            killLevel = 10;
        }
        else if(level >= 6 && level < 7){
            earIndex += 50;
            killLevel = 2;
        }
        else if(level >= 5 && level < 6){
            earIndex += 250;
            killLevel = 1;
        }
        else if(level < 5){
            earIndex -= 2000;
            killLevel = 0;
        }
        if(earIndex >= 1999){
            int levelAmount = (int)(Math.random()*6);
            int amount = levelAmount * killLevel;
            removePeople(amount);
            disaster = "earthquake, level: " + level;
            change = 1;
        }

        //Tsunami Chance Maker
        int tsuIndex = (int)(Math.random()*200);
        if(tsuIndex >= 199){
            int amount = (int)(Math.random()*40);
            removePeople(amount);
            disaster = "tsunami";
            change = 1;
        }

        //Wildfire Chanace Maker
        int wilIndex = (int)(Math.random()*350);
        if(time.getSeason().equals("spring")){
            wilIndex += 10;
        }
        else if(time.getSeason().equals("fall")){
            wilIndex += 5;
        }
        if(wilIndex >= 349){
            int amount = (int)(Math.random()*13);
            removePeople(amount);
            disaster = "wildfire";
            change = 1;
        }

        //Makes it nothing if there is no disaster
        if(change == 0){
            disaster = "none";
        }
    }

    public String getDisaster(){
        return disaster;
    }

    public int populationOf(Society society,String PlaceName){
        ArrayList<String> placedata = new ArrayList<String>();
        //finds the total population
        totalPopulation = society.people.size();
        for(int count = 0;count < totalPopulation;count++){
            placedata.add(society.people.get(count).getPlace());
        }
        int occurances = Collections.frequency(placedata, PlaceName);
        System.out.println("Population for "+PlaceName+":"+occurances);

        //empty the placedata array every time.
        placedata.clear();
        return occurances;
    }
}
