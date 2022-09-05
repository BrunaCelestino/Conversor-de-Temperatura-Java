public class FahrenheitToTemp {
    public double transform(UnityTemp type, double temp) {
        if (type == UnityTemp.CELSIUS || type == UnityTemp.C) {
            return (temp - 32) * 5/9;
        } else if(type == UnityTemp.KELVIN || type == UnityTemp.K) {
            return (temp - 32) * 5/9 + 273.15;
        } else {
            return temp;
        }

    }
}