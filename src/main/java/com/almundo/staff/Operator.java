package com.almundo.staff;

import com.almundo.callcenter.Dispatcher;
import com.almundo.conf.Rank;

/**
 * @author Juan Claje hija de empleado. Valor del atributo rank = 0
 */
public class Operator extends Employee {

    public Operator(Dispatcher dispatcher, String name) {
        super(dispatcher, name);
        rank = Rank.Operator;
    }
}
