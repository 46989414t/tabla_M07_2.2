package sample;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
/**
 *
 * @author kalt
 */
public class Tabla extends Application {
    private TableView<Persona> tabla = new TableView();
    @Override
    public void start(Stage primaryStage) {
        TableColumn<Persona, String> nombre = new TableColumn<>("Nombre");
        nombre.setCellValueFactory(new PropertyValueFactory<Persona, String>("nombre"));

        TableColumn<Persona, String> apellido = new TableColumn<>("Apellido");
        apellido.setCellValueFactory(new PropertyValueFactory<Persona, String>("apellido"));

        TableColumn<Persona, String> email = new TableColumn<>("Email");
        email.setCellValueFactory(new PropertyValueFactory<Persona, String>("email"));

        tabla.getColumns().addAll(nombre, apellido, email);
        final ObservableList<Persona> datos = FXCollections.observableArrayList(
                new Persona("Jose 1", "Manuel", "kaltwulx@blabla"),
                new Persona("Jose 2", "Manuel", "kaltwulx@blabla"),
                new Persona("Jose 3", "Manuel", "kaltwulx@blabla"));
        tabla.setItems(datos);
        tabla.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        Scene scene = new Scene(tabla, 300, 250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
    public static class Persona {
        private final SimpleStringProperty nombre;
        private final SimpleStringProperty apellido;
        private final SimpleStringProperty email;
        public Persona(String nombre, String apellido, String email) {
            this.nombre = new SimpleStringProperty(nombre);
            this.apellido = new SimpleStringProperty(apellido);
            this.email = new SimpleStringProperty(email);
        }
        public String getNombre() {
            return nombre.get();
        }
        public String getApellido() {
            return apellido.get();
        }
        public String getEmail() {
            return email.get();
        }
    }
}