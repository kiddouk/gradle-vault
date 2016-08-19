package io.errorlab.gradle.vault

import org.gradle.api.Project
import org.gradle.api.Plugin

class VaultPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        target.getExtensions().add("vault", VaultExtension())
    }
}
