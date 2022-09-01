import java.util.Scanner;

public class ConvertTemperatures {
    public static void main(String[] args) {
        double result;
        initialize();
        FahrenheitToTemp transformFahrenheitToTemp = new FahrenheitToTemp();
        CelsiusToTemp transformCelsiusToTemp = new CelsiusToTemp();
        KelvinToTemp transformKelvinToTemp = new KelvinToTemp();

        UnityTemp unityInput = getUnityTemp("entrada");
        UnityTemp unityOutput = getUnityTemp("saída");

        double temp = getTemp();
        System.out.println("Você vai transformar " + temp + " " + unityInput + " em " + unityOutput);


        switch (unityInput) {
            case CELSIUS:
                result = transformCelsiusToTemp.transform(unityOutput, temp);
                break;

            case FAHRENHEIT:
                result = transformFahrenheitToTemp.transform(unityOutput, temp);
                break;

            case KELVIN:
                result = transformKelvinToTemp.transform(unityOutput, temp);
                break;

            default:
                result = 0;
                break;
        }

        System.out.printf("O resultado da conversão é %f", result);
    }

    private static void initialize() {
        System.out.println("Bem vindo ao nosso conversor de temperaturas.");
    }
    private static UnityTemp getUnityTemp(String io) {
        Scanner input = new Scanner(System.in);
        System.out.println("Digite a unidade de temperatura de " + io);
        String typeString = input.nextLine();
        return UnityTemp.valueOf(typeString);
    }
    private static double getTemp() {
        Scanner input = new Scanner(System.in);
        System.out.println("Digite uma temperatura: ");
        return input.nextDouble();
    }

}