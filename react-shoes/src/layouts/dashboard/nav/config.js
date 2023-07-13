// component
import SvgColor from '../../../components/svg-color';

// ----------------------------------------------------------------------

const icon = (name) => <SvgColor src={`/assets/icons/navbar/${name}.svg`} sx={{ width: 1, height: 1 }} />;

const navConfig = [
  // {
  //   title: 'user',
  //   path: '/dashboard/user',
  //   icon: icon('ic_user'),
  // },
  {
    title: '商城',
    path: '/dashboard/products',
    icon: icon('ic_shop'),
  },
    /*
  {
    title: 'blog',
    path: '/dashboard/blog',
    icon: icon('ic_blog'),
  },
  */
  {
    title: '登录',
    path: '/login',
    icon: icon('ic_lock'),
  },
  /*
    {
    title: 'Not found',
    path: '/404',
    icon: icon('ic_disabled'),
  },
  */
];

export default navConfig;
