//**************************************************************************************************
// CLASS: Sorter
//
// DESCRIPTION
// Implements the insertion sort algorithm to sort an ArrayList<> of Students.
//
// COURSE AND PROJECT INFO
// CSE205 Object Oriented Programming and Data Structures, Fall B 2019
// Project Number: 2
//
// AUTHOR
// Kevin R. Burger (burgerk@asu.edu)
// Computer Science & Engineering Program
// Fulton Schools of Engineering
// Arizona State University, Tempe, AZ 85287-8809
//
// EDITED
// Changed some access levels and removed unused parts
//
// EDITED BY
// Kristin Brooks, krbrook7, krbrook7@asu.edu
//**************************************************************************************************
import java.util.ArrayList;

class Sorter {

    /**
     * Sorts pList into ascending order using the insertion sort algorithm.
     */
    static void insertionSort(ArrayList<Student> pList) {
        for (int i = 1; i < pList.size(); ++i) {
            for (int j = i; keepMoving(pList, j); --j) {
                swap(pList, j, j - 1);
            }
        }
    }

    /**
     * Returns true if we need to continue moving the element at pIndex until it reaches its
     * proper location.
     *
     * This method uses the ternary operator ?: which has this syntax:
     *
     *     (conditional-expression) ? true-expression : false-expression
     *
     * The behavior is that the conditional-expression is evaluated and it will be either true or
     * false. If the conditional-expression is true, then the expression (true-expression) following
     * the ? symbol is evaluated. If the conditional expression is false, then the expression
     * (false-expression) following the : symbol is evaluated. For example:
     *
     *     x = (a < b) ? 1 : 0;
     *
     * would compare a to see if it is less than b. If a < b is true, then 1 is assigned to x. If
     * a < b is false, then 0 would be assigned to x. Note that the ternary operator is just a
     * shorter way to write an if-else statement. The statement above could have been written as:
     *
     *     if (a < b) {
     *         x = 1;
     *     } else {
     *         x = 0;
     *     }
     *
     * Whether you prefer to write such code using an if-else statement or using the ternary
     * operator is a personal choice, but you will see other programmers using the ternary operator
     * so you should know how it works.
     */
    private static boolean keepMoving(ArrayList<Student> pList, int pIndex) {
        if (pIndex < 1) return false;
        Student after = pList.get(pIndex);
        Student before = pList.get(pIndex - 1);
        return after.compareTo(before) < 0;
    }

    /**
     *  Swaps the elements in pList at pIndex1 and pIndex2.
     */
    private static void swap(ArrayList<Student> pList, int pIndex1, int pIndex2) {
        Student temp = pList.get(pIndex1);
        pList.set(pIndex1, pList.get(pIndex2));
        pList.set(pIndex2, temp);
    }

}
