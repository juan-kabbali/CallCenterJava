package com.almundo.callcenter;

/**
 * @author Juan Claje hija de empleado. Valor del atributo rank = 1
 */
class Supervisor extends Employee {

    public Supervisor(Dispatcher dispatcher, String name) {
        super(dispatcher, name);
        rank = Rank.Supervisor;
    }
}
