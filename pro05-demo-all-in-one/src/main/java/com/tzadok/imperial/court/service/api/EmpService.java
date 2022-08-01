package com.tzadok.imperial.court.service.api;

import com.tzadok.imperial.court.entity.Emp;

/**
 * @ProjectName: pro05-demo-all-in-one
 * @PackageName: com.tzadok.imperial.court.service.api
 * @ClassName: EmpService
 * @Author: 小北
 * @Description:
 * @date: 2022/7/31 22:51
 */
public interface EmpService {
    Emp getEmpByLoginAccount(String loginAccount, String loginPassword);
}
