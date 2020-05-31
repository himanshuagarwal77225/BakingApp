package com.udacity.bakingapp.utils;

import android.content.Context;

import com.udacity.bakingapp.data.RecipeRepository;
import com.udacity.bakingapp.data.local.RecipesDatabase;
import com.udacity.bakingapp.data.remote.ApiClient;
import com.udacity.bakingapp.data.remote.RecipeService;

public class Injection {
    public static ViewModelFactory provideViewModelFactory(Context context) {
        RecipeRepository repository = provideRecipeRepository(context);
        return ViewModelFactory.getInstance(repository);
    }

    public static RecipeRepository provideRecipeRepository(Context context) {
        RecipeService apiService = ApiClient.getInstance();
        AppExecutors executors = AppExecutors.getInstance();
        RecipesDatabase database = RecipesDatabase.getInstance(context.getApplicationContext());
        return RecipeRepository.getInstance(
                executors,
                apiService,
                database);
    }
}
