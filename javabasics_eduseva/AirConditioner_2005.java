package javabasics_eduseva;

/**
 * Created by Divyendra on 2/19/2016.
 */
public class AirConditioner_2005 implements AirConditioner {
    private boolean isON;
    protected int temperature;

    public void increaseTemp(){
        if (isON) temperature++;
    }

    public void decreaseTemp(){
        if (isON) temperature--;
    }

    public void turnOff(){
        changeStatus(false);  //Why not 'isON = false;' directly ??? We will come back
    }

    public void turnOn(){
        changeStatus(true);
        temperature = 25;  //Default temperature is 25 degree Celsius.
    }

    protected void changeStatus(boolean status) {
        isON = status;
    }

    public int getTemperature(){
        return temperature;
    }

}
