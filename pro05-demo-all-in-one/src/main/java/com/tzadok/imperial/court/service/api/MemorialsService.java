package com.tzadok.imperial.court.service.api;

import com.tzadok.imperial.court.entity.Memorials;

import java.util.List;

/**
 * @ProjectName: pro05-demo-all-in-one
 * @PackageName: com.tzadok.imperial.court.service.api
 * @ClassName: MemorialsService
 * @Author: 小北
 * @Description:
 * @date: 2022/8/1 9:39
 */
public interface MemorialsService {

    List<Memorials> getAllMemorialsDigest();

    Memorials getMemorialsDetailById(String memorialsId);

    void updateMemorialsStatusToRead(String memorialsId);

    void updateMemorialsFeedBack(String memorialsId, String feedbackContent);
}
