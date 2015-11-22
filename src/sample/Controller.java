package sample;

import javafx.event.ActionEvent;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

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



    ConectarApi ca = new ConectarApi();

   // String stringCiudad = introCiudad.getText();
  //  String stringDias = introDias.getText();



   /* public void datos(ConectarApi ca){
        ca.setCity(introCiudad.getText());
        ca.setUnitats(introUnidad.getText());
        ca.setDies(introDias.getText());
        System.out.println("crea objeto");
    }*/

    public void onAceptar() {
        //idTablaResul = new TableView();
//        idTablaResul.setEditable(false);
//        idTablaResul.getColumns().addAll(idDiaColumn, idMaximaColumn, idMinimaColumn);
        System.out.println("acepta");

        String strCiudad = idCiudad.getText();
        String strDies = idDias.getText();

        ca.setCity(strCiudad);
        ca.setDies(strDies);

        System.out.println("city"+ca.getCity());
        System.out.println("dies"+ca.getDies());

        //System.out.println("minima"+ca.getMinimaArrayList().size());
        ca.getMinimaArrayList();
        ca.getMaximaArrayList();
        ca.getFechaArrayList();

        Iterator<String> nombreIterator = ca.minimaArrayList.iterator();
        while(nombreIterator.hasNext()){
            String elemento = nombreIterator.next();
            idTextoMin.appendText(elemento);
            //idTablaResul.se
            //idMinimaColumn.setCellFactory(elemento);
            System.out.print("Temperatura minima: "+elemento);
        }

        Iterator<String> nombreIterator2 = ca.maximaArrayList.iterator();
        while(nombreIterator2.hasNext()){
            String elemento2 = nombreIterator2.next();
            //elemento2.
            idTextoMax.appendText(elemento2);
            System.out.print("Temperatura máxima: "+elemento2);
        }
        Iterator<String> nombreIterator3 = ca.fechaArrayList.iterator();
        while(nombreIterator3.hasNext()){
            String elemento3 = nombreIterator3.next();
            idTextoDia.appendText(elemento3);
            System.out.print("FECHA: "+elemento3);
        }





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
