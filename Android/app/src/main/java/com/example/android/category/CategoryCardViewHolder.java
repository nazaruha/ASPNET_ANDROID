package com.example.android.category;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android.R;

public class CategoryCardViewHolder extends RecyclerView.ViewHolder { // обично VIEW-шка
    private ImageView categoryImage;
    private TextView categoryName;

    public CategoryCardViewHolder(@NonNull View itemView) {
        super(itemView);
        categoryName = itemView.findViewById(R.id.categoryName);
        categoryImage = itemView.findViewById(R.id.categoryImage);
    }

    public ImageView getCategoryImage() {
        return categoryImage;
    }

    public TextView getCategoryName() {
        return categoryName;
    }
}
