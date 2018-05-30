package com.mrxia.snake.module;

import java.util.LinkedList;
import java.util.function.Predicate;

/**
 * 贪吃蛇类
 *
 * @author xiazijian
 */
public class Snake {

    /**
     * 蛇方向枚举
     */
    public enum Direction {

        UP(-10), DOWN(10), LEFT(-1), RIGHT(1);

        private int value;

        Direction(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public boolean isReverse(Direction direction) {
            return this.value + direction.getValue() == 0;
        }
    }

    /**
     * 记录蛇的点
     */
    private LinkedList<Point> points;

    /**
     * 蛇当前方向
     */
    private Direction direction;

    public Snake(int panelWidth, int panelHeight) {

        points = new LinkedList<>();

        int x = panelWidth / 2;
        int y = panelHeight / 2;

        for (int i = 0; i < 5 && y < panelHeight - 1 ; i++, y++) {
            points.add(new Point(x, y));
        }

        this.direction = Direction.UP;
    }

    /**
     * 自然移动一步
     *
     * @param isFeed 判断是否吃到食物的回调
     * @return 回调的判断结果
     */
    public boolean step(Predicate<Point> isFeed) {

        Point head = getHead();

        int x = head.getX() + direction.getValue() % 10;
        int y = head.getY() + direction.getValue() / 10;

        head = new Point(x, y);
        points.addFirst(head);

        // 判断是否吃到食物，如果没吃到,则移动尾部
        boolean feed = isFeed.test(head);
        if (!feed) {
            points.removeLast();
        }

        // 将判断结果返回
        return feed;
    }

    public boolean step(Direction direction, Predicate<Point> isFeed) {

        // 如果是反向，则不移动
        if (!this.direction.isReverse(direction)) {
            this.direction = direction;
        }

        return step(isFeed);
    }

    public boolean contains(int x, int y) {
        return points.contains(new Point(x, y));
    }

    public boolean isBody(Point point) {
        return points.contains(point) && !getHead().equals(point);
    }

    /**
     * 获取头部
     * @return
     */
    public Point getHead() {
        return points.getFirst();
    }
}
