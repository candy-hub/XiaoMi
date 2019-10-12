package com.qf.controller;

import com.qf.domain.ResponseShops;
import com.qf.domain.ShopKinds;
import com.qf.domain.Shops;
import com.qf.response.Response;
import com.qf.response.ShopFuzzyQuery;
import com.qf.service.ShopKindsService;
import com.qf.service.ShopsService;
import com.qf.utils.UploadUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.*;
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

    @RequestMapping(value = "findById/{shopId}",method = RequestMethod.GET)
    public Shops findById(@PathVariable int shopId){
        return shopsService.findByShopId(shopId);
    }

    //详情页轮播图
    @RequestMapping(value = "findPic/{shopId}",method = RequestMethod.GET)
    public List findPic(@PathVariable Integer shopId){
        return shopsService.findPic(shopId);
    }

    //一级菜单
    @RequestMapping(value = "/show1",method = RequestMethod.GET)
    public List<ShopKinds> show1(){
        //System.out.println(shopKindsService.show1());
        return shopKindsService.show1();
    }

    //轮播图
    @RequestMapping(value = "/showlbt",method = RequestMethod.GET)
    public List<Shops> showlbt(){
        return shopsService.showlbt(1);
    }

    //手机专场
    @RequestMapping(value = "/showPhone",method = RequestMethod.GET)
    public List<Shops> showPhone(){
        return shopsService.showlbt(2);
    }

    //二级菜单
    @RequestMapping(value = "/show2/{ids}",method = RequestMethod.GET)
    public List<Shops> show2(@PathVariable("ids") Integer skId){
          return shopsService.show2(skId);
    }

    //热卖商品
    @RequestMapping(value = "/showRM/{page}/{size}",method = RequestMethod.GET)
    public ResponseShops showRM(@PathVariable("page") Integer page, @PathVariable("size") Integer size){
       return shopsService.showRM(page, size);
    }

    //模糊查询商品展示
    @RequestMapping(value = "/vague/{name}",method = RequestMethod.GET)
    public List<Shops> vague(@PathVariable("name") String name){
      return shopsService.vague(name);
    }

    /*
     * 后台商品管理
     */
    @RequestMapping(value = "/findAllShops/{page}/{size}",method = RequestMethod.GET)
    public Response findAllShops(@PathVariable("page") int page, @PathVariable("size") int size){
        return shopsService.findAllShops(page,size);
    }

    @RequestMapping(value = "/findByValues/{page}/{size}",method = RequestMethod.POST)
    public Response findByValues(@PathVariable("page") int page, @PathVariable("size") int size, @RequestBody ShopFuzzyQuery shopFuzzyQuery){

        return shopsService.ShopFuzzyQuery(page,size,shopFuzzyQuery);
    }

    @RequestMapping(value = "/orderShops/{page}/{size}/{name}",method = RequestMethod.POST)
    public Response orderShops(@PathVariable("page") int page, @PathVariable("size") int size,@PathVariable("name") String name){
        System.out.println(name);
        return shopsService.orderShops(page,size,name);
    }

    @RequiresPermissions(value = {"deleteShops"})
    @RequestMapping(value = "/deleteShops/{shopId}",method = RequestMethod.GET)
    public String deleteShops(@PathVariable int shopId){

        return  shopsService.deleteShops(shopId);
    }

    /*小图上传*/
    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    public String upload(MultipartFile file){

//        logger.debug("传入的文件参数：{}", JSON.toJSONString(file, true));
        if (Objects.isNull(file) || file.isEmpty()) {
            return "fail";
        }else {
            String path = uploadUtils.upload(file);
//            System.out.println(path);
            return path;
        }

    }

    @RequiresPermissions(value = {"addShops"})
    @RequestMapping(value = "/addShops",method = RequestMethod.POST)
    public String addShops(@RequestBody Shops shops){
        return shopsService.addShops(shops);
    }

    @RequestMapping(value = "/findShopsById/{shopId}",method = RequestMethod.GET)
    public Shops findShopsById(@PathVariable int shopId){
        return shopsService.findByShopId(shopId);
    }

    @RequiresPermissions(value = {"updateShops"})
    @RequestMapping(value = "/updateShops",method = RequestMethod.POST)
    public String updateShops(@RequestBody Shops shops){
        return shopsService.addShops(shops);
    }

    /*
    *后台商品类别管理
    */
    @RequestMapping(value = "/findAllKinds/{page}/{size}",method = RequestMethod.GET)
    public Response findAllKinds(@PathVariable("page") int page, @PathVariable("size") int size){
        return shopKindsService.findAllShopKinds(page,size);
    }

    @RequestMapping(value = "/addShopKinds",method = RequestMethod.POST)
    public String addShopKinds(@RequestBody ShopKinds shopKinds){

        return shopKindsService.addShopKinds(shopKinds);
    }

    @RequestMapping(value = "findShopKindsById/{skId}",method = RequestMethod.GET)
    public ShopKinds findShopKindsById(@PathVariable int skId){
        return shopKindsService.findShopKindsById(skId);
    }

    @RequestMapping(value = "/updateShopKinds",method = RequestMethod.POST)
    public ShopKinds updateShopKinds(@RequestBody ShopKinds shopKinds){

        return shopKindsService.updateShopKinds(shopKinds);
    }

    @RequestMapping(value = "/deleteShopKinds/{skId}",method = RequestMethod.GET)
    public void deleteShopKinds(@PathVariable int skId){

       shopKindsService.deleteShopKinds(skId);
    }
}
