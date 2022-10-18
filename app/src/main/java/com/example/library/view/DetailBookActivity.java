package com.example.library.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.library.databinding.ActivityDetailBookBinding;
import com.squareup.picasso.Picasso;

import java.util.Arrays;

public class DetailBookActivity extends AppCompatActivity {

    private ActivityDetailBookBinding binding;
    int contador = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailBookBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        readExtra();


        binding.btnPrestar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(contador == numPages.length){
                    System.out.println("Ya no contamos con libros para prestar");
                }else{
                    numeros[contador] = aleatorio;
                    contador--;
                }
                //System.out.println(Arrays.toString(numeros));
            }
        });
    }

    private void readExtra() {
        if (getIntent() != null && getIntent().getExtras() != null) {
            if (getIntent().getExtras().containsKey("TITULO")) {
                configToolbar(getIntent().getExtras().getString("TITULO"));
            }

            if (getIntent().getExtras().containsKey("GENDER")) {
                binding.textGender.setText(getIntent().getExtras().getString("GENDER"));
            }

            if (getIntent().getExtras().containsKey("DESCRIPTION")) {
                binding.textDescription.setText(getIntent().getExtras().getString("DESCRIPTION"));
            }

            if (getIntent().getExtras().containsKey("NUM_PAGES")) {
                binding.editNumPages.setText(String.valueOf(getIntent().getExtras().getInt("NUM_PAGES")));
            }
            if (getIntent().getExtras().containsKey("NUM_COPIES")) {
                binding.editNumCopies.setText(String.valueOf(getIntent().getExtras().getInt("NUM_COPIES")));
            }

            if (getIntent().getExtras().containsKey("URL_IMG")) {
                Picasso.with(this).load(getIntent().getExtras().getString("URL_IMG")).into(binding.imgBook);
            }
        }
    }

    private void configToolbar(String toolbarName) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(toolbarName);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }



}