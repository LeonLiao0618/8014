import Bike.BikeRental;
import Person.CustomerRecord;
import Person.Name;

import java.text.ParseException;
import java.util.Date;

public class test {
    public static void main(String[]args) throws ParseException {
        BikeRental bikeRental = new BikeRental();
        bikeRental.setBike("electric",10);
        bikeRental.setBike("roadBike",50);
        System.out.println(bikeRental.getBikeHashMap().size());
        System.out.println(bikeRental.getBikeHashMap().get(bikeRental.getBikeSerialNumberList().get(2)));
        System.out.println(bikeRental.getBikeSerialNumberList().size());
        System.out.println(bikeRental.getBikeSerialNumberList().get(2));
        System.out.println(bikeRental.getBikeSerialNumberList().get(36));
        System.out.println(bikeRental.getRentalRelationship().size());

        CustomerRecord a = new CustomerRecord(new Name("David","Tennet"), "1984-05-30",true);
        CustomerRecord b = new CustomerRecord(new Name("Leon","Liao"), "1994-04-21",false);
        CustomerRecord c = new CustomerRecord(new Name("louie","Francisco"), "1975-07-16",false);
        CustomerRecord d = new CustomerRecord(new Name("Charlotte","Bird"), "2001-04-1",true);
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);

        int numberOfElectricBike = bikeRental.availableBikes("electric").size();
        int numberOfRoadBike = bikeRental.availableBikes("roadBike").size();
        System.out.println("current numberOfElectricBike:" + numberOfElectricBike);
        System.out.println("current numberOfRoadBike:" + numberOfRoadBike);

        bikeRental.issueBike(a,"electric");
        bikeRental.issueBike(b,"roadBike");
        bikeRental.issueBike(c,"roadBike");
        bikeRental.issueBike(d,"electric");

        int numberOfElectricBike1 = bikeRental.availableBikes("electric").size();
        int numberOfRoadBike1 = bikeRental.availableBikes("roadBike").size();
        System.out.println("current numberOfElectricBike:" + numberOfElectricBike1);
        System.out.println("current numberOfRoadBike:" + numberOfRoadBike1);

        System.out.println(bikeRental.getRentedBikes());
        bikeRental.getBike(a);
        bikeRental.getBike(b);

        bikeRental.issueBike(a,"electric");
        bikeRental.issueBike(c,"electric");

        bikeRental.terminateRental(a);
        bikeRental.issueBike(a,"electric");


    }
}
