# Publishing plugin from gradle

## Intent

This plugin extends the project in order to fetch the wanted credentials from Hashicorp vault. As you can see it in the code base, this plugin is tiny and does one thing only.


It exposes a simple extension to your project so you can use it.


## Usage

First, this plugin depends on an external library that you need to access like so:
```
buildscript {
  repositories {
    maven {
      url  "http://dl.bintray.com/kunickiaj/maven"
    }
}
```

Then simply apply the plugin
```
plugins {
  id "io.errorlab.gradle.vault" version "0.1.0"
}
```

Make sure that you have `VAULT_ADDR` and `VAULT_TOKEN` defined when using gradle. After which, you have access to any credential with the following directives
```
project.vault.get("secret/my_secret")
```


Alternatively, you can configure the plugin like so
```
vault {
  addr = "http://127.0.0.1:8200"
  token = "dont_put_a_token_here_it_is_unsafe"
}
```

example for Android:
```
$> vault write secret/android-signing-key-credentials key_password=12345 store_password=abcde
```
```
  signingConfigs {
    release {
      keyAlias 'release'
      keyPassword project.vault.get("secret/signing-keys")['data']['key_password']
      storeFile file('release.keystore')
      storePassword project.vault.get("secret/signing-keys")['data']['store_password']
    }
```


thats it.

All PR, comments and issues are welcome.
