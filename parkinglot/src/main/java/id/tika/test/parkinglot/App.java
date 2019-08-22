package id.tika.test.parkinglot;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import id.tika.test.parkinglot.Car;

/**
 * Hello world!
 *
 */
public class App 
{
	static List<Car> parkingSlot = new ArrayList<Car>();
	static Scanner in = new Scanner(System.in); 
	
    public static void main( String[] args )
    {
        //System.out.println( "Hello World!" + args[0]);
    	System.out.println( "Hello GOJEK!!");
    	System.out.println("create total parking lot: ");
    	String name = in.nextLine();;
        defineParkingSlot(Integer.valueOf(name));       	
    	chooseMenu();
        
    }
    
    public static void defineParkingSlot (Integer totalSlot) {    	
    	for(int a=0; a<totalSlot; a++) {
    		Car park = new Car();
        	parkingSlot.add(park);
        }  	
    	System.out.println("Early Parking Slot "+parkingSlot.size());    	
    }
    
    public static void park (Car car) {    	
    	
    		String status ="FULL";
    		for(int x=0; x<parkingSlot.size(); x++) {
        		if(null == parkingSlot.get(x).getSlot()) {
        			car.setSlot((x+1));
        			parkingSlot.set(x, car);
        			status="PARKED";
        			System.out.println("Allocated slot number : "+(x+1));
        			break;
        		}
        	}
    		
    		if(status.equalsIgnoreCase("FULL")) {
    			System.out.println("sorry, parking lot is FULL");    			
    		}
    		
    		displayParkingLot();
    	
    }
    
    public static void leave (Integer slot) {   
    	System.out.println("---- "+parkingSlot.get(slot));
    	if(null != parkingSlot.get(slot).getSlot()) {
    		Car newCar = new Car();
        	parkingSlot.set(slot, newCar);
        	System.out.println("leave slot "+(slot+1));
    	} else {
    		System.out.println(slot+" is empty");
    	}
    	
    	displayParkingLot();
    }
    
    
    
    public static List<Car> findCarByColor (String color) {    	
    	List<Car> getCar = new ArrayList<Car>();
    	for(Car car : parkingSlot) {
    		if(color.equalsIgnoreCase(car.getColor())) {
    			getCar.add(car);
    		}
    	}    		
    	return getCar;
    }
    
    public static List<Car> findCarByNumberPlate (String numberPlate) {    	
    	List<Car> getCar = new ArrayList<Car>();
    	for(Car car : parkingSlot) {
    		if(numberPlate.equalsIgnoreCase(car.getNumberPlate())) {
    			getCar.add(car);
    		}
    	}    		
    	return getCar;
    }
    
    public static void chooseMenu () {    	
    	System.out.println("------------------------");
    	System.out.println("Menu: ");
    	System.out.println("1. Park: ");
    	System.out.println("2. Leave: ");
    	System.out.println("3. Get car by Color: ");
    	System.out.println("4. Get Car by Reg Numb: ");
    	System.out.println("------------------------");
    	System.out.println("Choose Menu: ");
    	String menu = in.nextLine();
    	System.out.println("------------------------");
    	
    	switch (menu) { 
        case "0": 
        	System.out.println("create total parking lot: ");
        	String name = in.nextLine();;
            defineParkingSlot(Integer.valueOf(name));        	
            break; 
        case "1": 
        	System.out.println("input car detail with format (numberPlate~color): ");
        	String carStr = in.nextLine();;
            String[] carSpt = carStr.split("\\~");        	
        	 Car car = new Car();
             car.setColor(carSpt[1]);
             car.setNumberPlate(carSpt[0]);
             park(car);  
     		chooseMenu();
            break; 
        case "2": 
        	System.out.println("input car slot: ");
        	String slot = in.nextLine();
        	leave(Integer.valueOf(slot)-1);   
    		chooseMenu();
            break; 
        case "3": 
        	System.out.println("get car by color");
            String color = in.nextLine();
            List<Car> cars = findCarByColor(color);
            if(null!= cars && cars.size()>0) {
            	System.out.println("car found");
            	for(Car c : cars) {
                	System.out.println("Slot No. "+c.getSlot()+" Reg Numb. "+c.getNumberPlate()+" color. "+c.getColor());
                }
            } else {
            	System.out.println("not found "+color);
            }
            chooseMenu();
            break; 
        case "4": 
        	System.out.println("get car by reg num");
            String regNum = in.nextLine();
            cars = findCarByNumberPlate(regNum);
            if(null!= cars && cars.size()>0) {
            	System.out.println("car found");
            	for(Car c : cars) {
                	System.out.println("Slot No. "+c.getSlot()+" Reg Numb. "+c.getNumberPlate()+" color. "+c.getColor());
                }
            } else {
            	System.out.println("not found "+regNum);
            }
            chooseMenu();
            break;          
        default: 
            //dayString = "Invalid day"; 
        	System.out.println("no menu"); 
            break; 
        }     	
    	
    }
    
    public static void displayParkingLot() {
    	for(Car c : parkingSlot) {
			if(null != c.getSlot()) {
				System.out.println("Slot No. "+c.getSlot()+" Reg Numb. "+c.getNumberPlate()+" color. "+c.getColor());
			}
    	}
    }
}
