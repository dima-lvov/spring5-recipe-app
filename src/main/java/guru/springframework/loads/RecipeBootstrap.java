package guru.springframework.loads;

import guru.springframework.domain.Difficulty;
import guru.springframework.domain.Ingredient;
import guru.springframework.domain.Notes;
import guru.springframework.domain.Recipe;
import guru.springframework.domain.UnitOfMeasure;
import guru.springframework.repositories.CategoryRepository;
import guru.springframework.repositories.RecipeRepository;
import guru.springframework.repositories.UnitOfMeasureRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

import static java.util.Arrays.asList;

/**
 * Created by Dimon on 08.10.2017
 */
@Slf4j
@Component
public class RecipeBootstrap implements ApplicationListener<ContextRefreshedEvent> {

	private final CategoryRepository categoryRepository;
	private final RecipeRepository recipeRepository;
	private final UnitOfMeasureRepository unitOfMeasureRepository;

	public RecipeBootstrap(final CategoryRepository categoryRepository,
	                       final RecipeRepository recipeRepository,
	                       final UnitOfMeasureRepository unitOfMeasureRepository) {
		this.categoryRepository = categoryRepository;
		this.recipeRepository = recipeRepository;
		this.unitOfMeasureRepository = unitOfMeasureRepository;
	}

	@Override
	@Transactional
	public void onApplicationEvent(final ContextRefreshedEvent event) {
		log.debug("---->ContextRefreshedEvent...");
		recipeRepository.saveAll(getRecipes());
	}

	private List<Recipe> getRecipes() {
		Recipe guacamole = new Recipe();
		guacamole.setDescription("How to Make Perfect Guacamole");
		guacamole.getCategories().add(categoryRepository.findByDescription("Mexican").get());
		guacamole.getCategories().add(categoryRepository.findByDescription("American").get());
		guacamole.setPrepTime(10);
		guacamole.setServings(4);
		guacamole.setDifficulty(Difficulty.EASY);
		Notes guacamoleNotes = new Notes();
		guacamoleNotes.setRecipeNotes("For a very quick guacamole just take a 1/4 cup of salsa and mix it in" +
				" with your mashed avocados.\n" +
				"Feel free to experiment! One classic Mexican guacamole has pomegranate seeds and chunks of " +
				"peaches in it (a Diana Kennedy favorite)." +
				" Try guacamole with added pineapple, mango, or strawberries.\n" +
				"The simplest version of guacamole is just mashed avocados with salt. " +
				"Don't let the lack of availability of other ingredients stop you from making guacamole.\n" +
				"To extend a limited supply of avocados, add either sour cream or cottage " +
				"cheese to your guacamole dip. Purists may be horrified, but so what? It tastes great.\n" +
				"For a deviled egg version with guacamole, try our Guacamole Deviled Eggs!\n" +
				"\n" +
				"\n" +
				"Read more: http://www.simplyrecipes.com/recipes/perfect_guacamole/#ixzz4ux5ewHKq"
		);
		guacamole.setNotes(guacamoleNotes);
		guacamole.setDirections("1 Cut avocado, remove flesh: Cut the avocados in half. " +
				"Remove seed. Score the inside of the avocado with a blunt knife and scoop out the flesh with a spoon. "
				+ "(See How to Cut and Peel an Avocado.) Place in a bowl.\n" +
				"\n" +
				"2 Mash with a fork: Using a fork, roughly mash the avocado. " +
				"(Don't overdo it! The guacamole should be a little chunky.)\n" +
				"\n" +
				"3 Add salt, lime juice, and the rest: Sprinkle with salt and lime (or lemon) juice." +
				" The acid in the lime juice will provide some balance to the richness of the avocado" +
				" and will help delay the avocados from turning brown.\n" +
				"Add the chopped onion, cilantro, black pepper, and chiles. " +
				"Chili peppers vary individually in their hotness. So, start with a half of one chili" +
				" pepper and add to the guacamole to your desired degree of hotness.\n" +
				"Remember that much of this is done to taste because of the variability in the fresh " +
				"ingredients. Start with this recipe and adjust to your taste.\n" +
				"4 Cover with plastic and chill to store: Place plastic wrap on the surface of the " +
				"" +
				"\n" +
				"Chilling tomatoes hurts their flavor, so if you want to add chopped tomato to your" +
				" guacamole, add it just before serving.\n" +
				"\n" +
				"\n" +
				"Read more: http://www.simplyrecipes.com/recipes/perfect_guacamole/#ixzz4ux5z945h");

		Recipe taco = new Recipe();
		taco.setDescription("Spicy Grilled Chicken Tacos Recipe");
		taco.getCategories().add(categoryRepository.findByDescription("Mexican").get());
		taco.getCategories().add(categoryRepository.findByDescription("American").get());
		taco.setPrepTime(20);
		taco.setCookTime(15);
		taco.setServings(6);
		taco.setDifficulty(Difficulty.MODERATE);
		taco.setSource("Sally Pasley Vargas");
		Notes tacoNotes = new Notes();
		tacoNotes.setRecipeNotes("We have a family motto and it is this: Everything goes better in a tortilla.\n" +
				"Any and every kind of leftover can go inside a warm tortilla, usually with a healthy dose of pickled " +
				"jalapenos. I can always sniff out a late-night snacker when the aroma of tortillas heating in a hot " +
				"pan on the stove comes wafting through the house.\n" +
				"Today’s tacos are more purposeful – a deliberate meal instead of a secretive midnight snack!\n" +
				"First, I marinate the chicken briefly in a spicy paste of ancho chile powder, oregano, cumin, and " +
				"sweet orange juice while the grill is heating. You can also use this time to prepare the taco toppings.\n" +
				"Grill the chicken, then let it rest while you warm the tortillas. Now you are ready to assemble " +
				"the tacos and dig in. The whole meal comes together in about 30 minutes!\n" +
				"\n" +
				"\n" +
				"Read more: http://www.simplyrecipes.com/recipes/spicy_grilled_chicken_tacos/#ixzz4ux4P5aVb");
		taco.setNotes(tacoNotes);
		taco.setDirections("1 Prepare a gas or charcoal grill for medium-high, direct heat.\n" +
				"2 Make the marinade and coat the chicken: In a large bowl, stir together the chili powder, oregano," +
				" cumin, sugar, salt, garlic and orange zest. Stir in the orange juice and olive oil to make a loose" +
				" paste. Add the chicken to the bowl and toss to coat all over.\n" +
				"Set aside to marinate while the grill heats and you prepare the rest of the toppings.\n" +
				"Spicy Grilled Chicken Tacos\n" +
				"3 Grill the chicken: Grill the chicken for 3 to 4 minutes per side, or until a thermometer " +
				"inserted into the thickest part of the meat registers 165F. " +
				"Transfer to a plate and rest for 5 minutes.\n" +
				"4 Warm the tortillas: " +
				"Place each tortilla on the grill or on a hot, dry skillet over medium-high heat." +
				" As soon as you see pockets of the air start to puff up in the tortilla, turn it with tongs " +
				" heat for a few seconds on the other side.\n" +
				"Wrap warmed tortillas in a tea towel to keep them warm until serving.\n" +
				"5 Assemble the tacos: Slice the chicken into strips. On each tortilla, place a small handful " +
				"of arugula. Top with chicken slices, sliced avocado, radishes, tomatoes, and onion slices. " +
				"Drizzle with the thinned sour cream. Serve with lime wedges.\n" +
				"\n" +
				"\n" +
				"Read more: http://www.simplyrecipes.com/recipes/spicy_grilled_chicken_tacos/#ixzz4ux4P5aVb");
		addGuacamoleIngredients(guacamole);
		addTacoIngredients(taco);
		return asList(guacamole, taco);
	}

