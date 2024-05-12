package org.example;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");

        System.out.println("Argument count: " + args.length);
        for (int i = 0; i < args.length; i++) {
            System.out.println("Argument " + i + ": " + args[i]);

            if (args[i].equals("exit1"))
            {
                System.out.println("exit1");
                System.exit(1);
            }
            else if (args[i].equals("exit5"))
            {
                System.out.println("exit5");
                System.exit(5);
            }
            else if (args[i].equals("exit10"))
            {
                System.out.println("exit10");
                System.exit(10);
            }

        }



    }
}