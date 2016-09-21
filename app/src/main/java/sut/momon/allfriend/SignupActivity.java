package sut.momon.allfriend;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;

public class SignupActivity extends AppCompatActivity {

    //การประกาศตัวแปร

    private EditText nameEditText,addressEditText,phoneEditText,userEditText,passwordEditText;
    private String nameString,addressString,phoneString,userString,passwordString,genderString,imageString;
    private RadioButton maleRadioButton,famaleRadioButton;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        //Bind Winget
        nameEditText = (EditText) findViewById(R.id.editText);
        addressEditText = (EditText) findViewById(R.id.editText2);
        phoneEditText = (EditText) findViewById(R.id.editText3);
        userEditText = (EditText) findViewById(R.id.editText4);
        passwordEditText = (EditText) findViewById(R.id.editText5);
        maleRadioButton = (RadioButton) findViewById(R.id.radioButton);
        famaleRadioButton = (RadioButton) findViewById(R.id.radioButton2);
        imageView = (ImageView) findViewById(R.id.imageView);

        //ImageView Controller
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                startActivityForResult(Intent.createChooser(intent,"โปรดเลือกรูปภาพ"),1);

            } //onclick
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if ((requestCode == 1) && (resultCode == RESULT_OK)) {

            Log.d("SUTFriendV1","Result ==> Success");




        }   //if

    }   // onActivityResult

    public void clickSignUpSign(View view) {

        //Get Value From Edit Text
        nameString = nameEditText.getText().toString().trim();
        addressString = addressEditText.getText().toString().trim();
        phoneString = phoneEditText.getText().toString().trim();
        userString = userEditText.getText().toString().trim();
        passwordString = passwordEditText.getText().toString().trim();

        //check Space
        if (nameString.equals("") || addressString.equals("") || phoneString.equals("") ||
                userString.equals("") || passwordString.equals("")) {

            //Have Space
            MyAlert myAlert = new MyAlert(this, R.drawable.doremon48,"มีช่องว่าง","กรุณากรอกทุกช่อง ครับ");
            myAlert.myDialog();
        } else if (!(maleRadioButton.isChecked()) || famaleRadioButton.isChecked()) {
            //Non Check
            MyAlert myAlert = new MyAlert(this, R.drawable.nobita48,"ยังไม่เลือก Gender","กรุณาเลือก Gender");
            myAlert.myDialog();
        }


    }   //clickSign
        //trim ตัดช่องว่างของตัวอักษรอัตโนมัติ







}
