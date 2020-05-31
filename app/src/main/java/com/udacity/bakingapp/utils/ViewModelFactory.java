package com.udacity.bakingapp.utils;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.udacity.bakingapp.data.RecipeRepository;
import com.udacity.bakingapp.ui.recipedetail.RecipeDetailViewModel;
import com.udacity.bakingapp.ui.recipelist.RecipeListViewModel;

public class ViewModelFactory implements ViewModelProvider.Factory {

    private final RecipeRepository repository;

    private ViewModelFactory(RecipeRepository repository) {
        this.repository = repository;
    }

    public static ViewModelFactory getInstance(RecipeRepository repository) {
        return new ViewModelFactory(repository);
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(RecipeListViewModel.class)) {
            //noinspection unchecked
            return (T) new RecipeListViewModel(repository);
        } else if (modelClass.isAssignableFrom(RecipeDetailViewModel.class)) {
            //noinspection unchecked
            return (T) new RecipeDetailViewModel(repository);
        }
        throw new IllegalArgumentException("Unknown ViewModel class: " + modelClass.getName());
    }
}
