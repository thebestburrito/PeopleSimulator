import java.util.*;

class Society {
    ArrayList <Person> people = new ArrayList <Person>();
    ArrayList <Place> places = new ArrayList <Place>();
    ArrayList <Person> couples = new ArrayList <Person>();
    public Time time = new Time(1, 1, 0, 0);
    public int population;
    public int totalPopulation;
    public int totalPlaces = 5;
    public String disaster = "none";
    //these names came from https://nameberry.com/unisex-names
    private String[] firstNames = {
        "Avery", "Riley", "Jordan", "Angel", "Parker", "Sawyer", "Peyton", "Quinn", "Blake", "Hayden", "Taylor", "Dakota", "Reese", "Zion", "Remmington", "Amari", "Phoenix", "Kendall", "Harley", "Rylan", "Marley", "Dallas"
    };

    private String[] lastNames = {
        "Hill", "Carson", "Ware", "McMahon", "Murray", "Smith", "Jones", "Robinson", "Morris", "Brown", "Meyers", "Reed", "Schmidt", "Estrada", "Huang", "Patel", "Gupta", "Gomez", "Ramirez", "Thomas", "Jordan", "Samson", "Samuels", "Evans", "Butts", "Wright", "Black", "White"
    };

    private String[] placeNames = {
        "burg", "ton", "burgh", "town", " City", "ville", " Center"," Lake", "wood", "ford", "land", "house", "hill", "bridge", " Creek", "boro"
    };

    Society(int numPeople) {
        population = numPeople;
        String fullName;
        String gender;
        for (int i = 0; i < numPeople; i++) {
            fullName = firstNames[(int)(Math.random()*firstNames.length)] + " " + lastNames[(int)(Math.random()*lastNames.length)];
            int randomIndex = (int)(Math.random()*2);
            if (randomIndex >= 1) {
                gender = "female";
            } else {
                gender = "male";
            }
            for(int j = 0; j < 5; j++) {
                places.add(new Place(lastNames[(int)(Math.random()*lastNames.length)]+placeNames[(int)(Math.random()*placeNames.length)],"ummm?"));
            }
            people.add(new Person((int)(Math.random()*100),fullName, gender,time.getDayCount(), places.get((int)(Math.random()*places.size())).getPlace(), "unknown", "unknown"));
        }
    }

