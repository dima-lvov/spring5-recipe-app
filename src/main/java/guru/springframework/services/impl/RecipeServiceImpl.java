package guru.springframework.services.impl;

import guru.springframework.domain.Recipe;
import guru.springframework.repositories.RecipeRepository;
import guru.springframework.services.RecipeService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by Dimon on 08.10.2017
 */
@Component
public class RecipeServiceImpl implements RecipeService {

	private final RecipeRepository recipeRepository;

	public RecipeServiceImpl(final RecipeRepository recipeRepository) {
		this.recipeRepository = recipeRepository;
	}

	@Override
	public Iterable<Recipe> getAll() {
		return toList(recipeRepository.findAll());
	}

	private <T> List<T> toList(final Iterable<T> iterable) {
		List<T> list = new ArrayList<>();
		if (Objects.nonNull(iterable)) {
			iterable.forEach(list::add);
		}
		return list;
	}
}
