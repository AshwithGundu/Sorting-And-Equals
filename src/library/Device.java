/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import exceptions.NoFineException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Device represents a piece of mechanical or electronic equipment
 *
 * @author Ashwith Gundu
 */
public class Device extends Item {

    /**
     * Unique ID of Device
     */
    private String deviceID;
    /**
     * Rack number of device in the library
     */

    private String rackNo;

    /**
     * Initialize the variables of super class. Assigns generateUniqueID() to
     * deviceID and generateRackID() to rackNo
     *
     * @param title - title of Device
     */
    public Device(String title) {
        super(title);
        generateUniqueID();
    }

    /**
     * Calculates the fine a member needs to pay to the library in dollars.<br>
     * If return-date (dateTime2) is before due-date (dateTime1),
     * NoFineException is thrown with message "Return date is before due
     * date".<br> Else, If difference between hours is less than 1 then fine is
     * 0. <br>else if difference between hours is in between [1,5] then fine is
     * $5 <br>else if difference between hours is in between (5,10] then fine is
     * $10 <br> else fine is $50
     *
     * @param dateTime1 - Due date of an item in format "MM/dd/yyyy HH:mm:ss"
     * @param dateTime2 - Actual return date of an item in format "MM/dd/yyyy
     * HH:mm:ss"
     * @return double - Payable amount to library
     * @throws NoFineException - if return date(dateTime2) is less than due
     * date(dateTime1)
     */
    @Override
    public double calculateFine(String dateTime1, String dateTime2) throws NoFineException {
        Date c = new Date(dateTime1);//due date
        Date d = new Date(dateTime2);//return date
        if (d.before(c)) {
            throw new NoFineException("Return date is before due date");
        } else if (((d.getTime() / 3600000) - (c.getTime() / 3600000)) < 1) {
            return 0;
        } else if (((d.getTime() / 3600000) - (c.getTime() / 3600000)) >= 1 && ((d.getTime() / 3600000) - (c.getTime() / 3600000)) <= 5) {
            return 5;
        } else if (((d.getTime() / 3600000) - (c.getTime() / 3600000)) >= 6 && ((d.getTime() / 3600000) - (c.getTime() / 3600000)) <= 10) {
            return 10;
        } else {
            return 50;
        }
    }

    /**
     * This method generates rack identification number to keep the device at a
     * particular location in the library . <br>The rack ID is generated by
     * using the following algorithm. Beginning from the third character until
     * the end of the device title_D_length of the deviceID. <br>However, we can
     * have couple of exceptions.<br> If the first character is “I”, the rackID
     * would include the first character along with the given algorithm. <br>If
     * the second character is “p”, the rackID would include the second
     * character along with the given algorithm.
     *
     * <h3>Examples</h3>
     *
     * <table summary = "Examples" border ="1px">
     * <tr>
     * <th>Device Title</th>
     * <th>Rack ID</th>
     * </tr>
     * <tr>
     * <td>Device Title</td>
     * <td>droid Charager_D_7</td>
     * </tr>
     * <tr>
     * <td>Ifhone Charger</td>
     * <td>Ihone Charger_D_7</td>
     * </tr>
     * <tr>
     * <td>Phone</td>
     * <td>one_D_7</td>
     * </tr>
     * <tr>
     * <td>Ipfoen</td>
     * <td>Ipfoen_D_7</td>
     * </tr>
     * </table>
     *
     * @return - String rack Number of Device
     */
    @Override
    public String generateRackID() {
        String rackID;
        if (this.getTitle().charAt(0) == 'I') {
            rackID = this.getTitle();
        } else if (this.getTitle().charAt(1) == 'p') {
            rackID = this.getTitle().substring(1);
        } else {
            rackID = this.getTitle().substring(2);
        }
        return rackID + "_D_" + deviceID.length();
    }

    /**
     * This method concatenates LIBRARY_CODE, "_D_", counter and returns it.
     *
     * @return - String Unique ID of Device
     */
    @Override
    public String generateUniqueID() {
        deviceID = LIBRARY_CODE + "_D_" + counter;
        return deviceID;
    }

    /**
     * Invoke super.toString() and concatenate deviceID and rackNo.<br> For
     * example:<br>
     * Title: android charger, Available: false, DeviceID: NWM_D_3, RackNo:
     * droid charger_D_7
     *
     * @return - String representation of Device
     */
    @Override
    public String toString() {
        return "Title: " + this.getTitle().toLowerCase() + ", Available: " + this.isAvailable() + ", DeviceID: " + deviceID + ", RackNo: " + generateRackID();
    }
}