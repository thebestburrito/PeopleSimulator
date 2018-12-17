import java.util.ArrayList;


class Person {
    private int age;
    private String name;
    private String sex;
    private int likeability;
    ArrayList < Integer > haves = new ArrayList < Integer > ();
    ArrayList < Integer > wants = new ArrayList < Integer > ();
    public Person(int age, String name, String sex, int likeability) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.likeability = likeability;
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

    public String getSex() {
        return sex;
    }
    public void marry() {

    }

    public int getLikeability() {
        return likeability;
    }

    public void addLike() {
        likeability++;
    }

    public void hadBirthday() {
        age++;
    }

}