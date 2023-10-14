package me.aroze.arozeutils.kotlin.reflection

import me.aroze.arozeutils.minecraft.instance
import org.bukkit.Bukkit
import org.bukkit.event.Listener
import java.io.File
import java.util.jar.JarInputStream

fun getClassesInPackage(pkg: String, predicate: (Class<*>) -> Boolean = { true }): List<Class<*>> {
    val classes = mutableListOf<Class<*>>()
    val instanceClass = instance::class.java
    val path = instanceClass.protectionDomain.codeSource.location.toURI()
    val jar = File(path)
    val stream = JarInputStream(jar.inputStream())
    val directory = pkg.replace('.', '/')

    while (true) {
        val entry = stream.nextJarEntry ?: break
        val entryName = entry.name

        if (!entryName.startsWith(directory) || !entryName.endsWith(".class"))
            continue

        val clazz = instanceClass.classLoader.loadClass(entryName
            .replace('/', '.')
            .replace(".class", ""))

        if (!predicate.invoke(clazz))
            continue

        classes.add(clazz)
    }

    return classes
}

fun registerListenersPackage(pkg: String) {
    for (listener in getClassesInPackage(pkg) { Listener::class.java in it.interfaces })
        Bukkit.getPluginManager().registerEvents(listener.getField("INSTANCE")[null] as Listener, instance)
}