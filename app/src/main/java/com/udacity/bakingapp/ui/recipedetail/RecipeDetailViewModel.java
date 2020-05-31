package com.udacity.bakingapp.ui.recipedetail;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.udacity.bakingapp.data.RecipeRepository;
import com.udacity.bakingapp.data.local.model.Ingredient;
import com.udacity.bakingapp.data.local.model.Recipe;
import com.udacity.bakingapp.data.local.model.Step;
import com.udacity.bakingapp.utils.SingleLiveEvent;

import java.util.List;

import timber.log.Timber;

public class RecipeDetailViewModel extends ViewModel {

    private final SingleLiveEvent<Integer> openStepDetailEvent = new SingleLiveEvent<>();
    private MutableLiveData<Recipe> recipeLiveData = new MutableLiveData<>();
    private MutableLiveData<List<Ingredient>> ingredientsLiveData = new MutableLiveData<>();
    private MutableLiveData<List<Step>> stepsList = new MutableLiveData<>();
    private MutableLiveData<Step> currentStep = new MutableLiveData<>();
    private RecipeRepository repository;

    public RecipeDetailViewModel(RecipeRepository repository) {
        this.repository = repository;
    }

    public void init(Recipe recipe, boolean twoPane) {
        Timber.d("Initializing viewModel");

        repository.saveRecipe(recipe);

        setIngredients(recipe.getIngredients());
        setSteps(recipe.getSteps());
        if (twoPane) {
            setCurrentStep(0);
        }
    }

    public LiveData<Step> getCurrentStep() {
        return currentStep;
    }

    public void setCurrentStep(int position) {
        currentStep.setValue(stepsList.getValue().get(position));
        openStepDetailEvent.setValue(position);
    }

    private void setSteps(List<Step> steps) {
        stepsList.setValue(steps);
    }

    private void setIngredients(List<Ingredient> ingredients) {
        ingredientsLiveData.setValue(ingredients);
    }

    public LiveData<List<Step>> getStepsList() {
        return stepsList;
    }

    public LiveData<List<Ingredient>> getIngredientsLiveData() {
        return ingredientsLiveData;
    }

    public LiveData<Recipe> getRecipeLiveData() {
        return recipeLiveData;
    }

    private void setRecipeLiveData(Recipe recipe) {
        recipeLiveData.setValue(recipe);
    }

    public SingleLiveEvent<Integer> getOpenStepDetailEvent() {
        return openStepDetailEvent;
    }
}
