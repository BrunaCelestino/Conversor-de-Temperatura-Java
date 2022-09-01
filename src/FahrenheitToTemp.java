public class FahrenheitToTemp {
    public double transform(UnityTemp type, double temp) {
        if (type == UnityTemp.CELSIUS) {
            return (temp - 32) * 5/9;
        } else if(type == UnityTemp.KELVIN) {
            return (temp - 32) * 5/9 + 273.15;
        } else {
            return temp;
        }

    }
}