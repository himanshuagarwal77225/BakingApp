package com.udacity.bakingapp.ui.recipedetail.ingredients;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.udacity.bakingapp.data.local.model.Ingredient;
import com.udacity.bakingapp.databinding.ItemIngredientBinding;

public class IngredientViewHolder extends RecyclerView.ViewHolder {

    private final ItemIngredientBinding binding;

    public IngredientViewHolder(@NonNull ItemIngredientBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public static IngredientViewHolder create(ViewGroup parent) {
        // Inflate
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        // Create the binding
        ItemIngredientBinding binding =
                ItemIngredientBinding.inflate(layoutInflater, parent, false);
        return new IngredientViewHolder(binding);
    }

    public void bindTo(final Ingredient ingredient) {
        binding.setIngredient(ingredient);

        binding.executePendingBindings();
    }
}
