package com.shoes.cart.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shoes.cart.api.Apis;
import com.shoes.cart.domin.dto.DeleteCartDTO;
import com.shoes.cart.domin.dto.InsertCartDTO;
import com.shoes.cart.domin.dto.UpdateCartDTO;
import com.shoes.cart.domin.query.QueryCartByCartId;
import com.shoes.cart.domin.query.QueryCartByUserIdPage;
import com.shoes.cart.domin.vo.cartVO;
import com.shoes.cart.service.CartService;
import com.shoes.common.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@Api(tags = "cart")
@Tag(name = "购物车模块", description = "实现对购物车的增删改查")
@RestController
@RequestMapping("/cart")
public class CartController implements Apis {
    @Autowired
    CartService cartService;


    @Override
    @ApiOperation("传入用户id，查询用户购物车中的全部数据")
    @GetMapping("/page")
    public ResultVO<Page<cartVO>> getCartByUserIdPage(QueryCartByUserIdPage queryCartByUserIdPage) {
        Page<cartVO> cartItemVOPage = cartService.getCartByUserIdPage(queryCartByUserIdPage);
        if (cartItemVOPage != null)
            return ResultVO.success(cartItemVOPage, "查询成功");
        else
            return ResultVO.failed("查询失败");
    }

    @Override
    @ApiOperation("传入用户购物车明细id，查询一条数据")
    @GetMapping("/cart")
    public ResultVO<cartVO> getCartByCartId(QueryCartByCartId queryCartByCartId) {
        System.out.println(queryCartByCartId);
        cartVO cartVO = cartService.getCartByCartId(queryCartByCartId);
        if (cartVO != null)
            return ResultVO.success(cartVO, "查询成功");
        else
            return ResultVO.failed("查询失败");
    }

    @Override
    @ApiOperation("更新一条数据")
    @PutMapping("/cart")
    public ResultVO<String > update(@RequestBody List<UpdateCartDTO> updateCartDTO) {
        String  cart = cartService.update(updateCartDTO);
        if (cart != null)
            return ResultVO.success("更新成功", "更新成功");
        else
            return ResultVO.failed("更新失败");
    }

    @Override
    @ApiOperation("传入用户购物车明细id，删除一条数据")
    @DeleteMapping("/CartIdBatch")
    public ResultVO<String> deleteByCartIdBatch(@RequestBody List<DeleteCartDTO> deleteCartDTO) {
        String message = cartService.deleteByCartIdBatch(deleteCartDTO);
        if (message != null)
            return ResultVO.success(message, "删除成功");
        else
            return ResultVO.failed("删除失败，无需删除");
    }

    @Override
    @ApiOperation("添加一条数据")
    @PostMapping("cart")
    public ResultVO<cartVO> insertCart(@RequestBody InsertCartDTO insertCartDTO) {
        cartVO cartVO = cartService.insertCart(insertCartDTO);
        if (cartVO != null)
            return ResultVO.success(cartVO, "添加成功");
        else
            return ResultVO.failed("添加失败");
    }
}
