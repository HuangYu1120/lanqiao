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

	/*
	变量的声明
	语法：数据类型 变量名称（标识符）;
	*/
	/*Image downImg,leftImg,rightImg,upImg,currentImg;
	//Image movedownImg1,movedownImg2,moveleftImg1,moveleftImg2,moverightImg1,moverightImg2,moveupImg1,movedupImg2;
	
	//声明一维数组
	Image heroLeftImage[]=new Image[3];
	Image heroRightImage[]=new Image[3];
	Image heroUpImage[]=new Image[3];
	Image heroDownImage[]=new Image[3];
	Image currentImg;*/


	//声明二维数组
	Image heroImage[][]=new Image[4][3];
    Image currentImg;

	int x,y;
	int leftFlag,rightFlag,upFlag,downFlag;
	public MainCanvas(){
		try
		{
			
            x=120;
            y=120;


			leftFlag=0;
			rightFlag=0;
			upFlag=0;
			downFlag=0;
			/*
			给变量赋值
			语法：变量名称=value;
	
		第一种赋值方法
		直接对变量进行赋值
  
			
			/*downImg=Image.createImage("/sayo10.png");
			leftImg=Image.createImage("/sayo12.png");
			rightImg=Image.createImage("/sayo16.png");
			upImg=Image.createImage("/sayo14.png");

            //下 ll
            movedownImg1=Image.createImage("/sayo00.png");
			 movedownImg2=Image.createImage("/sayo20.png");

		    //左
			moveleftImg1=Image.createImage("/sayo02.png");
			moveleftImg2=Image.createImage("/sayo22.png");

             //右
			moverightImg1=Image.createImage("/sayo06.png");
			moverightImg2=Image.createImage("/sayo26.png");
			//上
			moveupImg1=Image.createImage("/sayo04.png");
			movedupImg2=Image.createImage("/sayo24.png");



第二种方法赋值
使用for循环对一维数组对变量赋值

//左
for (int i=0;i<heroLeftImage.length;i++ )
{
heroLeftImage[i]=Image.createImage("/sayo"+i+"2.png");
	}

//右
for (int i=0;i<heroRightImage.length;i++ )
{
heroRightImage[i]=Image.createImage("/sayo"+i+"6.png");
}

//上
for (int i=0;i<heroUpImage.length;i++ )
{
heroUpImage[i]=Image.createImage("/sayo"+i+"4.png");
	}

//下
for (int i=0;i<heroDownImage.length;i++ )
{
heroDownImage[i]=Image.createImage("/sayo"+i+"0.png");
	}
		
		//c初始位置
        currentImg=heroDownImage[1];
*/



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
	public void keyPressed(int keyCode){
		int action=getGameAction(keyCode);
		/*
		action的值：UP、DOWN、LEFT、RIGHT
		*/



		//向左移
		if(action==LEFT){
			if(leftFlag==0){
			currentImg=heroImage[0][0];
		    leftFlag++;
			}
			else if (leftFlag==1)
			{
             currentImg=heroImage[0][2];
		    leftFlag=0;
				}
			/*else if(leftFlag==2)
			{
			currentImg=heroLeftImg;
			leftFlag=0;
			}*/
			x=x-5;
		}

		//向右移
		else if(action==RIGHT){
             if(rightFlag==0){
			currentImg=heroImage[1][0];
		    rightFlag++;
			}
			else if (rightFlag==1)
			{
             currentImg=heroImage[1][2];
		    rightFlag=0;
			}
			/*currentImg=rightImg;*/
			x=x+5;
		}

		//向上移
		else if(action==UP){
			if(upFlag==0){
			currentImg=heroImage[2][0];
		    upFlag++;
			}
			else if (upFlag==1)
			{
             currentImg=heroImage[2][2];
		    upFlag=0;
			}
			/*currentImg=upImg;*/
			y=y-5;
		}

		//向下移
	    else 
		{
			if(downFlag==0){
			currentImg=heroImage[3][0];
		    downFlag++;
			}
			else if (downFlag==1)
			{
             currentImg=heroImage[3][2];
		    downFlag=0;
			}
			/*currentImg=downImg;*/
			y=y+5;
		}
		repaint();
		}

}