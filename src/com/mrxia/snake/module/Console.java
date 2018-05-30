package com.mrxia.snake.module;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 控制台类
 *
 * @author xiazijian
 */
public class Console {

    private Scanner scanner;

    private Panel panel;

    /**
     * 按键与方向的映射
     */
    private Map<Character, Snake.Direction> keyMap;

    public Console() {
        scanner = new Scanner(System.in);
        panel = new Panel(10, 32);
        initKeyMap();
    }

    private void initKeyMap() {
        keyMap = new HashMap<>();
        keyMap.put('W', Snake.Direction.UP);
        keyMap.put('A', Snake.Direction.LEFT);
        keyMap.put('S', Snake.Direction.DOWN);
        keyMap.put('D', Snake.Direction.RIGHT);
    }

    public void start() {

        panel.increaseFoods(6);
        for(;;){

            // 打印面板，开始游戏
            panel.print();

            //获取控制按钮，判断并返回操作结果
            char ch = control();
            boolean eat = panel.step(keyMap.get(ch));

            if ( panel.isDead()) {
                System.out.println("游戏结束");
                break;
            }

            if (eat) {
                panel.increaseFoods(1);
            }
        }
    }

    /**
     * 获取控制命令
     * @return 命令字符
     */
    private char control() {
        return scanner.next().toUpperCase().charAt(0);
    }

}
