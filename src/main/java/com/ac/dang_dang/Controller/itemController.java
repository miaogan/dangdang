package com.ac.dang_dang.Controller;

import com.ac.dang_dang.service.impl.TItemServiceImpl;
import com.ac.dang_dang.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/item")
public class itemController {
    final
    TItemServiceImpl ItemServiceImpl;

    public itemController(TItemServiceImpl ItemServiceImpl) {
        this.ItemServiceImpl = ItemServiceImpl;
    }

}
