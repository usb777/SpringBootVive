import org.apache.commons.lang3.SerializationUtils;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Human1 implements Serializable {
    int age = 20;
    String name = "Dzmitry";

    public  Human1(int age, String name)
    {
        this.age = age;
        this.name = name;
    }

    public  Human1()
    {
        this.age = 56;
        this.name = "Mister";
    }

}

public class ObjectToByteArray {
    public static void main(String args[]) throws Exception {

        Human1 obj = new Human1(33,"Mitiok");
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(obj);
        oos.flush();
        byte [] data = bos.toByteArray();

        System.out.println("Hello: "+data.toString());

        Human1 obj1 =(Human1) SerializationUtils.deserialize(data);
        System.out.println("deserialized name: "+obj1.name);
        System.out.println("deserialized age: "+obj1.age);

    }
}
