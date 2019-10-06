package com.qf.response;

import com.qf.domain.Shops;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;
@Data
public class AddShops {
    private Shops shops;
    private MultipartFile file;
}
