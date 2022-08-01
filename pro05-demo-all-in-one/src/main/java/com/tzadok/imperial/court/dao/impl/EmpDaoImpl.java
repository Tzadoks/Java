package com.tzadok.imperial.court.dao.impl;

import com.tzadok.imperial.court.dao.BaseDao;
import com.tzadok.imperial.court.dao.api.EmpDao;
import com.tzadok.imperial.court.entity.Emp;

/**
 * @ProjectName: pro05-demo-all-in-one
 * @PackageName: com.tzadok.imperial.court.dao.impl
 * @ClassName: EmpDaoImpl
 * @Author: 小北
 * @Description:
 * @date: 2022/7/31 16:07
 */
public class EmpDaoImpl extends BaseDao<Emp> implements EmpDao {


    @Override
    public Emp selectEmpByLoginAccount(String loginAccount, String encodeLoginPassword) {

        //1.编写SQL语句
        String sql = "select emp_id empId," +
                "emp_name empName," +
                "emp_position empPosition," +
                "login_account loginAccount," +
                "login_password loginPassword " +
                "from t_emp where login_account = ? and login_password = ?";

        //2.调用父类的方法查询单个对象
        return super.getSingleBean(sql, Emp.class,loginAccount,encodeLoginPassword);
    }
}
