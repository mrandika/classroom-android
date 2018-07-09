package org.dtek.andika.classroom;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView namaUser;
    CardView cardPelajaran, cardPiket, cardKabinet, cardFeedback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final SharedPreferences prefs = PreferenceManager
                .getDefaultSharedPreferences(this);
        String userName = prefs.getString("username", null);

        if (userName == null) {
            final EditText input = new EditText(this);
            final AlertDialog dialog = new AlertDialog.Builder(this)
                    .setView(input).setTitle("Halo! Siapakah anda ?")
                    .setPositiveButton("Ok",
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    EditText theInput = input;
                                    String enteredText = theInput.getText()
                                            .toString();
                                    if (!enteredText.equals("")) {
                                        SharedPreferences.Editor editor = prefs
                                                .edit();
                                        editor.putString("username",
                                                enteredText);
                                        editor.commit();
                                    }
                                }
                            }).create();
            dialog.show();
        }
        setContentView(R.layout.activity_main);
        // Delegasi Widgets
        namaUser = findViewById(R.id.namaUser);
        cardPelajaran = findViewById(R.id.cardPelajaran);
        cardPiket = findViewById(R.id.cardPiket);
        cardKabinet = findViewById(R.id.cardKabinet);
        cardFeedback = findViewById(R.id.cardFeedback);

        namaUser.setText("Halo, "+userName+"!");

        cardPelajaran.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, pelajaran.class);
                startActivity(intent);
            }
        });
        cardPiket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, piket.class);
                startActivity(intent);
            }
        });
        cardKabinet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = getApplicationContext();
                CharSequence text = "Card Kabinet di tap.";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
        });
        cardFeedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = getApplicationContext();
                CharSequence text = "Card Feedback di tap.";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
        });
    }
}
