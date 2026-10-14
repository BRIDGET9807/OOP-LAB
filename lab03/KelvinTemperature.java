package lab03;
public class KelvinTemperature {
    private double kelvin;

    public KelvinTemperature(double kelvin) { setKelvin(kelvin); }

    public void setKelvin(double kelvin) {
        if (kelvin < 0) throw new IllegalArgumentException("Below absolute zero");
        this.kelvin = kelvin;
    }

    public double getCelsius()    { return kelvin - 273.15; }
    public double getFahrenheit() { return getCelsius() * 9 / 5 + 32; }

    public static void main(String[] args) {
        KelvinTemperature t = new KelvinTemperature(300);
        System.out.printf("%.2f C, %.2f F%n", t.getCelsius(), t.getFahrenheit());
        try {
            new KelvinTemperature(-5);
        } catch (IllegalArgumentException e) {
            System.out.println("Rejected: " + e.getMessage());
        }
    }
}
