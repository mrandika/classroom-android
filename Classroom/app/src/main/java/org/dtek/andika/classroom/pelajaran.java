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
                Intent intent = new Intent(pelajaran.this, pelajaranSenin.class);
                startActivity(intent);
            }
        });
        pelajarancardSelasa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(pelajaran.this, pelajaranSelasa.class);
                startActivity(intent);
            }
        });
        pelajarancardRabu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(pelajaran.this, pelajaranRabu.class);
                startActivity(intent);
            }
        });
        pelajarancardKamis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(pelajaran.this, pelajaranKamis.class);
                startActivity(intent);
            }
        });
        pelajarancardJumat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(pelajaran.this, pelajaranJumat.class);
                startActivity(intent);
            }
        });
        pelajarancardSabtu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(pelajaran.this, pelajaranSabtu.class);
                startActivity(intent);
            }
        });
    }
}
