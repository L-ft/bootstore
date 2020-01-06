package com.vp.bootstore.controller.cuxiaobook;


import com.vp.bootstore.dao.IBookInfoDao;
import com.vp.bootstore.dao.impl.IBookInfoDaoImpl;
import com.vp.bootstore.pojo.BookInfo;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet("/InsterCuxiao")
public class InsterCuxiao extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        IBookInfoDao iBookInfoDao = new IBookInfoDaoImpl();
        BookInfo bookInfo = iBookInfoDao.findid(id);
        if (bookInfo!=null){
            request.setAttribute("bookinfo",bookInfo);
            request.getRequestDispatcher("backstage/instercuxiao.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}