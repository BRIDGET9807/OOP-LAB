

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
public static void main(String[] args){

    Car car1= new Car("Mercedes", 2020,1400.9);
    car1.display();
    Car car2 = new Car ("BMW", 2021, 1100.5);
    car2.display();
    Car car3= new Car("Mazda", 2006, 5000.7);
    car3.display();
}
}   

    
