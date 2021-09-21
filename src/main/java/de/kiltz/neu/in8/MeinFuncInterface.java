package de.kiltz.neu.in8;

@FunctionalInterface
public interface MeinFuncInterface {

    int tuWas(int a, int b);

    default int addiere(int a, int b) {
        return a + b;
    }
}
