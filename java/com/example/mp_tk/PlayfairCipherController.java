package com.example.mp_tk;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class PlayfairCipherController {

    @FXML
    private TextArea TextAreaBefore;

    @FXML
    private TextArea TextAreaAfter;

    @FXML
    private TextField TextFieldKey;

    String userInput = "";
    String Key = "";


    public void initialize(){
        TextAreaBefore.setText("");
        TextAreaAfter.setDisable(true);
    }

    public void TextFieldKey(ActionEvent ae){
        String Key = ((Button)ae.getSource()).getText();
        TextAreaBefore.setText(TextAreaBefore.getText()+ Key);
    }
    public void CipherButtonClickHandler(ActionEvent event){
        String btnCipher = ((Button)event.getSource()).getText();

        String textAreaBeforeString =  TextAreaBefore.getText();

        String textFieldKeyString = TextFieldKey.getText();
        if ( textFieldKeyString.matches("[a-zA-Z]+") && textAreaBeforeString.matches("[a-zA-Z ]+")  ){
        char[] encpt_arr = PlayfairCipherEncipher.encrypt(textAreaBeforeString,textFieldKeyString);
        String encpt_arr_str = String.valueOf(encpt_arr);
        TextAreaAfter.setText(encpt_arr_str);
        }else {
            TextAreaAfter.setText("Zadavany text smí obsahovat pouze znaky anglicke abecedy");
        }
    }
    public void DeCipherButtonClickHandler(ActionEvent event){
        String btnDeCipher = ((Button)event.getSource()).getText();

        String textAreaBeforeString =  TextAreaBefore.getText();

        String textFieldKeyString = TextFieldKey.getText();
        if ( textFieldKeyString.matches("[a-zA-Z]+") && textAreaBeforeString.matches("[a-zA-Z ]+")  ){
        char[] decrypt_arr = PlayfairCipherDecipher.decrypt(textAreaBeforeString,textFieldKeyString);
        String decrypt_arr_str = String.valueOf(decrypt_arr);
        TextAreaAfter.setText(decrypt_arr_str);
         }else{
            TextAreaAfter.setText("Zadavany text smí obsahovat pouze znaky anglicke abecedy");
        }

    }


}
