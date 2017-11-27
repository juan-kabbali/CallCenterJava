package com.almundo.callcenter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Juan Actua como un orquestador entre las llamadas y los empleados.
 */
public class Dispatcher {

    private final int LEVELS = 3;
    private final int NUM_OPERATORS = 5;
    private final int NUM_SUPERVISORS = 4;
    private final int NUM_DIRECTORS = 2;

    // lista de empleados y llamadas por nivel
    List<List<Employee>> employeesPerLevels;
    List<List<Call>> callQueuesPerLevels;

    public Dispatcher() {
        employeesPerLevels = new ArrayList<List<Employee>>(LEVELS);
        callQueuesPerLevels = new ArrayList<List<Call>>(LEVELS);

        // Inicializar los operadores.
        ArrayList<Employee> operators = new ArrayList<Employee>(NUM_OPERATORS);
        for (int o = 0; o < NUM_OPERATORS; o++) {
            operators.add(new Operator(this, "Operador " + Integer.toString(o + 1)));
        }

        // Inicializar los supervisores.
        ArrayList<Employee> supervisors = new ArrayList<Employee>(NUM_SUPERVISORS);
        for (int s = 0; s < NUM_SUPERVISORS; s++) {
            supervisors.add(new Supervisor(this, "Supervisor " + Integer.toString(s + 1)));
        }

        // Inicializar los directores
        ArrayList<Employee> directors = new ArrayList<Employee>(NUM_DIRECTORS);
        for (int d = 0; d < NUM_DIRECTORS; d++) {
            directors.add(new Director(this, "Director " + Integer.toString(d + 1)));
        }

        // Asignar los empleados segun su nivel
        employeesPerLevels.add(operators);
        employeesPerLevels.add(supervisors);
        employeesPerLevels.add(directors);
        System.out.println("Personal del callcenter \n"
                + operators.size() + " Operadores \n"
                + supervisors.size() + " Supervisores \n"
                + directors.size() + " Directores \n"
                + "##################################");

        // Asignar las tres listas de llamadas encoladas segund su rank
        ArrayList<Call> calls = new ArrayList<>();
        callQueuesPerLevels.add(calls);
        callQueuesPerLevels.add(calls);
        callQueuesPerLevels.add(calls);
    }

    /**
     * Encuentra un empleado disponible para una llamada segun el rank de ambos
     *
     * @param call
     * @return
     */
    public Employee getEmployeeForCall(Call call) {
        for (int level = call.getRank().getValue(); level < LEVELS; level++) {
            List<Employee> availableEmployees = employeesPerLevels.get(level);
            for (Employee emp : availableEmployees) {
                if (emp.isFree()) {
                    return emp;
                }
            }

        }
        return null;
    }

    /**
     * Asigna una llamada a un empleado disponible, en caso que no hayan
     * empleados disponibles, se agrega la llamada a la cola de llamadas segun
     * su rank
     *
     * @param call
     */
    public void dispatchCall(Call call) {
        Employee emp = getEmployeeForCall(call);
        if (emp != null) {
            emp.receiveCall(call);
            call.setEmployee(emp);
        } else { // Si no hay empleados disponibles, se almacenana en una cola
            System.out.println("---------------- Llamada esperando para ser contestada"
                    + "----------------- \n");
            callQueuesPerLevels.get(call.getRank().getValue()).add(call);
        }
    }

    /**
     * Si un empleado se desocupa, se buscan llamadas que esten en espera para
     * que las responda
     *
     * @param emp
     */
    public void assignCall(Employee emp) {
        for (int rank = emp.getRank().getValue(); rank >= 0; rank--) {
            List<Call> queuedCalls = callQueuesPerLevels.get(rank);
            if (queuedCalls.size() > 0) {
                Call call = queuedCalls.remove(0);
                if (call != null) {
                    emp.receiveCall(call);
                }
            }
        }
    }
}
