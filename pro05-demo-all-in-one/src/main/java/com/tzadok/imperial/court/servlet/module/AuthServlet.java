package com.tzadok.imperial.court.servlet.module; /**
 * @ProjectName: pro05-demo-all-in-one
 * @PackageName: ${PACKAGE_NAME}
 * @ClassName: ${NAME}
 * @Author: 小北
 * @Description:
 * @date: 2022/7/31 22:45
 */

import com.tzadok.imperial.court.entity.Emp;
import com.tzadok.imperial.court.exception.LoginFailedException;
import com.tzadok.imperial.court.service.api.EmpService;
import com.tzadok.imperial.court.service.impl.EmpServiceImpl;
import com.tzadok.imperial.court.servlet.base.ModelBaseServlet;
import com.tzadok.imperial.court.util.ImperialCourtConst;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "AuthServlet", value = "/auth")
public class AuthServlet extends ModelBaseServlet {

    private EmpService empService = new EmpServiceImpl();

    protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            //1.获取请求参数
            String loginAccount = request.getParameter("loginAccount");
            String loginPassword = request.getParameter("loginPassword");
            //2.调用EmpService 方法去执行登录逻辑
            Emp emp = empService.getEmpByLoginAccount(loginAccount,loginPassword);

            //3.创建session对象
            HttpSession session = request.getSession();

            //4.存入session域
            session.setAttribute(ImperialCourtConst.LOGIN_EMP_ATTR_NAME,emp);

            //5.前往指定页面
            //临时页面
//            String templateName = "temp";
//            processTemplate(templateName,request,response);

            //目标地址
            response.sendRedirect(request.getContextPath()+"/work?method=showMemorialsDigestList");

        } catch (Exception e) {
            e.printStackTrace();

            //6.判断是否登陆失败
            if (e instanceof LoginFailedException){
                //7.登陆失败返回登录页面
                //①异常信息存入session域
                request.setAttribute("message",e.getMessage());
                //②处理视图：index
                processTemplate("index",request,response);
            }else {
                //8如果不是登录异常则封装为运行时异常继续抛出
                throw new RuntimeException(e);
            }
        }
    }

    protected void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1.通过request对象获取httpSession对象
        HttpSession session = request.getSession();
        //2.将HttpSession对象强制失效
        session.invalidate();
        //3.回到首页
        String templateName = "index";
        processTemplate(templateName,request,response);
    }
}
