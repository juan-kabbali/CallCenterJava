package com.almundo.callcenter;

/**
 * @author Juan En este enum se definen los valores del Rank correspondientes a
 * la jerarquia del cargo de los empleados
 */
public enum Rank {

    /**
     *
     */
    Operator(0),

    /**
     *
     */
    Supervisor(1),

    /**
     *
     */
    Director(2);

    private int value;

    private Rank(int value) {
        this.value = value;
    }

    /**
     *
     * @return
     */
    public int getValue() {
        return this.value;
    }
}
