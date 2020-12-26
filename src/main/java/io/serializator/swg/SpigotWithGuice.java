package io.serializator.swg;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import io.serializator.swg.state.FictiveStateManager;
import org.bukkit.plugin.java.JavaPlugin;

public class SpigotWithGuice extends JavaPlugin {

    @Inject
    private FictiveStateManager stateManager;

    @Override
    public void onEnable() {
        createInjector();

        stateManager.registerListeners();
    }

    private void createInjector() {
        Injector injector = Guice.createInjector(new OurDiModule(this));
        injector.injectMembers(this);
    }
}
