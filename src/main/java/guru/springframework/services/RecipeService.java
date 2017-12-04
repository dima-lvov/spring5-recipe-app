package guru.springframework.services;

import guru.springframework.commands.RecipeCommand;
import guru.springframework.domain.Recipe;

/**
 * Created by Dimon on 08.10.2017
 */
public interface RecipeService {

	Iterable<Recipe> getRecipes();

	Recipe findById(final Long id);

	RecipeCommand saveRecipeCommand(final RecipeCommand command);
}
