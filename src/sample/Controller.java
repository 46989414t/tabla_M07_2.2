package sample;

import javafx.event.ActionEvent;

import javafx.scene.control.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class Controller {

    public TextField idCiudad;
    //public TextField introUnidad;
    public TextField idDias;

    public TableView idTablaResul;
    public TableColumn idDiaColumn;
    public TableColumn idMaximaColumn;
    public TableColumn idMinimaColumn;

    public TextArea idTextoDia;
    public TextArea idTextoMax;
    public TextArea idTextoMin;

    public boolean hayTexto=false;

    public ArrayList<String> elementoMinList = new ArrayList<String>();
    public int contadorMin=0;



    ConectarApi ca = new ConectarApi();


    public void onAceptar() {
        System.out.println("estado texto: " + hayTexto);
            System.out.println("acepta");

            String strCiudad = idCiudad.getText();
            String strDies = idDias.getText();

            ca.setCity(strCiudad);
            ca.setDies(strDies);

            System.out.println("city" + ca.getCity());
            System.out.println("dies" + ca.getDies());


            //System.out.println("minima"+ca.getMinimaArrayList().size());
            ca.getMinimaArrayList();
            ca.getMaximaArrayList();
            ca.getFechaArrayList();

            Iterator<String> nombreIterator = ca.minimaArrayList.iterator();
            while (nombreIterator.hasNext()) {
                String elemento = nombreIterator.next();

                idTextoMin.appendText(elemento);
                //elementoMinList.add(elemento);
                //idTablaResul.se
                //idMinimaColumn.setCellFactory(elemento);
                //contadorMin++;
                System.out.print("Temperatura minima: " + elemento);

            }

            Iterator<String> nombreIterator2 = ca.maximaArrayList.iterator();
            while (nombreIterator2.hasNext()) {
                String elemento2 = nombreIterator2.next();
                //elemento2.
                idTextoMax.appendText(elemento2);
                System.out.print("Temperatura máxima: " + elemento2);

            }
            Iterator<String> nombreIterator3 = ca.fechaArrayList.iterator();
            //idTextoDia.clear();
            while (nombreIterator3.hasNext()) {

                String elemento3 = nombreIterator3.next();
                idTextoDia.appendText(elemento3);
                System.out.print("FECHA: " + elemento3);
            }


    }


    public void onReset(ActionEvent actionEvent) {
        String diaBorrar = idTextoDia.getText();
        String diaBorrar1 = diaBorrar.replace(diaBorrar.substring(0, diaBorrar.length()),"dsfdsf");
        idTextoDia.getText().;
        System.out.println("texto para reset: "+diaBorrar1);
    }
}
