import { Helmet } from 'react-helmet-async';
import { useState } from 'react';
// @mui
import { Container, Stack, Typography } from '@mui/material';
// components
import {useNavigate} from "react-router-dom";
import {LoadingButton} from "@mui/lab";
import { ProductSort, ProductList, ProductCartWidget, ProductFilterSidebar } from '../sections/@dashboard/products';
// mock
import PRODUCTS from '../_mock/products';

// ----------------------------------------------------------------------

export default function ProductsPage2() {
  const [openFilter, setOpenFilter] = useState(false);

  const navigate = useNavigate();

  const handleOpenFilter = () => {
    setOpenFilter(true);
  };
 const increate =()=>{

 }
  const Delete =()=>{

  }
  const change =()=>{

  }

  const handleCloseFilter = () => {
    setOpenFilter(false);
  };
  const pushGetway = () =>{
    navigate('/dashboard/show');
  }

  return (
    <>
      <Helmet>
        <title> 越越の奇妙鞋城 </title>
      </Helmet>

      <Container>
        <Typography variant="h4" sx={{ mb: 5 }}>
          以下是越越の奇妙鞋城的所有商品展示
        </Typography>
          <Stack direction="row" justifyContent="space-between" alignItems="center" sx={{ mb: 5 }}>
              <Stack direction="row" spacing={3} sx={{ my: 1 }}>
                  <LoadingButton fullWidth size="large" type="submit" variant="contained" onClick={increate}>
                      增加商品
                  </LoadingButton>
                  <LoadingButton fullWidth size="large" type="submit" variant="contained" onClick={Delete}>
                      删除商品
                  </LoadingButton>
                  <LoadingButton fullWidth size="large" type="submit" variant="contained" onClick={change}>
                      修改商品
                  </LoadingButton>
              </Stack>
              <Stack direction="row" spacing={1} flexShrink={0} sx={{ my: 1 }}>
                  <ProductFilterSidebar openFilter={openFilter} onOpenFilter={handleOpenFilter} onCloseFilter={handleCloseFilter} />
                  <ProductSort />
              </Stack>
          </Stack>
        <ProductList products={PRODUCTS} onClick={pushGetway}/>
        <ProductCartWidget />
      </Container>
    </>
  );
}
