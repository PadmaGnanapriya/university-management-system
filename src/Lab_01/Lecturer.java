package Lab_01;


import java.util.Scanner;

import jdk.nashorn.internal.ir.LexicalContext;
import jdk.nashorn.internal.ir.LexicalContextNode;

import java.util.Scanner;

public class Lecturer{
    String name,subject;
    int age;
    int course;
    Scanner scanner =new Scanner(System.in);

    public static void printResult(String name,int age,String subject){
        System.out.println("Welcome to University Management System\n\n...");
        System.out.println("Student registation completed");
        System.out.println("Name      : "+name);
        System.out.println("Age       : "+age);
        System.out.println("Subject   : "+subject);
    }

    public void registation(){
        System.out.println("Welcome to University Management System\n\n...");
        System.out.println("Lecturer Registration.");
        System.out.println("\nPlease submit following informations,");
        System.out.println("1.  Name  : ");
        name=scanner.next();
        System.out.println("2.  Age   : ");
        age=scanner.nextInt();
        System.out.println("3.  Select Course number from following list,");
        System.out.println("    [1] SENG 11111 - Introdution to Programing");
        System.out.println("    [2] SENG 11112 - Fundamentals of Engineering");
        System.out.println("    [3] SENG 11113 - Data Structure and Algorithms");
        course=scanner.nextInt();
        if(course==1)
            subject="SENG 11111 - Introdution to Programing";
        else if(course==2)
            subject="SENG 11112 - Fundamentals of Engineering";
        else if(course==3)
            subject="SENG 11113 - Data Structure and Algorithms";

        printResult(name,age,subject);
    }
}
