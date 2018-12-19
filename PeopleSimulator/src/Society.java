import java.util.ArrayList;

class Society {
    ArrayList < Person > people = new ArrayList < Person > ();

    // public Person[] people = new Person[100];
    public int population;
    // these names came from https://nameberry.com/unisex-names
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

        String sex;
        for (int i = 0; i < numPeople; i++) {
            fullName = firstNames[(int)(Math.random() * firstNames.length)] + " " +
                lastNames[(int)(Math.random() * lastNames.length)];
            if ((int)(Math.random() * 1000) % 2 == 0) {
                sex = "male";
            } else {
                sex = "female";
            }
            people.add(new Person((int)(Math.random() * 100), fullName, sex, 0));

        }
    }

    public String findOldestPerson() {
        int age = 0;
        int ageIndex = 0;
        ArrayList < String > oldestNames = new ArrayList < String > ();
        String listOfNames = " ";
        String oldestPerson = " ";
        for (int i = 0; i < this.population; i++) {
            if (this.people.get(i).olderThan(age)) {
                ageIndex = i;
                age = this.people.get(i).getAge();
            } else if (this.people.get(i).getAge() == age) {
                oldestNames.add(this.people.get(ageIndex).getName());
                oldestNames.add(this.people.get(i).getName());
            }
        }
        if (oldestNames.isEmpty()) {
            oldestPerson = "The oldest person is " + this.people.get(ageIndex).getName() + " " +
                this.people.get(ageIndex).getAge();
        } else if (!oldestNames.isEmpty()) {
            for (int j = 0; j < oldestNames.size(); j++) {
                if (j == oldestNames.size() - 1) {
                    listOfNames += "and " + oldestNames.get(j);
                } else {
                    listOfNames += oldestNames.get(j) + ", ";
                }

            }
            oldestPerson = "The oldest people are:" + (listOfNames) + " who are " + age;
        }

        return (oldestPerson);
    }
    public void checkLove(Person a, Person b){
        for(int i = 0; i < a.getHaves().size(); i++){
            if(a.getHaves().get(i) == b.getWants().get(i) || a.getWants().get(i) == b.getHaves().get(i)){
                a.addLove();
                b.addLove();
            }
        }
    }
}