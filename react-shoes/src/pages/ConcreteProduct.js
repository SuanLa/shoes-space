import {Helmet} from "react-helmet-async";
import {Card, CardContent, CardMedia, Container, Typography} from "@mui/material";

export default function ConcreteProduct({data}){

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
            </Container>
        </>
    )
}