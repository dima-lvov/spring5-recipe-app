package guru.springframework.repositories;

import guru.springframework.domain.Recipe;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Dimon on 08.10.2017
 */
public interface RecipeRepository extends CrudRepository<Recipe, Long> {
}
