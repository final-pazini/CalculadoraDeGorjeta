package com.loopgabriel.calculadoradegorjetasimple;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText editTextValor;
    private TextView textPorcentagem;
    private SeekBar seekBarPorcentagem;
    private TextView textGorjeta;
    private TextView textTotal;

    private double porcentagem = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextValor = findViewById(R.id.editTextValor);
        textPorcentagem = findViewById(R.id.textPorcentagem);
        seekBarPorcentagem = findViewById(R.id.seekBarPorcentagem);
        textGorjeta = findViewById(R.id.textgorjeta);
        textTotal = findViewById(R.id.textTotal);

        seekBarPorcentagem.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                porcentagem = i;
                textPorcentagem.setText(Math.round(porcentagem) + "%");
                calcular();

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


    }


    public void calcular(){

        String valorRecuperado = editTextValor.getText().toString();
        if(valorRecuperado == null || valorRecuperado.equals("")){

            Toast.makeText(
                    getApplicationContext(),
                    "Digite um valor primeiro",
                    Toast.LENGTH_SHORT
            ).show();

        }else{

            //conversão de string para double
            double valorDigitado = Double.parseDouble(valorRecuperado);

            //calculo
            double gorjeta = valorDigitado * (porcentagem/100);
            double total = gorjeta + valorDigitado;

            //exibição
            textGorjeta.setText("R$ " + gorjeta);
            textTotal.setText("R$ " + total);

        }

    }
}