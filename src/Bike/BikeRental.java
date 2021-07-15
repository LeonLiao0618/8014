package Bike;


import Person.CustomerRecord;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BikeRental {


    public static final String ELETRICBIKE = "electric";
    public static final String ROADBIKE = "roadBike";

    //store the bike
    //key: BikeSerialNumber
    //value: Bike
    public static final Map<BikeSerialNumber, Bike> bikeHashMap = new HashMap<BikeSerialNumber, Bike>();

    //store the SerialNumber of each bike
    public static final ArrayList<BikeSerialNumber> bikeSerialNumberList = new ArrayList<>();

    //store the rental Relationship between customer and bike
    //key: CustomerRecord
    //value: Bike
    public static Map<CustomerRecord, Bike> rentalRelationship = new HashMap<CustomerRecord, Bike>();


    /**
     * initialize the Bike: electric bike 10, road bike 50
     */
    public void setBike(String biketype, int bikenumber){
        int n;
        int NC;
        BikeSerialNumber BN;
        boolean ifrented = false;

        if (bikenumber<0){
            throw new IllegalArgumentException("invalid bike number: " + bikenumber);
        }

        if (biketype.equals(ROADBIKE)){
            String LC = "RB";
            for (n = 0, NC = 100; n < bikenumber; n++){
                NC = NC + n;
                BN = new BikeSerialNumber(LC,NC);
                Bike bike = new RoadAbstractBike(BN,biketype,ifrented);
                bikeHashMap.put(BN,bike);
                bikeSerialNumberList.add(BN);
            }
        }
        else if (biketype.equals(ELETRICBIKE)){
            String LC = "EB";
            boolean ifcharged = true;
            for (n = 0, NC = 100; n < bikenumber; n++) {
                NC = NC + n;
                BN = new BikeSerialNumber(LC, NC);
                Bike bike = new EletricAbstractBike(BN, biketype, ifrented, ifcharged);
                bikeHashMap.put(BN, bike);
                bikeSerialNumberList.add(BN);
            }
        }

    }

    /**
     * get the bike with exist CustomerRecord from whom rented this bike
     */
    public  Bike getBike(CustomerRecord CR) {
        if (!rentalRelationship.containsKey(CR)){
            throw new IllegalArgumentException("this costumer have not rented any bike");
        }
        else {
            return rentalRelationship.get(CR);

        }
    }

    /**
     * provide bike type to get the bikes which are currently available to be rented
     * @return ArrayList availableBikeList
     */
    public static ArrayList availableBikes(String bikeType){

        ArrayList<Bike> availableBikeList = new ArrayList<Bike>();

        for (int n =0; n < bikeSerialNumberList.size(); n++){
            if (bikeHashMap.get(bikeSerialNumberList.get(n)).getBikeType() == bikeType){
                if (bikeHashMap.get(bikeSerialNumberList.get(n)).rentedCheck()) {
                    availableBikeList.add(bikeHashMap.get(bikeSerialNumberList.get(n)));

                }
            }

        }

        return availableBikeList;

    }

    /**
     * get the bikes which are currently rented
     * @return ArrayList rentedBikes
     */
    public ArrayList getRentedBikes(){
        ArrayList<Bike> rentedBikes = new ArrayList<Bike>();

        for (int n =0; n < bikeSerialNumberList.size(); n++){
            if (bikeHashMap.get(bikeSerialNumberList.get(n)).rentedCheck() == false){
                rentedBikes.add(bikeHashMap.get(bikeSerialNumberList.get(n)));
            }

        }

        return rentedBikes;

    }

    /**
     * provide customerRecord and bike type
     * rent an available bike to a customer who meet the requirement
     * requirement: exist customerRecord, age 21 if rent an electric bike,exist available bike of each type
     * @throws IllegalArgumentException if the requirement is not meet
     */
    public void issueBike(CustomerRecord CR,String bikeType){

        if (!rentalRelationship.containsKey(CR)){
            if (bikeType == "roadBike"){
                if (BikeRental.availableBikes(bikeType).size() > 0){
                    ArrayList<Bike> temp = BikeRental.availableBikes(bikeType);
                    Bike bike = temp.get(0);
                    rentalRelationship.put(CR,bike);
                    bike.setIfRented(true);
                    System.out.println("rent RB successful");
                }
                else {
                    throw new IllegalArgumentException("no valid road bike " );
                }
            }

            else if (bikeType == "electric"){
                if (CR.isGoldClass()) {
                    if (CR.getAge() >= 21){
                        if (BikeRental.availableBikes(bikeType).size() > 0) {
                            ArrayList<Bike> temp = BikeRental.availableBikes(bikeType);
                            Bike bike = temp.get(0);
                            rentalRelationship.put(CR, bike);
                            bike.setIfRented(true);
                            System.out.println("rent EB successful");
                        } else {
                            throw new IllegalArgumentException("no valid electric bike ");
                        }
                    }
                    else {
                        throw new IllegalArgumentException("costumer under 21 years old" );
                    }
                }
                else {
                    throw new IllegalArgumentException("no a gold class" );
                }

            }


            else {
                throw new IllegalArgumentException("invalid bike type " + bikeType);
            }

        }

        else {
            throw new IllegalArgumentException("no valid bike of this type: " + bikeType);
        }
    }

    /**
     * provide customerRecord to terminate the rental
     * remove the rental relationship from Map<CustomerRecord, Bike> rentalRelationship
     */
    public void terminateRental(CustomerRecord CR){
        if (!rentalRelationship.containsKey(CR)){
            throw new IllegalArgumentException("this costumer have not rented any bike");
        }
        else {
            rentalRelationship.get(CR).setIfRented(false);
            rentalRelationship.remove(CR);
            System.out.println("terminate successfully");
        }
    }

    //for testing
    public  Map<BikeSerialNumber, Bike> getBikeHashMap() {
        return bikeHashMap;
    }

    public  ArrayList<BikeSerialNumber> getBikeSerialNumberList() {
        return bikeSerialNumberList;
    }

    public  Map<CustomerRecord, Bike> getRentalRelationship() {
        return rentalRelationship;
    }
}
