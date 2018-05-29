package com.mrxia.snake.module;

import java.util.HashSet;
import java.util.Random;

/**
 * 游戏面板类
 * @author xiazijian
 */
public class Panel {

    private Snake snake;

    private int rows = 10;

    private int cols = 10;

    private HashSet<Point> foods;

    public Panel() {
        snake = new Snake();
        foods = new HashSet<>();
    }

    public Panel(int rows, int cols) {
        this();
        this.rows = rows;
        this.cols = cols;
    }

    public void initFoods(int num) {

        Random random = new Random();
        for(;;) {

        }

    }
}
