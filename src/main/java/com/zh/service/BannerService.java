package com.zh.service;

import com.zh.domain.Banner;
import org.springframework.stereotype.Service;

import java.util.List;


public interface BannerService {

    List<Banner> getIndexBanner();

}
