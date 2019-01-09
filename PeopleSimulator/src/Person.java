import java.util.ArrayList;


class Person {
	public int age;
	private String name;
    private int birthday;
    private String gender;
    private ArrayList <Integer> haves = new ArrayList <Integer>();
    private ArrayList <Integer> wants = new ArrayList <Integer>();
    private boolean married = false;
    private boolean divorced = false;
    private String id;
    private String partner;
    private String mother;
    private String father;
    private String children;
	public Person(int age, String name,String gender,int birthdate, String id) {
		this.name = name;
		this.age = age;
        this.birthday = birthdate;
        this.gender = gender;
        this.id = id;
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

    public String getId(){
        return id;
    }
    public String getMother(){
        return mother;
    }
    public String getFather(){
        return father;
    }
    public String getChildren(){
        String child = "";
        String allChildren = "";
        for(int i = 0; i < children.length(); i++){
            if(!children.substring(i,i+1).equals(" ") || i == children.length()){
                child = child + children.charAt(i);
            }else{
                allChildren = allChildren + child;
            }
        }
        return allChildren;
    }
}