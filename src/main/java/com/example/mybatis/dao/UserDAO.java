package com.example.mybatis.dao;

import com.example.mybatis.dto.UserDTO;

import java.util.List;

public interface UserDAO {
    List <UserDTO> selectUsers(UserDTO param) throws Exception;
}
