package com.almundo.callcenter;

import com.almundo.conf.CommonAssets;
import com.almundo.conf.Rank;
import com.almundo.staff.Employee;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author Juan Representa la llamada de un cliente, tiene un rank minimo para
 * asignarla al empleado de ese rank que este disponible para responderla
 */
public class Call implements Runnable {

    // Numero minimo del Rank del empleado que puede atender esta llamada
    private Rank rank;

    // Empleado que esta atentiendo la llamada 
    private Employee employee;

    /**
     * Constructor de llamada, se asigna el Rank de Operador por defecto
     */
    public Call() {
        rank = Rank.Operator;
    }

    @Override
    public void run() {
        int threadDuration = getCallDurationInSeconds(CommonAssets.LOWER_CALL_LIMIT_TIME_IN_SECONDS, CommonAssets.UPPER_CALL_LIMIT_TIME_IN_SECONDS);
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
        return time * CommonAssets.MILISECONDS_TO_SECOONDS_CONVERTION;
    }

}
