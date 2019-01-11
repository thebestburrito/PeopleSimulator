import java.util.*;

class Society{
	// this declares a new instance variable... an ArrayList for people
	List<Person> people = new ArrayList<Person>();
    List<Place> places = new ArrayList<Place>();
	public int totalPopulation;
	// these names came from https://nameberry.com/unisex-names
	private String[] firstNames = {"Avery","Riley","Jordan","Angel","Parker","Sawyer","Peyton","Quinn","Blake","Hayden","Taylor","Dakota","Reese","Zion","Remmington","Amari","Phoenix","Kendall","Harley","Rylan","Marley","Dallas"};
	private String[] lastNames = {"Hill","Carson","Ware","McMahon","Murray","Smith","Jones","Robinson","Morris","Brown","Meyers","Reed","Schmidt","Estrada","Huang","Patel","Gupta","Gomez","Ramirez","Thomas","Jordan","Samson","Samuels","Evans","Butts","Wright","Black","White"};
    // this is the places array: its contains all the places, in which people can live.
    private String[] placeNames = {"burg", "ton", "burgh", "town", " City", "ville", " Center"," Lake", "wood","ford","land","house","hill","bridge"," Creek", "boro"};

	Society(int numPeople){
		// population = numPeople;
		String fullName;
        //this randomly generates only 5 towns to start with.
        for(int i = 0; i < 5; i++){
            places.add(new Place(lastNames[(int)(Math.random()*lastNames.length)]+placeNames[(int)(Math.random()*placeNames.length)]));
        }
		for(int i = 0; i < numPeople; i++){
            //First Place Butts Creek!
            fullName = firstNames[(int)(Math.random()*firstNames.length)] + " " + lastNames[(int)(Math.random()*lastNames.length)];
            people.add(new Person((int)(Math.random()*100),fullName, places.get((int) (Math.random()*places.size())).getPlace()));

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