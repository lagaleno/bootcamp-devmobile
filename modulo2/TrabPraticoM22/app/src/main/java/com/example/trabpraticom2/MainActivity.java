package com.example.trabpraticom2;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    public final static String MENSAGEM_ADICIONAL = "com.example.intent.MENSAGEM";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public double calculaINSS(double salarioBruto) {

        if(salarioBruto <= 1045.00) {
            return (salarioBruto*75)/1000;
        }

        if(salarioBruto <= 2089.60) {
            return ((salarioBruto*90)/1000)-15.67;
        }

        if(salarioBruto <= 3134.40 ) {
            return ((salarioBruto*120)/1000)-78.36;
        }

        if(salarioBruto <= 6101.06 ) {
            return ((salarioBruto*140)/1000)-141.05;
        }

        return 713.10;
    }

    public double calculaIRRF(double salarioBruto, double valorINSS, double num_dependentes) {
        double VALOR_DEPENDENTE = 180.59;
        double base_calculo = salarioBruto - valorINSS - (num_dependentes * VALOR_DEPENDENTE);

        if(base_calculo <= 1903.98) {
            return 0;
        }

        if(base_calculo <= 2826.65) {
            return ((base_calculo*75)/1000) - 142.80;
        }

        if(base_calculo <= 3751.05) {
            return ((base_calculo*150)/1000) - 354.0;
        }

        if(base_calculo <= 4664.68) {
            return ((base_calculo*225)/1000) - 636.13;
        }

        return ((base_calculo*275)/1000) - 869.36;
    }

    public void carregaResultado(View view) {
        EditText editText_salario = (EditText)findViewById(R.id.editText_salarioBruto);
        double salarioBruto = Double.parseDouble(editText_salario.getText().toString());
        //Log.e("TESTE", salarioBruto+"");


        EditText editText_dependente = (EditText) findViewById(R.id.editText_numeroDependente);
        double num_dependente = Double.parseDouble(editText_dependente.getText().toString());
        //Log.e("TESTE", num_dependente+"");

        EditText editText_outro = (EditText) findViewById(R.id.editText_OutrosDescontos);
        double outrosDescontos = Double.parseDouble(editText_outro.getText().toString());
        Log.e("TESTE", outrosDescontos+"");

        double valorINSS = calculaINSS(salarioBruto);
        double valorIRRF = calculaIRRF(salarioBruto, valorINSS, num_dependente);
        double salarioLiquido = salarioBruto - valorINSS - valorIRRF - outrosDescontos;

        double totalDescontos = valorINSS + valorIRRF + outrosDescontos;
        double procentagemDescontos = (totalDescontos/salarioBruto)*100;


        //passando info para outra tela
        Bundle bundle = new Bundle(); //passar muitos dados para outra activity
        bundle.putString("salarioBruto", salarioBruto+"");
        bundle.putString("valorINSS", valorINSS+"");
        bundle.putString("valorIRRF", valorIRRF+"");
        bundle.putString("outrosDescontos", outrosDescontos+"");
        bundle.putString("salarioLiquido", salarioLiquido+"");
        bundle.putString("porcentagemDescontos", procentagemDescontos+"");
        Log.e("TESTE", bundle.toString());

        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);




    }
}