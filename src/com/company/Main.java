package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int pisos, espacios, decision, pisoUsuario, espacioUsuario, valorComercial;
        String placa, marca, color;

        System.out.println("Ingrese la candidad de pisos");
        pisos = sc.nextInt();

        System.out.println("Ingrese la cantidad de espacios");
        espacios = sc.nextInt();

        Vehiculo.vehiculos = new Vehiculo[pisos][espacios];
        Sensor.sensores = new Sensor[pisos][espacios];

        Vehiculo.tamaño = espacios * pisos;

        System.out.println("¿Qué desea hacer a continuación?");
        decision = sc.nextInt();

        while (decision != 0){
            switch (decision){
                case 0:
                    System.out.println("Saliendo");
                    break;
                case 1:
                    System.out.println(Sensor.sensorLibre());
                    break;
                case 2:
                    System.out.println("¿En qué piso desea guardar el vehículo?");
                    pisoUsuario = sc.nextInt();
                    System.out.println("¿En qué espacio desea guardar el vehículo?");
                    espacioUsuario = sc.nextInt();
                    if(Vehiculo.vehiculos[pisoUsuario-1][espacioUsuario-1] != null){
                        System.out.println("El espacio ya está ocupado");
                    }else{
                        System.out.println("Ingrese la placa");
                        placa = sc.next();
                        System.out.println("Ingrese la marca");
                        marca = sc.next();
                        System.out.println("Ingrese el color");
                        color = sc.next();
                        Vehiculo vehiculo = new Vehiculo(placa, marca, color);
                        Vehiculo.vehiculos[pisoUsuario-1][espacioUsuario-1] = vehiculo;
                        Sensor sensor = new Sensor(1);
                        Sensor.sensores[pisoUsuario-1][espacioUsuario-1] = sensor;
                        System.out.println(vehiculo.toString());
                    }
                    break;
                case 3:
                    System.out.println("¿En qué piso desea guardar el vehículo?");
                    pisoUsuario = sc.nextInt();
                    System.out.println("¿En qué espacio desea guardar el vehículo?");
                    espacioUsuario = sc.nextInt();
                    if(Vehiculo.vehiculos[pisoUsuario-1][espacioUsuario-1] != null){
                        System.out.println("El espacio ya está ocupado");
                    }else{
                        System.out.println("Ingrese la placa");
                        placa = sc.next();
                        System.out.println("Ingrese la marca");
                        marca = sc.next();
                        System.out.println("Ingrese el color");
                        color = sc.next();
                        System.out.println("Ingrese el valor");
                        valorComercial = sc.nextInt();
                        Vehiculo vehiculo = new Vehiculo(placa, marca, color, valorComercial);
                        Vehiculo.vehiculos[pisoUsuario-1][espacioUsuario-1] = vehiculo;
                        Sensor sensor = new Sensor(1);
                        Sensor.sensores[pisoUsuario-1][espacioUsuario-1] = sensor;
                        System.out.println(vehiculo.toString());
                    }
                    break;
                case 4:
                    System.out.println(Vehiculo.toStringVehiculos());
                    break;
                case 5:
                    System.out.println("Hay: "+ Vehiculo.cantidadVehículos() + " vehículos actualmente");
                    break;
                case 6:
                    System.out.println("¿En qué piso desea guardar el vehículo?");
                    pisoUsuario = sc.nextInt();
                    System.out.println("¿En qué espacio desea guardar el vehículo?");
                    espacioUsuario = sc.nextInt();
                    if(Sensor.sensores[pisoUsuario-1][espacioUsuario-1] == null) {
                        System.out.println("Libre");
                    }else{
                        System.out.println("Ocupado");
                    }
                    break;
                case 7:
                    System.out.println(Sensor.sensoresEstado());
                    break;
                case 8:
                    System.out.println("Ingrese el color");
                    color = sc.next();
                    System.out.println(Vehiculo.vehiculoPorColor(color));
                    break;
                case 9:
                    Vehiculo[] array = Vehiculo.vehiculosPorValorComercial();
                    for(int i = 0; i < array.length; i++){
                            if(array[i] != null){
                                System.out.println(array[i]);
                            }
                    }
                    break;
                default:
                    System.out.println("Comando incorrecto");
                    break;


            }
            System.out.println("¿Qué desea hacer a continuación?");
            decision = sc.nextInt();
        }

    }
}
