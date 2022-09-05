public class KelvinToTemp {
    public double transform(UnityTemp type, double temp) {
        if (type == UnityTemp.FAHRENHEIT || type == UnityTemp.F) {
            return (temp - 273.15) * 9/5 + 32;
        } else if(type == UnityTemp.CELSIUS || type == UnityTemp.C) {
            return temp - 273.15;
        } else {
            return temp;
        }
    }
}
