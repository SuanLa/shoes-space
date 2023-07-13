import { faker } from '@faker-js/faker';
import { sample } from 'lodash';

// ----------------------------------------------------------------------

const PRODUCT_NAME = [
  '长城牌大力足球鞋，大力，就是牛',
  '超级涡轮增压鞋，不怕折，足够硬',
  '白露牌香奈儿鞋，闻着香，脚不臭',
  '这是一双你买了绝对不会后悔的鞋',
  '白熊牌傲娇小鞋，送一双白熊袜子',
  '水熊修身运动鞋，心飞扬，透心凉',
  '青梅虹鞋，牵红线，只为月老而生',
  '武松v8.0，上山打老虎，不怕',
  '环保地球鞋，纯白还不欲？',
  '海飞丝，清爽一夏',
  '远星，你忠实的伙伴',
  '征服，征服对手，征服世界',
  '老骥伏枥，志在千里',
  '鸡你太美~',
  '喜洋洋运动鞋，纯白天花板',
  '一路修心，落笔从容',
  '静莲，一个只做女鞋的品牌',
  '王炸，你值得信赖',
  '花好月圆，老祖宗都说好的品牌',
  '鸭鸭，破绽，焼冻鸡翅~',
  '古楼阁，那是一个旗袍的时代',
  '向日葵，希望你每一天都元气满满',
  '愿天堂没有资本',
  '这是一双老北京布鞋',
];
const PRODUCT_COLOR = ['#00AB55', '#000000', '#FFFFFF', '#FFC0CB', '#FF4842', '#1890FF', '#94D82D', '#FFC107'];

// ----------------------------------------------------------------------

const products = [...Array(24)].map((_, index) => {
  const setIndex = index + 1;

  return {
    id: faker.datatype.uuid(),
    cover: `/assets/images/products/product_${setIndex}.jpg`,
    name: PRODUCT_NAME[index],
    price: faker.datatype.number({ min: 4, max: 99, precision: 0.01 }),
    priceSale: setIndex % 3 ? null : faker.datatype.number({ min: 19, max: 29, precision: 0.01 }),
    colors:
      (setIndex === 1 && PRODUCT_COLOR.slice(0, 2)) ||
      (setIndex === 2 && PRODUCT_COLOR.slice(1, 3)) ||
      (setIndex === 3 && PRODUCT_COLOR.slice(2, 4)) ||
      (setIndex === 4 && PRODUCT_COLOR.slice(3, 6)) ||
      (setIndex === 23 && PRODUCT_COLOR.slice(4, 6)) ||
      (setIndex === 24 && PRODUCT_COLOR.slice(5, 6)) ||
      PRODUCT_COLOR,
    status: sample(['sale', 'new', '', '']),
  };
});

export default products;
