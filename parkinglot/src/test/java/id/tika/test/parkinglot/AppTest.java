package id.tika.test.parkinglot;

import java.util.List;

import id.tika.test.parkinglot.App;
import id.tika.test.parkinglot.AppTest;
import id.tika.test.parkinglot.Car;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
	/**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    	// define parking space
    	App.defineParkingSlot(6); 
        // define input 
        // park for 6 cars
        Car car = new Car();
        car.setColor("White");
        car.setNumberPlate("KA-01-HH-1234");
        App.park(car);        
        
        car = new Car();
        car.setColor("White");
        car.setNumberPlate("KA-01-HH-9999");
        App.park(car);  
        
        car = new Car();
        car.setColor("Black");
        car.setNumberPlate("KA-01-BB-0001");
        App.park(car);  
        
        car = new Car();
        car.setColor("Red");
        car.setNumberPlate("KA-01-HH-7777");   
        App.park(car);  
        
        car = new Car();
        car.setColor("Blue");
        car.setNumberPlate("KA-01-HH-2701");   
        App.park(car);  
        
        car = new Car();
        car.setColor("Black");
        car.setNumberPlate("KA-01-HH-3141");   
        App.park(car);          
        
        
        //4th leave
        App.leave(4);
        
        //find car with color white
        System.out.println("get car by color");
        String color = "white";
        List<Car> cars = App.findCarByColor(color);
        if(null!= cars && cars.size()>0) {
        	System.out.println("car found");
        	for(Car c : cars) {
            	System.out.println("Slot No. "+c.getSlot()+" Reg Numb. "+c.getNumberPlate()+" color. "+c.getColor());
            }
        } else {
        	System.out.println("not found "+color);
        }
        

        //find car with Reg Numb KA-01-HH-3141
        System.out.println("get car by reg num");
        String regNum = "KA-01-HH-3141";
        cars = App.findCarByNumberPlate(regNum);
        if(null!= cars && cars.size()>0) {
        	System.out.println("car found");
        	for(Car c : cars) {
            	System.out.println("Slot No. "+c.getSlot()+" Reg Numb. "+c.getNumberPlate()+" color. "+c.getColor());
            }
        } else {
        	System.out.println("not found "+color);
        }
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
    
}
