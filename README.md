# VanishCorrection Plugin

A custom Bukkit plugin designed to enhance vanish functionality for Minecraft servers with faction and roleplay (RP) elements. The plugin integrates with LuckPerms for permission management and PlaceholderAPI to provide placeholders, improving the overall vanish and roleplay experience for players.

## Features

- **Automatic Vanish Status Correction**: Ensures that players’ vanish status is accurate, especially useful when transitioning between different faction areas.
- **Printer Role Deactivation**: Removes the "printer" role upon player logout or when moving to a different faction area. Sends a notification to the player to confirm deactivation, ensuring clear role transitions in RP mode.
- **Faction Movement Logging**: Records each player's movement across factions, saving details such as faction name, coordinates, and timestamp in a YAML file for historical tracking and server insights.
- **Placeholder Support**: Adds a custom placeholder through PlaceholderAPI to indicate if the player is in their own faction’s claim.

## Why Use VanishCorrection?

VanishCorrection is ideal for servers that rely on RP elements or strict faction roles, ensuring that vanish statuses and roles are consistently managed. By keeping vanish states accurate, it improves gameplay immersion and helps maintain server integrity. The printer role removal and history tracking add further control and insights for server admins, allowing for better management and oversight of player activity.

## Installation

1. Download the plugin JAR file and place it in the `plugins` folder of your Minecraft server.
2. Ensure that **LuckPerms** and **PlaceholderAPI** are also installed on your server to take full advantage of the plugin’s capabilities.
3. Start or restart the server. The plugin will create a `history.yml` file for tracking player movement and faction history in the plugin's data folder.

## Usage

- **Vanish Management**: As players move between faction areas, their vanish status is automatically updated.
- **Role Deactivation**: Upon logout or moving to a new faction, the plugin removes the "printer" role, helping players stay in line with server roleplay rules.
- **History Logging**: Admins can review `history.yml` for a log of player movements, including faction transitions and coordinates.

## Configuration

The plugin requires no manual configuration. History logging and vanish corrections are handled automatically.

## Contributing

If you’d like to contribute or report any issues, please feel free to reach out via GitHub or submit a pull request.

## License

This plugin is released under the MIT License.

---
