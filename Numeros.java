public class Numeros {
    
        
    public Numeros(int n) {
        
    }

    public static boolean esPrimo(int numero) {
        if (numero <= 1) {
            return false;
        }
        if (numero <= 3) {
            return true;
        }
        if (numero % 2 == 0 || numero % 3 == 0) {
            return false;
        }
        
        for (int i = 5; i * i <= numero; i += 6) {
            if (numero % i == 0 || numero % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }
    
    public void mostrarPrimosYSuma(int n) {
        int contador = 0;
        int num = 2; 
        int suma = 0;
        
        System.out.println("Los primeros numeros primos son:");
        
        while (contador < n) {
            if (esPrimo(num)) {
                System.out.print(num + " ");
                suma += num;
                contador++;
            }
            num++;
        }
        
        System.out.println("\nLa suma es: " + suma);
    }
}