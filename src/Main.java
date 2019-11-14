//**************************************************************************************************
// CLASS: Main
//
// DESCRIPTION
// The Main class for Project 2.
//
// COURSE AND PROJECT INFO
// CSE205 Object Oriented Programming and Data Structures, Fall B 2019
// Project Number: 2
//
// AUTHOR
// Kevin R. Burger (burgerk@asu.edu)
// Computer Science & Engineering
// School of Computing, Informatics, and Decision Systems Engineering
// Fulton Schools of Engineering
// Arizona State University, Tempe, AZ 85287-8809
//
// EDITED
// The original file was the the pseudocode and method descriptions. The file was edited to add
// the code and remove the pseudocode.
//
// EDITED BY
// Kristin Brooks, krbrook7, krbrook7@asu.edu
//**************************************************************************************************
import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    /**
     * Instantiate a Main object and call run() on the object. Note that essentially now,
     * run() becomes the starting point of execution for the program.
     */
    public static void main(String[] args) {
        Main main = new Main();
        main.run();
    }

    /**
     * Calls other methods to implement the sw requirements.
     */
    private void run() {
        ArrayList<Student> studentList = null;
        try {
            studentList = readFile();
        } catch (FileNotFoundException noInputFile) {
            System.out.println("Sorry, could not open 'p02-students.txt' for reading. Stopping.");
            System.exit(-1);
        }
        calcTuition(studentList);
        Sorter.insertionSort(studentList, Sorter.SORT_ASCENDING);
        try {
            writeFile(studentList);
        } catch (FileNotFoundException noOutputFile) {
            System.out.println("Sorry, could not open 'p02-tuition.txt' for writing. Stopping.");
            System.exit(-1);
        }
    }

    /**
     * Calculates the tuition for each Student in pStudentList. Write an enhanced for loop that
     * iterates over each Student in pStudentList. For each Student, call calcTuition() on that
     * Student object. Note: this is a polymorphic method call. What does that mean?
     */
    private void calcTuition(ArrayList<Student> studentList) {
        for (Student student : studentList) {
            student.calcTuition();
        }
    }

    /**
     * Reads the student information from "p02-students.txt" and returns the list of students as
     * an ArrayList<Student> object. Note that this method throws FileNotFoundException if the
     * input file could not be opened. The exception is caught and handled in run().
     */
    private ArrayList<Student> readFile() throws FileNotFoundException {
        ArrayList<Student> studentList = new ArrayList<>();
        Scanner input = new Scanner(new File ("src/p02-students.txt"));
        while (input.hasNext()) {
            String studentType = input.next();
            if (studentType.equals("C")) {
                studentList.add(readOnCampusStudent(input));
            } else {
                studentList.add(readOnlineStudent(input));
            }
        }
        input.close();
        return studentList;
    }

    /**
     * Reads the information for an on-campus student from the input file.
     */
    private OnCampusStudent readOnCampusStudent(Scanner input) {
        String id = input.next();
        String lastName = input.next();
        String firstName = input.next();
        OnCampusStudent onCampusStudent = new OnCampusStudent(id, firstName, lastName);
        String res = input.next();
        double fee = input.nextDouble();
        int credits = input.nextInt();
        if (res.equals("R")) {
            onCampusStudent.setResidency(OnCampusStudent.RESIDENT);
        } else {
            onCampusStudent.setResidency(OnCampusStudent.NON_RESIDENT);
        }
        onCampusStudent.setProgramFee(fee);
        onCampusStudent.setCredits(credits);
        return onCampusStudent;
    }

    /**
     * Reads the information for an online student from the input file.
     */
    private OnlineStudent readOnlineStudent(Scanner input) {
        String id = input.next();
        String lastName = input.next();
        String firstName = input.next();
        OnlineStudent onlineStudent = new OnlineStudent(id, firstName, lastName);
        String fee = input.next();
        int credits = input.nextInt();
        if (fee.equals("T")) {
            onlineStudent.setTechFee(true);
        } else {
            onlineStudent.setTechFee(false);
        }
        onlineStudent.setCredits(credits);
        return onlineStudent;
    }

    /**
     * Writes the output to "p02-tuition.txt" per the software requirements. Note that this method
     * throws FileNotFoundException if the output file could not be opened. The exception is caught
     * and handled in run().
     */
    private void writeFile(ArrayList<Student> studentList) throws FileNotFoundException {
        PrintWriter output = new PrintWriter("src/p02-tuition.txt");
        for (Student student : studentList) {
            output.printf("%-16s%-20s%-15s%8.2f", student.getId(), student.getLastName(),
                    student.getFirstName(), student.getTuition());
            output.println();
        }
        output.close();
    }
}
