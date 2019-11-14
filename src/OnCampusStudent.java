//**************************************************************************************************
// CLASS: OnCampusStudent (OnCampusStudent.java)
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
public class OnCampusStudent extends Student {

    final static int RESIDENT = 1;
    final static int NON_RESIDENT = 2;
    private int resident;
    private double programFee;

    /**
     *
     */
    public OnCampusStudent (String id, String firstName, String lastName) {
        super(firstName, lastName, id);
    }

    /**
     *
     */
    @Override
    public void calcTuition() {
        double t;
        if (getResidency() == RESIDENT) {
            t = TuitionConstants.ONCAMP_RES_BASE;
        } else {
            t = TuitionConstants.ONCAMP_NONRES_BASE;
        }
        t = t + getProgramFee();
        if (getCredits() > TuitionConstants.MAX_CREDITS) {
            t = t + (getCredits() - TuitionConstants.MAX_CREDITS) * TuitionConstants.ONCAMP_ADD_CREDITS;
        }
        setTuition(t);
    }

    /**
     *
     */
    public double getProgramFee() {
        return programFee;
    }

    /**
     *
     */
    public int getResidency() {
        return resident;
    }

    /**
     *
     */
    public void setProgramFee(double programFee) {
        this.programFee = programFee;
    }

    /**
     *
     */
    public void setResidency(int resident) {
        this.resident = resident;
    }
}