package com.zl;

/*
* 工具类
* 存放静态方法
* 工具方法
*/

import java.awt.*;
import java.io.File;
import java.util.Stack;

public class GameUtil {

    static int RAY_MAX=8;

    static int MAP_W = 11;                           //地图 宽 高 偏移 格子边长
    static int MAP_H = 11;                          // 宽是 横着的格子数量  高是竖着的格子数量
    static int OFFSET = 45;
    static int SQUARE_LENGTH = 50;


    //鼠标相关参数
    //坐标
    static  int MOUSE_X;
    static  int MOUSE_Y;
    //状态
    static  boolean LEFT=false;
    static  boolean RIGHT=false;

    //游戏状态 0 表示游戏中 1 胜利 2 失败
    static  int state=0;


    //底层元素   -1 雷   0 空   1-8 表示对应数字
    static int[][] DATA_BOTTOM=new int[MAP_W+2][MAP_H+2];

    //顶层元素   -1 无覆盖   0 覆盖  1 插旗  2差错旗
    static int[][] DATA_TOP=new int[MAP_W+2][MAP_H+2];




    //载入图片
    static Image bomb=Toolkit.getDefaultToolkit().getImage("imgs/bomb.png");
    static Image top=Toolkit.getDefaultToolkit().getImage("imgs/flag0.jpg");
    static Image flag=Toolkit.getDefaultToolkit().getImage("imgs/flag1.jpg");
    static Image noflag=Toolkit.getDefaultToolkit().getImage("imgs/flag2.jpg");

    static Image face=Toolkit.getDefaultToolkit().getImage("imgs/face.png");
    static Image over=Toolkit.getDefaultToolkit().getImage("imgs/win.png");
    static Image win=Toolkit.getDefaultToolkit().getImage("imgs/over.png");


    static Image [] images=new Image[9];
    static {
        for (int i=1;i<=8; i++){
            images[i]=Toolkit.getDefaultToolkit().getImage("imgs/num/"+i+".png");
        }
    }


}
