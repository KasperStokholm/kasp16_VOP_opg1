/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kasp16_vop_opg1;

import ancient_encryption.CipherInterface;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

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
    private Tab rps;
    @FXML
    private ToggleGroup method;
    @FXML
    private Tab cipher;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         spinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, CipherInterface.ALPHABETH.length - 1, CipherInterface.ALPHABETH.length / 2));
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
    
}