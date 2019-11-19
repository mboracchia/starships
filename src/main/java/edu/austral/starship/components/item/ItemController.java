package edu.austral.starship.components.item;

import edu.austral.starship.components._common.GameController;

public class ItemController extends GameController {
    public ItemController(Item item) {
        super(item, new ItemView());
    }
}
