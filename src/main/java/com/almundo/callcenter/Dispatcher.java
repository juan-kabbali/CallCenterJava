package com.almundo.callcenter;

import com.almundo.conf.CommonAssets;
import com.almundo.staff.Employee;
import java.util.List;

/**
 * @author Juan Actua como un orquestador entre las llamadas y los empleados.
 */
public class Dispatcher {

    // lista de empleados y llamadas por nivel
    List<List<Employee>> employeesPerLevels;
    List<List<Call>> callQueuesPerLevels;

    /**
     * Constructor del Dispatcher, se inicializan las listas de empleados y
     * llamadas segund el Rank
     */
    public Dispatcher() {
    }

    /**
     * Encuentra un empleado disponible para una llamada segun el rank de ambos
     *
     * @param call
     * @return
     */
    public Employee getEmployeeForCall(Call call) {
        for (int level = call.getRank().getValue(); level < CommonAssets.LEVELS; level++) {
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

    public void setEmployeesPerLevels(List<List<Employee>> employeesPerLevels) {
        this.employeesPerLevels = employeesPerLevels;
    }

    public void setCallQueuesPerLevels(List<List<Call>> callQueuesPerLevels) {
        this.callQueuesPerLevels = callQueuesPerLevels;
    }
    
    
}
