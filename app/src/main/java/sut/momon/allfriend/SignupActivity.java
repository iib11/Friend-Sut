package sut.momon.allfriend;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
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
    private String nameString,addressString,phoneString,userString,passwordString,genderString,imageString,imagepathString,imageNameString;
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

            //Find Path of Image

            Uri uri = data.getData();
            imagepathString = myFindPath(uri);
            Log.d("SUTFriendV1","imagePathString ==> "+ imagepathString);

            //Setup ImageView

            try {

                Bitmap bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(uri));
                imageView.setImageBitmap(bitmap);

            } catch (Exception e) {
                e.printStackTrace();
            }


        }   //if

    }   // onActivityResult

    private String myFindPath(Uri uri) {

        String strResult = null;

        String[] strings = {MediaStore.Images.Media.DATA};
        Cursor cursor = getContentResolver().query(uri,strings,null,null,null);

        if (cursor != null) {

            cursor.moveToFirst();
            int index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
            strResult = cursor.getString(index);

        } else {

            strResult = uri.getPath();

        }


        return strResult;
    }

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
