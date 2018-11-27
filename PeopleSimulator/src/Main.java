
class Main {
	// I'll be using this main method for testing!!!
	public static void main(String[] args) {

		Society peopleTown = new Society(10000);
    Date startDate = new Date(1, 1, 0, 0);
		for(int i = 0; i < peopleTown.population; i++){
			//the ArrayList method .get(i) is how to get the element at i
			//System.out.println(i + " " + peopleTown.people.get(i).getName() + " age = "+ peopleTown.people.get(i).getAge());
		}

    //  System.out.println(peopleTown.getOldestPerson().getName() + " is the oldest person, with an age of " + peopleTown.getOldestPerson().getAge());

     //System.out.println(peopleTown.getBirthday());
      
      
      for(int i = 0; i < 10000; i++) {
        startDate.newDate();
        System.out.println(startDate.getDate());
      }
	}
  public static void pause (int msPause) { // pause method 
    try {
      Thread.sleep(msPause);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
