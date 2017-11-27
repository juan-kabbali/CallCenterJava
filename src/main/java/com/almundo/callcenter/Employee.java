package com.almundo.callcenter;

/**
 *
 * @author Juan Abstraccion de un empleado que cumple la funcion de modelar las
 * caracteristicas en comun de los tres tipos de empleados existentes en el
 * callcenter. Adicionalmente, gestiona el estado de su trabajo, es decir, esta
 * en la capacidad de recibir llamadas, terminarlas, reconocer cuando esta libre
 * y reasigarse una llamada sin atender.
 */
abstract class Employee {

    private Call currentCall = null;
    protected Rank rank;
    private Dispatcher dispatcher;
    private String name;

    public Employee(Dispatcher dispatcher, String name) {
        this.dispatcher = dispatcher;
        this.name = name;
    }

    /**
     * Retorna el nombre del empleado
     *
     * @return Name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Inicia la llamada
     *
     * @param call
     */
    public void receiveCall(Call call) {
        currentCall = call;
    }

    /**
     * Finaliza la llamada y libera el empleado
     */
    public void callCompleted() {
        if (currentCall != null) {
            currentCall.end();
            currentCall = null;
        }
        // Si hay llamadas en espera, se asignan a un empleado
        assignNewCall();
    }

    /**
     * Si el empleado esta libre, le asigna una llamada que este encolada
     */
    public void assignNewCall() {
        if (isFree()) {
            dispatcher.assignCall(this);
        }
    }

    /**
     * Retorna el valor de isFree
     *
     * @return isFree
     */
    public boolean isFree() {
        return currentCall == null;
    }

    /**
     * Retorna el Rank
     *
     * @return Rank
     */
    public Rank getRank() {
        return rank;
    }
}
