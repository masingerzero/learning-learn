package org.masingerzero.modernjava;

import java.util.HashMap;
import java.util.Map;

public class Sandbox {

    public static void main(String[] args) {
//        System.out.println("Hello Shell");
//       new Sandbox().testOverflow(0);

//        Map<String, List<>> characterMap = new HashMap<>();
//        characterMap.put("one", 'a');
//        characterMap.put("one", 'b');
//
//        System.out.println(characterMap);

    }

    public void testOverflow(int i) {
        System.out.println(i++);
        testOverflow(i);
    }

}



