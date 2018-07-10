package org.dtek.andika.classroom;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.preference.PreferenceManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.github.javiersantos.appupdater.AppUpdater;
import com.github.javiersantos.appupdater.enums.UpdateFrom;

public class MainActivity extends AppCompatActivity {

    TextView namaUser, feedback, appname;
    CardView cardPelajaran, cardPiket, cardKabinet, cardFeedback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Dapatkan Informasi User dan Device
        final String deviceBrand = Build.BRAND;
        final String deviceModel = Build.MODEL;
        final String deviceVersion = Build.VERSION.RELEASE;
        final String appVersion = BuildConfig.VERSION_NAME;
        final String appID = BuildConfig.APPLICATION_ID;
        super.onCreate(savedInstanceState);

        AppUpdater appUpdater = new AppUpdater(this)
                .setUpdateFrom(UpdateFrom.GITHUB)
                .setGitHubUserAndRepo("mrandika", "classroom-android");
        appUpdater.start();

        final SharedPreferences prefs = PreferenceManager
                .getDefaultSharedPreferences(this);
        final String userName = prefs.getString("username", null);

        if (userName == null) {
            final EditText input = new EditText(this);
            input.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_FLAG_CAP_SENTENCES);
            final AlertDialog dialog = new AlertDialog.Builder(this)
                    .setView(input).setTitle("Halo! Siapakah anda ?")
                    .setPositiveButton("Ok",
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    String enteredText = input.getText().toString();
                                    if (!enteredText.equals("")) {
                                        SharedPreferences.Editor editor = prefs.edit();
                                        editor.putString("username", enteredText);
                                        editor.apply();
                                        Intent restart = getBaseContext().getPackageManager()
                                                .getLaunchIntentForPackage( getBaseContext().getPackageName() );
                                        restart.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                        startActivity(restart);
                                    }
                                }
                            }).create();
            dialog.show();

        }

        setContentView(R.layout.activity_main);
        // Delegasi Widgets
        namaUser = findViewById(R.id.namaUser);
        feedback = findViewById(R.id.feedback);
        appname = findViewById(R.id.appname);
        cardPelajaran = findViewById(R.id.cardPelajaran);
        cardPiket = findViewById(R.id.cardPiket);
        cardKabinet = findViewById(R.id.cardKabinet);
        cardFeedback = findViewById(R.id.cardFeedback);

        if (userName == null) {
            namaUser.setText(R.string.greet);
        } else {
            namaUser.setText("Halo, "+userName+"!");
        }

        if (appVersion.contains("DEBUG")) {
            // Jika versi beta/alpha
            feedback.setText(R.string.feedbackBeta);
            appname.setText(R.string.app_nameBeta);
        } else {
            // Jika versi stabil
            feedback.setText(R.string.feedback);
        }

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
                Intent intent = new Intent(MainActivity.this, kabinet.class);
                startActivity(intent);
            }
        });
        cardFeedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);

                emailIntent.setType("plain/text");
                emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, new String[]{"mrizkiandika226@gmail.com"});
                emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "[FEEDBACK] Aplikasi Classroom");
                emailIntent.putExtra(Intent.EXTRA_TEXT,
                        "[User and Device Info]\n"
                                +"Username: " + userName + "\n"
                                + "Application ID: " + appID + "\n"
                                + "Application Version: " + appVersion + "\n"
                                + "Device: " + deviceBrand + " - " + deviceModel + "\n"
                                + "Android Version: " + deviceVersion + "\n\n"+"[User Feedback Field]\n\n");

                startActivity(Intent.createChooser(emailIntent, "Kirim Feedback..."));
            }
        });
    }
}