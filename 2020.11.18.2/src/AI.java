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
	����������
	�﷨���������� �������ƣ���ʶ����;
	*/
	//Image downImg,leftImg,rightImg,upImg,currentImg;
	//Image movedownImg1,movedownImg2,moveleftImg1,moveleftImg2,moverightImg1,moverightImg2,moveupImg1,movedupImg2;
	
	//��������
	Image heroLeftImage[]=new Image[3];
	Image heroRightImage[]=new Image[3];
	Image heroUpImage[]=new Image[3];
	Image heroDownImage[]=new Image[3];
	Image currentImg;
     
	int x,y;
	int leftFlag,rightFlag,upFlag,downFlag;
	public MainCanvas(){
		try
		{
			/*
			��������ֵ
			�﷨����������=value;
			*/

			
			/*downImg=Image.createImage("/sayo10.png");
			leftImg=Image.createImage("/sayo12.png");
			rightImg=Image.createImage("/sayo16.png");
			upImg=Image.createImage("/sayo14.png");

            //�� ll
            movedownImg1=Image.createImage("/sayo00.png");
			 movedownImg2=Image.createImage("/sayo20.png");

		    //��
			moveleftImg1=Image.createImage("/sayo02.png");
			moveleftImg2=Image.createImage("/sayo22.png");

              //��
			moverightImg1=Image.createImage("/sayo06.png");
			moverightImg2=Image.createImage("/sayo26.png");
			//��
			moveupImg1=Image.createImage("/sayo04.png");
			movedupImg2=Image.createImage("/sayo24.png");*/

x=120;
y=120;


			leftFlag=0;
			rightFlag=0;
			upFlag=0;
			downFlag=0;


//ʹ��forѭ����һά����ı������и�ֵ


//��
for (int i=0;i<heroLeftImage.length;i++ )
{
heroLeftImage[i]=Image.createImage("/sayo"+i+"2.png");
	}

//��
for (int i=0;i<heroRightImage.length;i++ )
{
heroRightImage[i]=Image.createImage("/sayo"+i+"6.png");
}

//��
for (int i=0;i<heroUpImage.length;i++ )
{
heroUpImage[i]=Image.createImage("/sayo"+i+"4.png");
	}

//��
for (int i=0;i<heroDownImage.length;i++ )
{
heroDownImage[i]=Image.createImage("/sayo"+i+"0.png");
	}


		//c��ʼλ��
        currentImg=heroDownImage[1];



		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	public void paint(Graphics g){
		g.setColor(0,0,0);
		g.fillRect(0,0,getWidth(),getHeight());
		g.drawImage(currentImg,x,y,0);//120��X���ꡢ100��Y����
	}
	public void keyPressed(int keyCode){
		int action=getGameAction(keyCode);
		/*
		action��ֵ��UP��DOWN��LEFT��RIGHT
		*/



		//������
		if(action==LEFT){
			if(leftFlag==0){
			currentImg=heroLeftImage[0];
		    leftFlag++;
			}
			else if (leftFlag==1)
			{
             currentImg=heroLeftImage[2];
		    leftFlag=0;
				}
			/*else if(leftFlag==2)
			{
			currentImg=heroLeftImg;
			leftFlag=0;
			}*/
			x=x-5;
		}

		//������
		else if(action==RIGHT){
             if(rightFlag==0){
			currentImg=heroRightImage[0];
		    rightFlag++;
			}
			else if (rightFlag==1)
			{
             currentImg=heroRightImage[2];
		    rightFlag=0;
			}
			/*currentImg=rightImg;*/
			x=x+5;
		}

		//������
		else if(action==UP){
			if(upFlag==0){
			currentImg=heroUpImage[0];
		    upFlag++;
			}
			else if (upFlag==1)
			{
             currentImg=heroUpImage[2];
		    upFlag=0;
			}
			/*currentImg=upImg;*/
			y=y-5;
		}

		//������
	    else 
		{
			if(downFlag==0){
			currentImg=heroDownImage[0];
		    downFlag++;
			}
			else if (downFlag==1)
			{
             currentImg=heroDownImage[2];
		    downFlag=0;
			}
			/*currentImg=downImg;*/
			y=y+5;
		}
		repaint();
		}

}