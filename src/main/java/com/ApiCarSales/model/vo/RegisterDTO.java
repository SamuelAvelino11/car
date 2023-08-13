package com.ApiCarSales.model.vo;

import com.ApiCarSales.Interface.UserRole;

public record RegisterDTO(String login, String password, UserRole role) {

}
