import java.util.ArrayList;


class Person {
	public int age;
	private String name;
    private int birthday;
    private String gender;
    private ArrayList <Integer> haves = new ArrayList <Integer>();
    private ArrayList <Integer> wants = new ArrayList <Integer>();
	public Person(int age, String name,String gender,int birthdate) {
		this.name = name;
		this.age = age;
        this.birthday = birthdate;
        this.gender = gender;
        for(int i = 0; i < 3; i++){
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

    public String getGender(){
    return gender;
    }

    public void setGender(String gender){
        this.gender = gender;
    }

    public ArrayList <Integer> getHaves(){
        return haves;
    }
    public ArrayList <Integer> getWants(){
        return wants;
    }
}