package se233.chapter5part2.model;

import javafx.geometry.Point2D;

public class SpecialFood extends Food {
    public SpecialFood(Point2D position) {
        super(position);
    }

    public SpecialFood() {
        super();
    }

    public int getGrowthValue() {
        return 5;
    }

    public String getColor() {
        return "green";
    }
}