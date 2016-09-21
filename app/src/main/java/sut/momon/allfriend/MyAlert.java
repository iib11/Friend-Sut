package sut.momon.allfriend;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

/**
 * Created by momot on 21/9/2559.
 */
public class MyAlert {

    //Explicit
    private Context context;
    private int anInt;
    private String titleString,massageString;

    public MyAlert(Context context, int anInt, String titleString, String massageString) {
        this.context = context;
        this.anInt = anInt;
        this.titleString = titleString;
        this.massageString = massageString;
    }

    public void myDialog() {

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setCancelable(false);//กดปุ่มกลับไม่ได้จนกว่าจะกดOK
        builder.setIcon(anInt);
        builder.setTitle(titleString);
        builder.setMessage(massageString);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.show();


    }

}   //Main Class
