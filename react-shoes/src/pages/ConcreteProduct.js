import {Helmet} from "react-helmet-async";
import {Button, Card, CardContent, CardMedia, Container, Typography} from "@mui/material";
import {useState} from "react";
import "../style/BottomStyle.css";

export default function ConcreteProduct(){
    const [data,setData] = useState(100)

    return(
        <>
            <Helmet>
                <title> Dashboard: ConcreteProduct | Minimal UI </title>
            </Helmet>
            <Container>
                <Card sx={{ maxWidth: 500 }}>
                    <CardMedia
                        sx={{ height: 200 }}
                        image="/static/images/cards/contemplative-reptile.jpg"
                        title="green iguana"
                    />
                    <CardContent>
                        <Typography gutterBottom variant="h5" component="div">
                            Lizard
                        </Typography>
                        <Typography variant="body2" color="text.secondary">
                            Lizards are a widespread group of squamate reptiles, with over 6,000
                            species, ranging across all continents except Antarctica
                        </Typography>
                    </CardContent>
                </Card>
                <Container>
                    <Typography variant='button'>价格: ${data}</Typography>
                </Container>
                <Container>
                    <Button variant="contained" size='large'>加入购物车</Button>
                </Container>
            </Container>
        </>
    )
}