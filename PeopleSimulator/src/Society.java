import java.util.*;

class Society {
 ArrayList < Person > people = new ArrayList < Person > ();
ArrayList<Place> places = new ArrayList<Place>();
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

 Society(int numPeople) {
  population = numPeople;
  String fullName;
  String gender;
  String id;
  for(int i = 0; i < 5; i++){
            places.add(new Place(lastNames[(int)(Math.random()*lastNames.length)]+placeNames[(int)(Math.random()*placeNames.length)]));
        }
  for (int i = 0; i < numPeople; i++) {
   fullName = firstNames[(int)(Math.random() * firstNames.length)] + " " + lastNames[(int)(Math.random() * lastNames.length)];
   int randomIndex = (int)(Math.random() * 2);
   if (randomIndex >= 1) {
    gender = "female";
   } else {
    gender = "male";
   }

   people.add(new Person((int)(Math.random()*100),fullName,gender,time.getDayCount(), places.get((int) (Math.random()*places.size())).getPlace()));
  }
 }

 public void cycleDay() {
  time.incrementTime();

  findTheLove(people.get((int)(Math.random() * population)), people.get((int)(Math.random() * population)));


 }


 public void addPerson(Person p1, Person p2) {
  String lastName;
  String gender;
  if ((p1.getGender() == "female" && p2.getGender() == "male") || (p1.getGender() == "male" && p2.getGender() == "female")) {
   if (p1.getGender().equals("male")) {
    String name = p1.getName();
    int space = name.indexOf(" ") + 1;
    lastName = name.substring(space, name.length());
   } else {
    String name = p2.getName();
    int space = name.indexOf(" ") + 1;
    lastName = name.substring(space, name.length());
   }
   int randomIndex = (int)(Math.random() * 2);
   if (randomIndex >= 1) {
    gender = "female";
   } else {
    gender = "male";
   }
   String fullName = firstNames[(int)(Math.random() * firstNames.length)] + " " + lastName;
   population++;
   people.add(new Person(0, fullName, gender, time.getDayCount(),p1.getPlace()));
   System.out.println(p1.getName() + " and " + p2.getName() + " had...");
   System.out.println(fullName + " born on " + time.dateToString());

  }
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
  if(a.getPlace().equals(b.getPlace())){
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
     a.makeMarry();                          //marries them and sets their partners (married depends on if compatibility is above 20 percent)
     b.makeMarry();
     System.out.println(a.getName() + " and " + b.getName() + " are newly wed with " + compatibility * 10 + " compatibility!");
    } else {
     System.out.println(a.getName() + " and " + b.getName() + " have no love :( with " + compatibility * 10 + " compatibility");
    }
   } else {
    System.out.println(a.getName() + " " + a.getAge() + " and " + b.getName() + " " + b.getAge() + " had a conflict of ages");
   }
  }else{
      System.out.println("Could not love because " + a.getName() + " is in " + a.getPlace() + " and " + b.getName() + " is in " + b.getPlace() + " :(");
  }

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
