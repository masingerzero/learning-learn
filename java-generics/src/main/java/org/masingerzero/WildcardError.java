package org.masingerzero;

import java.util.List;

public class WildcardError {

        void foo(List<?> i) {
            fooHelper(i);
        }

        public<T> void fooHelper (List<T> list) {
            list.set(0, list.get(0));
        }
}
