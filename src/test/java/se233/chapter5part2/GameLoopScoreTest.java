package se233.chapter5part2;

import javafx.geometry.Point2D;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se233.chapter5part2.controller.GameLoop;
import se233.chapter5part2.model.Food;
import se233.chapter5part2.model.Snake;
import se233.chapter5part2.view.GameStage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameLoopScoreTest {
    private GameStage gameStage;
    private Snake snake;

    @BeforeEach
    void setup() {
        gameStage = new GameStage();
        snake = new Snake(new Point2D(5, 5));
    }

    @Test
    void scoreShouldIncreaseByOneWhenEatNormalFood() {

        GameLoop gameLoop = new GameLoop(gameStage, snake);

        Food normalFood = new Food(new Point2D(5, 5));

        gameLoop.normalFood = normalFood;

        int oldScore = gameLoop.getScore();

        gameLoop.checkCollision();

        assertEquals(oldScore + 1, gameLoop.getScore());
    }
}
