package javabasics_eduseva;

/**
 * Created by Divyendra on 2/19/2016.
 */
public class AirConditioner_2015 extends AirConditioner_2005{
    @Override
    public void turnOn() {
        changeStatus(true);
        temperature = estimateSmartTemperature();
    }

    //New patented Smart Sensor Technology as the Advertisment claims.
    private int estimateSmartTemperature(){
        return (int) (10 + Math.random()*100%15);
    }

}
