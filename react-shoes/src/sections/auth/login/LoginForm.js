import {useContext, useState} from 'react';
import { useNavigate } from 'react-router-dom';
import { Link, Stack, IconButton, InputAdornment, TextField, Checkbox } from '@mui/material';
import { LoadingButton } from '@mui/lab';
import Iconify from '../../../components/iconify';
import {UserContext} from "../../../context/System";

export default function LoginForm({ onLogin }) {
    const navigate = useNavigate();
    const [isLoggedIn, setIsLoggedIn] = useState(false);
    const [showPassword, setShowPassword] = useState(false);
    const [usr,setUsr] = useState({username:null,password:null});

    const handleClick = () => {
        // const response = await loginUser();
        if (usr.username === "user") {
            navigate('/', { replace: true });
        }

        if (usr.username === "admin") {
            navigate('/dashboard/routes3', { replace: true });
        }
    };


    const loginUser = () => {
        // 模拟登录请求的异步操作
        return new Promise((resolve) => {
            // 假设在此处发送登录请求到后端进行验证
            // 根据后端返回的结果进行处理
            // 假设登录成功返回2，跳转至/routes2
            // 假设登录成功返回3，跳转至/routes3
            // 假设登录成功返回其他值，继续登录流程
            setTimeout(() => {
                resolve(2);
            }, 1000);
        });
    };

    if (isLoggedIn) {
        navigate('/dashboard/routes2', { replace: true });
    }

    return (
        <>
            <Stack spacing={3}>
                <TextField name="username" label="username" onChange={u=>setUsr({...usr,username: u.target.value})}/>
                <TextField
                    name="password"
                    label="Password"
                    type={showPassword ? 'text' : 'password'}
                    InputProps={{
                        endAdornment: (
                            <InputAdornment position="end">
                                <IconButton onClick={() => setShowPassword(!showPassword)} edge="end">
                                    <Iconify icon={showPassword ? 'eva:eye-fill' : 'eva:eye-off-fill'} />
                                </IconButton>
                            </InputAdornment>
                        ),
                    }}
                    onChange={p=>setUsr({...usr,password: p.target.value})}
                />
            </Stack>

            <Stack direction="row" alignItems="center" justifyContent="space-between" sx={{ my: 2 }}>
                <Checkbox name="remember" label="Remember me" />
                <Link variant="subtitle2" underline="hover">
                    忘记密码?点击这里
                </Link>
            </Stack>

            <UserContext.Provider value={usr.username}>
                <LoadingButton fullWidth size="large" type="submit" variant="contained" onClick={handleClick}>
                    登录
                </LoadingButton>
            </UserContext.Provider>
        </>
    );
}
