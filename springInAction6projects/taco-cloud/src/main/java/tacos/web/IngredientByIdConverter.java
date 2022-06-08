package tacos.web;


import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import tacos.Ingredient;
import tacos.Ingredient.Type;
import tacos.data.IngredientRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static tacos.Ingredient.Type.*;

@Component
public class IngredientByIdConverter implements Converter<String, Ingredient> {

    IngredientRepository ingredientRepository;

    public IngredientByIdConverter(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public Ingredient convert(String id) {
        Optional<Ingredient> byId = ingredientRepository.findById(id);
        return ingredientRepository.findById(id).orElse(null);
    }

}
