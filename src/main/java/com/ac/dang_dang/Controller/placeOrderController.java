package com.ac.dang_dang.Controller;

import com.ac.dang_dang.entity.TAddress;
import com.ac.dang_dang.service.impl.TAddressServiceImpl;
import com.ac.dang_dang.util.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/placeOrder")
@Slf4j
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
        if (sameAddress == null) {
            AddressService.save(address);
            return Result.success("添加成功");
        }
        return Result.error("地址已存在");
    }

    /**
     * 更新地址
     */
    @PutMapping("/updateAddress")
    public Result updateAddress(@RequestBody TAddress address) {
        log.info("address" + address);
        Integer updates = AddressService.updates(address);
        if (updates == 1) {
            return Result.success("更新成功");
        }else{
            return Result.error("更新失败");
        }
    }

    /**
     * 删除地址
     */
    @DeleteMapping("/{addressId}")
    public Result deleteAddress(@PathVariable Integer addressId) {
        AddressService.removeById(addressId);
        return Result.success("删除成功");
    }

    /**
     * 获取地址
     */
    @GetMapping("/{userId}")
    public Result getAddress(@PathVariable Integer userId, Integer addressId) {
        List<TAddress> allAddress = AddressService.getAllAddress(userId, addressId);
        return Result.success(allAddress);
    }
}
