import { useState } from 'react';
import { useNavigate } from 'react-router-dom';
// @mui
import { Link, Stack, IconButton, InputAdornment, TextField, Checkbox } from '@mui/material';
import { LoadingButton } from '@mui/lab';
// components
import axios from "axios";
import Iconify from '../../../components/iconify';

// ----------------------------------------------------------------------

export default function LoginForm() {
  const navigate = useNavigate();

  const [showPassword, setShowPassword] = useState(false);

  const [form,setForm] = useState({username:null,password:null})

  const handleClick = () => {
    // navigate('/dashboard', { replace: true });
      axios.post('http://localhost:21000/admin/login',{
          username: form.username,
          password: form.password
      }).then((response) => {

          if (response.data.code===0){
              navigate('/dashboard/app')
          }
      }).catch((error) =>{
          console.log(error);
      })
  };

  return (
    <>
      <Stack spacing={3}>
        <TextField name="username" label="username" onChange={(u)=>setForm({...form,username: u.target.value})}/>

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
          onChange={(p)=>setForm({...form, password: p.target.value})}
        />
      </Stack>

      <Stack direction="row" alignItems="center" justifyContent="space-between" sx={{ my: 2 }}>
        <Checkbox name="remember" label="Remember me" />
        <Link variant="subtitle2" underline="hover">
          Forgot password?
        </Link>
      </Stack>

      <LoadingButton fullWidth size="large" type="submit" variant="contained" onClick={handleClick}>
        Login
      </LoadingButton>
    </>
  );
}
