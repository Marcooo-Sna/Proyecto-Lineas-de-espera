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
                }
            }
        }while(opcion != 4);
    }
    
}
