package angelikalanger;

import java.util.ArrayList;
import java.util.List;

public class AngelikaSandBox {
    public static void main(String[] args) {
        Box<? super Long> box = new Box<>(0L);
        box.put(1L);
        Number number = 33;
//        box.put(number);


    }



}
