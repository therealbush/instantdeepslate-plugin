import net.minecrell.pluginyml.bukkit.BukkitPluginDescription

plugins {
  `java-library`
  id("io.papermc.paperweight.userdev") version "1.3.5"
  id("xyz.jpenilla.run-paper") version "1.0.6"
  id("net.minecrell.plugin-yml.bukkit") version "0.5.1"
}

group = "me.bush.instantdeepslate"
version = "1.0.1"
description = "A simple plugin that allows deepslate to be instantmined."

java {
  toolchain.languageVersion.set(JavaLanguageVersion.of(17))
}

dependencies {
  paperDevBundle("1.18.2-R0.1-SNAPSHOT")
}

tasks {
  assemble {
    dependsOn(reobfJar)
  }

  compileJava {
    options.encoding = Charsets.UTF_8.name()

    options.release.set(17)
  }
  javadoc {
    options.encoding = Charsets.UTF_8.name()
  }
  processResources {

    filteringCharset = Charsets.UTF_8.name()
  }
}

bukkit {
  load = BukkitPluginDescription.PluginLoadOrder.STARTUP
  main = "me.bush.instantdeepslate.InstantDeepslate"
  apiVersion = "1.18"
  authors = listOf("bush")
}
