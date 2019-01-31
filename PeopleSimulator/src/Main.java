class Main {
	public static void main(String[] args) {
        Society peopleTown = new Society(20);
        for(int i = 0; i < 100; i++) {
            peopleTown.cycleDay();
        }
	}

    public static void p(String toPrint){
        System.out.println(toPrint);
    }
}