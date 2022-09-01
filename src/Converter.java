import java.util.Scanner;

public class Converter {

    public static void main(String[] args) {
        double result;
        initialize();
        FahrenheitToTemp transformFahrenheitToTemp = new FahrenheitToTemp();
        CelsiusToTemp transformCelsiusToTemp = new CelsiusToTemp();
        KelvinToTemp transformKelvinToTemp = new KelvinToTemp();

        UnityTemp unityInput = getUnityTemp("entrada");
        UnityTemp unityOutput = getUnityTemp("saída");
        double temp = getTemp();

        if(unityInput == UnityTemp.CELSIUS) {
            result = transformCelsiusToTemp.transform(unityOutput, temp);

        } else if(unityInput == UnityTemp.FAHRENHEIT) {
            result = transformFahrenheitToTemp.transform(unityOutput, temp);

        } else if(unityInput == UnityTemp.KELVIN) {
            result = transformKelvinToTemp.transform(unityOutput, temp);

        } else {
            result = 0;
        }
        System.out.printf(temp + " " + unityInput + " é "  + " = " + result + " " + unityOutput);
    }

    private static void initialize() {
        System.out.println("Bem-vindo ao conversor de temperaturas: KELVIN, CELSIUS e FAHRENHEIT");
    }
    private static UnityTemp getUnityTemp(String io) {
        Scanner input = new Scanner(System.in);
        System.out.println("Digite a unidade de temperatura de " + io);
        String typeString = input.nextLine().toUpperCase();
        return UnityTemp.valueOf(typeString);
    }
    private static double getTemp() {
        Scanner input = new Scanner(System.in);
        System.out.println("Digite uma temperatura: ");
        return input.nextDouble();
    }

}