package io.serializator.swg.state;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Singleton;
import io.serializator.swg.SpigotWithGuice;
import io.serializator.swg.listeners.SendFictiveStateOnJoin;

import java.util.stream.Stream;

/**
 * A fictive state manager for the purpose of injecting into our listener
 */
@Singleton
public class FictiveStateManager {
    private final SpigotWithGuice plugin;
    private final Injector injector;

    @Inject
    public FictiveStateManager(SpigotWithGuice plugin, Injector injector) {
        this.plugin = plugin;
        this.injector = injector;
    }

    /**
     * Register our global listeners
     */
    public void registerListeners() {
        Stream.of(SendFictiveStateOnJoin.class)
                .map(injector::getInstance)
                .forEach(listener -> plugin.getServer().getPluginManager().registerEvents(listener, plugin));
    }

    /**
     * Get the state of our fictive minigame
     *
     * @return the state of our fictive minigame
     */
    public String getState() {
        return "In Progress";
    }
}
