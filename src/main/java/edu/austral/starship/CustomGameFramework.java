package edu.austral.starship;

import edu.austral.starship.base.collision.CollisionEngine;
import edu.austral.starship.base.framework.GameFramework;
import edu.austral.starship.components._common.GameController;
import edu.austral.starship.base.framework.ImageLoader;
import edu.austral.starship.base.framework.WindowSettings;
import edu.austral.starship.components._common.GameObject;
import edu.austral.starship.components._common.interfaces.Moveable;
import edu.austral.starship.components.asteroid.AsteroidController;
import edu.austral.starship.components.asteroid.AsteroidFactory;
import edu.austral.starship.components.asteroid.AsteroidView;
import edu.austral.starship.components.item.Item;
import edu.austral.starship.components.item.ItemController;
import edu.austral.starship.components.item.ItemFactory;
import edu.austral.starship.components.item.ItemView;
import edu.austral.starship.components.item.shootingSpeed.ShootingSpeedItemFactory;
import edu.austral.starship.components.item.shootingSpeed.ShootingSpeedItemView;
import edu.austral.starship.components.item.starshipLife.StarshipLifeItem;
import edu.austral.starship.components.item.starshipLife.StarshipLifeItemFactory;
import edu.austral.starship.components.item.starshipLife.StarshipLifeItemView;
import edu.austral.starship.components.projectile.Projectile;
import edu.austral.starship.components.projectile.ProjectileController;
import edu.austral.starship.components.projectile.ProjectileView;
import edu.austral.starship.components.starship.Starship;
import edu.austral.starship.components.starship.StarshipController;
import edu.austral.starship.components.starship.StarshipFactory;
import edu.austral.starship.components.starship.StarshipView;
import processing.core.PGraphics;
import processing.core.PImage;
import processing.event.KeyEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class CustomGameFramework implements GameFramework {
    private static final int WINDOW_WIDTH = 720;
    private static final int WINDOW_HEIGHT = 720;

    private static final String BACKGROUND_PATH = "src/main/java/edu/austral/starship/components/_assets/background.png";

    private final int UP_ARROW = 38;
    private final int RIGHT_ARROW = 39;
    private final int DOWN_ARROW = 40;
    private final int LEFT_ARROW = 37;
    private final int SPACEBAR = 32;

    private final int W = 87;
    private final int A = 65;
    private final int S = 83;
    private final int D = 68;
    private final int Q = 81;

    private final int R = 82;

    private final int ASTEROID_DELAY = 10;
    private final int ITEM_DELAY = 50;
    private final int RESPAWN_DELAY = 20;

    private int asteroidTime;
    private int itemTime;
    private int respawnTime;
    private int shootingTime1;
    private int shootingTime2;

    private boolean multiplayer;
    private boolean started;
    private boolean restarted;

    private PImage background;
    private PImage starship1;
    private PImage starship2;
    private PImage projectile1;
    private PImage projectile2;
    private PImage asteroid;
    private PImage itemShootingSpeed;
    private PImage itemLife;

    private CollisionEngine collisionEngine;

    private AsteroidFactory asteroidFactory;
    private StarshipFactory starshipFactory;
    private ItemFactory itemShootingSpeedFactory;
    private ItemFactory itemLifeFactory;

    private StarshipController player1;
    private StarshipController player2;

    private List<GameController> gameControllers;
    private List<GameController> gameControllersToDelete;

    @Override
    public void setup(WindowSettings windowsSettings, ImageLoader imageLoader) {
        windowsSettings
                .setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

        asteroidTime = 0;
        itemTime = 0;
        respawnTime = 0;
        shootingTime1 = 0;
        shootingTime2 = 0;

        multiplayer = false;
        started = false;
        restarted = false;

        background = imageLoader.load(BACKGROUND_PATH);
        starship1 = imageLoader.load(StarshipView.getSpritePath() + "1.png");
        starship2 = imageLoader.load(StarshipView.getSpritePath() + "2.png");
        projectile1 = imageLoader.load(ProjectileView.getSpritePath() + "1.png");
        projectile2 = imageLoader.load(ProjectileView.getSpritePath() + "2.png");
        asteroid = imageLoader.load(AsteroidView.getSpritePath());
        itemShootingSpeed = imageLoader.load(ShootingSpeedItemView.getSpritePath());
        itemLife = imageLoader.load(StarshipLifeItemView.getSpritePath());

        collisionEngine = new CollisionEngine();

        starshipFactory = new StarshipFactory();
        asteroidFactory = new AsteroidFactory();
        itemShootingSpeedFactory = new ShootingSpeedItemFactory();
        itemLifeFactory = new StarshipLifeItemFactory();

        player1 = starshipFactory.make(0, 0);
        player1.setImage(starship1);

        gameControllers = new ArrayList<>();
        gameControllersToDelete = new ArrayList<>();

        gameControllers.add(player1);
    }

    @Override
    public void draw(PGraphics graphics, float timeSinceLastDraw, Set<Integer> keySet) {
        graphics.background(background);
        graphics.translate(WINDOW_WIDTH / 2, WINDOW_HEIGHT / 2);

        if(restarted) {
            asteroidTime = 0;
            itemTime = 0;
            respawnTime = 0;
            shootingTime1 = 0;
            shootingTime2 = 0;

            multiplayer = false;
            restarted = false;

            player1 = starshipFactory.make(0, 0);
            player1.setImage(starship1);

            gameControllers = new ArrayList<>();
            gameControllersToDelete = new ArrayList<>();

            gameControllers.add(player1);
        }

        if (started) {
            if (multiplayer) {
                if (player1.isAlive() && gameControllers.contains(player1)) {
                    if (keySet.contains(UP_ARROW)) {
                        player1.moveForward();
                    }

                    if (keySet.contains(DOWN_ARROW)) {
                        player1.moveBackwards();
                    }

                    if (keySet.contains(LEFT_ARROW)) {
                        player1.rotateLeft();
                    }

                    if (keySet.contains(RIGHT_ARROW)) {
                        player1.rotateRight();
                    }

                    if (keySet.contains(SPACEBAR)) {
                        Starship starship1 = (Starship) player1.getGameObject();
                        if (shootingTime1 > starship1.getStarshipWeapon().getShootingSpeed()) {
                            ProjectileController newProjectile = player1.shoot();
                            newProjectile.setImage(projectile1);
                            gameControllers.add(newProjectile);
                            shootingTime1 = 0;
                        }
                    }
                    shootingTime1++;

                    for (int i = 0; i < player1.getLives(); i++) {
                        graphics.image(starship1, -(WINDOW_WIDTH / 2) + 30 + 30 * i, -(WINDOW_HEIGHT / 2) + 30, 20, 20);
                    }
                }

                if (player2.isAlive() && gameControllers.contains(player2)) {
                    if (keySet.contains(W)) {
                        player2.moveForward();
                    }

                    if (keySet.contains(S)) {
                        player2.moveBackwards();
                    }

                    if (keySet.contains(A)) {
                        player2.rotateLeft();
                    }

                    if (keySet.contains(D)) {
                        player2.rotateRight();
                    }

                    if (keySet.contains(Q)) {
                        Starship starship2 = (Starship) player2.getGameObject();
                        if (shootingTime2 > starship2.getStarshipWeapon().getShootingSpeed()) {
                            ProjectileController newProjectile = player2.shoot();
                            newProjectile.setImage(projectile2);
                            gameControllers.add(newProjectile);
                            shootingTime2 = 0;
                        }
                    }
                    shootingTime2++;

                    for (int i = 0; i < player2.getLives(); i++) {
                        graphics.image(starship2, -(WINDOW_WIDTH / 2) + 30 + 30 * i, -(WINDOW_HEIGHT / 2) + 65, 20, 20);
                    }
                }

                graphics.textAlign(3);
                graphics.textSize(24.0f);
                graphics.text("PLAYER 1 SCORE: " + player1.getScore(), 0, - (WINDOW_HEIGHT / 2) + 45);
                graphics.textAlign(3);
                graphics.textSize(24.0f);
                graphics.text("PLAYER 2 SCORE: " + player2.getScore(), 0, - (WINDOW_HEIGHT / 2) + 90);

            } else {
                if (player1.isAlive() && gameControllers.contains(player1)) {
                    if (keySet.contains(UP_ARROW)) {
                        player1.moveForward();
                    }

                    if (keySet.contains(DOWN_ARROW)) {
                        player1.moveBackwards();
                    }

                    if (keySet.contains(LEFT_ARROW)) {
                        player1.rotateLeft();
                    }

                    if (keySet.contains(RIGHT_ARROW)) {
                        player1.rotateRight();
                    }

                    if (keySet.contains(SPACEBAR)) {
                        Starship starship1 = (Starship) player1.getGameObject();
                        if (shootingTime1 > starship1.getStarshipWeapon().getShootingSpeed()) {
                            ProjectileController newProjectile = player1.shoot();
                            newProjectile.setImage(projectile1);
                            gameControllers.add(newProjectile);
                            shootingTime1 = 0;
                        }
                    }
                    shootingTime1++;

                    for (int i = 0; i < player1.getLives(); i++) {
                        graphics.image(starship1, -(WINDOW_WIDTH / 2) + 30 + 30 * i, -(WINDOW_HEIGHT / 2) + 30, 20, 20);
                    }

                    if (keySet.contains(W) || keySet.contains(A) || keySet.contains(S) || keySet.contains(D) || keySet.contains(Q)) {
                        player2 = starshipFactory.make(0, 0);
                        player2.setImage(starship2);
                        gameControllers.add(player2);
                        multiplayer = true;
                    }
                }
                graphics.textAlign(3);
                graphics.textSize(24.0f);
                graphics.text("SCORE: " + player1.getScore(), 0, - (WINDOW_HEIGHT / 2) + 45);
            }

            if (asteroidTime % ASTEROID_DELAY == 0) {
                AsteroidController newAsteroid = asteroidFactory.make();
                newAsteroid.setImage(asteroid);
                gameControllers.add(newAsteroid);
                asteroidTime++;
            } else {
                asteroidTime++;
            }

            if (player1.isAlive() && gameControllers.contains(player1)) {
                if (itemTime % ITEM_DELAY == 0 && Math.random() < Item.getDropProbability()) {
                    if(Math.random() < .5) {
                        ItemController newItem = itemShootingSpeedFactory.make();
                        newItem.setImage(itemShootingSpeed);
                        gameControllers.add(newItem);
                        itemTime++;
                    } else {
                        ItemController newItem = itemLifeFactory.make();
                        newItem.setImage(itemLife);
                        gameControllers.add(newItem);
                        itemTime++;
                    }
                } else {
                    itemTime++;
                }
            }

            List<GameObject> gameObjects = new ArrayList<>();

            for (GameController gameController : gameControllers) {
                gameController.render(graphics);
                gameController.move();
                if (!gameController.getGameObject().isAlive()) {
                    gameControllersToDelete.add(gameController);
                } else {
                    gameObjects.add(gameController.getGameObject());
                }
            }

            collisionEngine.checkCollisions(gameObjects);

            gameControllers.removeAll(gameControllersToDelete);

            if (!multiplayer && !restarted) {
                if (!player1.isAlive()) {
                    graphics.text("GAME OVER", 0, (WINDOW_HEIGHT / 2) - 90);
                    graphics.textAlign(3);
                    graphics.textSize(24.0f);
                    graphics.text("PRESS R TO START A NEW GAME", 0, (WINDOW_HEIGHT / 2) - 45);
                    if (keySet.contains(R)) {
                        restarted = true;
                    }
                }
            } else {
                if (player1.isAlive() && !player2.isAlive()) {
                    graphics.text("PLAYER 1 WINS", 0, (WINDOW_HEIGHT / 2) - 90);
                    graphics.textAlign(3);
                    graphics.textSize(24.0f);
                    graphics.text("PRESS R TO START A NEW GAME", 0, (WINDOW_HEIGHT / 2) - 45);
                    if (gameControllers.contains(player1)) {
                        gameControllers.remove(player1);
                    }
                    if (keySet.contains(R)) {
                        restarted = true;
                    }
                } else if (!player1.isAlive() && player2.isAlive()) {
                    graphics.text("PLAYER 2 WINS", 0, (WINDOW_HEIGHT / 2) - 90);
                    graphics.textAlign(3);
                    graphics.textSize(24.0f);
                    graphics.text("PRESS R TO START A NEW GAME", 0, (WINDOW_HEIGHT / 2) - 45);
                    if (gameControllers.contains(player2)) {
                        gameControllers.remove(player2);
                    }
                    if (keySet.contains(R)) {
                        restarted = true;
                    }
                }
            }
        } else {
            graphics.textAlign(3);
            graphics.textSize(24.0f);
            graphics.text("PRESS THE SPACEBAR TO START A NEW GAME", 0, (WINDOW_HEIGHT / 2) - 45);
            if (keySet.contains(SPACEBAR)) {
                started = true;
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent event) {

    }

    @Override
    public void keyReleased(KeyEvent event) {

    }
}
