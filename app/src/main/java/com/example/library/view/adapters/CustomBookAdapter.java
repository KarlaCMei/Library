package com.example.library.view.adapters;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.library.R;
import com.example.library.data.Book;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CustomBookAdapter extends RecyclerView.Adapter<CustomBookAdapter.ViewHolder> {

    private ArrayList<Book> mDataSet;
    private OnClicBookListener listener;

    /**
     * Initialize the dataset of the Adapter.
     *
     * @param dataSet String[] containing the data to populate views to be used by RecyclerView.
     */
    public CustomBookAdapter(ArrayList<Book> dataSet, OnClicBookListener listener) {
        mDataSet = dataSet;
        this.listener = listener;
    }


    // BEGIN_INCLUDE(recyclerViewOnCreateViewHolder)
    // Create new views (invoked by the layout manager)
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Create a new view.
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.book_list_item, parent, false);

       ViewHolder vh = new ViewHolder(v);
        vh.setListener(this.listener);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Book myBook = mDataSet.get(position);
        holder.setBook(myBook);
        holder.getTextTitulo().setText(myBook.getTitulo());
        holder.getTextGender().setText(myBook.getGenero());
        ImageView ivBasicImage =holder.getImgUrl();
        Picasso.with(ivBasicImage.getContext()).load(myBook.getUrlImg()).into(ivBasicImage);
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataSet.size();
    }

    // BEGIN_INCLUDE(recyclerViewSampleViewHolder)

    /**
     * Provide a reference to the type of views that you are using (custom ViewHolder)
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView textTitulo;
        private final TextView textGender;
        private final ImageView imgUrl;
        private Book book;
        private OnClicBookListener listener;

        public ViewHolder(View v) {
            super(v);
            // Define click listener for the ViewHolder's View.
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Se hace clic al elemento desde el adapter
                    Log.e("onClick", "Element " + getBook().getTitulo() + " clicked desde adapter");
                    getListener().onBookClicListener(getBook());
                }
            });
            textTitulo = v.findViewById(R.id.text_titulo);
            textGender = v.findViewById(R.id.text_genero);
            imgUrl = v.findViewById(R.id.img_book);
        }


        public TextView getTextTitulo() {
            return textTitulo;
        }

        public TextView getTextGender() {
            return textGender;
        }

        public ImageView getImgUrl() {
            return imgUrl;
        }

        public Book getBook() {
            return book;
        }

        public void setBook(Book book) {
            this.book = book;
        }

        public OnClicBookListener getListener() {
            return listener;
        }

        public void setListener(OnClicBookListener listener) {
            this.listener = listener;
        }
    }
    // END_INCLUDE(recyclerViewSampleViewHolder)
}
