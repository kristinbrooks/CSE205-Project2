//**************************************************************************************************
// CLASS: OnlineStudent (OnlineStudent.java)
//
// DESCRIPTION
// Defines the students who attend school on campus. It is a subclass of Student.
//
// COURSE AND PROJECT INFO
// CSE205 Object Oriented Programming and Data Structures, Fall B 2019
// Project Number: 2
//
// AUTHOR
// Kristin Brooks, krbrook7, krbrook7@asu.edu
//**************************************************************************************************
public class OnlineStudent extends Student {

    private boolean techFee;

    /**
     * Constructs an online student object using its superclass constructor.
     */
    public OnlineStudent(String id, String firstName, String lastName) {
        super(firstName, lastName, id);
    }

    /**
     * Overrides calcTuition from Main to have implementation specific to an online student.
     */
    @Override
    public void calcTuition() {
        double t = getCredits() * TuitionConstants.ONLINE_CREDIT_RATE;
        if (getTechFee()) {
            t = t + TuitionConstants.ONLINE_TECH_FEE;
        }
        setTuition(t);
    }

    /**
     * Accessor for techFee
     */
    public boolean getTechFee() {
        return techFee;
    }

    /**
     * Mutator for techFee
     */
    public void setTechFee(boolean techFee) {
        this.techFee = techFee;
    }
}