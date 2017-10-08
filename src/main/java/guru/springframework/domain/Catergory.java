package guru.springframework.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Set;

/**
 * Category of Recipes.
 *
 * Created by Dimon on 08.10.2017
 */
@Entity
public class Catergory {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String categoryName;
	@ManyToMany(mappedBy = "categories")
	private Set<Recipe> recipes;

	public Long getId() {
		return id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(final String categoryName) {
		this.categoryName = categoryName;
	}

	public Set<Recipe> getRecipes() {
		return recipes;
	}

	public void setRecipes(final Set<Recipe> recipes) {
		this.recipes = recipes;
	}
}

