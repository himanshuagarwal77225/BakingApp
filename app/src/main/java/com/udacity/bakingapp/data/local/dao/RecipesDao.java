package com.udacity.bakingapp.data.local.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;

import com.udacity.bakingapp.data.local.model.Recipe;

@Dao
public interface RecipesDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertRecipe(Recipe recipe);

}
