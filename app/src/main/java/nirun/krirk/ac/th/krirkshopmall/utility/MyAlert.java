package nirun.krirk.ac.th.krirkshopmall.utility;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;

import java.util.Locale;

import nirun.krirk.ac.th.krirkshopmall.R;

/**
 * Created by nirun on 6/3/2561.
 */

public class MyAlert {

    private Context context;

    public MyAlert(Context context) {
        this.context = context;
    }
    public  void myDialog(String titlestring,String messageString){

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setCancelable(false);
        builder.setIcon(R.drawable.ic_action_alert);
        builder.setTitle(titlestring);
        builder.setMessage(messageString);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });

        builder.show();

    }


}//main class
