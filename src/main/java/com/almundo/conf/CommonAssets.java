package com.almundo.conf;

import com.almundo.callcenter.Call;
import com.almundo.callcenter.Dispatcher;
import com.almundo.staff.Director;
import com.almundo.staff.Employee;
import com.almundo.staff.Operator;
import com.almundo.staff.Supervisor;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Juan
 */
public class CommonAssets {

    // Valores relacionados al staff
    public static final int LEVELS = 3;
    public static final int NUM_OPERATORS = 5;
    public static final int NUM_SUPERVISORS = 4;
    public static final int NUM_DIRECTORS = 2;

    // Valores realcionados a las llamadas
    public static final int TEST_10_CALLS = 10;
    public static final int TEST_20_CALLS = 20;
    public static final int MILISECONDS_TO_SECOONDS_CONVERTION = 1000;
    public static final int LOWER_CALL_LIMIT_TIME_IN_SECONDS = 5;
    public static final int UPPER_CALL_LIMIT_TIME_IN_SECONDS = 10;

    /**
     * Inicializa el dispatcher con todos sus atributos segun los valores
     * asignados en los atributos publicos estaticos de la clase 
     * CommonAssets
     * @return 
     */
    public static Dispatcher initDispatcher() {

        // Instanciar el dispatcher
        Dispatcher dispatcher = new Dispatcher();

        // lista de empleados y llamadas por nivel
        List<List<Employee>> employeesPerLevels;
        List<List<Call>> callQueuesPerLevels;

        // Instanciar las listas
        employeesPerLevels = new ArrayList<List<Employee>>(CommonAssets.LEVELS);
        callQueuesPerLevels = new ArrayList<List<Call>>(CommonAssets.LEVELS);

        // Inicializar los operadores.
        ArrayList<Employee> operators = new ArrayList<Employee>(CommonAssets.NUM_OPERATORS);
        for (int o = 0; o < CommonAssets.NUM_OPERATORS; o++) {
            operators.add(new Operator(dispatcher, "Operador " + Integer.toString(o + 1)));
        }

        // Inicializar los supervisores.
        ArrayList<Employee> supervisors = new ArrayList<Employee>(CommonAssets.NUM_SUPERVISORS);
        for (int s = 0; s < CommonAssets.NUM_SUPERVISORS; s++) {
            supervisors.add(new Supervisor(dispatcher, "Supervisor " + Integer.toString(s + 1)));
        }

        // Inicializar los directores
        ArrayList<Employee> directors = new ArrayList<Employee>(CommonAssets.NUM_DIRECTORS);
        for (int d = 0; d < CommonAssets.NUM_DIRECTORS; d++) {
            directors.add(new Director(dispatcher, "Director " + Integer.toString(d + 1)));
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

        // Asignar las listas al dispatcher
        dispatcher.setCallQueuesPerLevels(callQueuesPerLevels);
        dispatcher.setEmployeesPerLevels(employeesPerLevels);
        return dispatcher;
    }

}
