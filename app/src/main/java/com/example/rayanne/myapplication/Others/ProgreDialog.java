package com.example.rayanne.myapplication.Others;

import android.app.ProgressDialog;
import android.content.Context;

/**
 * Created by Pichau on 03/01/2018.
 */

public class ProgreDialog {
    String text;
    Context context;
    ProgressDialog pg;

    public ProgreDialog(Context context, String text) {
        pg = new ProgressDialog(context);
        pg.setMessage(text);
        pg.show();
    }

    public void pararProg() {
        pg.dismiss();
    }
}
