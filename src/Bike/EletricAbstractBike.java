package Bike;

final class EletricAbstractBike extends AbstractBike {
    private boolean ifcharged;
    public static boolean ifrented;

    /**
     * @see AbstractBike#AbstractBike(BikeSerialNumber, String)
     */
    public EletricAbstractBike(BikeSerialNumber bikeSerialNumber,String biketype,boolean ifrented,boolean ifcharged) {
        super(bikeSerialNumber,biketype);
        this.ifrented = ifrented;
        this.ifcharged = ifcharged;
    }

    /**
     * check the battery status of electric bike
     */
    public boolean electricBatteryCheck(boolean ifcharged) {
        return ifcharged;
    }

    /**
     * @param ifcharged is ture when customer return the bike, representing the battery is charged
     */
    public boolean electricBatteryRecharge(boolean ifcharged){
        return ifcharged = true;
    }


}
