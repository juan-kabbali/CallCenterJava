package com.almundo.callcenter;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author Juan Representa la llamada de un cliente, tiene un rank minimo para
 * asignarla al empleado de ese rank que este disponible para responderla
 */
public class Call implements Runnable {

    private final int MILISECONDS_TO_SECOONDS_CONVERTION = 1000;
    private final int LOWER_CALL_LIMIT = 5;
    private final int UPPER_CALL_LIMIT = 10;

    // Numero minimo del Rank del empleado que puede atender esta llamada
    private Rank rank;

    // Empleado que esta atentiendo la llamada 
    private Employee employee;

    public Call() {
        rank = Rank.Operator;
    }

    @Override
    public void run() {
        int threadDuration = getCallDurationInSeconds(LOWER_CALL_LIMIT, UPPER_CALL_LIMIT);
        try {
            Thread.sleep(threadDuration);
            employee.callCompleted();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Devuelve el rank de la llamada
     *
     * @return Rank
     */
    public Rank getRank() {
        return rank;
    }

    /**
     * Asigna el Rank a la llamada
     *
     * @param r
     */
    public void setRank(Rank r) {
        rank = r;
    }

    /**
     * Asigna un empleado a la llamada
     *
     * @param e
     */
    public void setEmployee(Employee e) {
        employee = e;
        new Thread(this).start();
        System.out.println("Nueva llamada asignada al empleado " + e.getName());
    }

    /**
     * Finaliza la llamada
     */
    public void end() {
        System.out.println("El Empleado " + employee.getName() + " finalizó"
                + " su llamada");
    }

    /**
     * Genera un valor aleatorio entre el valor minimo y maximo
     *
     * @param min
     * @param max
     * @return
     */
    private int getCallDurationInSeconds(int min, int max) {
        int time = ThreadLocalRandom.current().nextInt(min, max + 1);
        return time * MILISECONDS_TO_SECOONDS_CONVERTION;
    }

}
