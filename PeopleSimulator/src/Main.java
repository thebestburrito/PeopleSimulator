class Main {
    public static void main(String[] args) {
        Society peopleTown = new Society(2);
        for(int j = 0; j < peopleTown.population-1; j++){
                System.out.println(peopleTown.people.get(j).getName());
                peopleTown.checkLove(peopleTown.people.get(j),peopleTown.people.get(j+1));
        }
        for (int i = 0; i < peopleTown.population; i++) {

            System.out.println(peopleTown.people.get(i).getName() + " " + peopleTown.people.get(i).getAge() + " " + peopleTown.people.get(i).getSex() + " " + peopleTown.people.get(i).getHaves() + " " + peopleTown.people.get(i).getWants() + " " + peopleTown.people.get(i).getLove());
        }
        System.out.println(peopleTown.findOldestPerson());
    }
}