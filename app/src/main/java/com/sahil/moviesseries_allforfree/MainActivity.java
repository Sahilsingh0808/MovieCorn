package com.sahil.moviesseries_allforfree;

import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    TextView textView3,textView5,textView6;
    FloatingActionButton next;
    Dialog dialog;
    Button next1;
    CoordinatorLayout coordinatorLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        coordinatorLayout=(CoordinatorLayout)findViewById(R.id.coordlay);
        dialog=new Dialog(this);
        next= (FloatingActionButton) findViewById(R.id.next);
        next1=(Button)findViewById(R.id.button);
        next1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                custom_box();
                coordinatorLayout.animate().alpha(0.2f).setDuration(1500);
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                custom_box();
                coordinatorLayout.animate().alpha(0.2f).setDuration(1500);
            }
        });
    }

    private void custom_box() {
        dialog.setContentView(R.layout.custom_dialog);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        Button cancel=(Button)dialog.findViewById(R.id.button2);
        Button contin=(Button)dialog.findViewById(R.id.button3);
        dialog.show();
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        contin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Web.class));
                dialog.dismiss();
            }
        });
        dialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialog) {
                coordinatorLayout.animate().alpha(1).setDuration(1000);
            }
        });

    }

    public void rateApp(View view)
    {
        try
        {
            Intent rateIntent = rateIntentForUrl("https://play.google.com/store/apps/details?id=com.sahil.number&hl=en_IN&gl=US");
            startActivity(rateIntent);
        }
        catch (ActivityNotFoundException e)
        {
            Intent rateIntent = rateIntentForUrl("https://play.google.com/store/apps/details");
            startActivity(rateIntent);
        }
    }

    private Intent rateIntentForUrl(String url)
    {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(String.format("%s?id=%s", url, getPackageName())));
        int flags = Intent.FLAG_ACTIVITY_NO_HISTORY | Intent.FLAG_ACTIVITY_MULTIPLE_TASK;
        if (Build.VERSION.SDK_INT >= 21)
        {
            flags |= Intent.FLAG_ACTIVITY_NEW_DOCUMENT;
        }
        else
        {
            //noinspection deprecation
            flags |= Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET;
        }
        intent.addFlags(flags);
        return intent;
    }

    public void contact(View view) {
//            Intent intent=null;
//            try {
//                intent =new Intent(Intent.ACTION_VIEW);
//                intent.setPackage("com.facebook.katana");
//                intent.setData(Uri.parse("https://m.facebook.com/profile.php?id=100055710708389"));
//                startActivity(intent);
//            } catch (Exception e) {
//                startActivity(new Intent(Intent.ACTION_VIEW,
//                        Uri.parse("https://m.facebook.com/profile.php?id=100055710708389")));
//            }
        Toast.makeText(this, "This feature is coming soon.", Toast.LENGTH_SHORT).show();

    }
    public void share(View view) {
//        try {
//            Intent intent8 = new Intent(Intent.ACTION_SEND);
//            intent8.setType("text/plain");
//            intent8.putExtra(Intent.EXTRA_TEXT, "Hey, this is a wonderful app. You can watch any movie or series of your choice completely for free. Try the app yourself.\nAndroid Download Link: ");
//            startActivity(intent8);
//
//        } catch (Exception e) {
//            startActivity(new Intent(Intent.ACTION_VIEW,
//                    Uri.parse("")));
//        }

        Toast.makeText(this, "This feature is coming soon.", Toast.LENGTH_SHORT).show();
    }
}