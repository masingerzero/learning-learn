package tacos;

import lombok.Data;
import lombok.Getter;
import org.hibernate.validator.constraints.CreditCardNumber;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class TacoOrder implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private Date placedAt;

    @NotBlank(message = "Delivery name is required")
    String deliveryName;

    @NotBlank(message = "Delivery street name is required")
    String deliveryStreet;

    @NotBlank(message = "Delivery city is required")
    String deliveryCity;

    @NotBlank(message = "Delivery state is required")
    String deliveryState;

    @NotBlank(message = "Delivery zip is required")
    String deliveryZip;

    @CreditCardNumber(message = "Not a valid credit card number")
    String ccNumber;

    @Pattern(regexp="^(0[1-9]|1[0-2])([\\/])([2-9][0-9])$",
            message="Must be formatted MM/YY")
    String ccExpiration;

    @Digits(integer=3, fraction=0, message="Invalid CVV")
    String ccCVV;
    private List<Taco> tacos = new ArrayList<>();

    public TacoOrder() {

    }

    public void addTaco(Taco taco) {
        tacos.add(taco);
    }
}
