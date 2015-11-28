package sample;

import javafx.event.ActionEvent;

import javafx.event.Event;
import javafx.scene.control.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class Controller {

public TextField idCiudad;
public TextField idDias;
public TextField idMediaMin;
public TextField idMediaMax;


public TextArea idTextoDia;
public TextArea idTextoMax;
public TextArea idTextoMin;

public Button idAceptar;

public boolean hayTexto=false;

ConectarApi ca = new ConectarApi();

    /**
     * al aceptar le pasa los parametros a ConectarApi con sus condiciones,
     * sespues lee los arrayList y monta los textos de salida,
     * tambien calcula la media extrayendo los datos del arrayList.
     * En caso de error lanza mensaje
     */
    public void onAceptar() {

    System.out.println("estado texto: " + hayTexto);
        System.out.println("acepta");

        String strCiudad = idCiudad.getText();
        String strDies = idDias.getText();
    if(strDies.equals("1") || strDies.equals("2") || strDies.equals("3") || strDies.equals("4") || strDies.equals("5") || strDies.equals("6") || strDies.equals("7")
            ||strDies.equals("8") || strDies.equals("9") || strDies.equals("10") || strDies.equals("11") || strDies.equals("12") || strDies.equals("13")
            || strDies.equals("14") || strDies.equals("15") || strDies.equals("16")){

        ca.setDies(strDies);
    }
    else{
        idAceptar.setDisable(true);
        idTextoDia.setText(null);
        idTextoMax.setText(null);
        idTextoMin.setText(null);
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Formato incorrecto");
        alert.setHeaderText("Dias debe estar entre 1 y 16");
        alert.setContentText("Introduzca nuevo valor");

        alert.showAndWait();

    }

        ca.setCity(strCiudad);
       // ca.setDies(strDies);


        System.out.println("city" + ca.getCity());
        System.out.println("dies" + ca.getDies());


        //System.out.println("minima"+ca.getMinimaArrayList().size());
        ca.getMinimaArrayList();
        ca.getMaximaArrayList();
        ca.getFechaArrayList();
    //ca.getMinimaArrayList();
        Iterator<String> nombreIterator = ca.minimaArrayList.iterator();
        while (nombreIterator.hasNext()) {
            String elemento = nombreIterator.next();

            idTextoMin.appendText(elemento);
            System.out.print("Temperatura minima: " + elemento);

            float suma = 0;
            for (String i: ca.minimaArrayList){
                float dobI = Float.parseFloat(i);
                suma = suma + dobI;
            }
            idMediaMin.setText(String.valueOf(suma/ca.minimaArrayList.size()));

        }

    //ca.getMaximaArrayList();
        Iterator<String> nombreIterator2 = ca.maximaArrayList.iterator();
        while (nombreIterator2.hasNext()) {
            String elemento2 = nombreIterator2.next();
            //elemento2.
            idTextoMax.appendText(elemento2);
            System.out.print("Temperatura máxima: " + elemento2);

            float suma = 0;
            for (String i: ca.maximaArrayList){
                float dobI = Float.parseFloat(i);
                suma = suma + dobI;
            }
            idMediaMax.setText(String.valueOf(suma/ca.maximaArrayList.size()));

        }
    //ca.getFechaArrayList();
        Iterator<String> nombreIterator3 = ca.fechaArrayList.iterator();
        //idTextoDia.clear();
        while (nombreIterator3.hasNext()) {

            String elemento3 = nombreIterator3.next();
            idTextoDia.appendText(elemento3);
            System.out.print("FECHA: " + elemento3);
        }

    //resultadoMin = ca.minimaArrayList.


}

    /**
     * onReset
     * resetea los cuadros para pasar otros paramentros
     */
    public void onReset() {
    System.out.println("onReset");
    idTextoDia.setText(null);
    idTextoMax.setText(null);
    idTextoMin.setText(null);

    idDias.clear();
    ca.minimaArrayList.clear();
    ca.maximaArrayList.clear();
    ca.fechaArrayList.clear();

    idAceptar.setDisable(false);

}

    /**
     * desactiva el botón aceptar
     * @param event
     */
    public void onDeshabilitarAcep(Event event) {
    idAceptar.setDisable(true);
}
}
