import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        boolean sexoValido = true;

        Scanner entrada = new Scanner(System.in);

        // Inicio, solicitud de los datos - Formulario
        System.out.print("Ingresar nombre de usuario:");
        String nombre = entrada.nextLine();

        System.out.print("Ingresar apellido:");
        String apellido = entrada.nextLine();

        System.out.print("Ingresa la edad:");
        int edad = entrada.nextInt();

        // Validar que el sexo sea correcto
        char sexo = 'H';
        while (sexoValido) {
            System.out.print("Ingresa el sexo (H/M):");
            sexo = entrada.next().charAt(0);
            if (Persona.comprobarSexo(sexo)) {
                sexoValido = false;
            } else {
                System.out.println("Sexo inválido, debe ingresar 'H' o 'M'");
            }
        }

        System.out.print("Ingresa el peso (KG):");
        double peso = entrada.nextDouble();
        System.out.println("Ingresa la altura (Metros):");
        double altura = entrada.nextDouble();

        entrada.close();
        // Fin, solicitud de los datos - Formulario

        Persona persona1 = new Persona(nombre, apellido, edad, sexo, peso, altura);
        persona1.generaNSS();

        // Comprobación de peso
        if (persona1.calcularIMC() == -1) {
            System.out.print(persona1.getNombre() + ", esta bajo de peso");
        } else if (persona1.calcularIMC() == 0) {
            System.out.println(persona1.getNombre() + ", tiene un peso ideal");
        } else {
            System.out.println(persona1.getNombre() + ", tiene sobrepeso");
        }

        // Verificar si es mayor de edad
        if (persona1.esMayorDeEdad()) {
            System.out.println("Es mayor de edad");
        } else {
            System.out.println("Es menor de edad");
        }

        // Informacion de la persona
        System.out.println(persona1.toString());
    }
}