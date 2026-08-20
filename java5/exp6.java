class Person {
    String name;
    int age;
    void walk() {
        System.out.println(name + " is walking.");
    }
}
interface Sport {
    void playSport();
}
class SportStudent extends Person implements Sport {
    String sportName;
    public void playSport() {
        System.out.println(name + " (Age: " + age + ") is playing " + sportName + ".");
    }
}
public class exp6{
    public static void main(String[] args) {
        SportStudent s = new SportStudent();
        s.name = "John";
        s.age = 20;
        s.sportName = "Cricket";
        s.walk();
        s.playSport();
    }
}