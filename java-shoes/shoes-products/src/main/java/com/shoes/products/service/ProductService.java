package com.shoes.products.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shoes.products.domin.dto.deleteDTO;
import com.shoes.products.domin.dto.insertDTO;
import com.shoes.products.domin.dto.updateDTO;
import com.shoes.products.domin.query.QueryAllPage;
import com.shoes.products.domin.query.QueryById;
import com.shoes.products.domin.vo.productVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ClassName service
 * @Description TODO
 * @Author CHY
 * @Date 2023/7/4 15:53
 * @Version 1.0
 */
@Service
@Transactional(rollbackFor = RuntimeException.class)
public interface ProductService {
    productVO insertProduct(insertDTO insertDTO);

    String delete(deleteDTO deleteDTO);

    productVO update(updateDTO updateDTO);

    productVO recover(QueryById queryById);

    Page<productVO> getProductsAll(QueryAllPage queryAllPage);

    Page<productVO> getDeleteProducts(QueryAllPage queryAllPage);

    productVO getProduct(QueryById queryById);

    List<productVO> updateBatch(List<updateDTO> updateDTO);
}
