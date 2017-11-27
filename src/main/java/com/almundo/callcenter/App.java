package com.almundo.callcenter;

import com.almundo.conf.CommonAssets;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author Juan
 */
public class App {

    static Dispatcher dispatcher;
    static Runnable clientsCreator;
    public static final int INITIAL_DELAY = 0;
    public static final int TIME_TO_NEW_CLIENT = 1;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Inicializamos el dispatcher
        dispatcher = CommonAssets.initDispatcher();
        initClientsCreater();
    }

    /**
     * Inicializa un ScheduledExecutorService que simula las llamadas
     */
    static void initClientsCreater() {
        Runnable clientsCreator = () -> {
            Call call = new Call();
            dispatcher.dispatchCall(call);
        };
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        executor.scheduleAtFixedRate(clientsCreator, INITIAL_DELAY, TIME_TO_NEW_CLIENT, TimeUnit.SECONDS);
    }

}
