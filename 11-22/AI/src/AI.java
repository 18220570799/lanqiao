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
	
	int x,y;
	int LeftFlag,RightFlag,UpFlag,DownFlag;
	Image heroImg[][]=new Image[4][3];
	Image currentImg;
	public MainCanvas(){
		try
		{
			for(int i=0;i<heroImg.length;i++){
				for(int j=0;j<heroImg[i].length;j++){
				heroImg[i][j]=Image.createImage("/sayo"+i+j+".png");
				}
			}
			currentImg=heroImg[3][1];
			x=120;
			y=100;
			LeftFlag=1;
			RightFlag=1;
			UpFlag=1;
			DownFlag=1;
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
}
	public void paint(Graphics g){
		g.setColor(0,0,0);
		g.fillRect(0,0,getWidth(),getHeight());
		g.drawImage(currentImg,x,y,0);
	}
	public void keyPressed(int keyCode){
	int action=getGameAction(keyCode);
	if(action==LEFT){
	if(LeftFlag==1){
		currentImg=heroImg[0][0];
		LeftFlag++;
			}
			else if(LeftFlag==2){
			currentImg=heroImg[0][2];
			LeftFlag=1;
			}
	x=x-1;
	repaint();
	}
	if(action==RIGHT){
		if(RightFlag==1){
		currentImg=heroImg[1][0];
		RightFlag++;
			}
			else if(RightFlag==2){
			currentImg=heroImg[1][2];
			RightFlag=1;
			}
		x=x+1;
		repaint();
	}
	if(action==UP){
	if(UpFlag==1){
		currentImg=heroImg[2][0];
		UpFlag++;
			}
			else if(UpFlag==2){
			currentImg=heroImg[2][2];
			UpFlag=1;
			}
	y=y-1;
	repaint();
	}
	if(action==DOWN){

	if(DownFlag==1){
		currentImg=heroImg[3][0];
		DownFlag++;
			}
			else if(DownFlag==2){
			currentImg=heroImg[3][2];
			DownFlag=1;
			}
	y=y+1;
	repaint();
		}
	}
}