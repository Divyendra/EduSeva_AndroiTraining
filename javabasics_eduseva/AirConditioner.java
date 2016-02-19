package javabasics_eduseva;

/**
 * Created by Divyendra on 2/19/2016.
 */
public interface AirConditioner {
    //Methods in Interface are implicitly abstract, so 'abstract' keyword isn't necessary.
    public void increaseTemp();
    public void decreaseTemp();
    public void turnOn();
    public void turnOff();
    public int getTemperature();
}
