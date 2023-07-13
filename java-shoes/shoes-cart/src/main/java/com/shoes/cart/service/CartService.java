package com.shoes.cart.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shoes.cart.domin.dto.DeleteCartDTO;
import com.shoes.cart.domin.dto.InsertCartDTO;
import com.shoes.cart.domin.dto.UpdateCartDTO;
import com.shoes.cart.domin.query.QueryCartByCartId;
import com.shoes.cart.domin.query.QueryCartByUserIdPage;
import com.shoes.cart.domin.vo.cartVO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CartService {
    Page<cartVO> getCartByUserIdPage(QueryCartByUserIdPage queryCartByUserIdPage);

    cartVO getCartByCartId(QueryCartByCartId queryCartByCartId);

    String  update(List<UpdateCartDTO> updateCartDTO);

    String deleteByCartIdBatch(List<DeleteCartDTO> deleteCartDTOList);

    cartVO insertCart(InsertCartDTO insertCartDTO);
}
