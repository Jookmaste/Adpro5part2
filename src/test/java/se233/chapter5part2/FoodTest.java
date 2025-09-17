package se233.chapter5part2;

public class FoodTest {
    private Food food;

    @BeforeEach
    public void setup() {
        food = new Food(new Point2D(0, 0));
    }
    @Test
    public void respawn_shouldBeOnNewPosition() {
        food.respawn();
        assertNotSame(food.getPosition(), new Point2D(0, 0));
    }
}
