package com.company;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.util.*;

public class Main{
    static Scanner in = new Scanner(System.in);
    static double degrees, radian;
    static int newX, newY, yeter, yeter2, yeter3;

    public static void main(String[] args){

        currTime();
        System.out.println();
        tree();

    }

    public static void currTime(){

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss:ms");
        LocalDateTime now = LocalDateTime.now();
        System.out.println(dtf.format(now));

    }
    public static void tree (){
        gettingInfo();


    }

    public static void mathSectionX(int xA){
        newY = (int)(Math.tan(radian)*xA);
        yeter = (int)(Math.sqrt(xA*xA+newY*newY));
        forShownTree(xA, newY, yeter);
    }
    public static void mathSectionY(int yA){
        newX = (int)(yA/Math.tan(radian));
        yeter2 = (int)(Math.sqrt(newX*newX+yA*yA));
        forShownTree(newX, yA, yeter);
    }
    public static void mathSectionBoth(int xA, int yA){
        yeter3 = (int)(Math.sqrt(xA*xA+yA*yA));
        forShownTree(xA, yA, yeter);
    }
    public static void forShownTree(int x, int y, int yeter){
        String str="$#";
        for (int i = 0; i < y; i++){
            if (i == y)
                break;
            System.out.println(str);
            str = strWithSpace(str);

            if (i+1 == y){
                for (int j = 0; j < x; j++)
                    System.out.print("#");
            }

        }
    }
    public static String strWithSpace(String str){// not finished at all
        str = "# $";
        StringBuilder sb = new StringBuilder(str);
        for (int i = 0; i < sb.length()-1; i++) {
            if (sb.charAt(i) == ' ') {
                sb.setCharAt(i + 1, ' ');
            }
        }
        return sb.toString();

    }

    public static void gettingInfo(){

        System.out.print("Enter Axis(what do you have) 'x'/'y'/'both':");
        String xy = in.next();

        gettingXaxisYaxis(xy);

    }
    public static void gettingXaxisYaxis(String xy){
        switch (xy) {
            case "x":
                System.out.print("Enter x: ");
                int x = in.nextInt();
                System.out.print("Enter Degree(to find y): ");
                degrees = in.nextDouble();
                radian = Math.toRadians(degrees);
                mathSectionX(x);
                break;
            case "y":
                System.out.print("Enter y: ");
                int y = in.nextInt();
                System.out.print("Enter Degree(to find x): ");
                degrees = in.nextDouble();
                radian = Math.toRadians(degrees);
                mathSectionY(y);
                break;

            case "both":
                System.out.print("Enter x, space, y: ");
                String xandy = in.nextLine();

                String[] values = xandy.split(" ");// values[0, 1]-[x, y]

                if (values.length == 2) {
                    String xx = values[0];
                    String yy = values[1];
                    int xA = Integer.parseInt(xx);
                    int yA = Integer.parseInt(yy);
                    mathSectionBoth(xA, yA);
                } else {
                    System.out.println("Invalid input format. Please enter: .");
                }
                break;
            default:
                System.out.println("illegal command;");
        }



    }


}
