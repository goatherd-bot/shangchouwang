package com.atguigu.crowd.service.api;

import com.atguigu.crowd.entity.Admin;

import java.util.List;

/**
 * @author rookie
 * @create 2021-10-02-22:31
 */
public interface AdminService {

    void saveAdmin(Admin admin);

    List<Admin> getAll();
}
