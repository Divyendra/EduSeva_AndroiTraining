package javabasics_eduseva;

/**
 * Created by Divyu on 2/19/2016.
 */
public class Customer {
    public static void main(String[] args) {
        //2005 edition
        AirConditioner airConditioner = new AirConditioner_2005();
        airConditioner.turnOn();
        printTemperature(airConditioner);
        airConditioner.increaseTemp();
        airConditioner.increaseTemp();
        airConditioner.decreaseTemp();
        printTemperature(airConditioner);
        airConditioner.turnOff();

        //2015 edition
        airConditioner = new AirConditioner_2015();
        airConditioner.turnOn();
        printTemperature(airConditioner);

    }

    public static void printTemperature(AirConditioner airConditioner){
        System.out.println("Temp is : " + airConditioner.getTemperature());
    }
}
