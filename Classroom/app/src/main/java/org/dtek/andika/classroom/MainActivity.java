package org.dtek.andika.classroom;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.preference.PreferenceManager;
import android.provider.Settings;
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

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.namaUser)TextView namaUser;
    @BindView(R.id.feedback)TextView feedback;
    @BindView(R.id.appname)TextView appname;
    @BindView(R.id.cardPelajaran)CardView cardPelajaran;
    @BindView(R.id.cardPiket)CardView cardPiket;
    @BindView(R.id.cardKabinet)CardView cardKabinet;
    @BindView(R.id.cardFeedback)CardView cardFeedback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Dapatkan Informasi User dan Device
        final String deviceBrand = Build.BRAND;
        final String deviceModel = Build.MODEL;
        final String deviceVersion = Build.VERSION.RELEASE;
        final String appVersion = BuildConfig.VERSION_NAME;
        final String appID = BuildConfig.APPLICATION_ID;
        super.onCreate(savedInstanceState);

        if (isNetworkAvailable()) {
            AppUpdater appUpdater = new AppUpdater(this)
                    .setUpdateFrom(UpdateFrom.GITHUB)
                    .setGitHubUserAndRepo("mrandika", "classroom-android");
            appUpdater.start();
        } else {
            final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this)
                    .setIcon(R.drawable.connectionerror)
                    .setTitle("Hmm...")
                    .setMessage("Tidak ada koneksi Internet! koneksi diperlukan untuk memeriksa pembaruan, coba sambungkan ke Internet atau coba menggunakan Offline Mode!")
                    .setPositiveButton("Pengaturan", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            startActivityForResult(new Intent(Settings.ACTION_WIRELESS_SETTINGS), 0);
                        }
                    })
                    .setNegativeButton("Offline Mode", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            // Do nothing and close dialog
                        }
                    });
            builder.show();
        }

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
        ButterKnife.bind(this);

        if (userName == null) {
            namaUser.setText(R.string.greet);
        } else {
            namaUser.setText("Halo, "+userName+"!");
        }

        if ((appVersion.contains("DEBUG") || (appVersion.contains("BETA") || (appVersion.contains("ALPHA"))))) {
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
                if ((appVersion.contains("DEBUG") || (appVersion.contains("BETA") || (appVersion.contains("ALPHA"))))) {
                    final Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
                    final String emailText = "[Informasi Pengguna dan Perangkat]\n"
                            +"Nama Pengguna: " + userName + "\n"
                            + "ID Aplikasi: " + appID + "\n"
                            + "Versi Aplikasi: " + appVersion + "\n"
                            + "Perangkat: " + deviceBrand + " - " + deviceModel + "\n"
                            + "Versi Android: " + deviceVersion + "\n\n"+"[Kolom Feedback Pengguna]\n\n";
                    emailIntent.setType("plain/text");
                    emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, new String[]{"mrizkiandika226@gmail.com"});
                    emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "[FEEDBACK Beta] Aplikasi Classroom");
                    emailIntent.putExtra(Intent.EXTRA_TEXT, emailText);

                    startActivity(Intent.createChooser(emailIntent, "Kirim Feedback..."));
                } else {
                    final Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
                    final String emailText = "[Informasi Pengguna dan Perangkat]\n"
                            +"Nama Pengguna: " + userName + "\n"
                            + "ID Aplikasi: " + appID + "\n"
                            + "Versi Aplikasi: " + appVersion + "\n"
                            + "Perangkat: " + deviceBrand + " - " + deviceModel + "\n"
                            + "Versi Android: " + deviceVersion + "\n\n"+"[Kolom Saran Pengguna]\n\n";
                    emailIntent.setType("plain/text");
                    emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, new String[]{"mrizkiandika226@gmail.com"});
                    emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "[SARAN] Aplikasi Classroom");
                    emailIntent.putExtra(Intent.EXTRA_TEXT, emailText);

                    startActivity(Intent.createChooser(emailIntent, "Kirim Saran..."));
                }
            }
        });
    }
    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
}