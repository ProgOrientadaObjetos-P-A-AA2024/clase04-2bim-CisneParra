/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete4;

import java.util.*;
import paquete2.Arriendo;
import paquete3.ArriendoLocalComercial;
import paquete3.ArriendoLocalComida;
import paquete3.ArriendoLocalSesiones;

public class EjecutorDos {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        ArrayList<Arriendo> listaArriendos = new ArrayList<>();
        int opc;
        int num;
        int c = 0;
        System.out.println("Cuantos locales desea ingresar?");
        num = entrada.nextInt();
        do {
            System.out.println("Ingresar local Comercial     [1]");
            System.out.println("Ingresar local Comida        [2]");
            System.out.println("Ingresar local Sesiones      [3]");
            opc = entrada.nextInt();
            entrada.nextLine();
            switch (opc) {
                case 1: {
                    System.out.println("Ingrese nombre del propietario");
                    String n = entrada.nextLine();
                    System.out.println("Ingrese cuota base");
                    double cB = entrada.nextDouble();
                    System.out.println("Ingrese el valor fijo");
                    double vf = entrada.nextDouble();
                    ArriendoLocalComercial arriendoComercial = new ArriendoLocalComercial(
                            n, cB);
                    arriendoComercial.establecerValorAdicionalFijo(vf); // en $
                    listaArriendos.add(arriendoComercial);
                    c++;
                    break;
                }
                case 2: {
                    System.out.println("Ingrese nombre del propietario");
                    String n = entrada.nextLine();
                    System.out.println("Ingrese cuota base");
                    double cB = entrada.nextDouble();
                    System.out.println("Ingrese el iva a cobrar");
                    int iva = entrada.nextInt();
                    System.out.println("Ingrese el valor del agua");
                    double a = entrada.nextDouble();
                    System.out.println("Ingrese el valor de la luz");
                    double l = entrada.nextDouble();
                    ArriendoLocalComida arriendoComida = new ArriendoLocalComida(
                            n, cB);
                    arriendoComida.establecerIva(iva); // en porcentaje
                    arriendoComida.establecerValorAgua(a); // en $
                    arriendoComida.establecerValorLuz(l); // en $
                    listaArriendos.add(arriendoComida);
                    c++;
                    break;
                }
                case 3: {
                    System.out.println("Ingrese nombre del propietario");
                    String n = entrada.nextLine();
                    System.out.println("Ingrese cuota base");
                    double cB = entrada.nextDouble();
                    System.out.println("Ingrese el valor de las sillas");
                    double s = entrada.nextDouble();
                    System.out.println("Ingrese el valor de la amplificacion");
                    double a = entrada.nextDouble();
                    ArriendoLocalSesiones arriendoSesiones = new ArriendoLocalSesiones(
                            n, cB);
                    arriendoSesiones.establecerValorSillas(s); // en $
                    arriendoSesiones.establecerValorAmplificacion(a); // en $
                    listaArriendos.add(arriendoSesiones);
                    c++;
                    break;
                }
            }

        } while (num < c);

        for (int i = 0; i < listaArriendos.size(); i++) {
            listaArriendos.get(i).establecerArriendoMensual();
        }

        CentroComercial centro = new CentroComercial("La Pradera",
                listaArriendos);
        centro.establecerTotalArriendosBaseMensual();
        centro.establecerTotalArriendosFinalMensual();
        System.out.println(centro);

    }
}
