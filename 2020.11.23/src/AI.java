import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;
import java.io.*;

public class AI extends MIDlet
{
	Display display;
	MainCanvas mc;
	public AI(){
		display=Display.getDisplay(this);
		mc=new MainCanvas();
		display.setCurrent(mc);
	}
	public void startApp(){
	}
	public void destroyApp(boolean unc){
	}
	public void pauseApp(){
	}
}
class MainCanvas extends Canvas
{
	//声明二维数组
	Image heroImage[][]=new Image[4][3];
    Image currentImg;

	int x,y;
	int flag=0;
	int leftFlag,rightFlag,upFlag,downFlag;
	public MainCanvas(){
		try
		{	
            x=120;
            y=120;
	//第三种赋值方法：使用二维数组对变量进行赋值
 /*i值的含义
0：left
1: right
2: up
3: down
*/
 for (int i=0 ;i<heroImage.length;i++ )
 {
	 for (int j=0;j<heroImage[i].length ;j++ )
	 {
		 heroImage[i][j]=Image.createImage("/sayo"+i+j+".png");
      
	 }
 }
//定义初始图片
currentImg=heroImage[3][1];

		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	public void paint(Graphics g){
		g.setColor(0,0,0);
		g.fillRect(0,0,getWidth(),getHeight());
		g.drawImage(currentImg,x,y,0);//120：X坐标、100：Y坐标
	}

	//自定义函数
	public void swayAndMove(int direction){
	    if(flag==0){
		   currentImg=heroImage[direction][0];
		   flag++;
		}
		else if (flag==1)
		{
		    currentImg=heroImage[direction][2];
		    flag=0;
			}
        repaint();
	}
	public void keyPressed(int keyCode){
		int action=getGameAction(keyCode);
		/*
		action的值：UP、DOWN、LEFT、RIGHT
		*/

	//调用函数
		//向左移
		if(action==LEFT){
			swayAndMove(0);
			x=x-5;
		}

		//向右移
		else if(action==RIGHT){
			swayAndMove(1);
			x=x+5;
		}

		//向上移
		else if(action==UP){
			swayAndMove(2);
			y=y-5;
		}

		//向下移
	    else 
		{
			swayAndMove(3);
			y=y+5;
		}
		}
}