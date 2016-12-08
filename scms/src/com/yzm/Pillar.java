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
 * @describe 柱状图
 */
@WebServlet("/Pillar")
public class Pillar extends HttpServlet{
	
	int x=400;
	int y=200;
	int arrow=10;
	int border=20;
	
	float first=8;
	float second=6;
	float third=4;
	float sum=20;
	Color firstColor=Color.black;
	Color secondColor=Color.red;
	Color thirdColor=Color.yellow;
	Color otherColor=Color.green;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		
		
		BufferedImage image =begin(request, response);
		// 获取图形上下�?
		Graphics g = image.getGraphics();
		//设置背景�?
		g.setColor(Color.gray);
		g.fillRect(0, 0, x, y);//有待考证？应该是填充颜色
		
		g.setColor(Color.BLACK);
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(1));
		
		g.setFont(new Font("宋体", Font.PLAIN, 20));
		
		g.drawLine(border, y, x-border, y);//x�?
		g.drawLine(border, border, border, y);//y�?
		
		//花x的箭�?
		g.drawLine(x-border-arrow, y+arrow, x-border, y);
		g.drawLine(x-border-arrow, y-arrow, x-border, y);
		
		//花y的箭�?
		g.drawLine(border, border, border-arrow, border+arrow);
		g.drawLine(border, border, border+arrow, border+arrow);
		
		if(session.getAttribute("first")!=null){
			first=Float.parseFloat(""+(session.getAttribute("first")));
			second=Float.parseFloat(""+(session.getAttribute("second")));
			third=Float.parseFloat(""+(session.getAttribute("third")));
			sum=Float.parseFloat(""+(session.getAttribute("sum")));
		}
			
			int lengthy=(int)Math.floor(first/sum*180);
			g.fillRect(30,200-lengthy, 50, lengthy);
			g.drawString(first+"", 30, 200-lengthy-5);
			
			g.setColor(secondColor);
			lengthy=(int)Math.floor(second/sum*180);
			g.fillRect(105, 200-lengthy, 50, lengthy);
			g.drawString(second+"", 105, 200-lengthy-5);
			
			g.setColor(thirdColor);
			lengthy=(int)Math.floor(third/sum*180);
			g.fillRect(180, 200-lengthy, 50, lengthy);
			g.drawString(third+"", 180, 200-lengthy-5);
			
			g.setColor(otherColor);
			lengthy=(int)Math.floor((sum-first-second-third)/sum*180);
			g.fillRect(255, 200-lengthy, 50, lengthy);
			g.drawString(sum-first-second-third+"", 255, 200-lengthy-5);
			
			g.setColor(Color.black);
			for(int i=30;i<300;i++){
				if(i%20==0){
					g.drawLine(i, 60, i+15, 60);
				}
				
			}
		
		
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
