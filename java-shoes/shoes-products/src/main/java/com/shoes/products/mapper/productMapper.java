package com.shoes.products.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.shoes.products.entity.product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ClassName productMapper
 * @Description TODO
 * @Author CHY
 * @Date 2023/7/4 15:40
 * @Version 1.0
 */
@Mapper
@Repository
public interface productMapper extends BaseMapper<product> {
    @Update("update product set product_delete = 0 " +
            "where product_id= #{productId} and product_delete = 1")
    public int recover(@Param("productId") String productId);

    @Select("select product_id,product_name,product_description, " +
            "product_price,product_number,product_img " +
            "from product where product_delete = 1 " +
            "order by product_price ")
    List<product> getDeleteProductsAsc(@Param("pageNo") int pageNo, @Param("pageSize") int pageSize);

    @Select("select product_id,product_name,product_description," +
            "product_price,product_number,product_img " +
            " from product where product_delete = 1 " +
            "order by product_price desc ")
    List<product> getDeleteProductsDesc(@Param("pageNo") int pageNo, @Param("pageSize") int pageSize);

 }
