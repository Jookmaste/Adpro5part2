package se233.chapter5part2;

import javafx.geometry.Point2D;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se233.chapter5part2.controller.GameLoop;
import se233.chapter5part2.model.SpecialFood;
import se233.chapter5part2.model.Snake;
import se233.chapter5part2.view.GameStage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameLoopSpecialFoodTest {
    private Snake snake;
    private GameStage gameStage;

    @BeforeEach
    void setup() {
        gameStage = new GameStage();
        snake = new Snake(new Point2D(7, 7));
    }

    @Test
    void eatSpecialFood_ShouldGrowByFive() {
        SpecialFood specialFood = new SpecialFood(new Point2D(7, 7));

        GameLoop gameLoop = new GameLoop(gameStage, snake);

        gameLoop.specialFood = specialFood;

        int originalLength = snake.getLength();

        gameLoop.checkCollision();

        assertEquals(originalLength + specialFood.getGrowthValue(), snake.getLength(),
                "special food growthValue +5");
    }
}
