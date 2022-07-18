package fxTuloskortti;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import tuloskortti.GolfRekisteri;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.fxml.FXMLLoader;


/**
 * Golf tuloskortti -sovelluksen käyttöliittymä tapahtumien hoitaminen
 * @author janne
 * @version 13.6.2022
 * 
 */
public class TuloskorttiMain extends Application {
    @Override
    public void start(Stage primaryStage) {

        try {
            FXMLLoader ldr = new FXMLLoader(getClass().getResource("TuloskorttiGUIView.fxml"));
            final Pane root = (Pane)ldr.load();
            final TuloskorttiGUIController tuloskorttiCtrl = (TuloskorttiGUIController)ldr.getController();
            
            final Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("tuloskortti.css").toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.setTitle("Tuloskortti");
            
            // Asetetaan GolfRekisterin tiedot käyttöliittymälle
            GolfRekisteri golfRekisteri = new GolfRekisteri();
            tuloskorttiCtrl.setGolfRekisteri(golfRekisteri);
            
            Platform.setImplicitExit(false); // jos tämän laittaa, pitää itse sulkea
            
            primaryStage.setOnCloseRequest((event) -> {
                // Kutsutaan voikoSulkea-metodia
                if ( !tuloskorttiCtrl.voikoSulkea() ) event.consume();
            });
            
            primaryStage.show();
            if (!tuloskorttiCtrl.avaa()) Platform.exit();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @param args Ei käytössä
     */
    public static void main(String[] args) {
        launch(args);
    }
}