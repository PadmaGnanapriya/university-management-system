package Lab_01;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Scanner scanner=new Scanner(System.in);
        System.out.println("Welcome to University Management System");
        System.out.println("Press [1] Register as a student");
        System.out.println("Press [2] Register as a lecturer");
        int choice = scanner.nextInt();
        menu(choice);


    }
    public static void menu(int x){
        switch (x){
            case 1:
                Student stu=new Student();
                stu.registation();
                break;
            case 2:
                Lecturer lec=new Lecturer();
                lec.registation();
                break;
            default:
                System.out.println("Wrong choise");
                break;
        }
    }

}

