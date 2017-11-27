package com.almundo.callcenter;

/**
 * @author Juan Claje hija de empleado. Valor del atributo rank = 0
 */
class Operator extends Employee {

    public Operator(Dispatcher dispatcher, String name) {
        super(dispatcher, name);
        rank = Rank.Operator;
    }
}
