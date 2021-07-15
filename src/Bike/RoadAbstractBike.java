package Bike;

final class RoadAbstractBike extends AbstractBike {
    public static boolean ifRented;

    /**
     * @see AbstractBike#AbstractBike(BikeSerialNumber, String)
     */
    public RoadAbstractBike(BikeSerialNumber bikeSerialNumber,String biketype,boolean ifrented) {
        super(bikeSerialNumber,biketype);
        this.ifRented = ifrented;
    }





}
