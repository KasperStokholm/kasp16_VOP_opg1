/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kasp16_vop_opg1;

import ancient_encryption.CipherInterface;
import java.io.File;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import rock_paper_scissors.RockPaperScissors;
import static rock_paper_scissors.RockPaperScissors.HANDS;

/**
 * FXML Controller class
 *
 * @author Kasper
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private TextField message;
    @FXML
    private RadioButton buttonAtbash;
    @FXML
    private RadioButton buttonCaesar;
    @FXML
    private Button buttonEncrypt;
    @FXML
    private Button buttonDecrypt;
    @FXML
    private TextField messageEncrypt;
    @FXML
    private TextField messageDecrypt;
    @FXML
    private Spinner<Integer> spinner;
    @FXML
    private ToggleGroup method;
    @FXML
    private Button buttonRock;
    @FXML
    private Button buttonScissor;
    @FXML
    private Button buttonPaper;
    @FXML
    private ImageView playerImage;
    @FXML
    private ImageView opponentImage;
    @FXML
    private Label opponentChoice;
    @FXML
    private Label gameResult;

    RockPaperScissors rps;
    private Map<String, Image> picMap = new HashMap<>();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        spinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, CipherInterface.ALPHABETH.length - 1, CipherInterface.ALPHABETH.length / 2));
        rps = new RockPaperScissors();
        picMap.put(rps.HANDS[0],
            new Image(new File("Rock.png").toURI().toString()));
        picMap.put(rps.HANDS[1],
            new Image(new File("Scissors.png").toURI().toString()));
        picMap.put(rps.HANDS[2],
            new Image(new File("Paper.png").toURI().toString()));
    }

    @FXML
    private void doCipher(ActionEvent event){
        CipherInterface cipherToggle;
        
        if(method.getSelectedToggle() == buttonAtbash){
            cipherToggle = new AtbashCipher();
        } else {
            cipherToggle = new CeasarCipher(spinner.getValue());
        }
        if(((Button)event.getSource()).equals(buttonEncrypt)){
            messageEncrypt.setText(cipherToggle.encrypt(message.getText()));
        }else{
            messageDecrypt.setText(cipherToggle.decrypt(messageEncrypt.getText()));
        }  
    }

    @FXML
    private void doRPS(ActionEvent event) {
        if(((Button)event.getSource()).equals(buttonRock)){
            rps.play(HANDS[0]);
        }
        if(((Button)event.getSource()).equals(buttonScissor)){
            rps.play(HANDS[1]);
        }
        if(((Button)event.getSource()).equals(buttonPaper)){
            rps.play(HANDS[2]);
        }
        setResults();
    }
    
    private void setResults(){
        opponentChoice.setText(rps.getOpponentHand());
        playerImage.setImage(picMap.get(rps.getPlayerHand()));
        opponentImage.setImage(picMap.get(rps.getOpponentHand()));
        gameResult.setText(rps.getWinner());
    }
    
}