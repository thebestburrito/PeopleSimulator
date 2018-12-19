import java.util.ArrayList;


class Person {
    private int age;
    private String name;
    private String sex;
    private int love;
    private ArrayList <Integer> haves = new ArrayList < Integer > ();
    private ArrayList <Integer> wants = new ArrayList < Integer > ();
    public Person(int age, String name, String sex, int love) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.love = love;
        for(int i = 0; i < 3; i++){
            int num1 = ((int)(Math.random()*10));
            int num2 = ((int)(Math.random()*10));
            if(num1 > 5){
                num1 = num1 - 5;
            }
            if(num2 > 5){
                num2 = num2 -5;
            }
            haves.add(num1);
            wants.add(num2);
        }
    }

    public boolean olderThan(int otherAge) {
        if (age > otherAge) {
            return true;
        } else {
            return false;
        }

    }

    public ArrayList <Integer> getHaves(){
        return haves;
    }

    public ArrayList <Integer> getWants(){
        return wants;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getSex(){
        return sex;
    }

    public int getLove() {
        return love;
    }

    public void addLove() {
        love++;
    }

    public void hadBirthday() {
        age++;
    }

}