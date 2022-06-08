package tacos.data;

import tacos.Taco;
import tacos.TacoOrder;

import java.util.Optional;

public interface TacoOrderRepository {
    TacoOrder save(TacoOrder tacoOrder);

    Optional<TacoOrder> findById(Long id);
}
