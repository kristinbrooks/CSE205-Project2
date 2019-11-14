//**************************************************************************************************
// CLASS: Student (Student.java)
//
// DESCRIPTION
// Student is an abstract class and is the superclass for the OnCampusStudent and OnlineStudent
// classes. Remember that in a class hierarchy, the superclass declares data and methods that are
// common to all types of students.
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
// The original file was the the pseudocode, method descriptions, and the compareTo method.
// The file was edited to add the rest of the code and remove the pseudocode.
//
// EDITED BY
// Kristin Brooks, krbrook7, krbrook7@asu.edu
//**************************************************************************************************
public abstract class Student implements Comparable<Student> {

    // Declare private instance data
    private int credits;
    private String firstName;
    private String lastName;
    private String id;
    private double tuition;

    /**
     * Student(String, String, String)
     *
     * Creates a Student object and initializes the id, firstName, and lastName instance variables by
     * calling the mutator methods.
     */
    public Student(String firstName, String lastName, String id) {
        setFirstName(firstName);
        setLastName(lastName);
        setId(id);
    }

    /**
     * abstract calcTuition()
     *
     * calcTuition() is to be implemented by subclasses of Student. Remember that abstract methods
     * are not implemented in a superclass but must either be implemented in a subclass, or if not,
     * then the subclass also becomes an abstract class. The reason calcTuition() is abstract
     * and intended to be implemented by the subclasses of Student is because how we calculate the
     * tuition for an OnCampusStudent is different than how we calculate the tuition for an Online-
     * Student.
     */
    public abstract void calcTuition();

    /**
     * The java.lang.Comparable<T> interface declares one method int compareTo(T obj) that must be
     * implemented by any class which implements the interface. This method is called from Sorter.
     * keepMoving() to compare the mId fields of two Students.
     *
     * Compares the mId fields of 'this' Student and pStudent. Returns -1 if this Student's mId
     * field is less than pStudent's mId field. Returns 0 if this Student's mId field is equal to
     * pStudent's mId field. Returns 1 if this Student's mId field is greater than pStudent's mId
     * field.
     *
     * Note that the mId field of a Student is a java.lang.String and String also implements the
     * Comparable<String> interface and consequently, also implements a compareTo() method to
     * compare two strings. Hence, all we have to do here is to call the String class compareTo()
     * method on the two mId strings of 'this' Student and pStudent and return whatever that method
     * returns.
     */
    @Override
    public int compareTo(Student student) {
        return getId().compareTo(student.getId());
    }

    /**
     * Accessor method for credits.
     */
    public int getCredits() {
        return credits;
    }

    /**
     * Accessor method for firstName.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Accessor method for id.
     */
    public String getId() {
        return id;
    }

    /**
     * Accessor method for lastName.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Accessor method for tuition.
     */
    public double getTuition() {
        return tuition;
    }

    /**
     * Mutator method for credits.
     */
    public void setCredits(int credits) {
        this.credits = credits;
    }

    /**
     * Mutator method for firstName.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Mutator method for id.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Mutator method for lastName.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Mutator method for tuition.
     */
    protected void setTuition() {
        this.tuition = tuition;
    }
}
