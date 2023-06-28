package com.ac.dang_dang.Controller;

import com.ac.dang_dang.entity.TAddress;
import com.ac.dang_dang.service.impl.TAddressServiceImpl;
import com.ac.dang_dang.util.Result;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/placeOrder")
public class placeOrderController {
    final
    TAddressServiceImpl AddressService;

    public placeOrderController(TAddressServiceImpl AddressService) {
        this.AddressService = AddressService;
    }

    @PostMapping("/addAddress")
    public Result addAddress(@RequestBody TAddress address){
        AddressService.add(address);
        return Result.success();
    }
}
