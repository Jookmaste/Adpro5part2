package se233.chapter5part2.model;

import javafx.geometry.Point2D;
import se233.chapter5part2.view.GameStage;

import java.util.ArrayList;
import java.util.List;

public class Snake {
    private Direction direction;
    private Point2D head;
    private Point2D prev_tail;
    private List<Point2D> body;

    public Snake(Point2D position) {
        direction = Direction.DOWN;
        body = new ArrayList<>();
        this.head = position;
        this.body.add(this.head);
    }

    public boolean checkDead() {
        Point2D head = body.get(0);

        // ถ้าหัวออกนอกขอบกระดาน → ตาย
        if (head.getX() < 0 || head.getX() >= GameStage.WIDTH ||
                head.getY() < 0 || head.getY() >= GameStage.HEIGHT) {
            return true;
        }

        // เช็คชนตัวเอง
        for (int i = 1; i < body.size(); i++) {
            if (head.equals(body.get(i))) {
                return true;
            }
        }
        return false;
    }

    public void move() {
        head = head.add(direction.current);
        prev_tail = body.remove(body.size() - 1);
        body.add(0, head);
    }

    public void setDirection(Direction direction) {
        // ไม่อนุญาตให้เปลี่ยนทิศทางตรงข้ามกับที่กำลังเคลื่อนไป
        if (this.direction == Direction.UP && direction == Direction.DOWN) return;
        if (this.direction == Direction.DOWN && direction == Direction.UP) return;
        if (this.direction == Direction.LEFT && direction == Direction.RIGHT) return;
        if (this.direction == Direction.RIGHT && direction == Direction.LEFT) return;
        this.direction = direction;
    }

    public Direction getDirection () {
        return this.direction;
    }

    public Point2D getHead () {
        return head;
    }

    public boolean collided(Food food) {
        return head.equals(food.getPosition());
    }

    public void grow() {
        body.add(prev_tail);
    }

    public int getLength() {
        return body.size();
    }

    public List<Point2D> getBody() {
        return body;
    }
}