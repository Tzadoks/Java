package com.tzadok.maven;

import com.tzadok.imperial.court.dao.BaseDao;
import com.tzadok.imperial.court.entity.Emp;
import com.tzadok.imperial.court.util.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;
import java.util.List;

/**
 * @ProjectName: pro05-demo-all-in-one
 * @PackageName: com.tzadok.maven
 * @ClassName: ImperialCourtTesr
 * @Author: 小北
 * @Description:
 * @date: 2022/7/31 15:10
 */
public class ImperialCourtTest {

    private BaseDao<Emp> baseDao = new BaseDao<>();

    @Test
    public void testGetConnection(){
        Connection connection = JDBCUtils.getConnection();

        System.out.println("connection = " + connection);

        JDBCUtils.releaseConnection(connection);
    }

    @Test
    public void testGetSingleBean() {

        String sql = "select emp_id empId," +
                "emp_name empName," +
                "emp_position empPosition," +
                "login_account loginAccount," +
                "login_password loginPassword " +
                "from t_emp where emp_id=?";

        Emp emp = baseDao.getSingleBean(sql, Emp.class, 1);

        System.out.println("emp = " + emp);

    }

    @Test
    public void  testBeanList(){
        String sql = "select emp_id empId,emp_name empName,emp_position empPosition,login_account loginAccount,login_password loginPassword from t_emp ";

        List<Emp> list = baseDao.getBeanList(sql, Emp.class);

        for (Emp emp : list) {
            System.out.println("emp = " + emp);
        }

    }

    @Test
    public void testUpdate(){

        String sql = "update t_emp set emp_position = ? where emp_id = ?";

        String empPosition = "minister";

        String empId = "3";

        int update = baseDao.update(sql, empPosition, empId);

        System.out.println(update);
    }

    @Test
    public void test1(){
        System.out.println("你好啊啊");
    }
}
