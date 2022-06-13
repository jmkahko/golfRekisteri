package tuloskortti;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.fxml.FXMLLoader;


/**
 * @author janne
 * @version 13.6.2022
 *
 */
public class TuloskorttiMain extends Application {
    @Override
    public void start(Stage primaryStage) {
        try {
            FXMLLoader ldr = new FXMLLoader(getClass().getResource("TuloskorttiGUIView.fxml"));
            final Pane root = ldr.load();
            //final TuloskorttiGUIController tuloskorttiCtrl = (TuloskorttiGUIController) ldr.getController();
            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("tuloskortti.css").toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.setTitle("Tuloskortti");
            primaryStage.show();
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