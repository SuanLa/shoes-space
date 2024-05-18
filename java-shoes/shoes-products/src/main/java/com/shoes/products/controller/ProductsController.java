package com.shoes.products.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shoes.common.ResultVO;
import com.shoes.products.api.Apis;
import com.shoes.products.domin.dto.deleteDTO;
import com.shoes.products.domin.dto.insertDTO;
import com.shoes.products.domin.dto.updateDTO;
import com.shoes.products.domin.query.QueryAllPage;
import com.shoes.products.domin.query.QueryById;
import com.shoes.products.domin.vo.productVO;
import com.shoes.products.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName controller
 * @Description TODO
 * @Author CHY
 * @Date 2023/7/4 15:03
 * @Version 1.0
 */

@Log4j2
@Api(tags = "product")
@Tag(name = "商品模块", description = "实现对商品的增删改查")
@RestController
@RequestMapping("/product")
public class ProductsController implements Apis {
    @Autowired
    private ProductService productService;



    @Override
    @PostMapping("/product")//添加一个产品
    @ApiOperation("添加一个产品")
    public ResultVO<productVO> insertProduct(@RequestBody insertDTO insertDTO) {
        productVO productVO = productService.insertProduct(insertDTO);
        if (productVO != null)
            return ResultVO.success(productVO, "添加成功");
        else
            return ResultVO.failed("添加失败");
    }

    @Override
    @DeleteMapping("/{productId}")//通过传入的productId进行删除
    @ApiOperation("通过传入的productId查找商品进行逻辑删除")
    public ResultVO<String> delete(@PathVariable("productId") deleteDTO deleteDTO) {
        String flag = productService.delete(deleteDTO);
        if (flag != null)
            return ResultVO.success(flag, "删除成功");
        else
            return ResultVO.failed("删除失败,未找到改产品信息");
    }

    @Override
    @PutMapping("/product")
    @ApiOperation("通过传入product更新一个产品信息")
    public ResultVO<productVO> update(@RequestBody updateDTO updateDTO) {
        productVO productVO = productService.update(updateDTO);
        if (productVO != null)
            return ResultVO.success(productVO, "更新成功");
        else
            return ResultVO.failed("更新失败，未查询到该商品");
    }

    @Override
    @PutMapping("/recover")
    @ApiOperation("实现逻辑恢复功能，通过传入product_id查找")
    public ResultVO<productVO> recover(@RequestParam("productId") QueryById queryById) {
        /**
         * 逻辑恢复，
         * 通过传入的id将对应商品的product_delete 改为 0，
         * 返回受影响的行数，
         * 查询成功后返回这个商品的全部信息
         */
        productVO productVO = productService.recover(queryById);
        if (productVO != null)
            return ResultVO.success(productVO, "恢复成功");
        else
            return ResultVO.failed("该商品无需恢复");
    }

    @Override
    @GetMapping("/page")
    @ApiOperation("查询全部商品分页展示")
    public ResultVO<Page<productVO>> getProductsAll(QueryAllPage queryAllPage) {
        Page<productVO> productVOIPageVO = productService.getProductsAll(queryAllPage);
        if (productVOIPageVO != null) {
//            System.out.println(productVOIPageVO);
//            byte[] bytes;
//            try {
//                bytes = objectMapper.writeValueAsString(productVOIPageVO).getBytes();
//            } catch (JsonProcessingException e) {
//                throw new RuntimeException(e);
//            }
//            Message message=new Message();
//            message.setTopic("product-page");
//            message.setBody(bytes);
//            rocketMQTemplate.convertAndSend(message);
            return ResultVO.success(productVOIPageVO, "查询成功");
            // 发送购物车更新的消息到RocketMQ
        }
        else
            return ResultVO.failed("未查询到商品信息");
    }


    @Override
    @GetMapping("/{productId}")
    @ApiOperation("根据id查询一个商品")
    public ResultVO<productVO> getProduct(@PathVariable("productId") QueryById queryById) {
        productVO productVO = productService.getProduct(queryById);
        if (productVO != null)
            return ResultVO.success(productVO, "查询成功");
        else
            return ResultVO.failed("该商品信息不存在");
    }

    @Override
    @GetMapping("/deletion")//分页展示被删除的商品
    @ApiOperation("分页展示被删除的商品")
    public ResultVO<Page<productVO>> getDeleteProducts(QueryAllPage queryAllPage) {
        Page<productVO> deleteProducts = productService.getDeleteProducts(queryAllPage);
        if (deleteProducts != null)
            return ResultVO.success(deleteProducts, "查询成功");
        else
            return ResultVO.failed("为查询到信息");
    }

    @Override
    @PutMapping("/productBatch")
    @ApiOperation("通过传入 id 和num 批量更新一个产品信息")
    public ResultVO<List<productVO>> updateBatch(@RequestBody List<updateDTO> updateDTOList) {
        List<productVO> productVO = productService.updateBatch(updateDTOList);
        if (productVO != null)
            return ResultVO.success(productVO, "批量修改商品库存成功");
        else
            return ResultVO.failed("修改失败");
    }
}
