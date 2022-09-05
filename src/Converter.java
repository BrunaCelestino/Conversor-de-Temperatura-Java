import java.util.Scanner;

public class Converter {

    public static void main(String[] args) {
        try {
            initialize();
            getTemp();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            main(null);
        }
    }

    private static void initialize() {
        System.out.println(" ______________________________________________________________________");
        System.out.println("|                                                                      |");
        System.out.println("|                Bem-vindo ao conversor de temperaturas                |");
        System.out.println("|______________________________________________________________________|");
        System.out.println(" ______________________________________________________________________");
        System.out.println("|                                                                      |");
        System.out.println("|                                 MENU                                 |");
        System.out.println("|______________________________________________________________________|");
        System.out.println("|                                                                      |");
        System.out.println("|                           Opção C - CELSIUS                          |");
        System.out.println("|                           Opção F - FAHRENHEIT                       |");
        System.out.println("|                           Opção K - KELVIN                           |");
        System.out.println("|______________________________________________________________________|");

    }

    private static UnityTemp getUnityTemp(String io) {
        try {
            Scanner input = new Scanner(System.in);
            System.out.println(" ______________________________________________________________________");
            System.out.println("|                                                                      |");
            System.out.println("               Digite a unidade de temperatura de " + io);
            System.out.println(" ______________________________________________________________________ ");
            String typeString = input.nextLine().toUpperCase();

            return UnityTemp.valueOf(typeString);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            System.err.println("Unidade de temperatura inválida, tente novamente");
            return getUnityTemp(io);
        }
    }


    private static void getTemp() {
        try {
            FahrenheitToTemp transformFahrenheitToTemp = new FahrenheitToTemp();
            CelsiusToTemp transformCelsiusToTemp = new CelsiusToTemp();
            KelvinToTemp transformKelvinToTemp = new KelvinToTemp();

            UnityTemp unityInput = getUnityTemp("entrada");
            UnityTemp unityOutput = getUnityTemp("saída");

            Scanner input = new Scanner(System.in);

            System.out.println(" ______________________________________________________________________");
            System.out.println("|                                                                      |");
            System.out.println("|               Digite a quantidade de temperaturas                    |");
            System.out.println(" ______________________________________________________________________ ");
            int degree = input.nextInt();


            double temp;
            double result;
            double average = 0;
            double averageResult = 0;

            if (unityInput == UnityTemp.C) {
                unityInput = UnityTemp.CELSIUS;
            } else if (unityInput == UnityTemp.F) {
                unityInput = UnityTemp.FAHRENHEIT;
            } else if (unityInput == UnityTemp.K) {
                unityInput = UnityTemp.KELVIN;
            }

            if (unityOutput == UnityTemp.C) {
                unityOutput = UnityTemp.CELSIUS;
            } else if (unityOutput == UnityTemp.F) {
                unityOutput = UnityTemp.FAHRENHEIT;
            } else if (unityOutput == UnityTemp.K) {
                unityOutput = UnityTemp.KELVIN;
            }

            double[] temperature = new double[degree];
            for (int i = 0; i < degree; i++) {
                int temperatureNumber = i + 1;
                System.out.println(" ______________________________________________________________________");
                System.out.println("|                                                                      |");
                System.out.println("                  Digite a temperatura " + unityInput + " número " + temperatureNumber);
                System.out.println(" ______________________________________________________________________ ");

                temperature[i] = input.nextDouble();
            }

            System.out.println(" ______________________________________________________________________");
            System.out.println("|                                                                      |");
            System.out.println("|                               Opções:                                |");
            System.out.println("                     Quantidade de temperaturas: " + degree);
            System.out.println("                     Unidade de entrada: " + unityInput);
            System.out.println("                     Unidade de saída: " + unityOutput);
            System.out.println("|                                                                      |");
            System.out.println("|                               Resultado:                             |");


            for (double unit : temperature) {

                if (unityInput == UnityTemp.CELSIUS) {
                    result = transformCelsiusToTemp.transform(unityOutput, unit);

                } else if (unityInput == UnityTemp.FAHRENHEIT) {
                    result = transformFahrenheitToTemp.transform(unityOutput, unit);

                } else if (unityInput == UnityTemp.KELVIN) {
                    result = transformKelvinToTemp.transform(unityOutput, unit);

                } else {
                    result = 0;
                }

                average += unit;
                temp = unit;


                System.out.println("                      " + temp + " " + unityInput + " é " + " = " + result + " " + unityOutput);
                averageResult += result;
            }
            average /= degree;
            averageResult /= degree;


            System.out.println("   A média das temperaturas inseridas é: " + average + " " + unityInput + " ou " + averageResult + " " + unityOutput);
            System.out.println("|                                                                      |");
            System.out.println(" ______________________________________________________________________ ");
            input.close();

        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            System.err.println("Unidade de temperatura inválida, tente novamente");
            getTemp();

        } catch (java.util.InputMismatchException e) {
            System.err.println(e.getMessage());
            System.err.println("Dado inválido, tente novamente");
            getTemp();

        }
    }
}