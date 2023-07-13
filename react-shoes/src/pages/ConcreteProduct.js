import {Helmet} from "react-helmet-async";
import {Container, Typography, Button} from "@mui/material";
import { useState } from "react";

const productsData = [
    {
        id: "1676980720629305346",
        title: "长城大力",
        description: "长城牌大力足球鞋，大力，就是牛",
        price: 89,
        image: "/assets/images/products/product_1.jpg",
    },
    // Add more products here
];
export default function ConcreteProduct(){
    const [currentProductIndex, setCurrentProductIndex] = useState(0);
    const [isHovered, setIsHovered] = useState(false);
    const handleNext = () => {
        setCurrentProductIndex((prevIndex) => (prevIndex + 1) % productsData.length);
    };

    const handlePrevious = () => {
        setCurrentProductIndex((prevIndex) => (prevIndex - 1 + productsData.length) % productsData.length);
    };
    const handleMouseEnter = () => {
        setIsHovered(true);
    };

    const handleMouseLeave = () => {
        setIsHovered(false);
    };
    const handleAddToCart = () => {
        // 处理将商品添加到购物车的逻辑
        console.log("商品已添加到购物车");
    };

    const currentProduct = productsData[currentProductIndex];
    return(
        <>
            <Helmet>
                <title> 商品信息详情 </title>
            </Helmet>
            <Container>
                <div style={{display: "flex", gap: "2rem"}}>
                    <div style={{flex: 1}}>
                        <img
                            src={currentProduct.image}
                            alt={currentProduct.title}
                            style={{width: "100%", height: "auto"}}
                            onMouseEnter={handleMouseEnter}
                            onMouseLeave={handleMouseLeave}
                        />
                    </div>
                    <div
                        style={{
                            flex: 1,
                            display: "flex",
                            flexDirection: "column",
                            gap: "2rem",
                            justifyContent: "flex-start",
                        }}
                    >
                        <Typography variant="h5" gutterBottom style={{fontSize: "1.5rem"}}>
                            <h1>{currentProduct.title}</h1>
                        </Typography>
                        <Typography variant="body2" color="text.secondary" style={{fontSize: "1.2rem"}}>
                            <h2>商品详情：<br/></h2>
                                {currentProduct.description}
                        </Typography>
                        <Typography variant="body2" color="text.secondary" style={{fontSize: "1.2rem"}}>
                            <h2>价格：￥{currentProduct.price}</h2>
                        </Typography>
                        <Button
                            variant="contained"
                            onClick={handleAddToCart}
                            style={{fontSize: "1.2rem", padding: "0.8rem 2rem", marginTop: "auto"}}
                        >
                            加入购物车
                        </Button>
                    </div>
                </div>
            </Container>
        </>
    );
}