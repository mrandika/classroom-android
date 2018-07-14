package org.dtek.andika.classroom;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;

public class laporanPiket extends AppCompatActivity {

    @BindView(R.id.automaticData)RadioButton automaticData;
    @BindView(R.id.data)TextView data;
    @BindView(R.id.hari)EditText hari;
    @BindView(R.id.tanggal)EditText tanggal;
    @BindView(R.id.ruang)EditText ruang;
    @BindView(R.id.menyapu)CheckBox menyapu;
    @BindView(R.id.mengepel)CheckBox mengepel;
    @BindView(R.id.papanTulis)CheckBox papanTulis;
    @BindView(R.id.alatElektronik)CheckBox alatElektronik;
    @BindView(R.id.tataLetak)CheckBox tataLetak;
    @BindView(R.id.sarpras)CheckBox sarpras;
    @BindView(R.id.keteranganTambahan)EditText keteranganTambahan;
    @BindView(R.id.kirimLaporan)Button kirimLaporan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laporan_piket);
        ButterKnife.bind(this);

        Date detailedDate = Calendar.getInstance().getTime();
        SimpleDateFormat detailedFormat = new SimpleDateFormat("EEEE, dd/MM/yyyy - HH:mm:ss.", new Locale("id"));
        final String detailedDateOutput = detailedFormat.format(detailedDate);

        SimpleDateFormat simpleFormat = new SimpleDateFormat("EEEE, dd MMM yyyy.", new Locale("id"));
        final String simpleDateOutput = simpleFormat.format(detailedDate);
        data.setText(simpleDateOutput);

        kirimLaporan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String done = "✅ ";
                String notDone = "❌ ";
                String getHari = hari.getText().toString();
                String getTanggal = ", pada tanggal"+tanggal.getText().toString()+".";
                String getRuangan = ruang.getText().toString();
                String getKeterangan = keteranganTambahan.getText().toString();

                if (!getRuangan.isEmpty() && menyapu.isChecked() && mengepel.isChecked() && papanTulis.isChecked() &&
                        alatElektronik.isChecked() && tataLetak.isChecked() && sarpras.isChecked()) {

                    final Intent emailIntent = new Intent(Intent.ACTION_SEND);
                    emailIntent.setType("plain/text");
                    emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"starbhak.rpl2@gmail.com"});
                    emailIntent.putExtra(Intent.EXTRA_SUBJECT, "[LAPORAN PIKET] XI RPL 2");
                    emailIntent.putExtra(Intent.EXTRA_TEXT,
                            "Laporan piket hari "+simpleDateOutput+
                                    " Melaporkan bahwa semua anggota piket telah melakukan kewajibannya untuk Ruang "+getRuangan+".\n\n"+
                                    "Ketuntasan:\n"+
                                    done+"Menyapu\n"+
                                    done+"Mengepel\n"+
                                    done+"Membersihkan papan tulis\n"+
                                    done+"Mengecek alat elektronik\n"+
                                    done+"Tata letak\n"+
                                    done+"Pengembalian sarana dan prasarana\n\n"+
                                    "Dibuat otomatis oleh Classroom pada "+detailedDateOutput);

                    startActivity(Intent.createChooser(emailIntent, "Kirim Laporan..."));
                } else {
                    Context context = getApplicationContext();
                    CharSequence text = "Data belum lengkap atau piket belum tuntas!";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
            }
        });
    }
}