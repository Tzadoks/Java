package com.tzadok.imperial.court.dao.api;

import com.tzadok.imperial.court.entity.Emp;

/**
 * @ProjectName: pro05-demo-all-in-one
 * @PackageName: com.tzadok.imperial.court.dao.api
 * @ClassName: EmpDap
 * @Author: 小北
 * @Description:
 * @date: 2022/7/31 16:07
 */
public interface EmpDao {
    Emp selectEmpByLoginAccount(String loginAccount, String encodeLoginPassword);
}
