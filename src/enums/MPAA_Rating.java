/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enums;

/**
 * This enum contains Motion Picture Association of America(MPAA) rating
 * description and age restriction for DVD
 *
 * @author Ashwith Gundu
 */
public enum MPAA_Rating {

    /**
     * Rating description is "General Audiences" and age restriction value 0
     */
    G(0),
    /**
     * Rating description is "Adults Only" and age restriction value 18
     */
    NC_17(18),
    /**
     * Rating description is "Parental Guidance Suggested" and age restriction
     * value 12
     */
    PG(12),
    /**
     * Rating description is "Parents Strongly Cautioned" and age restriction
     * value 13
     */
    PG_13(13),
    /**
     * Rating description is "Restricted" and age restriction value 17
     */
    R(17);

    private final int age;
    private String description;

    private MPAA_Rating(int age) {
        this.age = age;
    }

    /**
     * This getter method is used to access the age restriction
     *
     * @return - int This returns age restriction
     */
    public int getAge() {
        return age;
    }

    /**
     * This getter method is used to access the rating description
     *
     * @return int This returns rating description
     */
    public String getDescription() {
        return description;
    }
}
