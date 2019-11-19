package edu.austral.starship.components._common.interfaces;

import edu.austral.starship.components.starship.Starship;
import edu.austral.starship.components.starship.StarshipWeapon;

public interface Consumable {
    void upgrade(Starship starship);

    void upgrade(StarshipWeapon starshipWeapon);
}
