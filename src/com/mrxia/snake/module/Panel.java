package com.mrxia.snake.module;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * 游戏面板类
 * @author xiazijian
 */
public class Panel {

    private Snake snake;

    private Set<Point> foods;

    private int rows = 10;

    private int cols = 10;

    private Random random;

    public Panel() {
        init();
    }

    public Panel(int rows, int cols) {
        this.cols = cols;
        this.rows = rows;
        init();
    }

    private void init() {
        random = new Random();
        snake = new Snake(cols, rows);
        foods = new HashSet<>();
    }

    /**
     * 增加食物
     * @param num 食物数量
     */
    public void increaseFoods(int num) {

        for (;;) {
            int x = random.nextInt(cols - 2) + 1;
            int y = random.nextInt(rows - 2) + 1;

            //先判断是否为蛇包含的坐标
            if (snake.contains(x, y)) {
                continue;
            }
            foods.add(new Point(x, y));

            if (foods.size() == num) {
                break;
            }
        }
    }

    /**
     * 打印面板
     */
    public void print() {

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (i == 0 || i == rows - 1) {
                    System.out.print("-");
                } else if (j == 0 || j == cols - 1) {
                    System.out.print("|");
                } else if (snake.contains(i, j)) {
                    System.out.print("#");
                } else if (foods.contains(new Point(i, j))) {
                    System.out.print("@");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
