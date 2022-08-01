package com.tzadok.imperial.court.servlet.module; /**
 * @ProjectName: pro05-demo-all-in-one
 * @PackageName: ${PACKAGE_NAME}
 * @ClassName: ${NAME}
 * @Author: 小北
 * @Description:
 * @date: 2022/8/1 9:38
 */

import com.tzadok.imperial.court.entity.Memorials;
import com.tzadok.imperial.court.service.api.MemorialsService;
import com.tzadok.imperial.court.service.impl.MemorialsServiceImpl;
import com.tzadok.imperial.court.servlet.base.ModelBaseServlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "WorkServlet", value = "/work")
public class WorkServlet extends ModelBaseServlet {

    private MemorialsService memorialsService = new MemorialsServiceImpl();

    protected void showMemorialsDigestList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1.调用service方法查询数据
        List<Memorials> memorialsList = memorialsService.getAllMemorialsDigest();

        //2.查询的数据存入请求域
        request.setAttribute("memorialsList",memorialsList);

        //3.渲染视图
        String templateName = "memorials-list";
        processTemplate(templateName,request,response);
    }

    protected void showMemorialsDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1.从请求参数读取MemorialsId
        String memorialsId = request.getParameter("memorialsId");

        //2.根据memorialsId从service中查询memorials对象
        Memorials memorials = memorialsService.getMemorialsDetailById(memorialsId);

        //********************补充功能********************
        //获取奏折状态
        Integer memorialsStatus = memorials.getMemorialsStatus();

        //判断奏折状态
        if (memorialsStatus == 0){
            //更新奏折状态:数据库修改
            memorialsService.updateMemorialsStatusToRead(memorialsId);
            //更新奏折状态:当前对象修改
            memorials.setMemorialsStatus(1);

        }

        //********************补充功能********************

        //3.将memorials对象存入请求域
        request.setAttribute("memorials",memorials);

        //4.渲染视图
        String templateName = "memorials_detail";
        processTemplate(templateName,request,response);
    }


    protected void feedBack(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");

        //获取表单请求参数
        String memorialsId = request.getParameter("memorialsId");
        String feedbackContent = request.getParameter("feedbackContent");

        //执行更新
        memorialsService.updateMemorialsFeedBack(memorialsId,feedbackContent);

        //重定向回奏折页面
        response.sendRedirect(request.getContextPath() + "/work?method=showMemorialsDigestList");

    }
}
