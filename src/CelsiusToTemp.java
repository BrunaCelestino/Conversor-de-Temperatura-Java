public class CelsiusToTemp {

    public double transform(UnityTemp type, double temp) {
        if (type == UnityTemp.FAHRENHEIT || type == UnityTemp.F) {
            return (temp * 9/5) + 32;
        } else if(type == UnityTemp.KELVIN || type == UnityTemp.K) {
            return temp + 273.15;
        } else {
            return temp;
        }
    }
}