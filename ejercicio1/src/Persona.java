public class Persona {
  private String nombre, apellido, nss;
  private int edad;
  private final char SEXO;
  private double peso, altura;

  public Persona(String nombre, String apellido, int edad, char sexo, double peso, double altura) {
    this.nombre = nombre;
    this.apellido = apellido;
    this.edad = edad;
    this.SEXO = sexo;
    this.peso = peso;
    this.altura = altura;
  }

  public double imc() {
    return this.peso / (this.altura * this.altura);
  }

  public int calcularIMC() {
    final int PESO_NORMAL_H = 20, SOBREPESO_H = 25, PESO_NORMAL_M = 19, SOBREPESO_M = 24;
    int imc = 0;

    if (this.SEXO == 'H' || this.SEXO == 'h') {
      if (imc() < PESO_NORMAL_H) {
        imc = -1;
      } else if (imc() >= PESO_NORMAL_H && imc() <= SOBREPESO_H) {
        imc = 0;
      } else if (imc() > SOBREPESO_H) {
        imc = 1;
      }
    }

    if (this.SEXO == 'M' || this.SEXO == 'm') {
      if (imc() < PESO_NORMAL_M) {
        imc = -1;
      } else if (imc() >= PESO_NORMAL_M && imc() <= SOBREPESO_M) {
        imc = 0;
      } else if (imc() > SOBREPESO_M) {
        imc = 1;
      }
    }

    return imc;
  }

  public boolean esMayorDeEdad() {
    boolean mayor = false;

    if (this.edad >= 18) {
      mayor = true;
    }

    return mayor;
  }

  public static boolean comprobarSexo(char sexo) {
    boolean sexoValido = false;

    if (sexo == 'H' || sexo == 'M' || sexo == 'h' || sexo == 'm') {
      sexoValido = true;
    }

    return sexoValido;
  }

  public String toString() {
    return "Nombre: " + this.nombre + " " + this.apellido + "\n" + "Edad: " + this.edad + " Sexo:" + this.SEXO + "\n"
        + "NSS: " + this.nss + "\n" + "Peso: " + this.peso + " Altura: " + this.altura;
  }

  public void generaNSS() {
    String nssGenerado = "";

    for (int i = 0; i < 8; i++) {
      int numOrLetra = (int) (Math.random() * 2); // Genera 1 o 0
      if (numOrLetra == 1) { // Se debe obtener una letra
        int codigoAscii = (int) Math.floor(Math.random() * (90 - 65) + 65); // Genera código ASCII de la A-Z
        nssGenerado = nssGenerado + (char) codigoAscii;

      } else { // Se debe obtener un número
        int numero = (int) (Math.random() * 10); // Genera numero del 0-9
        nssGenerado = nssGenerado + numero;
      }
    }

    this.nss = nssGenerado;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getNombre() {
    return this.nombre;
  }

  public void setApellido(String apellido) {
    this.apellido = apellido;
  }

  public void setEdad(int edad) {
    this.edad = edad;
  }

  public void setPeso(double peso) {
    this.peso = peso;
  }

  public void setAltura(double altura) {
    this.altura = altura;
  }

}