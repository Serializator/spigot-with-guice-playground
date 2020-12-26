package io.serializator.swg;

import com.google.inject.AbstractModule;

public class OurDiModule extends AbstractModule {
    private final SpigotWithGuice plugin;

    public OurDiModule(SpigotWithGuice plugin) {
        this.plugin = plugin;
    }

    @Override
    protected void configure() {
        bind(SpigotWithGuice.class).toInstance(plugin);
    }
}
