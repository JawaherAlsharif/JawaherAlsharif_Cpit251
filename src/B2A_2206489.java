/*

Name : Jawaher Adnan Alsharif
ID : 2206489
Section : B2A
Course Name :  Programming II 
Assignment Number : #1

*/

import java.io.*;
import java.util.Scanner;

public class B2A_2206489 {

    public static void main(String[] args) throws FileNotFoundException {
        // Creat a file that I will read from it.
        File inputFile = new File("input.txt");
        
        // If the file doesn’t exist, print a message to let the user know what happened (see Input file for more details.
        if(!inputFile.exists()){
            System.out.println("The File Not Found");
            System.exit(0);
        }
        
        // Creat a file that I will write in it.
        File printFile = new File("output.txt");
        
        // Creat a Scanner and a PrintWriter for the files.
        Scanner inputreader = new Scanner(inputFile);
        PrintWriter output = new PrintWriter(printFile);
        
        
        // -------------------- Arrrays for Methods ----------------------------
        
        // 1# One-dimensional Array for Method addDepartment().
        String [] department = new String [3];
        
        // 2# Two-dimensional (2D) Array for Method addDepartment().
        String [][] studentsNames = new String [3][3];
        
        // 3# One-dimensional Array for Method addAwardCriteria().
        String [] criteria = new String [5];
        
        // 4# Three-dimensional Array for Method addScore().
        int [][][] score = new int [3][3][5];
        
        
        // ----------------------- Output File ---------------------------------
        output.println();
        output.println();
        output.println("***** Welcome to the College Star Winner System *****");
        
        // Creat a while loop to read the data from a file.
        while (inputreader.hasNext()){
            // to read a word.
            String line = inputreader.next();
            
            //creat if statments for line to uses the methods according to the word in line.
            if (line.equalsIgnoreCase("addDepartment")){
                     addDepartment(department , inputreader);              
            }
              
            else if (line.equalsIgnoreCase("addStudentsName")){ 
                     addStudentsNames(department, studentsNames, inputreader);
            }
            
            else if (line.equalsIgnoreCase("addAwardCriteria")){ 
                     addAwardCriteria(criteria, inputreader); 
            }
            
            else if (line.equalsIgnoreCase("addScore")){ 
                     addScore(department, studentsNames, criteria, score, inputreader);     
            }
      
            else if (line.equalsIgnoreCase("printcontestDetails")){
                printContestDetail(department, studentsNames, criteria, score, output);  
            }
            
            else if (line.equalsIgnoreCase("printDepartmentWinner")){
                printWinnerAwardByEachDepartment(department, studentsNames, criteria, score, output);   
            }
            
            else if (line.equalsIgnoreCase("printFCITWinner")){
                printFCITWinner(department, studentsNames, criteria, score, output); 
            }
            
            else if (line.equalsIgnoreCase("Quit")){
                output.println("	Thank you for using the College Star Winner System, Good Bye!");   
            }  
            
        }
        
        output.flush();
        output.close(); //printwriter.
        inputreader.close(); //scanner.
        
    }  
   
    // ---------------------------- Methods ------------------------------------
    
    // 1# Method addDepartment().
    // String array for the Departments’ names.
    public static void addDepartment(String[] department, Scanner inputreader) {
        for (int i = 0; i < department.length; i++) {
            department[i]=inputreader.next();   
        }
        
    }
    // -----------------------------------------
    
    // 2# Method addStudentsNames().
    // String Two-Dimensional array to store students’ names who participated in the contest from each department.
    public static void addStudentsNames(String[] department, String[][] studentsNames, Scanner inputreader) {
        for (int i = 0; i < department.length; i++) {
            for (int j = 0; j < studentsNames[i].length; j++) {
                studentsNames[i][j] = inputreader.next();
            }
        }
        
    }
    // -----------------------------------------
    
    // 3# Method addAwardCriteria().
    // String array for the Contest Criteria.
    public static void addAwardCriteria(String[] criteria, Scanner inputreader) {
        for (int i = 0; i < criteria.length; i++) {
            criteria[i]=inputreader.next();   
        }
        
    }
    // -----------------------------------------
    
    // 4# Method addScore().
    // Three-Dimensional (3D) Array for the points scored by each student in different criteria from each department.
    public static void addScore(String[] department, String[][] studentsNames, String[] criteria, int[][][] score, Scanner inputreader) {
        for (int i = 0; i < department.length; i++){
            for (int j = 0; j < studentsNames[i].length; j++){
                for (int k = 0; k < criteria.length; k++){
                    score[i][j][k] =inputreader.nextInt();
                }  
            } 
        } 
   
    }
    // ----------------------------------------- 
    
    // 5# Method printContestDetail().
    // Method to Print Contest Details.
    public static void printContestDetail(String[] department, String[][] studentsNames, String[] criteria, int[][][] score , PrintWriter output){
        for (int i = 0 ; i < department.length; i++){
            output.println(department[i]);
            int count = 0 ; 
            int total = 0;
            for (int j = 0 ; j < studentsNames[i].length; j++){
                output.print(studentsNames[i][j]+ "\t");
                for (int k = 0 ; k < criteria.length ; k++){
                    output.print(score[i][j][k] + "\t");
                    count++;
                    total += score[i][j][k];
                    
                    if(count % 5 == 0){
                        output.println(total);
                        total = 0;  
                    }
                }  
            }
            
            output.println();    
        }
        
    }
    // -----------------------------------------
    
    // 6# Method printWinnerAwardByEachDepartment().
    // Method to print winners from each department based on contest.
    public static void printWinnerAwardByEachDepartment(String[] department, String[][] studentsNames, String[] criteria, int[][][] score , PrintWriter output){
        for (int i = 0; i < department.length; i++){
            int max = -1;
            String topStudentName = "";
            int highestStudentScore = 0;
            boolean printNameStudentName = false;
            for (int j = 0; j < studentsNames[i].length; j++){
                int sum = 0;
                for (int k = 0; k < criteria.length; k++){
                    sum += score[i][j][k];
                }
                
                if (sum > max && !printNameStudentName){
                    max = sum;
                    topStudentName = studentsNames[i][j];
                    highestStudentScore = sum;
                }
            }
            output.println("The winner of the " + department[i] + " Department is " + topStudentName + " with total of " + highestStudentScore);
        }
        
    }
    // ----------------------------------------- 
    
    // 7# Method printFCITWinner().
    // Method to print the winner from each department based on contest criteria.
    public static void printFCITWinner(String[] department, String[][] studentsNames, String[] criteria, int[][][] score , PrintWriter output){
        String departmentName = "";
        String studentName = "";
        int highestScore = 0;
        for (int i = 0; i < studentsNames.length; i++){
            for (int j = 0; j < department.length; j++){
                int totalScore = 0;
                for (int k = 0; k < criteria.length; k++){
                    totalScore += score[i][j][k];
                }
                
                if (totalScore > highestScore){
                    highestScore = totalScore;
                    studentName = studentsNames[i][j];
                    departmentName = department[i];
                }
            }
        }
        output.println("The winner of FCIT is " + studentName + " from the " + departmentName + " Department with total of " + highestScore + "\n");

    }
    // -------------------------------------------------------------------------
    
    
}

    
    
   
