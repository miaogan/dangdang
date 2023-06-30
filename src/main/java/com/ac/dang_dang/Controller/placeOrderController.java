package com.ac.dang_dang.Controller;

import com.ac.dang_dang.entity.TAddress;
import com.ac.dang_dang.service.impl.TAddressServiceImpl;
import com.ac.dang_dang.util.Result;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/placeOrder")
public class placeOrderController {
    final
    TAddressServiceImpl AddressService;

    public placeOrderController(TAddressServiceImpl AddressService) {
        this.AddressService = AddressService;
    }
    /**
     * 添加地址
     */
    @PostMapping("/addAddress")
    public Result addAddress(@RequestBody TAddress address) {
        TAddress sameAddress = AddressService.getSameAddress(address);
        if (sameAddress==null){
            AddressService.save(address);
            return Result.success("添加成功");
        }
        return Result.error("地址已存在");
    }
    /**
     * 更新地址
     */
    @PostMapping("/updateAddress")
    public Result updateAddress(@RequestBody TAddress address) {
        AddressService.updates(address);
        return Result.success("更新成功");
    }
    /**
     * 删除地址
     */
    @DeleteMapping("/deleteAddress")
    public Result deleteAddress(Integer id){
        AddressService.removeById(id);
        return Result.success("删除成功");
    }
    /**
     * 获取地址
     */
    @PostMapping("/getAddress")
    public Result getAddress(String userId){
        List<TAddress> allAddress = AddressService.getAllAddress(userId);
        return Result.success(allAddress);
    }
}
