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
import {useEffect, useState} from "react";
import '../style/BottomStyle.css';

function Number({number}){
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
                            }}
                        >
                            <AddIcon fontSize="inherit" />
                        </Button>
                        <Button
                            variant='contained'
                            aria-label="reduce"
                            onClick={() => {
                                setCount(Math.max(count - 1, 0));
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
            'price': 100,
            'num': 1
        },{
            'id': 2,
            'name': 'Nike Space Hippie 04',
            'price': 200,
            'num': 2
        },{
            'id': 3,
            'name': 'Nike Blazer Low 77 Vintage',
            'price': 300,
            'num': 2
        }
    ]);

    const sum = () => {
        let money = 0;
        return arrays.map(array=>(
            money = money + array.num * array.price
        ))
    }

    return(
        <>
            <Box sx={{flexGrow: 1}}>
                <Grid container spacing={0}>
                    {
                        arrays.map(array=>(
                                <ListItem key={array.id}>
                                    <Grid xs={1}>
                                        <Checkbox/>
                                    </Grid>
                                    <Grid xs={4}>
                                        <ListItemText>{array.name}</ListItemText>
                                    </Grid>
                                    <Grid xs={3}>
                                        <ListItemText>${array.price}</ListItemText>
                                    </Grid>
                                    <Grid xs={3}>
                                        <Number number={array.num}/>
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