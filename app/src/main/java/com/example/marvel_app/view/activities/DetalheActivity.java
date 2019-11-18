package com.example.marvel_app.view.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.dh_marvelapp.R;
import com.example.marvel_app.model.pojos.Result;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.squareup.picasso.Picasso;

public class DetalheActivity extends AppCompatActivity {

    private ImageView imgHQ;
    private TextView txtTitulo;
    private TextView txtDescricao;
    private TextView txtData;
    private TextView txtPreco;
    private TextView txtPaginas;
    private FloatingActionButton btnReturn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe);

        initViews();

        if (getIntent() != null) {
            Result result = getIntent().getParcelableExtra("Result");

            Picasso.get().load(result.getThumbnail().getPath() + ".jpg").into(imgHQ);

            txtTitulo.setText(result.getTitle());
            txtDescricao.setText(result.getDescription());

            String dataISO = result.getDates().get(0).getDate().split("T")[0];
            String[] dates = dataISO.split("-");
            String dataUsuario = dates[2] + "/" + dates[1] + "/" + dates[0];
            txtData.setText(dataUsuario);

            txtPreco.setText("US$ " + String.format("%.2f", result.getPrices().get(0).getPrice()));
            txtPaginas.setText(result.getPageCount().toString() + " pages");

            imgHQ.setOnClickListener(v -> {
                Intent intent = new Intent(DetalheActivity.this, DetalheImagemActivity.class);
                Bundle bundle = new Bundle();
                bundle.putParcelable("Result", result);
                intent.putExtras(bundle);
                startActivity(intent);
            });
        }

        btnReturn.setOnClickListener(v -> {
            Intent intent = new Intent(DetalheActivity.this, MainActivity.class);
            startActivity(intent);
        });

    }

    public void initViews() {
        imgHQ = findViewById(R.id.imgHQ);
        txtTitulo= findViewById(R.id.txtTitulo);
        txtDescricao= findViewById(R.id.txtDescricao);
        txtData= findViewById(R.id.txtData);
        txtPreco= findViewById(R.id.txtValor);
        txtPaginas= findViewById(R.id.txtPaginas);
        btnReturn= findViewById(R.id.buttonReturn);
    }
}
