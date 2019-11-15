//**************************************************************************************************
// INTERFACE: Comparable (Comparable.java)
//
// DESCRIPTION
// Comparable is an interface to compare Student objects.
//
// COURSE AND PROJECT INFO
// CSE205 Object Oriented Programming and Data Structures, Fall B 2019
// Project Number: 2
//
// AUTHOR
// Kristin Brooks, krbrook7, krbrook7@asu.edu
//**************************************************************************************************

/**
 * Compares two Student objects
 */
public interface Comparable<Student> {
    int compareTo(Student student);
}