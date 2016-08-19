package io.errorlab.gradle.vault

import com.adamkunicki.vault.Vault
import com.adamkunicki.vault.VaultConfiguration
import com.adamkunicki.vault.api.Secret

val addr = if (System.getenv().get("VAULT_ADDR") != null) System.getenv().get("VAULT_ADDR")!! else ""
val token = if (System.getenv().get("VAULT_TOKEN") != null) System.getenv().get("VAULT_TOKEN")!! else ""

data class VaultExtension(val vault_addr: String = addr, val vault_token: String = token) {
    val conf = VaultConfiguration(vault_addr, vault_token)
    val vault = Vault(conf)

    fun get(name: String): Secret {
        return vault.logical.read(name)
    }
}
