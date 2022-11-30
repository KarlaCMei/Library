package com.example.library.view;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.library.data.Book;
import com.example.library.data.BookList;
import com.example.library.databinding.ActivityMainBinding;
import com.example.library.view.adapters.CustomBookAdapter;
import com.example.library.view.adapters.OnClicBookListener;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements OnClicBookListener {

    private ActivityMainBinding binding;
    private CustomBookAdapter adapter;

    @SuppressLint("NotifyDataSetChanged")
    ActivityResultLauncher<Intent> startActivityIntent = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if (result.getResultCode() == Activity.RESULT_OK) {
                    Intent intent = result.getData();
                    if(intent!=null && intent.getExtras()!=null && intent.getExtras().containsKey("CREATE_BOOK")){
                        if(intent.getExtras().getBoolean("CREATE_BOOK")){
                            if(adapter!=null){
                                adapter.notifyDataSetChanged();
                            }
                        }
                    }
                }
            });


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        configToolbar();

        adapter = new CustomBookAdapter(BookList.getBooks(), this);
        binding.listBooks.setLayoutManager(new GridLayoutManager(this, 2));
        binding.listBooks.setAdapter(adapter);

        binding.btnCreateBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent createBook = new Intent(MainActivity.this, CreateBookActivity.class);
                startActivityIntent.launch(createBook);
            }
        });
    }


    @Override
    public void onBookClicListener(Book book) {
        Intent detailActivity = new Intent(this, DetailBookActivity.class);
        detailActivity.putExtra("TITULO", book.getTitulo());
        detailActivity.putExtra("GENDER", book.getGenero());
        detailActivity.putExtra("DESCRIPTION", book.getDescripcion());
        detailActivity.putExtra("NUM_PAGES", book.getPageNum());
        detailActivity.putExtra("NUM_COPIES", book.getCopies());
        detailActivity.putExtra("URL_IMG", book.getUrlImg());
        detailActivity.putExtra("LIST_CHARACTERS", book.getCharacters());
        startActivity(detailActivity);
    }

    private void configToolbar() {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Home");
        }
    }


}