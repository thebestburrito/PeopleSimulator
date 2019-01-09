import java.util.ArrayList;

class Society {
 ArrayList < Person > people = new ArrayList < Person > ();

 public Time time = new Time(1, 1, 0, 0);
 public int population;
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

 Society(int numPeople) {
  population = numPeople;
  String fullName;
  String gender;
  String id;
  for (int i = 0; i < numPeople; i++) {
   fullName = firstNames[(int)(Math.random() * firstNames.length)] + " " + lastNames[(int)(Math.random() * lastNames.length)];
   int randomIndex = (int)(Math.random() * 2);
   id = Integer.toString(i);
   if (randomIndex >= 1) {
    gender = "female";
   } else {
    gender = "male";
   }
   people.add(new Person((int)(Math.random() * 100), fullName, gender, time.getDayCount(), id));
  }
 }

 public void cycleDay() {
  time.incrementTime();
  //hey folks put your daily methods in here
  findTheLove(people.get((int)(Math.random() * population)), people.get((int)(Math.random() * population)));
    //addPerson(people.get((int)(Math.random() * population)), people.get((int)(Math.random() * population)));

 }


 public void addPerson(Person p1, Person p2) {
  String lastName;
  String gender;
  String id;
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
   id = Integer.toString(population);
   people.add(new Person(0, fullName, gender, time.getDayCount(), id));  //This adds a baby with a new id :)
   for(int i = 0; i < population; i++){
       if(people.get(i).getId().equals(id)){
           if(p1.getGender().equals("male") && p2.getGender().equals("female")){          //This section just sets the property of father or mother depending on who was male or female
               people.get(i).setFather(p1.getId());
               p1.setChildren(id);
               people.get(i).setMother(p2.getId());
               p2.setChildren(id);
           }else if(p2.getGender().equals("male") && p1.getGender().equals("female"))
                people.get(i).setFather(p2.getId());
                p2.setChildren(id);
               people.get(i).setMother(p1.getId());
               p1.setChildren(id);
       }
   }
   System.out.println(p1.getName() + " and " + p2.getName() + " had...");
   System.out.println(fullName + " born on " + time.dateToString());
  // System.out.println("Parent 1 id :" + p1.getId() + "\n Parent 2 id: " + p2.getId() + "\n baby id: " + id + "\n parent 1 child id: " + p1.getChildren());
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

 public Person getOldestPerson() {
  int loc = 0; //location used in return statement
  int age = 0;
  for (int i = 0; i < this.population; i++) { //for each position in the people array, compares age to the age variable then records the position of the highest.
   if (this.people.get(i).olderThan(age)) {
    age = this.people.get(i).getAge();
    loc = i;
   }
  }
  return this.people.get(loc); //returns the location of the person
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
     a.makeMarry();                          //marries them and sets their partners (married depends on if compatibility is above 20 percent)
     b.makeMarry();
     a.setPartner(b.getId());
     b.setPartner(a.getId());
     System.out.println(a.getName() + " and " + b.getName() + " are newly wed with " + compatibility * 10 + " compatibility!");
     System.out.println(a.getPartner()+ " " + b.getId()+ " " + b.getPartner() + " " + a.getId());                                    //test to see if ID works
    } else {
     System.out.println(a.getName() + " and " + b.getName() + " have no love :( with " + compatibility * 10 + " compatibility");
    }
   } else {
    System.out.println(a.getName() + " " + a.getAge() + " and " + b.getName() + " " + b.getAge() + " had a conflict of ages");
   }
  }
}
