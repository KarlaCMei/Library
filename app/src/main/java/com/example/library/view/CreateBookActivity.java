package com.example.library.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.library.data.Book;
import com.example.library.data.BookList;
import com.example.library.databinding.ActivityCreateBookBinding;

public class CreateBookActivity extends AppCompatActivity {

    private ActivityCreateBookBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCreateBookBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        configToolbar();

        binding.btnCreateBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createBook();
            }
        });
    }

    public void createBook() {
        Book newBook = new Book();
        newBook.setTitulo(binding.editTitle.getText().toString());
        newBook.setGenero(binding.editGender.getText().toString());
        newBook.setDescripcion(binding.editDescription.getText().toString());
        newBook.setPageNum(Integer.parseInt(binding.editNumPages.getText().toString()));
        newBook.setCopies(Integer.parseInt(binding.editNumCopies.getText().toString()));
        newBook.setUrlImg(binding.editUrlImg.getText().toString());
        BookList.addBook(newBook);

        //intent para regresar al activity con informacion
        Intent finishIntent = new Intent();
        finishIntent.putExtra("CREATE_BOOK", true);
        setResult(RESULT_OK, finishIntent);
        finish();
    }

    private void configToolbar() {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Crear libro");
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