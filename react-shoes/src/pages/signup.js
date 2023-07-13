import { Helmet } from 'react-helmet-async';
import { styled } from '@mui/material/styles';
import { Link, Container, Typography, Divider, Stack, Button } from '@mui/material';
import { useNavigate, useLocation } from 'react-router-dom';
import { useState, useEffect } from 'react';
import useResponsive from '../hooks/useResponsive';
import Logo from '../components/logo';
import Iconify from '../components/iconify';
import SignupForm from "./SignupForm";


const StyledRoot = styled('div')(({ theme }) => ({
    [theme.breakpoints.up('md')]: {
        display: 'flex',
    },
    position: 'relative', // 添加相对定位
}));

const StyledSection = styled('div')(({ theme }) => ({
    width: '100%',
    maxWidth: 480,
    display: 'flex',
    flexDirection: 'column',
    justifyContent: 'center',
    boxShadow: theme.customShadows.card,
    backgroundColor: theme.palette.background.default,
}));

const StyledContent = styled('div')(({ theme }) => ({
    maxWidth: 480,
    margin: 'auto',
    minHeight: '100vh',
    display: 'flex',
    justifyContent: 'center',
    flexDirection: 'column',
    padding: theme.spacing(12, 0),
}));

export default function Signup() {
    const mdUp = useResponsive('up', 'md');
    const location = useLocation();
    const navigate = useNavigate();
    const [isLoggedIn, setIsLoggedIn] = useState(false);

    useEffect(() => {
        if (isLoggedIn) {
            navigate('/dashboard/products', { replace: true });
        }
    }, [isLoggedIn, navigate]);

    const handleLogin = () => {
        setIsLoggedIn(true);
    };

    if (isLoggedIn) {
        return "routes2"; // 不渲染登录页面，直接跳转到目标页面
    }

    return (
        <>
            <Helmet>
                <title>越越の奇妙鞋城注册界面</title>
            </Helmet>

            <StyledRoot>
                <Logo
                    sx={{
                        position: 'fixed',
                        top: { xs: 16, sm: 24, md: 40 },
                        left: { xs: 16, sm: 24, md: 40 },
                    }}
                />
                <Container maxWidth="sm">
                    <StyledContent>
                        <Typography variant="h4" gutterBottom>
                            <h1>越越の奇妙鞋城</h1>
                        </Typography>
                        <SignupForm onLogin={handleLogin} />
                    </StyledContent>
                </Container>
            </StyledRoot>
        </>
    );
}

