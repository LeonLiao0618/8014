package Person;

import java.util.Calendar;
import java.util.Random;

public class CustomerSerialNumber {

    private CustomerSerialNumber customerSerialNumber;

    //part one of the customerSerialNumber
    private char firstLetter;
    private char lastLetter;
    private String abbr;


    //part two of the customerSerialNumber
    private int issueyear;
    Calendar calendar=Calendar.getInstance();


    //part third of the customerSerialNumber
    Random ran = new Random();//use random number to create the last part of SerialNumber
    int serialNumber1 ;
    int serialNumber2 ;

    public CustomerSerialNumber(Name name) {
        this.firstLetter = name.getFirstLetter(name);
        this.lastLetter = name.getSecondLetter(name);
        this.abbr = String.valueOf(firstLetter + lastLetter);
        this.issueyear = calendar.get(Calendar.YEAR);//get issueYear from the calender
        this.serialNumber1 = ran.nextInt(10);
        this.serialNumber2 = ran.nextInt(10);
    }

    /**
     * get the customer serial number
     * @return customerSerialNumber
     */
    public CustomerSerialNumber getCustomerNumber(){
        return customerSerialNumber;
    }

    /**
     * get the year of issue
     * @return issueYear
     */
    public int getissueyear() {
        return issueyear;
    }

    /**
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (!(obj instanceof CustomerSerialNumber))
            return false;

        final CustomerSerialNumber customerSerialNumber = (CustomerSerialNumber) obj;

        // non-null at construction, no need to check here
        return abbr.equals(customerSerialNumber.abbr)
                && issueyear == (customerSerialNumber.issueyear)
                && serialNumber1 == (customerSerialNumber.serialNumber1)
                && serialNumber2 == (customerSerialNumber.serialNumber2);
    }


    /**
     * override method from code sample
     */
    @Override
    public int hashCode() {
        int hc = 17;

        hc = 37 * hc + String.valueOf(customerSerialNumber).hashCode();

        return 37 * hc + String.valueOf(customerSerialNumber).hashCode();
    }

    @Override
    public String toString(){
        return String.valueOf(firstLetter) + String.valueOf(lastLetter) + "-" + issueyear + "-" + serialNumber1 + serialNumber2;
    }


}
