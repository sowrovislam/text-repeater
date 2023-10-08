package com.example.reprint;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    EditText edtext, edlimit;


    Button button;

    ImageView copy;


    TextView tvtext;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtext=findViewById(R.id.edtext);
        edlimit=findViewById(R.id.edlimit);
        button=findViewById(R.id.button);
        copy=findViewById(R.id.copy);
        tvtext=findViewById(R.id.tvtext);




        copy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                ClipboardManager clipboardManager= (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);

                ClipData clipData=ClipData.newPlainText("copy",tvtext.getText().toString());

                clipboardManager.setPrimaryClip(clipData);


                Toast.makeText(MainActivity.this, "copy data", Toast.LENGTH_SHORT).show();




            }
        });









        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){

                if (edtext.length()>0&&edlimit.length()>0){


                    tvtext.setText("");
            String name1= edtext.getText().toString();

            int numbar=Integer.parseInt(edlimit.getText().toString());






            for (int x=0; x<=numbar; x++){


                if (numbar>1000){

                  if (edlimit.length()<numbar){

                      edlimit.setError("max numbar 100");

                  }




                }else {


                    tvtext.append(""+name1+"  "+"\n");
                }



            }


















                }else {

                    edlimit.setError("input valu");

                    edtext.setError("input valu");
                }





            }
        });












    }
}