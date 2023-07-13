import { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import {
    Link,
    Stack,
    IconButton,
    InputAdornment,
    TextField,
    Checkbox,
    FormControl,
    RadioGroup,
    FormControlLabel, Radio
} from '@mui/material';
import { LoadingButton } from '@mui/lab';
import Iconify from '../components/iconify';


export default function SignupForm({ onLogin }) {
    const navigate = useNavigate();
    const [isLoggedIn, setIsLoggedIn] = useState(false);
    const [showPassword, setShowPassword] = useState(false);
    const [formData, setFormData] = useState({
        nickname: '',
        fullName: '',
        password: '',
        confirmPassword: '',
        birthdate: '',
        gender: ''
    });
    const handleChange = (event) => {
        const { name, value } = event.target;
        setFormData((prevData) => ({
            ...prevData,
            [name]: value
        }));
    };
    const handleClick = async () => {
        const response = await signUser();

        if (response === 1) {
            navigate('/dashboard/Login', { replace: true });
        } else {
            setIsLoggedIn(true);
            onLogin();
        }
    };


    const signUser = () => {
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
        navigate('/dashboard/product', { replace: true });
    }

    return (
        <>
            <Stack spacing={3}>
                <TextField name="email" label="Email address" />
                <TextField name="nickname" label="昵称" value={formData.nickname} onChange={handleChange} />
                <TextField name="fullName" label="姓名" value={formData.fullName} onChange={handleChange} />
                <TextField
                    name="password"
                    label="密码"
                    type={showPassword ? 'text' : 'password'}
                    value={formData.password}
                    onChange={handleChange}
                    InputProps={{
                        endAdornment: (
                            <InputAdornment position="end">
                                <IconButton onClick={() => setShowPassword(!showPassword)} edge="end">
                                    <Iconify icon={showPassword ? 'eva:eye-fill' : 'eva:eye-off-fill'} />
                                </IconButton>
                            </InputAdornment>
                        ),
                    }}
                />
                <TextField
                    name="birthdate"
                    label="出生日期"
                    type="date"
                    value={formData.birthdate}
                    onChange={handleChange}
                />
                <FormControl component="fieldset">
                    <RadioGroup name="gender" value={formData.gender} onChange={handleChange}>
                        <FormControlLabel value="male" control={<Radio />} label="男" />
                        <FormControlLabel value="female" control={<Radio />} label="女" />
                    </RadioGroup>
                </FormControl>
            </Stack>

            <LoadingButton fullWidth size="large" type="submit" variant="contained" onClick={handleClick}>
                注册
            </LoadingButton>
        </>
    );
}
