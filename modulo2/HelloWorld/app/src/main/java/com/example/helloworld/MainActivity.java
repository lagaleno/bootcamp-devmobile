package com.example.helloworld;

import android.content.Intent;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    public final static String MENSAGEM_ADICIONAL = "com.example.intent.MENSAGEM";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void novaTela(View view) {
        Intent messageIntent  = new Intent(this, NovaTelaActivity.class);

        //passando mensagem entre componentes
        messageIntent.putExtra(MENSAGEM_ADICIONAL, "Larissa");

        startActivity(messageIntent);

    }
}