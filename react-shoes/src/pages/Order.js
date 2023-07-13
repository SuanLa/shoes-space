import { Box, Button, Checkbox, Grid, ListItem, ListItemText } from "@mui/material";
import { useEffect, useState } from "react";
import {styled} from "@mui/material/styles";

const QuantityContainer = styled(Grid)(({ theme }) => ({
    display: "flex",
    alignItems: "center",
    gap: theme.spacing(0.2),
}));

export default function Order() {
    const [orders, setOrders] = useState([
        {
            id: 1,
            name: '这是一双你买了绝对不会后悔的鞋',
            customerId: '张三的油纸伞',
            orderDate: '2023-07-13',
            totalAmount: 500,
            status: '未支付',
            address: '提瓦特大陆',
        },
        {
            id: 2,
            name: '白露牌香奈儿鞋，闻着香，脚不臭',
            customerId: '张三的油纸伞',
            orderDate: '2023-6-21',
            totalAmount: 300,
            status: '已支付',
            address: '星际和平公司',
        },
        {
            id: 3,
            name: '长城牌大力足球鞋，大力，就是牛',
            customerId: '张三的油纸伞',
            orderDate: '2023-05-20',
            totalAmount: 700,
            status: '已支付',
            address: '黑塔空间站',
        },
        // 如果需要，可以添加更多订单
    ]);

    const [editAddress, setEditAddress] = useState(false);
    const [addressValue, setAddressValue] = useState('');
    const [editOrderId, setEditOrderId] = useState(null);
    const handleRemoveItem = (id) => {
        setOrders(orders.filter(order => order.id !== id));
    };
    const handleAddressEdit = (order) => {
        setEditAddress(true);
        setAddressValue(order.address);
        setEditOrderId(order.id);
    };

    const handleAddressSave = (order) => {
        setEditAddress(false);
        // 更新订单地址
        const updatedOrders = orders.map(order => {
            if (order.id === editOrderId) {
                return { ...order, address: addressValue };
            }
            return order;
        });
        setOrders(updatedOrders);
        setEditOrderId(null);
    };

    const handlePayment = (order) => {
        // 处理支付逻辑
        console.log('支付订单', order.id);
    };

    const calculateTotal = () => {
        let total = 0;
        orders.forEach(order => {
            total += order.num * order.price;
        });
        return total;
    };

    return (
        <>
            <Box sx={{ flexGrow: 1 }}>
                <Grid container spacing={0}>
                    <ListItem>
                        <Grid item xs={2.5}>
                            <ListItemText>商品名称</ListItemText>
                        </Grid>
                        <Grid item xs={1.7}>
                            <ListItemText>用户ID</ListItemText>
                        </Grid>
                        <Grid item xs={1.5}>
                            <ListItemText>下单时间</ListItemText>
                        </Grid>
                        <Grid item xs={1.7}>
                            <ListItemText>￥价格</ListItemText>
                        </Grid>
                        <Grid item xs={2}>
                            <ListItemText>订单地址</ListItemText>
                        </Grid>
                    </ListItem>
                    {orders.map(order => (
                        <ListItem key={order.id}>
                            <Grid item xs={3}>
                                <ListItemText>{order.name}</ListItemText>
                            </Grid>
                            <Grid item xs={2}>
                                <ListItemText>{order.customerId}</ListItemText>
                            </Grid>
                            <Grid item xs={2}>
                                <ListItemText>{order.orderDate}</ListItemText>
                            </Grid>
                            <Grid item xs={2}>
                                <ListItemText>￥{order.totalAmount}</ListItemText>
                            </Grid>
                            <Grid item xs={3}>
                                {editAddress && editOrderId === order.id ? (
                                    <>
                                        <input
                                            type="text"
                                            value={addressValue}
                                            onChange={e => setAddressValue(e.target.value)}
                                        />
                                        <Button variant="contained" size="small" onClick={handleAddressSave}>
                                            确认
                                        </Button>
                                    </>
                                ) : (
                                    <ListItemText>{order.address}</ListItemText>
                                )}
                            </Grid>
                            <Grid item xs={1}>
                                <Button
                                    variant="contained"
                                    size="small"
                                    onClick={() => handleAddressEdit(order)}
                                >
                                    修改地址
                                </Button>
                            </Grid>
                            <Grid item xs={1}>
                                {order.status === '未支付' && (
                                    <Button variant="contained" size="small" onClick={() => handlePayment(order)}>
                                        支付
                                    </Button>
                                )}
                            </Grid>
                            <Grid item xs={1}>
                                <Button variant="contained" size="small" onClick={() => handleRemoveItem(order.id)}>
                                    ×
                                </Button>
                            </Grid>
                        </ListItem>
                    ))}
                </Grid>
            </Box>
        </>
    );
}