/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Anastacio
 */
class Sensor_temperatura extends Sensor {
   @Override
    public float getData(){
     System.out.println("METODO QUE ACESSA O ENDEREÇO X DO SENSOR< VIA PROTOCOLO Y E OBTEM O VALOR DODO LIDO");
     return (float) 50.4;
     
 }  
}
