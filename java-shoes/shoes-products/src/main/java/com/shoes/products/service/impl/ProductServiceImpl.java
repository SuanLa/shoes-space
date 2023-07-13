package com.shoes.products.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shoes.products.domin.dto.deleteDTO;
import com.shoes.products.domin.dto.insertDTO;
import com.shoes.products.domin.dto.updateDTO;
import com.shoes.products.domin.query.QueryAllPage;
import com.shoes.products.domin.query.QueryById;
import com.shoes.products.domin.vo.productVO;
import com.shoes.products.entity.product;
import com.shoes.products.mapper.productMapper;
import com.shoes.products.service.ProductService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName myServiceImpl
 * @Description TODO
 * @Author CHY
 * @Date 2023/7/4 22:31
 * @Version 1.0
 */
@Service
@Transactional(rollbackFor = RuntimeException.class)
public class ProductServiceImpl implements ProductService {
    @Autowired
    productMapper productMapper;


    @CachePut(value = "product" )
    public productVO insertProduct(@NotNull insertDTO insertDTO) {
        product product = new product();
        //productId是通过雪花算法实现
        product.setProductName(insertDTO.getProductName());
        product.setProductDescription(insertDTO.getProductDescription());
        product.setProductPrice(insertDTO.getProductPrice());
        product.setProductNumber(insertDTO.getProductNumber());
        product.setProductImg(insertDTO.getProductImg());
        int flag = productMapper.insert(product);
        if (flag == 1) {//插入成功
            product productTemp = productMapper.selectById(product.getProductId());
            productVO productVO = new productVO();
            BeanUtils.copyProperties(productTemp, productVO);
            return productVO;
        }
        return null;
    }


    @CacheEvict(value = "product" )
    public String delete(@NotNull deleteDTO deleteDTO) {
        int flag = productMapper.deleteById(deleteDTO.getProductId());
        String temp = null;
        if (flag == 1) {
            temp = "删除成功";
            return temp;
        } else
            return null;
    }

    @CachePut(value = "product" )
    public productVO update(updateDTO updateDTO) {
        product product = new product();
        BeanUtils.copyProperties(updateDTO, product);
        System.out.println(product);
        System.out.println(updateDTO);
        int count = productMapper.updateById(product);
        productVO productVO = new productVO();
        if (count == 1) {
            new product();
            product productTemp;
            productTemp = productMapper.selectById(product.getProductId());
            BeanUtils.copyProperties(productTemp, productVO);
            return productVO;
        } else
            return null;
    }

    @CachePut(value = "product" )
    public List<productVO> updateBatch(List<updateDTO> updateDTOList) {
        int count = 0;
        for (updateDTO updateDTO : updateDTOList) {
            product product=new product();
            BeanUtils.copyProperties(updateDTO,product);
            count += productMapper.updateById(product);
        }
        if (count == updateDTOList.size()) {
            List<String> list = new ArrayList<>();
            for (updateDTO dto : updateDTOList) {
                list.add(dto.getProductId());
            }
            List<product> productList = productMapper.selectBatchIds(list);
            List<productVO> productVOList = new ArrayList<>();
            for (product productTemp : productList) {
                productVO productVOTemp = new productVO();
                BeanUtils.copyProperties(productTemp, productVOTemp);
                productVOList.add(productVOTemp);
            }
            return productVOList;
        } else
            return null;
    }


    @CachePut(value = "product" )
    public productVO recover(QueryById queryById) {
        /**
         * 逻辑恢复，
         * 通过传入的id将对应商品的product_delete 改为 0，
         * 返回受影响的行数，
         * 查询成功后返回这个商品的全部信息
         */
        int flag = productMapper.recover(queryById.getProductId());
        System.out.println(flag);
        productVO productVO = new productVO();
        if (flag == 1) {
            QueryWrapper<product> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("product_id", queryById.getProductId());
            product product = productMapper.selectOne(queryWrapper);
            BeanUtils.copyProperties(product, productVO);
            return productVO;
        } else
            return null;
    }


    @Cacheable(value = "product" )
    public Page<productVO> getProductsAll(QueryAllPage queryAllPage) {
        QueryWrapper<product> queryWrapper = new QueryWrapper<>();
        if (queryAllPage != null) {
            if (queryAllPage.getOrder().equals("ASC") ||
                    queryAllPage.getOrder().equals("asc"))
                queryWrapper.orderByAsc("product_price");
            if (queryAllPage.getOrder().equals("DESC") ||
                    queryAllPage.getOrder().equals("desc"))
                queryWrapper.orderByDesc("product_price");
            Page<product> page = new Page<>(queryAllPage.getPageNo(), queryAllPage.getPageSize());
            Page<product> productPage = productMapper.selectPage(page, queryWrapper);
            Page<productVO> productVOPage = new Page<>();
            BeanUtils.copyProperties(productPage, productVOPage);
            return productVOPage;
        }
        return null;
    }

    @Cacheable(value = "product" )
    public Page<productVO> getDeleteProducts(QueryAllPage queryAllPage) {
        List<product> productList;
        if (queryAllPage.getOrder() != null && (queryAllPage.getOrder().equals("DESC") ||
                queryAllPage.getOrder().equals("desc")))
            productList = productMapper.getDeleteProductsDesc(queryAllPage.getPageNo(), queryAllPage.getPageSize());
        else
            productList = productMapper.getDeleteProductsAsc(queryAllPage.getPageNo(), queryAllPage.getPageSize());
        if (productList != null) {
            int pageNo = queryAllPage.getPageNo(); // 当前页码
            int pageSize = queryAllPage.getPageSize(); // 每页大小
            long total = productList.size(); // 符合查询条件的总记录数
            Page<product> page = new Page<>(pageNo, pageSize, total);
            page.setRecords(productList);
            Page<productVO> productVOIPage = new Page<>();
            BeanUtils.copyProperties(page, productVOIPage);
            return productVOIPage;
        } else return null;
    }

    @Cacheable(value = "product" )
    public productVO getProduct(QueryById queryById) {
        product product = productMapper.selectById(queryById);
        productVO productVO = new productVO();
        if (product != null) {
            BeanUtils.copyProperties(product, productVO);
            return productVO;
        } else
            return null;
    }
}
