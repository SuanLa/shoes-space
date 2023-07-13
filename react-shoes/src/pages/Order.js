import {
    Box,
    Button,
    ButtonGroup,
    Checkbox,
    Grid,
    ListItem,
    ListItemText,
    Stack,
    Typography
} from "@mui/material";
import AddIcon from '@mui/icons-material/Add';
import RemoveIcon from '@mui/icons-material/Remove';
import { useEffect, useState } from "react";
import {styled} from "@mui/material/styles";

const QuantityContainer = styled(Grid)(({ theme }) => ({
    display: "flex",
    alignItems: "center",
    gap: theme.spacing(0.2),
}));
function Number({ number, updateNumber }) {
    const [count, setCount] = useState(1);

    useEffect(() => {
        setCount(number);
    }, [number]);

    const handleIncrease = () => {
        setCount(count + 1);
        updateNumber(count + 1);
    };

    const handleReduce = () => {
        setCount(Math.max(count - 1, 0));
        updateNumber(Math.max(count - 1, 0));
    };

    return (
        <QuantityContainer>
            <ListItemText>{count}</ListItemText>
            <Button variant="contained" aria-label="increase" onClick={handleIncrease}>
                <AddIcon fontSize="inherit" />
            </Button>
            <Button variant="contained" aria-label="reduce" onClick={handleReduce}>
                <RemoveIcon fontSize="inherit" />
            </Button>
        </QuantityContainer>
    );
}

export default function Order() {
    const [arrays, setArrays] = useState([
        {
            'id': 1,
            'name': '长城牌大力足球鞋，大力，就是牛',
            'price': 100,
            'num': 1
        },
        {
            'id': 2,
            'name': '白露牌香奈儿鞋，闻着香，脚不臭',
            'price': 200,
            'num': 2
        },
        {
            'id': 3,
            'name': '这是一双你买了绝对不会后悔的鞋',
            'price': 300,
            'num': 2
        }
    ]);

    const handleRemoveItem = (id) => {
        setArrays(arrays.filter(array => array.id !== id));
    };

    const handleCheckout = () => {
        // 实现结算逻辑
        console.log('进行结算');
    };

    const calculateTotal = () => {
        let total = 0;
        arrays.forEach(array => {
            total += array.num * array.price;
        });
        return total;
    };

    return (
        <>
            <Box sx={{ flexGrow: 1 }}>
                <Grid container spacing={0}>
                    {arrays.map(array => (
                        <ListItem key={array.id}>
                            <Grid xs={1}>
                                <Checkbox />
                            </Grid>
                            <Grid xs={4}>
                                <ListItemText>{array.name}</ListItemText>
                            </Grid>
                            <Grid xs={3}>
                                <ListItemText>${array.price}</ListItemText>
                            </Grid>
                            <Grid xs={3}>
                                <Number number={array.num} updateNumber={(num) => {
                                    const updatedArrays = arrays.map(a => {
                                        if (a.id === array.id) {
                                            return { ...a, num };
                                        }
                                        return a;
                                    });
                                    setArrays(updatedArrays);
                                }} />
                            </Grid>
                            <Grid sx={1}>
                                <Button variant="contained" size='small' onClick={() => handleRemoveItem(array.id)}>×</Button>
                            </Grid>
                        </ListItem>
                    ))}
                </Grid>
            </Box>
        </>
    );
}
