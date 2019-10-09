package com.qf.response;

import com.qf.domain.Users;
import lombok.Data;

@Data
public class UserCode {
    private Users users;
    private String code;
}
