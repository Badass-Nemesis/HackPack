import java.io.*;
import java.util.*;

public class OOPs_Constructors_and_This {
    public static class Person {
        int age;
        String name;

        void saysHi() {
            System.out.println(name + "[" + age + "] says Hi.");
        }

        // this is a deafault constructor given by java compiler automatically. we don't need to write this unless we are calling 
        // parameter in the main function
        Person(){
            //default constructor
        }

        // this is a parameterized constructor. it should be given by us
        Person(int age, String name){
            this.age = age;
            this.name = name;
        }
    }

    public static void main(String[] args) {
        Person p1 = new Person();
        p1.age = 10;
        p1.name = "A";
        p1.saysHi();

        Person p2 = new Person(20, "B");
        p2.saysHi();
    }
}
