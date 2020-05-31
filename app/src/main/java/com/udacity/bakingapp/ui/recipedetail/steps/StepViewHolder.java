package com.udacity.bakingapp.ui.recipedetail.steps;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.udacity.bakingapp.data.local.model.Step;
import com.udacity.bakingapp.databinding.ItemStepBinding;

public class StepViewHolder extends RecyclerView.ViewHolder {

    private final ItemStepBinding binding;

    public StepViewHolder(@NonNull ItemStepBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public static StepViewHolder create(ViewGroup parent) {
        // Inflate
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        // Create the binding
        ItemStepBinding binding =
                ItemStepBinding.inflate(layoutInflater, parent, false);
        return new StepViewHolder(binding);
    }

    public void bindTo(final Step step, final int position) {
        binding.textTitle.setText(step.getShortDescription());
        binding.textOrder.setText(String.valueOf(position));
        binding.executePendingBindings();
    }
}
