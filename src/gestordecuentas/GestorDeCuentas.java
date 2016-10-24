/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestordecuentas;

import java.util.Scanner;
import java.util.InputMismatchException;

/**
 *
 * @author Roberto
 */
public class GestorDeCuentas {

    int numeroCuentas;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int cuenta, oficina, entidad;
        double saldo;
        String titular;
        boolean fin = false;
        Scanner teclado;
        
        CuentaBancaria miCuentaLiberbank=null;
        GestorDeCuentas miGestor = new GestorDeCuentas();
        
        miGestor.numeroCuentas=3; //necesitamos instancias un objeto para acceder a los atributos
       // numeroCuentas= 3;//nos daría error
        

        CuentaBancaria miCuentaBBVA;           //instancio un objeto de la clase CuentaBancaria
        miCuentaBBVA = new CuentaBancaria();
       
        teclado = new Scanner(System.in);
        try {
             //se piden todos los datos por teclado y se asignan los valores a través de los métodos set
            System.out.print("Introduce el nº de cuenta:");
            cuenta = teclado.nextInt();
            miCuentaBBVA.setNumeroCuenta(cuenta);
            System.out.print("Introduce el nº de entidad:");
            entidad = teclado.nextInt();
            miCuentaBBVA.setCodigoEntidad(entidad);
            System.out.print("Introduce el nº de oficina:");
            oficina = teclado.nextInt();
            miCuentaBBVA.setCodigoOficina(oficina);
            teclado.nextLine();//para vaciar el buffer
            System.out.print("Introduce el titular");
            titular = teclado.nextLine();
            miCuentaBBVA.setTitular(titular);

        } catch (InputMismatchException e) {
            System.out.println("Se esperaba un entero");
        } catch (Exception e) {
            System.out.printf("Se ha producido un error :%s", e.getMessage());
            e.printStackTrace();
        }

        try {
            //otra forma es pedir todos los datos y pasarlos directamente al constructor
            System.out.print("Introduce el nº de cuenta:");
            cuenta = teclado.nextInt();
            //comprobamos que el valor de la cuenta bancaria es correcto
            do {
                System.out.print("Introduce el nº de oficina:");
                oficina = teclado.nextInt();
            } while (!CuentaBancaria.verificaOficina(oficina));

            System.out.print("Introduce el nº de entidad:");
            entidad = teclado.nextInt();
            teclado.nextLine();//para vaciar el buffer
            System.out.print("Introduce el titular");
            titular = teclado.nextLine();
            //llamada al constructor con parámtros
            miCuentaLiberbank
                    = new CuentaBancaria(entidad, oficina, cuenta, titular, 0);

        } catch (InputMismatchException e) {
            System.out.println("Se esperaba un entero");
        } catch (Exception e) {
            System.out.printf("Se ha producido un error :%s", e.getMessage());
            e.printStackTrace();
        }

        CuentaBancaria miCuentaING = new CuentaBancaria();
        //otra forma de hacerlo sería dentro de un método de la clase
        miCuentaING.introducirNumeroCuenta();//este método gestiona las excepciones
        try {
            miCuentaING.introducirCodigoEntidad();//este método delega el control de las excepciones
            //como he declarado que lanza dos excepciones, las tengo que controlar
        } catch (InputMismatchException e) {
            System.out.println("Se esperaba un entero");
        } catch (Exception e) {
            System.out.printf("Se ha producido un error :%s", e.getMessage());
            e.printStackTrace();
        }

        //mostramos un menú
        while (!fin) {

            System.out.println("Seleccionar una opción:");
            
            System.out.println("[1] Ver número de cuenta completo (CCC).");
            System.out.println("[2] Ver titular de la cuenta.");
            System.out.println("[3] Ver código de entidad de la cuenta.");
            System.out.println("[4] Ver código de oficina de la cuenta.");
            System.out.println("[5] Ver número de la cuenta.");
            System.out.println("[6] Ver dígitos de control de la cuenta.");
            System.out.println("[7] Realizar un ingreso.");
            System.out.println("[8] Retirar efectivo.");
            System.out.println("[9] Consultar saldo.");
            System.out.println("[0] Salir.");

            System.out.println("Escriba la selección: ");
            int selec = 0 ;
            selec  = teclado.nextInt();

            switch (selec){
                case 1:
                    System.out.printf("Entidad: %i oficina %i cuenta %i", 
                                      miCuentaLiberbank.getCodigoEntidad(),
                                      miCuentaLiberbank.getCodigoOficina(),
                                      miCuentaLiberbank.getNumeroCuenta());
                    break;
                case 2:
                    break;
                case 7:
                    System.out.print("Cantidad a ingresar:");
                    miCuentaLiberbank.realizarIngreso(teclado.nextDouble());
                case 0:
                    fin = true;
                    break;
            }
       }
    }
}


