/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author oguev
 */
public class Main {
    
    public static void main(String[] args) {
        Conexion c = new Conexion();
        if(c.con()!=null){
            System.out.println("Bien");
        }else{
            System.out.println("mal");
        }
    }
    
}
