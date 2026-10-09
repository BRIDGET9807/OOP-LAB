
import java.time.Year;
public class Car {
    String brand;
    int year;
    double mileage;

public Car( String brand, int year, double mileage){
    this.brand = brand;
    this.year = year;
    this.mileage= mileage;
}
public void display(){
    System.out.println("Brand: " + brand + "| Year:"+ year + "| Mileage: "+ mileage+ "km");

}
boolean isAntique(){
    return Year.now().getValue() - year > 25;

}
public static void main(String[] args){

    Car car1= new Car("Mercedes", 1999,1400.9);
    car1.display();
    System.out.println("Antique?" + car1.isAntique());


    Car car2 = new Car ("BMW", 2021, 1100.5);
    car2.display();
    System.out.println("Antique?" + car2 .isAntique());



    Car car3= new Car("Mazda", 2000, 5000.7);
    car3.display();
    System.out.println("Antique?" + car3.isAntique());
}
}   

    
