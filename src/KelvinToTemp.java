public class KelvinToTemp {
    public double transform(UnityTemp type, double temp) {
        if (type == UnityTemp.FAHRENHEIT) {
            return (temp - 273.15) * 9/5 + 32;
        } else if(type == UnityTemp.CELSIUS) {
            return temp - 273.15;
        } else {
            return temp;
        }
    }
}