	private final void addGuacamoleIngredients(Recipe owner) {
		log.debug("----> addGuacamoleIngredients...");
		UnitOfMeasure teaspoon = unitOfMeasureRepository.findByDescription("Teaspoon").get();
		UnitOfMeasure tablespoon = unitOfMeasureRepository.findByDescription("Tablespoon").get();
		UnitOfMeasure each = unitOfMeasureRepository.findByDescription("Each").get();
		UnitOfMeasure cup = unitOfMeasureRepository.findByDescription("Cup").get();
		UnitOfMeasure dash = unitOfMeasureRepository.findByDescription("Dash").get();

		owner.addIngredient(new Ingredient("Ripe avocados", toBigDecimal(2), each)).
				addIngredient(new Ingredient("Kosher salt", toBigDecimal(0.5), teaspoon)).
				addIngredient(new Ingredient("Fresh lime juice or lemon juice",
						toBigDecimal(1), tablespoon)).
				addIngredient(new Ingredient("Minced red onion or thinly sliced green",
						toBigDecimal(0.25), cup)).
				addIngredient(new Ingredient("Serrano chilies, stems and seeds removed, minced",
						toBigDecimal(2), each)).
				addIngredient(new Ingredient("Tablespoons cilantro (leaves and tender stems), finely chopped",
						toBigDecimal(2), each)).
				addIngredient(new Ingredient("Freshly grated black pepper", toBigDecimal(1), dash)).
				addIngredient(new Ingredient("Ripe tomato, seeds and pulp removed, chopped",
						toBigDecimal(0.5), each));

	}

	private final void addTacoIngredients(Recipe owner) {
		log.debug("----> addTacoIngredients...");
		UnitOfMeasure teaspoon = unitOfMeasureRepository.findByDescription("Teaspoon").get();
		UnitOfMeasure tablespoon = unitOfMeasureRepository.findByDescription("Tablespoon").get();
		UnitOfMeasure each = unitOfMeasureRepository.findByDescription("Each").get();

		owner.addIngredient(new Ingredient("Ancho chili powder", toBigDecimal(2), tablespoon)).
				addIngredient(new Ingredient("Dried oregano", toBigDecimal(1), teaspoon)).
				addIngredient(new Ingredient("Dried cumin",toBigDecimal(1), teaspoon)).
				addIngredient(new Ingredient("Sugar", toBigDecimal(1), teaspoon)).
				addIngredient(new Ingredient("Salt", toBigDecimal(0.5), teaspoon)).
				addIngredient(new Ingredient("Glove garlic, finely chopped", toBigDecimal(1), each)).
				addIngredient(new Ingredient("Finely grated orange zest", toBigDecimal(1), tablespoon)).
				addIngredient(new Ingredient("Fresh-squeezed orange juice", toBigDecimal(3), tablespoon)).
				addIngredient(new Ingredient("Olive oil", toBigDecimal(2), tablespoon)).
				addIngredient(new Ingredient("Skinless, boneless chicken thighs", toBigDecimal(6), each));
	}

	private BigDecimal toBigDecimal(Integer number) {
		return BigDecimal.valueOf(number);
	}
	private BigDecimal toBigDecimal(Double number) {
		return BigDecimal.valueOf(number);
	}
}