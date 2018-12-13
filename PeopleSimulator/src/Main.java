
class Main {
	// I'll be using this main method for testing!!!
    //code gang
	public static void main(String[] args) {

		Society peopleTown = new Society(10000);
    Time startDate = new Time(1, 1, 0, 0);
		/*for(int i = 0; i < peopleTown.population; i++){
			//the ArrayList method .get(i) is how to get the element at i
			System.out.println(i + " " + peopleTown.people.get(i).getName() + " age = "+ peopleTown.people.get(i).getAge());
		}*/

    //  System.out.println(peopleTown.getOldestPerson().getName() + " is the oldest person, with an age of " + peopleTown.getOldestPerson().getAge());



      for(int i = 0; i < 10000; i++) {
        startDate.incrementTime();
        System.out.println(startDate.dateToString());
      }
	}
  public static void pause (int msPause) { // pause method
    try {
      Thread.sleep(msPause);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
  public static long bellCurve(int mean, int sd) {
		// make nombors gud
	    int i = mean - (3*sd);
	    int j = mean + (3*sd);
		int x = i;
		for(int c = i; c < j; c++) {
			double l = Math.random();
			if(l >= 0.5) {
				x++;
			}
		}
		return x;
	}

}
