class Main {

	public static void main(String[] args) {
		Society peopleTown = new Society(100);


      for(int i = 0; i < peopleTown.population; i++) {
        //peopleTown.cycleDay();
        System.out.println(i + " " + peopleTown.people.get(i).getName() + " age = "+ peopleTown.people.get(i).getAge() + " Balance = " + peopleTown.people.get(i).getBalance());
        System.out.println("IQ :" +peopleTown.people.get(i).calcIQ());
        System.out.println("Income :" +peopleTown.people.get(i).calcIncome());
	}

    }
}