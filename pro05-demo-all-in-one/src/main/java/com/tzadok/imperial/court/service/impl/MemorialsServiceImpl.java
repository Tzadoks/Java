package com.tzadok.imperial.court.service.impl;

import com.tzadok.imperial.court.dao.api.MemorialsDao;
import com.tzadok.imperial.court.dao.impl.MemorialsDaoImpl;
import com.tzadok.imperial.court.entity.Memorials;
import com.tzadok.imperial.court.service.api.MemorialsService;

import java.util.List;

/**
 * @ProjectName: pro05-demo-all-in-one
 * @PackageName: com.tzadok.imperial.court.service.impl
 * @ClassName: MemorialsServiceImpl
 * @Author: 小北
 * @Description:
 * @date: 2022/8/1 9:40
 */
public class MemorialsServiceImpl implements MemorialsService {

    private MemorialsDao memorialsDao = new MemorialsDaoImpl();

    @Override
    public List<Memorials> getAllMemorialsDigest() {

        return memorialsDao.selectAllMemorialsDigest();
    }

    @Override
    public Memorials getMemorialsDetailById(String memorialsId) {

        return memorialsDao.selectMemorialsById(memorialsId);
    }

    @Override
    public void updateMemorialsStatusToRead(String memorialsId) {

        memorialsDao.updateMemorialsStatusToRead(memorialsId);
    }

    @Override
    public void updateMemorialsFeedBack(String memorialsId, String feedbackContent) {
        memorialsDao.updateMemorialsFeedBack(memorialsId,feedbackContent);
    }
}
