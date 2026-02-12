/*
 * Dieses Programm ist KONSENS-Software und urheberrechtlich geschützt.
 * Nutzungsrechte werden nach KONSENS-Gesetz § 27 Nutzungsrecht und
 * Verwaltungsabkommen KONSENS Abschnitt 11 Nutzungsrecht  eingeräumt.
 *
 * Eine Kopie der Lizenz erhalten Sie unter:
 *
 * https://www.gesetze-im-internet.de/konsens-g/BJNR312900017.html
 * http://archiv.konsens.ktz.testa-de.net/Zentraldokumente/VerwAbk_KONSENS/
 */
package de.kiltz.neu.in8;

import java.util.function.BiConsumer;

public class BiConsumerTest {
    public static void main(String[] args) {
        BiConsumer<Integer, Integer> xUndY = (x, y) -> System.out.println(x + " + " + y + " = " + (x + y));
        xUndY.accept(1, 2);

        addTwo(1, 2, (x, y) -> System.out.println(x + y));          // 3
        addTwo("Node", ".js", (x, y) -> System.out.println(x + y)); // Node.js

        // s. https://mkyong.com/java8/java-8-biconsumer-examples/
    }

    static <T> void addTwo(T a1, T a2, BiConsumer<T, T> c) {
        c.accept(a1, a2);
    }
}
