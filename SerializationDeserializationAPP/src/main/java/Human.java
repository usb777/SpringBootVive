import java.io.Serializable;

public class Human implements Serializable {

    public int age = 36;
    public String name = "Dzmitry";

    public Human(int age, String name)
    {
        this.age = age;
        this.name = name;
    }

}
