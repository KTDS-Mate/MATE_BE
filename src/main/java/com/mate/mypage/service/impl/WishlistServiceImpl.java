package com.mate.mypage.service.impl;

import com.mate.mypage.dao.WishlistDao;
import com.mate.mypage.service.WishlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WishlistServiceImpl implements WishlistService {

    @Autowired
    private WishlistDao wishlistDao;


}
