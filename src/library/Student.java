/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import enums.Limit;
import exceptions.InvalidNumberOfCourses;

/**
 * A person who is studying at a school or college.
 *
 * @author Ashwith Gundu
 */
public class Student extends Member {

    /**
     * Courses taken by a student in a semester.
     */
    private String coursesTaken;

    /**
     * Initializes the variables of this class and the super class. Initialize
     * the Item array with itemLimit as its size from Limit enum and set it to
     * the items of the super class.
     *
     * @param coursesTaken - Courses taken by student
     * @param age - Age of the student
     * @param name - Name of the student
     */
    public Student(String coursesTaken, int age, String name) {
        super(name, age);
        this.coursesTaken = coursesTaken;
        this.setItems(new Item[Limit.Student.getItemLimit()]);
    }

    /**
     * This method returns true if the number of courses taken by a student is
     * less than or equal to 3. Else, throw InvalidNumberOfCourses exception
     *
     * @return boolean
     * @throws InvalidNumberOfCourses - If number of courses taken is greater
     * than 3
     */
    public boolean checkCoursesTaken() throws InvalidNumberOfCourses {
        String[] NumberOfCourses = coursesTaken.split(",");
        if (NumberOfCourses.length <= 3) {
            return true;
        } else {
            throw new InvalidNumberOfCourses();
        }
    }

    @Override
    public int compareTo(Member t) {
        if (Integer.parseInt(this.getMemberID()) < Integer.parseInt(t.getMemberID())) {
            return -1;
        } else if (Integer.parseInt(this.getMemberID()) == Integer.parseInt(t.getMemberID())) {
            return 0;
        } else {
            return 1;
        }
    }

    /**
     * Invoke super.toString() and concatenate the coursesTaken
     *
     * @return - String representation of Student in the given format. <br>For
     * example: <br>MemberID: 919649853 <br>Name: John Snow <br>Age: 19
     * <br>Title: THE HUNGER GAMES, Available: false, BookID: NWM_B_1, RackNo:
     * SH.1.2011, Edition: 2.0, Authors: Arml, D. L., Tan, P., Teck, T.<br>
     * Title: THE GIVER, Available: false, BookID: NWM_B_2, RackNo: GY.2.2010,
     * Edition: 4.0, Authors: Sierra, K., Goss, J., tek, L.<br> Title: android
     * charger, Available: false, DeviceID: NWM_D_3, RackNo: droid Charger_D_7
     * Courses Taken: HCI,Android,IOS
     */
    @Override
    public String toString() {
        return super.toString() + "\nCourses Taken: " + this.coursesTaken;
    }

}
