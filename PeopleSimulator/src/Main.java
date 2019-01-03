
class Main {

	public static void main(String[] args) {

		Society peopleTown = new Society(10000);

      for(int i = 0; i < 10000; i++) {
        peopleTown.cycleDay();
        /* System.out.println(peopleTown.people.get(i).getName()); */
        System.out.println("IQ :" +peopleTown.people.get(i).calcIQ());
        System.out.println("Icome :" +peopleTown.people.get(i).calcIncome());
      }
	}

}
