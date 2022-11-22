package com.zl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GameWin extends JFrame {        //mouseevent
    int weigh =2*GameUtil.OFFSET+GameUtil.MAP_W*GameUtil.SQUARE_LENGTH;
    int height= 4*GameUtil.OFFSET+GameUtil.MAP_H*GameUtil.SQUARE_LENGTH;

    Image offScreenImage=null;

     MapBottom mapBottom =new MapBottom();
    MapTop mapTop=new MapTop();

     void launch(){
          this.setVisible(true);            // 设置可见
          this.setSize(weigh,height);        // 设置窗口大小
         this.setLocationRelativeTo(null);          //设置窗口位置  剧中显示
         this.setTitle("tech elevator Minesweeper ");     //设置窗体标题
         this.setDefaultCloseOperation(EXIT_ON_CLOSE);   //设置关闭窗口

         //鼠标事件

         this.addMouseListener(new MouseAdapter() {
             @Override
             public void mouseClicked(MouseEvent e) {
                 super.mouseClicked(e);
                 switch (GameUtil.state){
                     case 0:
                         if (e.getButton()==1){
                             GameUtil.MOUSE_X=e.getX();
                             GameUtil.MOUSE_Y=e.getY();
                             GameUtil.LEFT=true;
                         }
                         if (e.getButton()==3){
                             GameUtil.MOUSE_X=e.getX();
                             GameUtil.MOUSE_Y=e.getY();
                             GameUtil.RIGHT=true;
                         }
                     case 1:
                     case 2:
                         if (e.getButton()==1){
                             if (e.getX()>GameUtil.OFFSET + GameUtil.SQUARE_LENGTH*(GameUtil.MAP_W/2)  &&
                                     e.getX()<GameUtil.OFFSET+ GameUtil.SQUARE_LENGTH*(GameUtil.MAP_W/2)+GameUtil.SQUARE_LENGTH
                             && e.getY()>GameUtil.OFFSET && e.getY()<GameUtil.OFFSET +GameUtil.SQUARE_LENGTH){
                                 mapBottom.reGame();
                                 mapTop.reGame();
                                 GameUtil.state=0;
                             }
                         }
                         break;
                     default:
                 }

             }

         });

         while (true){
             repaint();     //循环绘制
             try {
                 Thread.sleep(40);
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
         }
     }

     //调用这个方法，添加一个入口函数 main()
     public static void main(String[] args) {

         GameWin gameWin =new GameWin();
         gameWin.launch();

     }

     //绘制雷区 绘制组件  绘制图形，纵坐标相等是横线，设置颜色
   @Override
    public void paint(Graphics g){
         offScreenImage=this.createImage(weigh,height);
         Graphics gImage=offScreenImage.getGraphics();
         //设置背景颜色
         gImage.setColor(Color.blue);
         gImage.fillRect(0,0,weigh,height);
         mapTop.paintSelf(gImage);
         mapBottom.paintSelf(gImage);
         mapTop.paintSelf(gImage);               // g  传入画笔
         g.drawImage(offScreenImage,0,0,null);

   }


}
