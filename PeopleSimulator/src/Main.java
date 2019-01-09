class Main {
	public static void main(String[] args) {
    System.out.println("Cheeze!");
		Society peopleTown = new Society(10000);

      for(int i = 0; i < 10000; i++) {
        peopleTown.cycleDay();
      }
	}

}