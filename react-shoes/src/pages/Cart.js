import {Box, Button, ButtonGroup, Checkbox, Grid, ListItem, ListItemText, Stack, Typography} from "@mui/material";
import AddIcon from '@mui/icons-material/Add';
import RemoveIcon from '@mui/icons-material/Remove';
import {useEffect, useState} from "react";
import '../style/BottomStyle.css';
import {styled} from "@mui/material/styles";

const StyledProductImg = styled('img')({
    top: 0,
    width: '15%',
    height: '80%',
    objectFit: 'cover',
    position: 'absolute',
});

function Number({number,sum,setSum,price}){
    const [count,setCount] = useState(1)

    useEffect(
        ()=>{
            setCount(number)
        },[]
    )

    return(
        <>
            <Grid container>
                <Grid container direction='row' spacing={1}>
                    <ButtonGroup>
                        <Grid xs={1}>
                            <ListItemText>{count}</ListItemText>
                        </Grid>
                        <Button
                            variant='contained'
                            aria-label="increase"
                            onClick={() => {
                                setCount(count + 1);
                                setSum(sum+price)
                            }}
                        >
                            <AddIcon fontSize="inherit" />
                        </Button>
                        <Button
                            variant='contained'
                            aria-label="reduce"
                            onClick={() => {
                                setCount(Math.max(count - 1, 0));
                                if (count!==0)
                                {
                                    setSum(sum-price)
                                }
                            }}
                        >
                            <RemoveIcon fontSize="inherit" />
                        </Button>
                    </ButtonGroup>
                </Grid>
            </Grid>
        </>
    )
}

export default function CartPage(){
    const [arrays,setArrays] = useState([
        {
            'id': 1,
            'name': 'Nike Air Force 1 NDESTRUKT',
            'src': '/assets/images/products/product_1.jpg',
            'price': 100,
            'num': 1
        },{
            'id': 2,
            'name': 'Nike Space Hippie 04',
            'src': '/assets/images/products/product_2.jpg',
            'price': 200,
            'num': 2
        },{
            'id': 3,
            'name': 'Nike Blazer Low 77 Vintage',
            'src': '/assets/images/products/product_3.jpg',
            'price': 300,
            'num': 2
        },
        {
            'id': 4,
            'name': 'Nike Air Force 1 NDESTRUKT',
            'src': '/assets/images/products/product_4.jpg',
            'price': 100,
            'num': 1
        },{
            'id': 5,
            'name': 'Nike Space Hippie 04',
            'src': '/assets/images/products/product_5.jpg',
            'price': 200,
            'num': 2
        },{
            'id': 6,
            'name': 'Nike Blazer Low 77 Vintage',
            'src': '/assets/images/products/product_6.jpg',
            'price': 300,
            'num': 2
        },
        {
            'id': 7,
            'name': 'Nike Air Force 1 NDESTRUKT',
            'src': '/assets/images/products/product_7.jpg',
            'price': 100,
            'num': 1
        },{
            'id': 8,
            'name': 'Nike Space Hippie 04',
            'src': '/assets/images/products/product_8.jpg',
            'price': 200,
            'num': 2
        },{
            'id': 9,
            'name': 'Nike Blazer Low 77 Vintage',
            'src': '/assets/images/products/product_9.jpg',
            'price': 300,
            'num': 2
        },
        {
            'id': 10,
            'name': 'Nike Air Force 1 NDESTRUKT',
            'src': '/assets/images/products/product_10.jpg',
            'price': 100,
            'num': 1
        },{
            'id': 11,
            'name': 'Nike Space Hippie 04',
            'src': '/assets/images/products/product_11.jpg',
            'price': 200,
            'num': 2
        },{
            'id': 12,
            'name': 'Nike Blazer Low 77 Vintage',
            'src': '/assets/images/products/product_12.jpg',
            'price': 300,
            'num': 2
        }
    ]);

    const [sum,setSum] = useState(0);

    useEffect(
        ()=>{
            let cal = 0;
            arrays.reduce(product=> {
                // eslint-disable-next-line no-return-assign
                return cal += product.num * product.price
            })
            setSum(cal)
        },[]
    )


    return(
        <>
            <Box sx={{flexGrow: 1}}>
                <Grid container spacing={0}>
                    {
                        arrays.map(array=>(
                                <ListItem key={array.id}>
                                    <Grid xs={1}>
                                        <Checkbox indeterminate/>
                                    </Grid>
                                    <Grid xs={3}>
                                        <StyledProductImg alt={array.name} src={array.src} />
                                    </Grid>
                                    <Grid xs={2}>
                                        <ListItemText>{array.name}</ListItemText>
                                    </Grid>
                                    <Grid xs={2}>
                                        <ListItemText>${array.price}</ListItemText>
                                    </Grid>
                                    <Grid xs={3}>
                                        <Number number={array.num} sum={sum} setSum={setSum} price={array.price}/>
                                    </Grid>
                                    <Grid sx={1}>
                                        <Button variant="contained" size='small' onClick={()=>{
                                            setArrays(
                                                arrays.filter(a=> a.id!==array.id)
                                            )
                                        }}>×</Button>
                                    </Grid>
                                </ListItem>
                            )
                        )
                    }
                </Grid>
            </Box>
            <Stack direction="row" spacing={2} className='footers'>
                <Grid xs={4}>
                    <Checkbox/>
                </Grid>
                <Grid xs={4}>
                    <Typography variant='button'>合计: {sum}</Typography>
                </Grid>
                <Grid xs={4}>
                    <Button variant='contained' color='info'>去结算</Button>
                </Grid>
            </Stack>
        </>
    )
}