package com.sxt.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@WebServlet(name = "NumServlet",urlPatterns = "/ns",loadOnStartup = 0)
public class NumServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        //重写init初始化方法，将数据读取到ServletContext中
        //获取文件中的计数器数据
        //获取文件路径
        String path = this.getServletContext().getRealPath("/nums/nums.txt");
        //声明流对象
        FileReader fr = null;
        BufferedReader br = null;
        try {
            fr=new FileReader(path);
            br = new BufferedReader(fr);
            String nums = br.readLine();//第一次启动时是null
            this.getServletContext().setAttribute("nums",nums);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }



    //重写销毁方法，存储计数器到文件中
    @Override
    public void destroy() {
        //获取网页计数器
        ServletContext sc = this.getServletContext();
        int nums = (int) sc.getAttribute("nums");
        //获取文件路径
        String path = this.getServletContext().getRealPath("/nums/nums.txt");
        //写入文件nums.txt
        BufferedWriter bw = null;
        FileWriter fw = null;
        try {
            fw= new FileWriter(path);
            bw = new BufferedWriter(fw);
            bw.write(nums+"");
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
