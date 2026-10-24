public class EjercicioCinco {

    public static void main(String[] args) {
        // 1. Almacena el texto en una variable de tipo String
        String texto = "PROGRAMACION JAVA";
        
        // Variable contadora para las vocales
        int cantidadVocales = 0;
        
        // Se convierte el texto a mayúsculas para simplificar la validación
        String textoMayus = texto.toUpperCase();
        
        // 2. Recorre todos los caracteres del texto mediante una estructura repetitiva
        for (int i = 0; i < textoMayus.length(); i++) {
            char caracter = textoMayus.charAt(i);
            
            // Verifica si el carácter actual es una vocal (incluyendo vocales con tilde si fuera el caso)
            if (caracter == 'A' || caracter == 'E' || caracter == 'I' || caracter == 'O' || caracter == 'U' ||
                caracter == 'Á' || caracter == 'É' || caracter == 'Í' || caracter == 'Ó' || caracter == 'Ú') {
                cantidadVocales++;
            }
        }
        
        // 3. Despliega los resultados
        System.out.println("Texto analizado: " + texto);
        System.out.println("Cantidad de caracteres: " + texto.length());
        System.out.println("Cantidad de vocales: " + cantidadVocales);
    }
}