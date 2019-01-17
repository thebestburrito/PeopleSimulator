
class Main {

	public static void main(String[] args) {

		Society peopleTown = new Society(10000);

      for(int i = 0; i < 10000; i++) {
        peopleTown.cycleDay();
        //Shows Disater Variable
        System.out.println(peopleTown.getDisaster());
        //Shows Population
        System.out.println(peopleTown.population);
      }
	}

}
