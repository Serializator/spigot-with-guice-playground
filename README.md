# Spigot with Guice
A playground for trying out Guice with Spigot.  

Within Spigot you often see the main class being used as accessor for many components
within the plugin. Containing a getter for each of them.

Instantiation of dependencies is either uplifted to this main class (using manual Dependency Injection)
or no Dependency Injection is performed and these dependencies are instantiated within
the constructor of the dependent class.

In this playground I tried using Guice as IoC with a Spigot plugin, with primarily an example of
registering a listener which uses a fictive state manager (as if this plugin is a minigame).