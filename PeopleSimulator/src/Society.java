import java.util.*;

class Society{
	//this declares a new instance variable... an ArrayList for people
	List<Person> people = new ArrayList<Person>();

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
            people.add(new Person((int)(Math.random()*100),fullName, gender));
		}
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
      people.add(new Person(0, fullName, gender));
    }
    else{
      System.out.println(p1.getName() + " and " + p2.getName() + " can not have a child.");
    }
  }

}

