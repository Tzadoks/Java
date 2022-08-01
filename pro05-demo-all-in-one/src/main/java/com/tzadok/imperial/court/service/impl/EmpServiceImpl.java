package com.tzadok.imperial.court.service.impl;

import com.tzadok.imperial.court.dao.api.EmpDao;
import com.tzadok.imperial.court.dao.impl.EmpDaoImpl;
import com.tzadok.imperial.court.entity.Emp;
import com.tzadok.imperial.court.exception.LoginFailedException;
import com.tzadok.imperial.court.service.api.EmpService;
import com.tzadok.imperial.court.util.ImperialCourtConst;
import com.tzadok.imperial.court.util.MD5Util;

/**
 * @ProjectName: pro05-demo-all-in-one
 * @PackageName: com.tzadok.imperial.court.service.impl
 * @ClassName: EmpServiceImpl
 * @Author: 小北
 * @Description:
 * @date: 2022/7/31 22:51
 */
public class EmpServiceImpl implements EmpService {

    private EmpDao empDao = new EmpDaoImpl();

    @Override
    public Emp getEmpByLoginAccount(String loginAccount, String loginPassword) {

        //1.对密码进行加密
        String encodeLoginPassword = MD5Util.encode(loginPassword);
        //2.根据账户和加密密码查询数据
        Emp emp = empDao.selectEmpByLoginAccount(loginAccount,encodeLoginPassword);
        //3.检查Emp对象是否为null
        if (emp != null){
            //①不为null：返回emp
            return emp;
        }else{
            //②为null，抛登录失败异常
            throw new LoginFailedException(ImperialCourtConst.LOGIN_FAILED_MESSAGE);
        }
    }
}
