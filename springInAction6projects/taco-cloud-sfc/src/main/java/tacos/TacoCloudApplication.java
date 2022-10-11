package tacos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;
import tacos.Ingredient.Type;
import tacos.data.IngredientRepository;
import tacos.data.OrderRepository;
import tacos.data.UserRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

@SpringBootApplication
public class TacoCloudApplication {

    public static void main(String[] args) {
        SpringApplication.run(TacoCloudApplication.class, args);
    }

    @Bean
    @Profile("!prod")
    public CommandLineRunner dataLoader(IngredientRepository repo) {
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                repo.save(new Ingredient("FLTO", "Flour Tortilla", Type.WRAP));
                repo.save(new Ingredient("COTO", "Corn Tortilla", Type.WRAP));
                repo.save(new Ingredient("GRBF", "Ground Beef", Type.PROTEIN));
                repo.save(new Ingredient("CARN", "Carnitas", Type.PROTEIN));
                repo.save(new Ingredient("TMTO", "Diced Tomatoes", Type.VEGGIES));
                repo.save(new Ingredient("LETC", "Lettuce", Type.VEGGIES));
                repo.save(new Ingredient("CHED", "Cheddar", Type.CHEESE));
                repo.save(new Ingredient("JACK", "Monterrey Jack", Type.CHEESE));
                repo.save(new Ingredient("SLSA", "Salsa", Type.SAUCE));
                repo.save(new Ingredient("SRCR", "Sour Cream", Type.SAUCE));
            }
        };
    }


    @Bean
//    @Profile("!prod")
    public CommandLineRunner createData(UserRepository userRepository, OrderRepository orderRepository, PasswordEncoder encoder) {
        return args -> {
            User user = new User("juanfe", encoder.encode("juanfe"), "juanfe", "street", "pinto", "tx", "23932", "543293329");
            userRepository.save(user);


            Stream.generate(() -> {
                        TacoOrder tacoOrder = new TacoOrder();
                        tacoOrder.setDeliveryName("the delivery name");
                        tacoOrder.setDeliveryCity("the city");
                        tacoOrder.setDeliveryState("TX");
                        tacoOrder.setDeliveryZip("23322");
                        tacoOrder.setCcCVV("111");
                        tacoOrder.setCcExpiration("01/30");
                        tacoOrder.setCcNumber("4101892376179388");
                        tacoOrder.setDeliveryStreet("the Street");
                        tacoOrder.setUser(user);
                        return tacoOrder;
                    })
                    .limit(200)
                    .forEach(tacoOrder -> {
                        orderRepository.save(tacoOrder);
                    });


        };
    }

    @Bean
    @ConfigurationProperties(prefix = "taco.orders")
    public ThirdPartyClass createThirdPartyClass()   {
        return new ThirdPartyClass();
    }

    @Bean
    public CommandLineRunner testThirdPartyClass(ThirdPartyClass thirdPartyClass) {
        return args -> System.out.println(thirdPartyClass);
    }

}
