package Bike;

public class BikeSerialNumber {
    private String letterComponent;
    private int numberComponent;


    public BikeSerialNumber(String letterComponent,int numberComponent){
        this.letterComponent = letterComponent;
        this.numberComponent = numberComponent;

    }

    //each component is available to access
    public String getLetterComponent() {
        return letterComponent;
    }

    public int getNumberComponent() {
        return numberComponent;
    }

    @Override
    public String toString() {
        return  letterComponent +  numberComponent ;
    }

}
