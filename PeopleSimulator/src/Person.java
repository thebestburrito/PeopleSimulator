import java.util.ArrayList;


class Person {
	public int age;
	private String name;
    private int birthday;
    private String gender;
    public String place;
    public int thisPopulation;
    private ArrayList <Integer> haves = new ArrayList <Integer>();
    private ArrayList <Integer> wants = new ArrayList <Integer>();
    private boolean married = false;
    private boolean divorced = false;
    private String id;
    private String partner;
    private String mother;
    private String father;
    private String children;
    public int IQ = bellCurve(100,15);
    public int income = bellCurve(53719,30000);
    public int points = 0;
    public int mill = bellCurve(50,25);
	public Person(int age, String name,String gender,int birthdate,String place) {
	this.name = name;
	this.age = age;
    this.birthday = birthdate;
    this.gender = gender;
    this.place = place;
    for(int i = 0; i < 10; i++){
        haves.add((int)(Math.random()*10));
        wants.add((int)(Math.random()*10));
    }
    }


	public boolean olderThan(int otherAge) {
		if (age > otherAge) {
			return true;
		} else {
			return false;
		}

	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public void hadBirthday() {
		age++;
	}

    public void setGender(String gender){
        this.gender = gender;
    }

    public String getGender(){
        return gender;
    }

    public ArrayList <Integer> getHaves(){
        return haves;
    }
    public ArrayList <Integer> getWants(){
        return wants;
    }

    public boolean getMarried(){
        return married;
    }

    public void makeMarry(){
        married = true;
    }

    public boolean getDivorced(){
        return divorced;
    }

    public void makeDivorce(){
        divorced = true;
    }

    public void unMarry(){
        married = false;
    }

    public void unDivorce(){
        divorced = false;
    }
    public String getPartner(){
        return partner;
    }
 public void setPartner(String newPartner){
        partner = newPartner;
    }
    public String getId(){
        return id;
    }
    public String getMother(){
        return mother;
    }


    public void setMother(String newMother){
        mother = newMother;
    }
    public String getFather(){
        return father;
    }

    public void setFather(String newFather){
        father = newFather;
    }
    public String getChildren(){
        String child = "";
        String allChildren = "";
        for(int i = 0; i < children.length(); i++){
            if(!children.substring(i,i+1).equals(" ") || i == children.length()){
                child = child + children.charAt(i);
            }else{
                allChildren += allChildren + " " + child;
                child = "";
            }
        }
        return allChildren;
    }

    public void setChildren(String newChild){
        children += newChild + " ";
    }
     public static int bellCurve(int mean, int sd) {
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

    public String getPlace(){
         return this.place;
     }
     public String changePlaceTo(String newPlace){
         this.place = newPlace;
         return ("Person " + this.name + "moved to " + newPlace);
     }

}