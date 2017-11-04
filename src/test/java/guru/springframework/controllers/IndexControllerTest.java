package guru.springframework.controllers;

import guru.springframework.domain.Recipe;
import guru.springframework.services.RecipeService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.lang.Nullable;
import org.springframework.ui.Model;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by Dimon on 01.11.2017
 */
public class IndexControllerTest {

	private static final String EXPECTED_INDEX_PAGE_NAME = "index";
	public static final String RECIPES_ATTRIBUTE_NAME = "recipes";

	private IndexController controller;

	@Mock
	private RecipeService recipeService;

	@Mock
	private Model model;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		controller = new IndexController(recipeService);
	}

	@Test
	public void getIndexPage() throws Exception {
		final Set<Recipe> recipes = new HashSet<>();
		final Recipe firstRecipe = new Recipe();
		firstRecipe.setId(1L);
		final Recipe secondRecipe = new Recipe();
		secondRecipe.setId(2L);
		recipes.add(firstRecipe);
		recipes.add(secondRecipe);

		when(recipeService.getAll()).thenReturn(recipes);
		
		final ArgumentCaptor<Set<Recipe>> argumentCaptor = ArgumentCaptor.forClass(Set.class);

		final String actualViewName = controller.getIndexPage(model);
		assertThat(actualViewName, equalTo(EXPECTED_INDEX_PAGE_NAME));
		verify(recipeService, times(1)).getAll();
		verify(model, times(1))
				.addAttribute(eq(RECIPES_ATTRIBUTE_NAME), argumentCaptor.capture());

		assertThat(argumentCaptor.getValue(), equalTo(recipes));
	}

}