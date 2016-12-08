package com.yzm;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.geom.QuadCurve2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//化扇形图
//向上取整:Math.ceil()   //只要有小数都+1
//向下取整:Math.floor()   //不取小数
//四舍五入:Math.round()  //四舍五入
/**
 * @author  吴森
 * @Time 2016-12-1 23:30
 * @describe 扇形图
 */
@WebServlet("/Sector")
public class Sector extends HttpServlet{
	int x=400;
	int y=200;
	int	diameter=200;//直径
	float first=2;
	float second=6;
	float third=4;
	float sum=20;
	Color firstColor=Color.black;
	Color secondColor=Color.red;
	Color thirdColor=Color.yellow;
	Color otherColor=Color.green;
	int length=30;//矩形的边�?
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		System.out.println("获取到了"+session.getAttribute("first"));
		if(session.getAttribute("first")!=null){
			first=Float.parseFloat(""+(session.getAttribute("first")));
			second=Float.parseFloat(""+(session.getAttribute("second")));
			third=Float.parseFloat(""+(session.getAttribute("third")));
			sum=Float.parseFloat(""+(session.getAttribute("sum")));
		}
	
		String word="";
		BufferedImage image =begin(request, response);
		// 获取图形上下�?
		Graphics g = image.getGraphics();
		//设置背景�?
		g.setColor(Color.gray);
		g.fillRect(0, 0, x, y);//有待考证？应该是填充颜色
		
		g.setColor(Color.BLACK);
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(1));
		
		g.setFont(new Font("宋体", Font.PLAIN, 30));
		//第一个扇�?
		g.drawRoundRect(0,0,diameter,diameter,diameter,diameter);//画圆
		g.setColor(firstColor); g.fillArc(0,0,diameter,diameter,0,(int)Math.floor(first/sum*360));
		g.drawRect(diameter+50, 20, length, length);		
		word=(float)(Math.round((first/sum)*10000))/100+"%";
		g.drawString(word, 300, 50);
		
		
		g.setColor(secondColor); g.fillArc(0,0,diameter,diameter,(int)Math.floor(first/sum*360),(int)Math.floor(second/sum*360));
		g.drawRect(diameter+50, 70, length, length);
		word=(float)(Math.round((second/sum)*10000))/100+"%";
		g.drawString(word,300, 100);
		
		g.setColor(thirdColor); g.fillArc(0,0,diameter,diameter,(int)Math.floor((first+second)/sum*360),(int)Math.floor(third/sum*360));
		g.drawRect(diameter+50, 120, length, length);
		word=(float)(Math.round((third/sum)*10000))/100+"%";
		g.drawString(word, 300, 150);
		
		g.setColor(otherColor); g.fillArc(0,0,diameter,diameter,(int)Math.floor((first+second+third)/sum*360),(int)Math.floor((sum-first-second-third)/sum*360));
		g.drawRect(diameter+50, 170,length, length);
		word=(float)(Math.round(((sum-first-second-third)/sum)*10000))/100+"%";
		g.drawString(word, 300, 200);
		
		end(g, response, image);

	}
	
	
	BufferedImage begin(HttpServletRequest request, HttpServletResponse response){
		HttpSession session=request.getSession();
		response.setContentType("image/jpeg");
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		// 在内存中创建图象
		
		BufferedImage image = new BufferedImage(x, y, BufferedImage.TYPE_INT_RGB);
		return image;
	}
	
	void end(Graphics g,HttpServletResponse response,BufferedImage image) throws IOException{
		g.dispose();
		// 输出图象到页�?/两种方式
		ImageIO.write(image, "JPEG", response.getOutputStream());
	}
}
