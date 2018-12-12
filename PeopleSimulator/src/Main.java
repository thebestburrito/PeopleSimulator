
class Main {
	public static void main(String[] args) {
    System.out.print("hey");
		Society peopleTown = new Society(2);
		for(int i = 0; i < peopleTown.population; i++){

      System.out.println(peopleTown.people.get(i).getName() + " " + peopleTown.people.get(i).getAge() + " " + peopleTown.people.get(i).getSex());
		}
    System.out.println(peopleTown.findOldestPerson());
	}
}
