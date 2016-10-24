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
public class CuentaBancaria {
    private int codigoEntidad;
    private int codigoOficina;
    private int numeroCuenta;
    private String titular;
    private double saldo;
    Scanner tecladoNumeros;
    Scanner tecladoCadenas;
    
    public CuentaBancaria(){
        tecladoNumeros = new Scanner(System.in);
        tecladoCadenas = new Scanner(System.in);
    }
    
    public CuentaBancaria(int codigoEntidad, 
                           int codigoOficina, 
                           int numeroCuenta,
                           String titular, 
                           double saldo){
        
        this.codigoEntidad = codigoEntidad;
        this.codigoOficina = codigoOficina;
        this.numeroCuenta = numeroCuenta;
        this.titular = titular;
        this.saldo = saldo;
        tecladoNumeros = new Scanner(System.in);
        tecladoCadenas = new Scanner(System.in);
    }
    public void setCodigoEntidad(int codigo){
        codigoEntidad = codigo;
    }
    public void setCodigoOficina(int codigo){
        codigoOficina = codigo;
    }
    public void setNumeroCuenta(int codigo){
        numeroCuenta= codigo;
    }
    public void setTitular (String nombre){
        titular = nombre;
    }
    public void setSaldo(double cantidad){
        saldo = cantidad;
    }
    
    public void introducirNumeroCuenta() {
        boolean cuentaCorrecta = true;
        //realizamos el control de excepciones dentro del método
        do {
            try {
                System.out.print("Introduce el nº de cuenta:");
                numeroCuenta = tecladoNumeros.nextInt();

            } catch (InputMismatchException e) {
                System.out.println("Se esperaba un entero");
                cuentaCorrecta = false;
            } catch (Exception e) {
                System.out.printf("Se ha producido un error :%s", e.getMessage());
                e.printStackTrace();
                cuentaCorrecta = false;
            }
        } while (!cuentaCorrecta);
    }
    
    public void introducirCodigoEntidad() throws InputMismatchException, Exception {
        //realizamos el control de excepciones fuera del método
        try {
            System.out.print("Introduce el nº de cuenta:");
            numeroCuenta = tecladoNumeros.nextInt();

        } catch (InputMismatchException e) {
            throw  new InputMismatchException(e.getMessage());
        } catch (Exception e) {
            throw  new Exception(e.getMessage());
        }
    }
    
    
    public int getCodigoEntidad(){
        return codigoEntidad ;
    }
    public int getCodigoOficina(){
        return codigoOficina;
    }
    public int getNumeroCuenta(){
        return numeroCuenta;
    }
    public String getTitular (){
        return titular ;
    }
    public double getSaldo(){
        return saldo;
    }
    public void realizarIngreso(double cantidad){
        if (cantidad < 0){
           System.out.println("No se permiten ingresos negativos");
        }
        else  {
            saldo = saldo + cantidad;

        }
            
    }
    
    public static boolean verificaOficina(int oficina) {
        if (oficina > 1 && oficina < 10000){
            return true;
        }
        else {
            return false;
        }
    }
}

