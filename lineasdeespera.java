import java.util.Scanner;
public class lineasdeespera {
    public static void main(String [] args);{
        Scanner TSEscritora = new Scanner(System.in);
        do{
            System.out.println("Modelo de colas.");
            System.out.println("1. Modelo M/M/1.");
            System.out.println("2. Modelo M/M/C.");
            System.out.println("3. Modelo M/M/1/K.");
            System.out.println("4. Salir.");

            switch (opcion) {
                case 1 -> {
                    // Modelo M/M/1.
                    System.out.println("Ingrese la tasa de llegada (λ): ");
                    double Lambda = TSEscritora.nextDouble();
                    System.out.println("Ingrese la tasa de servicio (μ)");
                    double Mu = TSEscritora.nextDouble();
                    if(Mu <= Lambda){
                        System.out.println("Error. La tasa de servicio debe ser mayor que la tasa de llegada.");
                    }
                    double rho = Lambda / Mu;
                    double P0 = 1 - rho;
                    double Lq = rho * rho / (1 - rho);
                    double L = rho / (1 - rho);
                    double Wq = Lq / Lambda;
                    double W = L / Lambda;

                    System.out.println("Resultados del modelo M/M/1:");
                    System.out.println("Utilizacion (rho): " + rho);
                    System.out.println("Probabilidad de sistema vacio (P0): " + P0);
                    System.out.println("Numero promedio en cola (Lq): " + Lq);
                    System.out.println("Numero promedio en sistema (L): " + L);
                    System.out.println("Tiempo promedio en cola (Wq): " + Wq);
                    System.out.println("Tiempo promedio en sistema (W): " + W);
                }
                case 2 -> {
                    // Modelo M/M/C.
                    System.out.println("Ingrese la tasa de llegada (λ): ");
                    double Lambda = TSEscritora.nextDouble();
                    System.out.println("Ingrese la tasa de servicio (μ)");
                    double Mu = TSEscritora.nextDouble();
                    System.out.print("Ingrese el numero de servidores (C): ");
                    int C = TSEscritora.nextInt();

                    double rho = Lambda / (C * Mu);
                    if (rho >= 1) {
                        System.out.println("Error. El sistema es inestable ( p >= 1).");
                    }
                    //Calcular P0.
                    double suma = 0;
                    for(int n = 0; n < C; n++){
                        suma +=Math.pow(Lambda / Mu, n) / factorial (n);
                    }
                    double P0 = 1 / (suma + Math.pow(Lambda / Mu, C) / (factorial(C) * (1 - rho)));

                    double Lq = P0 * Math.pow (Lambda / Mu, C) * rho / (factorial(C) * Math.pow(1 - rho, 2));
                    double L = Lq + Lambda / Mu;
                    double Wq = Lq / Lambda;
                    double W = Wq + 1 / Mu;

                    System.out.println("Resultados para M/M/C:");
                    System.out.println("Utilizacion (rho): " + rho);
                    System.out.println("Probabilidad de sistema vacio (P0): " + P0);
                    System.out.println("Numero promedio en cola (Lq): " + Lq);
                    System.out.println("Numero promedio en sistema (L): " + L);
                    System.out.println("Tiempo promedio en cola (Wq): " + Wq);
                    System.out.println("Tiempo promedio en sistema (W): " + W);
                }
                case 3 -> {
                    // Modelo M/M/1/K.
                    System.out.println("Ingrese la tasa de llegada (λ): ");
                    double Lambda = TSEscritora.nextDouble();
                    System.out.println("Ingrese la tasa de servicio (μ)");
                    double Mu = TSEscritora.nextDouble();
                    System.out.println("Ingrese la capacidad del sistema (K): ");
                    int K = TSEscritora.nextInt();

                    double rho = Lambda = Mu;
                    if (rho >= 1) {
                        System.out.println("Error. El sistema es inestable");
                    }

                    double P0 = (1 - rho) / (1 - Math.pow(rho, K + 1));
                    double Lq = rho * (1 - (K + 1) * Math.pow(rho, K) + K * Math.pow(rho, K + 1)) / ((1 - rho) * (1 - Math.pow(rho, K + 1)));
                    double L = Lq + (1 - P0);
                    double Wq = Lq / (Lambda * (1 - P0));
                    double W = Wq + 1 / Mu;

                    System.out.println("Resultados para M/M/1/K:");
                    System.out.println("Utilizacion (rho): " + rho);
                }
            }
        }while(opcion != 4);
    }
}
