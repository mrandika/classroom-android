package org.dtek.andika.classroom;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class pelajaran extends AppCompatActivity {

    CardView pelajarancardSenin, pelajarancardSelasa, pelajarancardRabu, pelajarancardKamis, pelajarancardJumat, pelajarancardSabtu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pelajaran);

        pelajarancardSenin = findViewById(R.id.pelajarancardSenin);
        pelajarancardSelasa = findViewById(R.id.pelajarancardSelasa);
        pelajarancardRabu = findViewById(R.id.pelajarancardRabu);
        pelajarancardKamis = findViewById(R.id.pelajarancardKamis);
        pelajarancardJumat = findViewById(R.id.pelajarancardJumat);
        pelajarancardSabtu = findViewById(R.id.pelajarancardSabtu);

        pelajarancardSenin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        pelajarancardSelasa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        pelajarancardRabu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        pelajarancardKamis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        pelajarancardJumat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        pelajarancardSabtu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
