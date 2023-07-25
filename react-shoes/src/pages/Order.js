import {Box, Button, Grid, ListItem, ListItemText, Typography} from "@mui/material";
import { useState } from "react";
import {styled} from "@mui/material/styles";
import "../style/BottomStyle.css";

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
            totalAmount: 500,
            status: '未支付',
        },
        {
            id: 2,
            name: '白露牌香奈儿鞋，闻着香，脚不臭',
            totalAmount: 300,
            status: '已支付',
        },
        {
            id: 3,
            name: '长城牌大力足球鞋，大力，就是牛',
            totalAmount: 700,
            status: '已支付',
        },
        // 如果需要，可以添加更多订单
    ]);

    const [editAddress, setEditAddress] = useState(false);
    const [addressValue, setAddressValue] = useState('越越の奶茶店');
    const [editOrderId, setEditOrderId] = useState(null);
    const handleRemoveItem = (id) => {
        setOrders(orders.filter(order => order.id !== id));
    };
    const handleAddressEdit = (order) => {
        setEditAddress(true);
        setAddressValue(order.address);
        setEditOrderId(order.id);
    };

    const handleAddressSave = () => {
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
            total += order.totalAmount;
        });
        return total;
    };


    return (
        <Box>
            <Box display="flex" justifyContent="space-between" alignItems="center" mb={2}>
                {editAddress ? (
                    <Box display="flex" alignItems="center">
                        <input
                            type="text"
                            value={addressValue}
                            onChange={(e) => setAddressValue(e.target.value)}
                        />
                        <Button variant="contained" onClick={handleAddressSave}>
                            保存
                        </Button>
                    </Box>
                ) : (
                    <Box display="flex" alignItems="center">
                        <Typography variant="body1">
                            用户地址：{addressValue}
                        </Typography>
                        <Button variant="contained" onClick={() => handleAddressEdit(orders[0])}>
                            编辑地址
                        </Button>
                    </Box>
                )}
            </Box>

            <Typography variant="h6">商品名称：</Typography>
            {orders.map(order => (
                <ListItem key={order.id}>
                    <ListItemText primary={order.name} />
                    <Button variant="contained" onClick={() => handleRemoveItem(order.id)}>
                        删除
                    </Button>
                </ListItem>
            ))}

            <Box display="flex" justifyContent="space-between" alignItems="center" mt={2} className='footers'>
                <Typography variant="h6">总计金额：{calculateTotal()}</Typography>
                <Button variant="contained" onClick={() => handlePayment(orders[0])}>
                    提交订单
                </Button>
            </Box>
        </Box>
    );
}