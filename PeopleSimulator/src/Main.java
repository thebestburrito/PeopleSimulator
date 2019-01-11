class Main {

	public static void main(String[] args) {
		Society peopleTown = new Society(100);


    for(int i = 0; i < peopleTown.population; i++) {
        peopleTown.cycleDay();
	}
    for(int i = 0; i < peopleTown.population; i++) {

        System.out.println(i + " " + peopleTown.people.get(i).getName() +" Balance = " + peopleTown.people.get(i).acct.getBalance());
        System.out.println("IQ :" +peopleTown.people.get(i).calcIQ());
        System.out.println("Income :" +peopleTown.people.get(i).calcIncome());
	}

    }
}