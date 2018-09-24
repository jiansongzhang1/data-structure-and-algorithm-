import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

public class Heart extends Applet
{
    int width, height;
    Image image; 						//缓冲区对象
    Graphics g1;
    public void init()						//Applet初始化时调用
    {
        setBackground(Color.black); 				//设置背景
        this.setSize(350, 310);

        width = getSize().width; 				//获得窗口宽度
        height = getSize().height;
        image = createImage(width, height); 			//创建图像对象
        g1 = image.getGraphics();
    }
    public void paint(Graphics g)				//绘图方法
    {
        g1.clearRect(0, 0, width, height);
        g1.setColor(Color.blue);

        for(int i = 0; i <= 90; i++) 		//控制横向变化
            for(int j = 0; j  <= 90; j++)	//控制竖向变化
            {
                //转换为直角坐标
                double  r = Math.PI / 45 * i * (1 - Math.sin(Math.PI / 45 * j)) * 18;
                double  x = r * Math.cos(Math.PI / 45 * j) * Math.sin(Math.PI / 45 * i) + width / 2;   //为了在中间显示，加了偏移量
                double  y = -r * Math.sin(Math.PI / 45 * j) + height / 4;//为了在中间显示，加了偏移量
                g1.fillOval((int) x, (int)y, 2,2);	//绘制点
            }
        //显示缓存区的可变Image对象
        g.drawImage(image, 0, 0, this);
    }
}


