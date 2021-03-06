package com.almundo.callcenter;

import com.almundo.conf.CommonAssets;
import com.almundo.staff.Director;
import com.almundo.staff.Employee;
import com.almundo.staff.Operator;
import com.almundo.staff.Supervisor;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Juan
 */
public class NoAvailableEmployeesTest {

    private Dispatcher dispatcher;

    @Before
    public void beforeClass() {
        // Instanciar el dispatcher
        dispatcher = CommonAssets.initDispatcher();
    }

    /**
     * Prueba unitaria con 20 llamadas
     */
    @Test
    public void testDispatchCall() {
        System.out.println("dispatchCall 20 Calls");
        for (int i = 0; i < CommonAssets.TEST_20_CALLS; i++) {
            dispatcher.dispatchCall(new Call());
        }
    }

}
