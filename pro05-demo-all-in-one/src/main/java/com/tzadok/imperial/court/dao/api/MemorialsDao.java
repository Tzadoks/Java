package com.tzadok.imperial.court.dao.api;

import com.tzadok.imperial.court.entity.Memorials;

import java.util.List;

/**
 * @ProjectName: pro05-demo-all-in-one
 * @PackageName: com.tzadok.imperial.court.dao.api
 * @ClassName: MemorialsDao
 * @Author: 小北
 * @Description:
 * @date: 2022/7/31 16:08
 */
public interface MemorialsDao {
    List<Memorials> selectAllMemorialsDigest();

    Memorials selectMemorialsById(String memorialsId);

    void updateMemorialsStatusToRead(String memorialsId);

    void updateMemorialsFeedBack(String memorialsId, String feedbackContent);
}
