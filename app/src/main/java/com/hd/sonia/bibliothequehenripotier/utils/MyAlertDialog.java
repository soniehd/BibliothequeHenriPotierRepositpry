package com.hd.sonia.bibliothequehenripotier.utils;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;

import com.hd.sonia.bibliothequehenripotier.R;

/**
 * Created by Sonia on 10/09/2016.
 */
public class MyAlertDialog {
    public static void showLocationDialog(String title, String message,  final Context context){
        AlertDialog.Builder builder = new AlertDialog.Builder(context, R.style.MyDialogTheme);
        builder.setTitle(title);
        builder.setMessage(message);

        String positiveText = context.getString(android.R.string.ok);
        builder.setPositiveButton(positiveText,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ((Activity)context).finish();
                    }
                });

        AlertDialog dialog = builder.create();

        dialog.show();
    }


}
