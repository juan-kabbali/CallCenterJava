package com.almundo.callcenter;

/**
 * @author Juan Claje hija de empleado. Valor del atributo rank = 2
 */
class Director extends Employee {

    public Director(Dispatcher dispatcher, String name) {
        super(dispatcher, name);
        rank = Rank.Director;
    }
}
