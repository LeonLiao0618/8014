package Bike;

public interface Bike {
     /**
      * define global variable ELETRICBIKE and ROADBIKE
      */
     public static final String ELETRICBIKE = "electric";
     public static final String ROADBIKE = "roadBike";

     /**
      * set status of the bike
      * @param ifRented  ture if it's rented, false if not rented
      */
     void setIfRented(boolean ifRented);

     /**
      * check the Rented status of a bike
      * @return ture if not rented
      * @return false if rented
      */
     boolean rentedCheck();

     /**
      * get the bike type of a bike
      * @return String "electric" or "roadBike"
      */
     String getBikeType();


}
