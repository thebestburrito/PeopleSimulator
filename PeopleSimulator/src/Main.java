class Main {
	public static void main(String[] args) {
		Society peopleTown = new Society(50);
        for(int i = 0; i < 10000; i++) {
            peopleTown.cycleDay();
        }

        for(int j = 0; j < 50; j++){
            System.out.println(peopleTown.people.get(j).getName() + " " + peopleTown.people.get(j).getPersonalityNumber());
        }
	}
}