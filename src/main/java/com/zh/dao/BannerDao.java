package com.zh.dao;


import com.zh.domain.Banner;

import java.util.List;

public interface BannerDao {

    int insertBanner(Banner banner);

    List<Banner> findBannerAll();
}
