package com.shoes.cart.api;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shoes.cart.domin.dto.DeleteCartDTO;
import com.shoes.cart.domin.dto.InsertCartDTO;
import com.shoes.cart.domin.dto.UpdateCartDTO;
import com.shoes.cart.domin.query.QueryCartByCartId;
import com.shoes.cart.domin.query.QueryCartByUserIdPage;
import com.shoes.cart.domin.vo.cartVO;
import com.shoes.common.ResultVO;

import java.util.List;

/**
 * 测试接口
 *
 * @Author: Tomcat
 * @Date: 2023/7/6
 **/
public interface Apis {
    ResultVO<Page<cartVO>> getCartByUserIdPage(QueryCartByUserIdPage queryCartByUserIdPage);

    ResultVO<cartVO> getCartByCartId(QueryCartByCartId queryCartByCartId);

    ResultVO<String> update(List<UpdateCartDTO> updateCartDTO);

    ResultVO<String> deleteByCartIdBatch(List<DeleteCartDTO> deleteCartDTOList);

    ResultVO<cartVO> insertCart(InsertCartDTO insertCartDTO);

}
