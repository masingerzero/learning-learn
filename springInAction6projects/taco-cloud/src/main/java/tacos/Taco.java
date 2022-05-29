package tacos;


import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Data
public class Taco {
    @NotNull
    @Size(min = 5, message = "The name must have at least 5 characters long")
    private String name;
    @NotNull
    @Size(min = 1, message = "The taco must have at least one ingredient")
    private List<Ingredient> ingredients = new ArrayList<>();

    public void addIngredient(Ingredient ingredient) {
        ingredients.add(ingredient);
    }

}
