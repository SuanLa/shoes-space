import { Helmet } from 'react-helmet-async';
import { styled } from '@mui/material/styles';
import { Container, Typography } from '@mui/material';
import { useNavigate, useLocation } from 'react-router-dom';
import { useState, useEffect } from 'react';
import backgroundImage from './image/2.jpg';
import useResponsive from '../hooks/useResponsive';
import Logo from '../components/logo';
import Signup from './signup';
import LoginForm from '../sections/auth/login/LoginForm';



const StyledRoot = styled('div')(({ theme }) => ({
  [theme.breakpoints.up('md')]: {
    display: 'flex',
  },
  position: 'relative', // 添加相对定位
  backgroundImage: `url(${backgroundImage})`,
  backgroundSize: 'cover',
  backgroundPosition: 'center',
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

export default function LoginPage() {
  const mdUp = useResponsive('up', 'md');
  const location = useLocation();
  const navigate = useNavigate();
  const [isLoggedIn, setIsLoggedIn] = useState(false);
  const [showSignup, setShowSignup] = useState(false);
  const [showLoginForm, setShowLoginForm] = useState(true);
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
          <title>鞋城登录界面</title>
        </Helmet>

        <StyledRoot>
          <Logo
              sx={{
                position: 'fixed',
                top: { xs: 16, sm: 24, md: 40 },
                left: { xs: 16, sm: 24, md: 40 },
              }}
          />
          <Container maxWidth="sm"
                     sx={{
                       backgroundColor: 'rgba(255, 255, 255, 0.8)',
                       width: '100%',
                       height: '100%',
                     }}>
            <StyledContent>
              {!showSignup && ( // 在showSignup为false时显示
                <>
                  <Typography variant="h4" gutterBottom>
                    <h1>鞋城</h1>
                  </Typography>
                </>
            )}
              {showSignup && <Signup />}
              {showLoginForm && <LoginForm onLogin={handleLogin} />}
            </StyledContent>
          </Container>
        </StyledRoot>
      </>
  );
}

