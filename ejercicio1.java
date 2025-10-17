
import java.util.Scanner;

public class ejercicio1 {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        System.out.println("Introducir los N numeros primos que quieras visualizar");

        int n = sc.nextInt();

        Numeros ObjetoPrimos = new Numeros(n);

        ObjetoPrimos.mostrarPrimosYSuma(n);

        sc.close();
        
    }
}
