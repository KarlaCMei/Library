package com.example.library.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.library.R;
import com.example.library.databinding.ActivityDetailBookBinding;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Arrays;

public class DetailBookActivity extends AppCompatActivity {

    private ActivityDetailBookBinding binding;
    int contador = 0;
    //Integer contador = 0;

    private String tituloLibro;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailBookBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        readExtra();

        contador = Integer.parseInt(binding.editNumCopies.getText().toString());
        binding.btnPrestar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(contador==0){
                    Toast.makeText(getApplicationContext(), "Ya no contamos con libros para prestar", Toast.LENGTH_LONG).show();

                }else{
                    contador--;
                    binding.editNumCopies.setText(String.valueOf(contador));
                   // binding.editNumCopies.setText(contador.toString());

                }

            }
        });
    }

    private void readExtra() {
        if (getIntent() != null && getIntent().getExtras() != null) {
            if (getIntent().getExtras().containsKey("TITULO")) {
                tituloLibro = getIntent().getExtras().getString("TITULO");
                configToolbar(tituloLibro);
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

            if(getIntent().getExtras().containsKey("LIST_CHARACTERS")){

                ArrayList<String> characters = getIntent().getExtras().getStringArrayList("LIST_CHARACTERS");

                /*for(int i = 0;i < characters.size(); i++){
                    binding.textCharacters.append(getString(R.string.txt_name_character_detail_activity,characters.get(i)));
                }*/


                for(String chacrter:characters){
                    binding.textCharacters.append(getString(R.string.txt_name_character_detail_activity,chacrter));

                }
            }
        }
    }

    private void configToolbar(String toolbarName) {
        setSupportActionBar(binding.toolbarBookDetail);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(toolbarName);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // return super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }




    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.share:
                Toast.makeText(this, "Lee mi libro favorito: " + tituloLibro , Toast.LENGTH_SHORT).show();
                return true;

            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}