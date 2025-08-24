# SweetKombat

**Simulates the behavior of combat from Minecraft 1.8 on recent versions.**

## ⚙️ Settings

On `config.yml`, you can adjust:

```yml
attack-speed: 16.0    # Attack speed multiplier (1 = standard speed, 16 = simulates no sweep)
enable-sweep: false   # Enable/disable sweep attack (attack speed will set to 1)
language: en          # Locales (en, pt)
````

---

## 🔑 Permissions

| Permission | Standard  | Description                        |
|------------|-----------|------------------------------------|
| `op`       | OP        | Master permission for all commands |

---

## ⌨️ Commands

| Command                   | Permission | Description                          |
|---------------------------|------------|--------------------------------------|
| `/sk.enable`              | `op`       | Enable/disable 'Sweet Kombat' plugin |
| `/sk.attackspeed <valor>` | `op`       | Adjust attack speed (default: 16.0). |

---

## 🚀 Installation

1. Download the plugin `.jar` file.
2. Place it in your server's `plugins` folder.
3. Restart or reload the server.
4. Adjust the `config.yml` file as needed.
5. Restart to apply the modifications.