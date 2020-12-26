package io.serializator.swg;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.bukkit.plugin.java.JavaPlugin;

public class SpigotWithGuice extends JavaPlugin {
    private Injector injector;

    @Override
    public void onEnable() {
        injector = Guice.createInjector(new OurDiModule(this));
        injector.injectMembers(this);
    }

    public Injector getInjector() {
        return injector;
    }
}
