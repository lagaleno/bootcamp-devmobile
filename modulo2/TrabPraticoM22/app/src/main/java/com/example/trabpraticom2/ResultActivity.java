package com.example.trabpraticom2;

import android.util.Log;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Bundle bundle = getIntent().getExtras();
        Log.e("TESTE1", bundle.getString("salarioBruto"));

        String salarioBruto = bundle.getString("salarioBruto");
        TextView campo_salarioBruto = (TextView)findViewById(R.id.resultado_SalarioBruto);
        campo_salarioBruto.setText(salarioBruto);

        String valorINSS = bundle.getString("valorINSS");
        TextView campo_valorINSS = (TextView)findViewById(R.id.resultado_INSS);
        campo_valorINSS.setText(valorINSS);

        String valorIRRF = bundle.getString("valorIRRF");
        TextView campo_valorIRRF = (TextView)findViewById(R.id.resultado_IRRF);
        campo_valorIRRF.setText(valorIRRF);

        String outrosDescontos = bundle.getString("outrosDescontos");
        TextView campo_outrosDescontos = (TextView)findViewById(R.id.resultado_OutrosDescontos);
        campo_outrosDescontos.setText(outrosDescontos);

        String salarioLiquido = bundle.getString("salarioLiquido");
        TextView campo_salarioLiquido = (TextView)findViewById(R.id.resultado_SalarioLiquido);
        campo_salarioLiquido.setText(salarioLiquido);

        String porcentagemDescontos = bundle.getString("porcentagemDescontos");
        TextView campo_porcentagemDescontos = (TextView)findViewById(R.id.resultado_Descontos);
        campo_porcentagemDescontos.setText(porcentagemDescontos);

    }


}