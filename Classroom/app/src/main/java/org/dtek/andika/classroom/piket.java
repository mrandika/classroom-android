package org.dtek.andika.classroom;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class piket extends AppCompatActivity {

    CardView cardSenin, cardSelasa, cardRabu, cardKamis, cardJumat, cardSabtu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pelajaran);

        cardSenin = findViewById(R.id.cardSenin);
        cardSelasa = findViewById(R.id.cardSelasa);
        cardRabu = findViewById(R.id.cardRabu);
        cardKamis = findViewById(R.id.cardKamis);
        cardJumat = findViewById(R.id.cardJumat);
        cardSabtu = findViewById(R.id.cardSabtu);

        cardSenin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        cardSelasa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        cardRabu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        cardKamis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        cardJumat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        cardSabtu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
