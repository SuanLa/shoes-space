package com.shoes.products.api;



import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shoes.common.ResultVO;
import com.shoes.products.domin.dto.deleteDTO;
import com.shoes.products.domin.dto.insertDTO;
import com.shoes.products.domin.dto.updateDTO;
import com.shoes.products.domin.query.QueryAllPage;
import com.shoes.products.domin.query.QueryById;
import com.shoes.products.domin.vo.productVO;
import io.swagger.annotations.Api;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 测试接口
 *
 * @Author: Tomcat
 * @Date: 2023/7/6
 **/
@Api
@FeignClient(name = "product-service",url = "",path = "/product")
public interface Apis {
    @PostMapping("/product")//添加一个产品
    ResultVO<productVO> insertProduct(@RequestBody insertDTO insertDTO);
    @DeleteMapping("/{productId}")
    ResultVO<String> delete(@PathVariable("productId")deleteDTO deleteDTO);

    @PutMapping("/product")
    ResultVO<productVO> update(@RequestBody updateDTO updateDTO);

    @PutMapping("/productBatch")
    ResultVO<List<productVO>> updateBatch(@RequestBody List<updateDTO> updateDTO);

    @PutMapping("/recover")
    ResultVO<productVO> recover(@RequestParam("productId")QueryById queryById);

    @GetMapping("/page")
    ResultVO<Page<productVO>> getProductsAll(QueryAllPage queryAllPage);

    @GetMapping("/{productId}")
    ResultVO<productVO> getProduct(@PathVariable("productId")QueryById queryById);

    @GetMapping("/deletion")
    ResultVO<Page<productVO>> getDeleteProducts(QueryAllPage queryAllPage);

}
