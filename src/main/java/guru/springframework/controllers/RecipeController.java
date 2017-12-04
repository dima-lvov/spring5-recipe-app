package guru.springframework.controllers;

import guru.springframework.services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Dimon on 21.11.2017
 */
@Controller
@RequestMapping("/recipe")
public class RecipeController {

	private final RecipeService recipeService;

	@Autowired
	public RecipeController(final RecipeService recipeService) {
		this.recipeService = recipeService;
	}

	@RequestMapping("/show/{id}")
	public String getById(final Model model, final @PathVariable("id") Long id) {
		model.addAttribute("recipe", recipeService.findById(id));
		return "/recipe/show";
	}
}


