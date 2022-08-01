package com.tzadok.imperial.court.servlet.module;

/**
 * @ProjectName: pro05-demo-all-in-one
 * @PackageName: ${PACKAGE_NAME}
 * @ClassName: ${NAME}
 * @Author: 小北
 * @Description:
 * @date: 2022/7/31 18:09
 */

import com.tzadok.imperial.court.servlet.base.ViewBaseServlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "PortalServlet", value = "/")
public class PortalServlet extends ViewBaseServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //声明访问的首页的逻辑视图

        String templateName = "index";

        //调用父类的方法根据逻辑视图名称渲染视图
        processTemplate(templateName,request,response);

    }
}
