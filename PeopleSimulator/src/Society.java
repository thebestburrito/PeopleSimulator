import java.util.*;

class Society {
 ArrayList < Person > people = new ArrayList < Person > ();
ArrayList<Place> places = new ArrayList<Place>();
ArrayList<Person> couples = new ArrayList<Person>();
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

public int societalHappiness(){
    int totalHappiness = 0;
    int averageHappiness = 0;
    for(int i = 0; i < population; i++){
        totalHappiness += people.get(i).getHappiness();
        averageHappiness = (int) Math.floor(totalHappiness / population);
    }
    return averageHappiness;
}


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
    effectsOfMarriage();
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

 //takes parameters of two people   ----->  Every day, there is a 7 percent chance of someone finding a spouse ...
 public void findTheLove(Person a, Person b) {
  double loveA = 0;
  double loveB = 0;
  double compatibility = 0;
  if(a.getPlace().equals(b.getPlace()) && !a.isMarried() && !b.isMarried() && a.getHappiness() >  30 && b.getHappiness() > 30 && a != b){ //makes sure they are in the same place, not married already, have a high enough happiness, and are not the same person
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
  }

public void effectsOfMarriage(){                      //uh oh :O
    Person currentPerson;
    Person currentSpouse;
    for(int i = 0; i < this.population; i++){               //runs through population
        currentPerson = this.people.get(i);
        currentSpouse = this.people.get(i).getSpouse();
        if(currentPerson.isMarried() && !this.couples.contains(currentPerson) && !this.couples.contains(currentSpouse)){        //if they're married and not counted as a couple yet then count them as a couple and add a day to their marriage
            this.couples.add(currentPerson);
            this.couples.add(currentSpouse);
            currentPerson.addDayMarried();
            currentSpouse.addDayMarried();
        }else if(currentPerson.isMarried() && this.couples.contains(currentPerson)){                    //if they are already a couple add another day
            currentPerson.addDayMarried();
            currentSpouse.addDayMarried();
            if(currentPerson.getYearsMarried() > 0 && currentPerson.getDaysMarried() % 365 == 0){                    //if they made it a year, make them less happy
                if(Math.random()*10 > 5){                                                               // 50% chance they will be more happy as the year passes.... 50% chance they will be sadder
                    currentPerson.changeHappiness(5);
                }else{
                    currentPerson.changeHappiness(-4);
                }
                if(currentPerson.getHappiness() < 20 || currentSpouse.getHappiness() < 20 && currentPerson.getYearsMarried() != 20){    // as years go by, happiness decreases... if it gets to be too low... well you get the point
                    currentPerson.gotDivorcedFrom(currentSpouse);
                    currentSpouse.gotDivorcedFrom(currentPerson);
                }
            }
        }
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
