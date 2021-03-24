package com.example.helloworld;

import android.content.Intent;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class NovaTelaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nova_tela);

        Intent intent = getIntent();

        String mensagem = intent.getStringExtra(MainActivity.MENSAGEM_ADICIONAL);

        TextView labelName = (TextView)findViewById(R.id.textView2);
        labelName.setText(mensagem);
    }


}