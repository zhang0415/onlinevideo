package com.zh.service.impl;

import com.zh.dao.BannerDao;
import com.zh.domain.Banner;
import com.zh.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BannerServiceImpl implements BannerService {

    @Autowired
    BannerDao bannerDao;
    @Override
    public List<Banner> getIndexBanner() {
        return bannerDao.findBannerAll();
    }
}
