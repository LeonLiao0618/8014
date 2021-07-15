package Person;


import Bike.BikeSerialNumber;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Year;
import java.util.Calendar;
import java.util.Date;

public class CustomerRecord implements Person{
    private Name name;
    private Date dateOfBirth;
    private String dob;
    private CustomerSerialNumber customerSerialNumber;
    private String CN ;
    private int issueYear;
    private boolean goldClass;
    public int age ;
    Calendar calendar = Calendar.getInstance();
    static SimpleDateFormat formatter   =   new SimpleDateFormat("yyyy-MM-dd");

    public CustomerRecord(Name name, String dob, boolean goldClass) throws ParseException {
        this.name = name;
        this.dateOfBirth = formatter.parse(dob);
        this.customerSerialNumber = new CustomerSerialNumber(name);
        this.CN = String.valueOf(customerSerialNumber.getCustomerNumber());
        this.issueYear = customerSerialNumber.getissueyear();
        this.goldClass = goldClass;
        this.age = calendar.YEAR - CustomerRecord.getYearOfDOB(dateOfBirth);//age = current year - birth year

    }

    /**
     * get the age
     * @return int age
     */
    public int getAge(){
        return age;
    }

    /**
     * get the year of Date dateOfBirth
     * @return int year
     */
    private static int getYearOfDOB(Date dateOfBirth){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateOfBirth);
        int year = calendar.get(Calendar.YEAR);
        return year;
    }

    /**
     * get status of "ifIsGoldClass"
     * @return goldClass
     */
    public boolean isGoldClass() {
        return goldClass;
    }

    @Override
    public String toString() {
        return "CustomerRecord:\n" +
                "1.Name: " + name + "\n" +
                "2.Date of birth: " + formatter.format(dateOfBirth) +  "\n" +
                "3.Customer number: " + customerSerialNumber + "\n" +
                "4.Issue year: " + issueYear + "\n" +
                "5.Glod class: " + goldClass + "\n" +
                "6.Age: " + age;
    }


    @Override
    public Name getName() {
        return null;
    }

    @Override
    public Date getDateOfBirth() {
        return null;
    }
}
