package com.qf.controller;

import com.alibaba.fastjson.JSON;
import com.qf.domain.ShopKinds;
import com.qf.domain.Shops;
import com.qf.response.Response;
import com.qf.service.ShopKindsService;
import com.qf.service.ShopsService;
import com.qf.utils.UploadUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

@RestController
public class ShopController {

    @Resource
    private ShopKindsService shopKindsService;

    @Resource
    private ShopsService shopsService;

    @Resource
    private UploadUtils uploadUtils;

    private Logger logger = LoggerFactory.getLogger(ShopController.class);


    @RequestMapping("findById/{shopId}")
    public Shops findById(@PathVariable int shopId){
        return shopsService.findByShopId(shopId);
    }

    //一级菜单
    @RequestMapping("/show1")
    public List<ShopKinds> show1(){
        //System.out.println(shopKindsService.show1());
        return shopKindsService.show1();
    }

    //二级菜单
    @RequestMapping("/show2/{ids}")
    public List<Shops> show2(@PathVariable("ids") Integer skId){
          return shopsService.show2(skId);
    }


    /*
     * 后台商品管理
     */
    @RequestMapping("/findAllShops/{page}/{size}")
    public Response findAllShops(@PathVariable("page") int page, @PathVariable("size") int size){
        return shopsService.findAllShops(page,size);
    }

    @RequestMapping("/deleteShops/{shopId}")
    public void deleteShops(@PathVariable int shopId){
        shopsService.deleteShops(shopId);
    }

    /*小图上传*/
    @RequestMapping("/upload")
    public String upload(MultipartFile file){

        logger.debug("传入的文件参数：{}", JSON.toJSONString(file, true));
        if (Objects.isNull(file) || file.isEmpty()) {
            logger.error("文件为空");
            return "fail";
        }else {
            String path = uploadUtils.upload(file);
//            System.out.println(path);
            return path;
        }

    }

    @RequestMapping("/addShops")
    public Shops addShops(@RequestBody Shops shops){
        return shopsService.addShops(shops);
    }

    @RequestMapping("/findShopsById/{shopId}")
    public Shops findShopsById(@PathVariable int shopId){
        return shopsService.findByShopId(shopId);
    }

    @RequestMapping("/updateShops")
    public Shops updateShops(@RequestBody Shops shops){
        return shopsService.addShops(shops);
    }

    /*
    *后台商品类别管理
    */
    @RequestMapping("/findAllKinds/{page}/{size}")
    public Response findAllKinds(@PathVariable("page") int page, @PathVariable("size") int size){
        return shopKindsService.findAllShopKinds(page,size);
    }

    @RequestMapping("/addShopKinds")
    public String addShopKinds(@RequestBody ShopKinds shopKinds){

        return shopKindsService.addShopKinds(shopKinds);
    }

    @RequestMapping("findShopKindsById/{skId}")
    public ShopKinds findShopKindsById(@PathVariable int skId){
        return shopKindsService.findShopKindsById(skId);
    }

    @RequestMapping("/updateShopKinds")
    public ShopKinds updateShopKinds(@RequestBody ShopKinds shopKinds){

        return shopKindsService.updateShopKinds(shopKinds);
    }

    @RequestMapping("/deleteShopKinds/{skId}")
    public void deleteShopKinds(@PathVariable int skId){

       shopKindsService.deleteShopKinds(skId);
    }
}
