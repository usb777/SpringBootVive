import java.io.Serializable;
import org.apache.commons.lang3.*;

class Student implements Serializable {
    public int rollNumber;
    public String name;
    public char gender;

    public Student(int rollNumber, String name,   char gender)
    {
        this.rollNumber = rollNumber;
        this.name = name;
        this.gender = gender;
    }
}
public class SerializationUtilsClass {

    public static void main(String args[]) throws Exception {
        Student student = new Student(101, "Dzen", 'M');

        // converting Object to byte array
        // serializing the object of gfgStudent class
        // (student)
        byte[] studentSerialized = SerializationUtils.serialize(student);

        System.out.println("Student serialized "+studentSerialized.toString());


        Student newStudent = (Student) SerializationUtils.deserialize(studentSerialized);

        System.out.println(newStudent.rollNumber);
        System.out.println(newStudent.name);
        System.out.println(newStudent.gender);

    }
}
