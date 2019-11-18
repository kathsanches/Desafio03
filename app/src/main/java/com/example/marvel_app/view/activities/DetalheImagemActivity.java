package com.example.marvel_app.view.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.dh_marvelapp.R;
import com.example.marvel_app.model.pojos.Result;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.squareup.picasso.Picasso;

public class DetalheImagemActivity extends AppCompatActivity {

    private ImageView imgHQ;
    private FloatingActionButton btnReturn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_imagem);

        imgHQ = findViewById(R.id.imgDetalhe);
        btnReturn = findViewById(R.id.btnRtn);

        Result result = getIntent().getParcelableExtra("Result");
        Picasso.get().load(result.getThumbnail().getPath() + ".jpg").into(imgHQ);

        btnReturn.setOnClickListener(v -> {
            Intent intent = new Intent(DetalheImagemActivity.this, DetalheActivity.class);
            Bundle bundle = new Bundle();
            bundle.putParcelable("Result", result);
            intent.putExtras(bundle);
            startActivity(intent);
        });


    }


}
