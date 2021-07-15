package Bike;

import Person.CustomerRecord;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

// abstract class providing partial implementation of Bike
abstract class AbstractBike implements Bike{


    private BikeSerialNumber bikeSerialNumber;
    private int bikenumber;
    public String biketype;
    public static boolean ifrented;

     AbstractBike(BikeSerialNumber bikeSerialNumber,String biketype) {
         this.bikeSerialNumber = bikeSerialNumber;
         this.biketype = biketype;
    }

    /**
     * @see Bike#getBikeType()
     */
    public String getBikeType(){
        return biketype;
    }

    /**
     * @see Bike#setIfRented(boolean)
     */
    public void setIfRented(boolean ifRented) {
        AbstractBike.ifrented = ifrented;
    }
    public BikeSerialNumber getserialNumber(BikeSerialNumber BSN) {
        return BSN;
    }

    /**
     * @see Bike#rentedCheck()
     */
    public boolean rentedCheck() {
        if(ifrented){
            return false;
        }
        else return true;

    }

    @Override
    public String toString() {
        return "BikeSerialNumber: " + bikeSerialNumber + "\nBiketype :" + biketype ;
    }

}
