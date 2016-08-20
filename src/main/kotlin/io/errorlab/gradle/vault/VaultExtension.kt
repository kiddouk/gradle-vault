package io.errorlab.gradle.vault

import com.adamkunicki.vault.Vault
import com.adamkunicki.vault.VaultConfiguration
import com.adamkunicki.vault.api.Secret


class VaultExtension(
        var addr : String? = System.getenv().get("VAULT_ADDR"),
        var token : String? = System.getenv().get("VAULT_TOKEN")
) {

    fun get(name: String): Secret {
        val conf = VaultConfiguration(addr!!, token!!)
        val vault = Vault(conf)

        return vault.logical.read(name)
    }
}
