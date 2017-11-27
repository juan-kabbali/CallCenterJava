package com.almundo.callcenter;

import org.junit.Test;


/**
 *
 * @author Juan
 */
public class NoAvailableEmployeesTest {
    
    static final int TEST_20_CALLS = 20;
        
     /**
     * Prueba unitaria con 20 llamadas
     */
    @Test
    public void testDispatchCall() {
        System.out.println("dispatchCall 20 Calls");
        Dispatcher dispatcher = new Dispatcher();
        for(int i = 0; i < TEST_20_CALLS; i++){
            dispatcher.dispatchCall(new Call());
        }
    }
    
}
