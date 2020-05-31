package com.udacity.bakingapp.data.local;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.udacity.bakingapp.data.local.dao.IngredientsDao;
import com.udacity.bakingapp.data.local.dao.RecipesDao;
import com.udacity.bakingapp.data.local.model.Ingredient;
import com.udacity.bakingapp.data.local.model.Recipe;
import com.udacity.bakingapp.data.local.model.Step;

@Database(
        entities = {Recipe.class, Step.class, Ingredient.class},
        version = 1,
        exportSchema = false)
public abstract class RecipesDatabase extends RoomDatabase {

    public static final String DATABASE_NAME = "Recipes.db";
    private static final Object sLock = new Object();
    private static RecipesDatabase INSTANCE;

    public static RecipesDatabase getInstance(Context context) {
        synchronized (sLock) {
            if (INSTANCE == null) {
                INSTANCE = buildDatabase(context);
            }
            return INSTANCE;
        }
    }

    private static RecipesDatabase buildDatabase(final Context context) {
        return Room.databaseBuilder(
                context.getApplicationContext(),
                RecipesDatabase.class,
                DATABASE_NAME).build();
    }

    public abstract RecipesDao recipesDao();

    public abstract IngredientsDao ingredientsDao();
}
