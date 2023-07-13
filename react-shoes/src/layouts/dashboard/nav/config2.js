// component
import SvgColor from '../../../components/svg-color';

// ----------------------------------------------------------------------

const icon = (name) => <SvgColor src={`/assets/icons/navbar/${name}.svg`} sx={{ width: 1, height: 1 }} />;

// config2.js
const navConfig2 = [
  {
        title: '商城',
        path: '/dashboard/products',
        icon: icon('ic_shop'),
  },
  {
        title: '购物车',
        path: '/dashboard/cart',
        icon: icon('ic_cart'),
  },
  {
        title:'我的订单',
        path: '/dashboard/order',
        icon: icon('ic_blog'),
  },
  // 其他导航栏项...
];

export default navConfig2;

