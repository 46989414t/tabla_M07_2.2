package sample;

import javafx.event.ActionEvent;

import javafx.scene.control.TextField;

public class Controller {

    public TextField introCiudad;
    //public TextField introUnidad;
    public TextField introDias;

    ConectarApi ca = new ConectarApi();



   /* public void datos(ConectarApi ca){
        ca.setCity(introCiudad.getText());
        ca.setUnitats(introUnidad.getText());
        ca.setDies(introDias.getText());
        System.out.println("crea objeto");
    }*/

    public void onAceptar() {
        System.out.println("acepta");
        ca.setCity(ca.getCity());
        ca.setDies(ca.getDies());

        //introCiudad.setText(ca.getCity());
        //introDias.setText(ca.getDies());


        /*System.out.println("llega a aceptar");
        System.out.println(introCiudad);
        System.out.println(introUnidad);
        System.out.println(introDias);

        int introDiasInt=Integer.parseInt(introDias.getText());
        System.out.println("hace los parses INT");
        String introCiudadString = introCiudad.toString();
        String introUnidadString = introUnidad.toString();
        System.out.println("hace los parses");
        //ConectarApi ca = new ConectarApi(introCiudadString,introUnidadString, introDiasInt);
        ca.setCity(introCiudad.getText());
        ca.setUnitats(introUnidad.getText());
        ca.setDies(introDias.getText());
        System.out.println("crea objeto");*/

    }

}