    public void cycleDay() {
        int peopleLvl = population;
        time.incrementTime();
        findTheLove(people.get((int)(Math.random() * population)), people.get((int)(Math.random() * peopleLvl)));
        //hey folks put your daily methods in here
        for (int i = 0; i < peopleLvl; i++) {
            int chance = (int)(Math.random()*peopleLvl);
            int num1 = (int)(Math.random()*peopleLvl);
            int num2 = (int)(Math.random()*peopleLvl);
            if (people.get(num1).getSpouse() == people.get(num2)) {
                chance-= peopleLvl*.05;
            }
            if ((chance < peopleLvl*.005) && (num1 != num2)) {
                addPerson(people.get(num1), people.get(num2));
            }
        }
        effectsOfMarriage();
        makeDisaster();
        for (Person peep : people) {
            peep.acct.earnDailyIncome((double)peep.income);
        }
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
            people.add(new Person(0, fullName, gender, time.getDayCount(),p1.getPlace(),p1.getName(),p2.getName()));
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

        if (a.getPlace().equals(b.getPlace()) && !a.isMarried() && !b.isMarried() && a.getHappiness() >  30 && b.getHappiness() > 30 && a != b) {
        //makes sure they are in the same place, not married already, have a high enough happiness, and are not the same person
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

    //Removes people
    public void removePeople(int amount, String place) {
        for (int i = 0; i < amount; i++) {
            int index = (int)(Math.random()*population);
            people.get(index).markAsDeceased();
            population--;
        }
    }

    public void makeDisaster() {
        String thePlace = (places.get((int)(Math.random()* places.size())).getPlace());
        int change = 0;
        //Disasters {"tornado", "hurricane", "flood", "earthquake", "tsunami", "wildfires"};

        //Tornado Chance Maker
        int torIndex = (int)(Math.random()*400);
        if (time.getSeason().equals("spring")) {
            torIndex += 10;
        } else if (time.getSeason().equals("summer")) {
            torIndex += 5;
        }

        if (torIndex >= 399) {
            int level = (int)(Math.random()*3);
            int kill = (int)(Math.random()*6);
            if (level == 0) {
                removePeople(kill, thePlace);
                disaster = "small tornado, killed: " + kill + " in " + thePlace;
                change = 1;
            } else if (level == 1) {
                removePeople(kill * 2, thePlace);
                disaster = "medium tornado, killed: " + kill * 2 + " in " + thePlace;;
                change = 1;
            } else {
                removePeople(kill * 3, thePlace);
                disaster = "large tornado, killed: " + kill * 3 + " in " + thePlace;;
                change = 1;
            }
        }

        //Hurricane Chance Maker
        int hurIndex = (int)(Math.random()*400);
        if (time.getSeason().equals("fall")) {
            hurIndex += 10;
        } else if (time.getSeason().equals("summer")) {
            hurIndex += 5;
        }

        if (hurIndex >= 400) {
            int level = (int)((Math.random()*5) + 1);
            int amount = (int)(Math.random()*4) * level;
            removePeople(amount, thePlace);
            disaster = "hurricane, level: " + level + ", killed: " + amount  + " in " + thePlace;;
            change = 1;
        }

        //Flood Chance Maker
        int floIndex = (int)(Math.random()*400);
        if (time.getSeason().equals("spring")) {
            floIndex += 10;
        } else if (time.getSeason().equals("summer")) {
            floIndex += 5;
        } else if (time.getSeason().equals("fall")) {
            floIndex += 5;
        }

        if (floIndex >= 399) {
            int amount = (int)(Math.random()*6);
            removePeople(amount, thePlace);
            disaster = "flood, killed: " + amount  + " in " + thePlace;;
            change = 1;
        }

        //Earthquake Chance Maker
        int earIndex = (int)(Math.random()*2000);
        double level = Math.round(((Math.random()*6) + 2.5) * 100D) / 100D;
        int killLevel = 0;
        if (level >= 8) {
            earIndex += 0;
            killLevel = 100;
        } else if (level >= 7 && level < 8) {
            earIndex += 10;
            killLevel = 10;
        } else if (level >= 6 && level < 7) {
            earIndex += 50;
            killLevel = 2;
        } else if (level >= 5 && level < 6) {
            earIndex += 250;
            killLevel = 1;
        } else if (level < 5) {
            earIndex -= 2000;
            killLevel = 0;
        }

        if (earIndex >= 1999) {
            int levelAmount = (int)(Math.random()*6);
            int amount = levelAmount * killLevel;
            removePeople(amount, thePlace);
            disaster = "earthquake, level: " + level + ", killed: " + amount  + " in " + thePlace;;
            change = 1;
        }

        //Tsunami Chance Maker
        int tsuIndex = (int)(Math.random()*200);
        if (tsuIndex >= 199) {
            int amount = (int)(Math.random()*40);
            removePeople(amount, thePlace);
            disaster = "tsunami, killed: " + amount  + " in " + thePlace;;
            change = 1;
        }

        //Wildfire Chnace Maker
        int wilIndex = (int)(Math.random()*350);
        if (time.getSeason().equals("spring")) {
            wilIndex += 10;
        } else if (time.getSeason().equals("fall")) {
            wilIndex += 5;
        }

        if (wilIndex >= 349) {
            int amount = (int)(Math.random()*13);
            removePeople(amount, thePlace);
            disaster = "wildfire, killed: " + amount  + " in " + thePlace;;
            change = 1;
        }

        //Makes it nothing if there is no disaster
        if(change == 0) {
            disaster = "none";
        }
    }

    public String getDisaster() {
        return disaster;
    }

    public void giveFriends(Person a, Person b) {
        double friendshipA = 0;
        double friendshipB = 0;
        double friendship = 0;
        for (int j = 0; j < population; j++) {
            if (a != b) {
                if (a.getAge()-b.getAge() < 10 || b.getAge()-a.getAge() < 10) {
                    for (int i = 0; i < a.getCommonTraits().size(); i++) {
                        if (a.getCommonTraits().get(i) == b.getCommonTraits().get(i)) {
                            friendshipA++;
                        }

                        if (b.getCommonTraits().get(i) == a.getCommonTraits().get(i)) {
                            friendshipB++;
                        }
                    }

                    if (friendshipB == 0 || friendshipA == 0) {
                        friendship = 0;
                    } else if (friendshipA == 0 || friendshipB == 0) {
                        friendship = 0;
                    } else {
                        friendship = (friendshipA + friendshipB) / 2;
                    }

                    if (friendship >= 2) {
                        a.becameFriendsWith(b);
                        b.becameFriendsWith(a);
                    }
                }
            }
        }
    }

    public void effectsOfMarriage() {                      //uh oh :O
        Person currentPerson;
        Person currentSpouse;
        for (int i = 0; i < this.population; i++) {               //runs through population
            currentPerson = this.people.get(i);
            currentSpouse = this.people.get(i).getSpouse();
            if (currentPerson.isMarried() && !this.couples.contains(currentPerson) && !this.couples.contains(currentSpouse)) {        //if they're married and not counted as a couple yet then count them as a couple and add a day to their marriage
                this.couples.add(currentPerson);
                this.couples.add(currentSpouse);
                currentPerson.addDayMarried();
                currentSpouse.addDayMarried();
            }else if (currentPerson.isMarried() && this.couples.contains(currentPerson)) {                    //if they are already a couple add another day
                currentPerson.addDayMarried();
                currentSpouse.addDayMarried();
                if (currentPerson.getYearsMarried() > 0 && currentPerson.getDaysMarried() % 365 == 0) {                    //if they made it a year, make them less happy
                    if (Math.random()*10 > 5) {                                                               // 50% chance they will be more happy as the year passes.... 50% chance they will be sadder
                        currentPerson.changeHappiness(5);
                    } else {
                        currentPerson.changeHappiness(-6);
                    }

                    if (currentPerson.getHappiness() < 20 || currentSpouse.getHappiness() < 20) {    // as years go by, happiness decreases... if it gets to be too low... well you get the point
                        currentPerson.gotDivorcedFrom(currentSpouse);
                        currentSpouse.gotDivorcedFrom(currentPerson);
                    }
                }
            }
        }
    }

    public int societalHappiness() {
        int totalHappiness = 0;
        int averageHappiness = 0;
        for (int i = 0; i < population; i++) {
            totalHappiness += people.get(i).getHappiness();
            averageHappiness = (int) Math.floor(totalHappiness / population);
        }
        return averageHappiness;
    }

    public int populationOf (Society society,String PlaceName) {
        ArrayList<String> placedata = new ArrayList<String>();
        //finds the total population
        totalPopulation = society.people.size();
        for(int count = 0;count < totalPopulation;count++) {
            placedata.add(society.people.get(count).getPlace());
        }
        int occurances = Collections.frequency(placedata, PlaceName);

        //empty the placedata array every time.
        placedata.clear();
        return occurances;
    }

    public String getClassification(String placeName) {
        String h = "This places doesnt exist!";
        for(int count = 0;count < totalPlaces;count++) {
            if(places.get(count).getPlace().equals(placeName)) {
                h = places.get(count).getClassification();
            }
        }
        return h;  //multi return statement
    }

    public void addPlaces(String newPlace, String newClass) {
        places.add(new Place(newPlace, newClass));
        totalPlaces++;
    }
}