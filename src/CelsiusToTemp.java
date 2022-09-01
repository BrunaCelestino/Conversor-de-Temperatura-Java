public class CelsiusToTemp {

    public double transform(UnityTemp type, double temp) {
        if (type == UnityTemp.FAHRENHEIT) {
            return (temp * 9/5) + 32;
        } else if(type == UnityTemp.KELVIN) {
            return temp + 273.15;
        } else {
            return temp;
        }
    }
}