package guru.springframework.services;

import guru.springframework.domain.Recipe;

/**
 * Created by Dimon on 08.10.2017
 */
public interface RecipeService {

	Iterable<Recipe> getAll();

	Recipe getById(Long id);
}
