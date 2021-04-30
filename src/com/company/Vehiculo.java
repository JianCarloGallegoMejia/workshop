package com.company;


public class Vehiculo {

    public static Vehiculo[][] vehiculos;
    public static int tamaño;
    public static int cantidad = 0;
    private String placa;
    private String marca;
    private String color;
    private int valorComercial;

    public Vehiculo(){

    }

    public Vehiculo(String p, String m, String c){
        this(p, m, c, 30000000);
    }

    public Vehiculo(String p, String m, String c, int v){
        this.placa = p;
        this.marca = m;
        this.color = c;
        this.valorComercial = v;
        cantidad += 1;
    }

    @Override
    public String toString() {
        return "Vehiculo: " +
                "\n placa='" + placa + '\'' +
                ", \n marca='" + marca + '\'' +
                ", \n color='" + color + '\'' +
                ", \n valorComercial=" + valorComercial;
    }

    public static String toStringVehiculos() {
        String value = "";
        for(int i = 0; i < vehiculos.length; i++){
            for(int j = 0; j < vehiculos[i].length; j++){
                if(vehiculos[i][j] != null){
                    value = value + vehiculos[i][j].toString() + "\n";
                }
            }
        }
        return value;
    }

    public static String vehiculoPorColor(String color){
        String value = "";
        for(int i = 0; i < vehiculos.length; i++){
            for(int j = 0; j < vehiculos[i].length; j++){
                if(vehiculos[i][j] != null && vehiculos[i][j].color.equalsIgnoreCase(color)){
                    value = value + vehiculos[i][j].toString();
                }
            }
            value = value + "\n";
        }
        return value;
    }


    public static Vehiculo[] vehiculosPorValorComercial() {

        Vehiculo[] temp = new Vehiculo[vehiculos.length*vehiculos.length];
        int k = 0;

        for(int i = 0; i < vehiculos.length; i++) {
            for (int j = 0; j < vehiculos[i].length; j++) {
                if(vehiculos[i][j] != null){
                    temp[k++] = vehiculos[i][j];
                }
            }
        }

        int n = temp.length;
        Vehiculo temp2 = new Vehiculo();
        for(int i=0; i < n; i++){
            for(int j=1; j < (n-i); j++){
                if(temp[j] != null){
                    if(temp[j-1].valorComercial > temp[j].valorComercial){
                        temp2 = temp[j-1];
                        temp[j-1] = temp[j];
                        temp[j] = temp2;
                    }
                }

            }
        }

        return temp;
    }

    public static int cantidadVehículos(){
        return cantidad;
    }


    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getValorComercial() {
        return valorComercial;
    }

    public void setValorComercial(int valorComercial) {
        this.valorComercial = valorComercial;
    }
}
