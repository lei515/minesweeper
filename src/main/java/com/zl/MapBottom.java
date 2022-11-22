package com.zl;

/*
底层地图
绘制相关游戏组件
*/


import java.awt.*;

public class MapBottom {

    BottomRay bottomRay=new BottomRay();
    BottomNumber bottomNumber =new BottomNumber();
    {
        bottomRay.newRay();
        bottomNumber.newNum();
    }
    // 重置游戏
    void reGame(){
        for (int i=1;i<=GameUtil.MAP_W;i++){
            for (int j=1;j<=GameUtil.MAP_H;j++){
                GameUtil.DATA_BOTTOM[i][j]=0;
            }
        }
        bottomRay.newRay();
        bottomNumber.newNum();
    }

    // 绘制方法   引入画笔
   public void paintSelf(Graphics g){

       g.setColor(Color.red);
       /*for (int i=0; i< 500 ; i=i+50){
            g.setColor(Color.red);
            g.drawLine(0,i,500,i);
            g.drawLine(i,0,i,500);*/

            //画竖线
       for (int i=0;i<=GameUtil.MAP_W;i++){
             g.drawLine(GameUtil.OFFSET+i*GameUtil.SQUARE_LENGTH,
                          3*GameUtil.OFFSET,
                     GameUtil.OFFSET+i*GameUtil.SQUARE_LENGTH,
                     3*GameUtil.OFFSET+GameUtil.MAP_H*GameUtil.SQUARE_LENGTH);

       }
            //画横线
       for (int i=0; i<=GameUtil.MAP_H;i++){
           g.drawLine(GameUtil.OFFSET,
           3*GameUtil.OFFSET+i*GameUtil.SQUARE_LENGTH,
           GameUtil.OFFSET+GameUtil.MAP_H*GameUtil.SQUARE_LENGTH,
           3*GameUtil.OFFSET+i*GameUtil.SQUARE_LENGTH);

       }
             //地雷地图绘制
       for (int i=1; i<=GameUtil.MAP_W; i++){
           for (int j=1;j<=GameUtil.MAP_H;j++){
               if (GameUtil.DATA_BOTTOM[i][j]==-1){          //等于地雷
                   g.drawImage(GameUtil.bomb,
                           GameUtil.OFFSET + (i - 1) * GameUtil.SQUARE_LENGTH + 1,
                           GameUtil.OFFSET * 3 + (j - 1) * GameUtil.SQUARE_LENGTH + 1,
                           GameUtil.SQUARE_LENGTH - 2,
                           GameUtil.SQUARE_LENGTH - 2,
                           null
                   );
               }
               // number
               if (GameUtil.DATA_BOTTOM[i][j]>=0){
                   g.drawImage(GameUtil.images[GameUtil.DATA_BOTTOM[i][j]],
                           GameUtil.OFFSET + (i - 1) * GameUtil.SQUARE_LENGTH ,        //像素位置
                           GameUtil.OFFSET * 3 + (j - 1) * GameUtil.SQUARE_LENGTH ,

                           null);
               }
           }
       }
       switch (GameUtil.state){
           case 0:
               g.drawImage(GameUtil.face,
                       GameUtil.OFFSET + GameUtil.SQUARE_LENGTH*(GameUtil.MAP_W/2),
                       GameUtil.OFFSET,
                       null);
               break;
           case 1:
               g.drawImage(GameUtil.over,
                       GameUtil.OFFSET + GameUtil.SQUARE_LENGTH*(GameUtil.MAP_W/2),
                       GameUtil.OFFSET,
                       null);
               break;
           case 2:
               g.drawImage(GameUtil.win,
                       GameUtil.OFFSET + GameUtil.SQUARE_LENGTH*(GameUtil.MAP_W/2),
                       GameUtil.OFFSET,
                       null);
               break;

               default:
       }
    }
}
