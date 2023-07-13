// component
import SvgColor from '../../../components/svg-color';

// ----------------------------------------------------------------------

const icon = (name) => <SvgColor src={`/assets/icons/navbar/${name}.svg`} sx={{ width: 1, height: 1 }} />;

const navConfig3 = [
  {
    title: '分析报表',
    path: '/dashboard/app',
    icon: icon('ic_analytics'),
  },
  {
    title: '用户信息',
    path: '/dashboard/user',
    icon: icon('ic_user'),
  },
  {
    title: '商城',
    path: '/dashboard/products2',
    icon: icon('ic_shop'),
  },
  /*
{
  title: 'blog',
  path: '/dashboard/blog',
  icon: icon('ic_blog'),
},
*/
  /*
    {
    title: 'Not found',
    path: '/404',
    icon: icon('ic_disabled'),
  },
  */
];


export default navConfig3;
