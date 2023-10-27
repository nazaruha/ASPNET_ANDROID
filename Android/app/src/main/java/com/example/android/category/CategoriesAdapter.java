package com.example.android.category;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.android.application.HomeApplication;
import com.example.android.dto.category.CategoryItemDTO;

import java.util.List;
import com.example.android.R;

public class CategoriesAdapter extends RecyclerView.Adapter<CategoryCardViewHolder> { // для адаптування даних (під
    //  різні пристрої; країни - мову мінять; оптимізація - зображень, медіафайлів; реакція на зміни в пристрої)

    private List<CategoryItemDTO> categories; // list of our categories

    public CategoriesAdapter(List<CategoryItemDTO> categories) {
        this.categories = categories;
    }

    @NonNull
    @Override
    public CategoryCardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext()) // Returns the context the view is running in, through which it can access the current theme, resources, etc. Returns: The view's Context.
                .inflate(R.layout.category_view, parent, false);
        return new CategoryCardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryCardViewHolder holder, int position) {
        if (categories != null && position < categories.size()) {
            CategoryItemDTO item = categories.get(position); // по позиції списка отримуємо один елемент
            holder.getCategoryName().setText(item.getName()); // записуємо текст нашої категорії
            Glide.with(HomeApplication.getAppContext())
                    .load(item.getImage()) // image url
                    .apply(new RequestOptions().override(600)) // ставимо розширення
                    .into(holder.getCategoryImage()); // куда виводить
        }
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }
}
