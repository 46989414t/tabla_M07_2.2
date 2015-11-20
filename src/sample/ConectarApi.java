package sample;

import javafx.scene.control.TextField;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import java.lang.Object;
//import org.json.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.xml.transform.Transformer;
import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
/**
 * Created by 46989414t on 20/11/15.
 */
public class ConectarApi {

    /*public static void main(String[] args) {
        peticio();
    }*/


    public String city;
    public String unitats = "metric";
    public String dies;
    //public String api_key="4c3c9fd618e5d67bb93faf64733a3470";

    /*public ConectarApi(String city, String unitats, String dies) {
        this.city = city;
        this.unitats = unitats;
        this.dies = dies;

        //peticio();
    }*/

    public ConectarApi() {
        /*this.city="Barcelona";
        this.unitats="metric";
        this.dies="7";
        peticio();
        System.out.println("pasa por peticion");*/
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getUnitats() {
        return unitats;
    }

    public void setUnitats(String unitats) {
        this.unitats = unitats;
    }

    public String getDies() {
        return dies;
    }

    public void setDies(String dies) {
        this.dies = dies;
    }

    public String getHTML(String urlToRead) throws Exception{
        StringBuilder result = new StringBuilder();
        URL url = new URL(urlToRead);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line;
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }
        rd.close();
        return result.toString();//retorna un JSON
    }

    public void peticio(){
        String s;
        String api_key="4c3c9fd618e5d67bb93faf64733a3470";
        String peticio2 = "http://api.openweathermap.org/data/2.5/forecast/daily?q="+city+"&mode=json&units="+unitats+"&cnt="+dies+"&appid="+api_key;

        try {
            s = getHTML(peticio2);
            SJS(s);
            //SJC(s);
        } catch (Exception e) {
            e.getMessage();
            System.out.println("no existeix");
        }

    }

    public void SJS(String cadena) {
        System.out.println("pasa por SJS");
        //extraer fecha
        Calendar c = new GregorianCalendar();

        String dia, mes, annio;

        dia = Integer.toString(c.get(Calendar.DATE));
        mes = Integer.toString(c.get(Calendar.MONTH));
        annio = Integer.toString(c.get(Calendar.YEAR));

        int diaInt = Integer.parseInt(dia);
        //---------------------------
        Object obj02 = JSONValue.parse(cadena);
        JSONObject arra02=(JSONObject)obj02;

        String out = arra02.toJSONString();

        System.out.println("**********************************************");
        System.out.println("llega a SJS");
        //System.out.println(out);
        //Ciutats
        JSONObject respostaCity = (JSONObject)arra02.get("city");
        System.out.println("Ciudad: "+respostaCity.get("name"));

        //COD
        //System.out.println("llega a cod");
        //System.out.println("COD: "+arra02.get("cod"));

        //message
        //System.out.println("MESSAGE: "+arra02.get("message"));

        //cnt
        System.out.println("Previsión de días: "+arra02.get("cnt"));
        //List
        //System.out.println("llega al lista");
        JSONArray respostaList = (JSONArray)arra02.get("list");
        //Extraer atributos del primer tag de list
        for (int i =0; i < respostaList.size(); i++){

            //System.out.println("llega al primer for");
            JSONObject listaJsonObj = (JSONObject)respostaList.get(i);
            //Extraer atributos del tag temp
            JSONObject temp = (JSONObject)listaJsonObj.get("temp");
            System.out.println("DIA: "+(diaInt+i)+"/"+mes+"/"+annio);
            System.out.println("Mínimas: "+temp.get("min"));
            System.out.println("Máximas: "+temp.get("max")+"\n");

        }

    }

}
