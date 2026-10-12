class Address {
    String city;
    Address(String city) { this.city = city; }
}

class Person {
    String name;
    Address address;   
    Person(String name, Address address) { this.name = name; this.address = address; }
}

public class PersonAddressDemo {
    public static void main(String[] args) {
        Person p1 = new Person("Tariro", new Address("Harare"));
        System.out.println(p1.name + " lives in " + p1.address.city);  

        Person p2 = new Person("Farai", null);
        try {
            System.out.println(p2.address.city);  
        } catch (NullPointerException e) {
            System.out.println("NullPointerException: " + p2.name + " has no address");
        }

        // Safe version: check for null first
        String city = (p2.address != null) ? p2.address.city : "unknown";
        System.out.println("Safe lookup: " + city);
    }
}
