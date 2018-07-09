package org.dtek.andika.classroom;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class piket extends AppCompatActivity {

    CardView piketcardSenin, piketcardSelasa, piketcardRabu, piketcardKamis, piketcardJumat, piketcardSabtu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_piket);

        piketcardSenin = findViewById(R.id.piketcardSenin);
        piketcardSelasa = findViewById(R.id.piketcardSelasa);
        piketcardRabu = findViewById(R.id.piketcardRabu);
        piketcardKamis = findViewById(R.id.piketcardKamis);
        piketcardJumat = findViewById(R.id.piketcardJumat);
        piketcardSabtu = findViewById(R.id.piketcardSabtu);

        piketcardSenin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(piket.this, piketSenin.class);
                startActivity(intent);
            }
        });
        piketcardSelasa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(piket.this, piketSelasa.class);
                startActivity(intent);
            }
        });
        piketcardRabu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(piket.this, piketRabu.class);
                startActivity(intent);
            }
        });
        piketcardKamis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(piket.this, piketKamis.class);
                startActivity(intent);
            }
        });
        piketcardJumat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(piket.this, piketJumat.class);
                startActivity(intent);
            }
        });
        piketcardSabtu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(piket.this, piketSabtu.class);
                startActivity(intent);
            }
        });
    }
}
