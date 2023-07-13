package com.shoes.cart.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shoes.cart.domin.dto.DeleteCartDTO;
import com.shoes.cart.domin.dto.InsertCartDTO;
import com.shoes.cart.domin.dto.UpdateCartDTO;
import com.shoes.cart.domin.query.QueryCartByCartId;
import com.shoes.cart.domin.query.QueryCartByUserIdPage;
import com.shoes.cart.domin.vo.cartVO;
import com.shoes.cart.entity.cart;
import com.shoes.cart.mapper.cartMapper;
import com.shoes.cart.service.CartService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    cartMapper cartMapper;

    @Override
    @Cacheable("cart")
    public Page<cartVO> getCartByUserIdPage(QueryCartByUserIdPage queryCartByUserIdPage) {
        System.out.println(queryCartByUserIdPage);
        if (queryCartByUserIdPage != null) {
            QueryWrapper<cart> queryWrapper = new QueryWrapper<>();
            Page<cart> page = new Page<>(queryCartByUserIdPage.getPageNo(),
                    queryCartByUserIdPage.getPageSize());
            queryWrapper.eq("user_id", queryCartByUserIdPage.getUserId());
            Page<cart> cartPage = cartMapper.selectPage(page, queryWrapper);
            Page<cartVO> cartVOPage = new Page<>();
            BeanUtils.copyProperties(cartPage, cartVOPage);
            return cartVOPage;
        } else
            return null;
    }


    @Override
    @Cacheable("cart")
    public cartVO getCartByCartId(QueryCartByCartId queryCartByCartId) {
        System.out.println(queryCartByCartId);
        cart cart = cartMapper.selectById(queryCartByCartId.getCartId());
        cartVO cartVO = new cartVO();
        if (cart != null) {
            BeanUtils.copyProperties(cart, cartVO);
            return cartVO;
        } else
            return null;
    }

    @Override
    @CachePut("cart")
    public String update(List<UpdateCartDTO> updateCartDTO) {
        cart cart = new cart();
        int count = 0;
        for (UpdateCartDTO cartDTO : updateCartDTO) {
            BeanUtils.copyProperties(cartDTO, cart);
            count += cartMapper.updateById(cart);
        }
        if (count == updateCartDTO.size()) {
            return "更新成功";
        } else
            return null;
    }

    @Override
    @CacheEvict("cart")
    public String deleteByCartIdBatch(List<DeleteCartDTO> deleteCartDTOList) {
        int count = 0;
        for (DeleteCartDTO cartDTO : deleteCartDTOList) {
            count += cartMapper.deleteById(cartDTO.getCartId());
        }
        if (count == deleteCartDTOList.size()) {
            return "删除成功";
        } else
            return null;
    }

    @Override
    @CachePut("cart")
    public cartVO insertCart(InsertCartDTO insertCartDTO) {
        cart cart = new cart();
        BeanUtils.copyProperties(insertCartDTO, cart);
        int count = cartMapper.insert(cart);
        if (count == 1) {
            cart cartTemp = cartMapper.selectById(cart.getCartId());
            cartVO cartVO = new cartVO();
            BeanUtils.copyProperties(cartTemp, cartVO);
            return cartVO;
        } else
            return null;
    }
}
