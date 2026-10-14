/** Exercise 2: Animal[] with polymorphic sound(). */
abstract class Animal {
    abstract String sound();
}
class Cat  extends Animal { String sound() { return "Meow"; } }
class Cow  extends Animal { String sound() { return "Moo"; } }
class Duck extends Animal { String sound() { return "Quack"; } }

public class AnimalSounds {
    public static void main(String[] args) {
        Animal[] zoo = { new Cat(), new Cow(), new Duck() };
        for (Animal a : zoo) {
            System.out.println(a.getClass().getSimpleName() + ": " + a.sound());
        }
    }
}
