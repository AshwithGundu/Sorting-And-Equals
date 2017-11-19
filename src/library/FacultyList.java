/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import java.util.ArrayList;

/**
 * Faculty List represents a Collected set of faculties
 *
 * @author Ashwith Gundu
 */
public class FacultyList {

    ArrayList<Faculty> facultyList = new ArrayList<>();
    ArrayList<String> listOfNames = new ArrayList<>();

    /**
     * It is a constructor for facultyList
     */
    public FacultyList() {
    }

    /**
     * Returns the faculty list
     *
     * @return - String facultyList
     */
    public ArrayList<Faculty> getFacultyList() {
        return facultyList;
    }

    /**
     * Method that adds faculty to the facultyList
     *
     * @param faculty - faculty of the faculty member
     */
    public void addFaculty(Faculty faculty) {
        this.facultyList.add(faculty);
    }

    /**
     * Method adds names to the listOfNames
     *
     * @param name - name of the faculty argument to the addFacultyNames()
     */
    public void addFacultyNames(String name) {
        this.listOfNames.add(name);
    }

    /**
     * Overridden equals method.<br> This method checks the two FacultyList
     * objects by checking the list of faculty names in other list with the this
     * object list if both the lists are same then return true otherwise return
     * false
     *
     * @param obj - FacultyList object
     * @return - boolean either true or false
     */
    @Override
    public boolean equals(Object obj) {
        return obj == this;
    }

    /**
     * Prints the array list facultyList
     *
     * @return - String of faculty names
     */
    @Override
    public String toString() {
        String str = "";
        for (Faculty faculty : facultyList) {
            str = str + faculty;
        }
        return str;
    }

}
