package com.almundo.callcenter;

import org.junit.Test;

/**
 *
 * @author Juan
 */
public class DispatcherTest {
    

    static final int TEST_10_CALLS = 10;
    
    /**
     * Prueba unitaria con 10 llamadas
     */
    @Test
    public void testDispatchCall() {
        System.out.println("dispatchCall 10 Calls");
        Dispatcher dispatcher = new Dispatcher();
        for(int i = 0; i < TEST_10_CALLS; i++){
            dispatcher.dispatchCall(new Call());
        }
    }
    
}
