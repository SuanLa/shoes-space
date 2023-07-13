import { Helmet } from 'react-helmet-async';
import { faker } from '@faker-js/faker';
// @mui
import { useTheme } from '@mui/material/styles';
import { Grid, Container, Typography } from '@mui/material';
// components
import Iconify from '../components/iconify';
// sections
import {
  AppTasks,
  AppNewsUpdate,
  AppOrderTimeline,
  AppCurrentVisits,
  AppWebsiteVisits,
  AppTrafficBySite,
  AppWidgetSummary,
  AppCurrentSubject,
  AppConversionRates,
} from '../sections/@dashboard/app';

// ----------------------------------------------------------------------

export default function DashboardAppPage() {
  const theme = useTheme();

  return (
    <>
      <Helmet>
        <title> 统计报表界面 </title>
      </Helmet>

      <Container maxWidth="xl">
        <Typography variant="h4" sx={{ mb: 5 }}>
          嘿，我亲爱的管理员同志，欢迎回来
        </Typography>

        <Grid container spacing={3}>
          <Grid item xs={12} sm={6} md={3}>
            <AppWidgetSummary title="安卓用户数量" total={114000} icon={'ant-design:android-filled'} />
          </Grid>

          <Grid item xs={12} sm={6} md={3}>
            <AppWidgetSummary title="苹果用户数量" total={13528} color="info" icon={'ant-design:apple-filled'} />
          </Grid>

          <Grid item xs={12} sm={6} md={3}>
            <AppWidgetSummary title="应用浏览数量" total={472300} color="warning" icon={'ant-design:windows-filled'} />
          </Grid>

          <Grid item xs={12} sm={6} md={3}>
            <AppWidgetSummary title="出现bug次数" total={234} color="error" icon={'ant-design:bug-filled'} />
          </Grid>

          <Grid item xs={12} md={6} lg={8}>
            <AppWebsiteVisits
              title="用户报表分析图"
              subheader="(+43%) 比去年"
              chartLabels={[
                '01/01/2003',
                '02/01/2003',
                '03/01/2003',
                '04/01/2003',
                '05/01/2003',
                '06/01/2003',
                '07/01/2003',
                '08/01/2003',
                '09/01/2003',
                '10/01/2003',
                '11/01/2003',
              ]}
              chartData={[
                {
                  name: '1号分店',
                  type: 'column',
                  fill: 'solid',
                  data: [23, 11, 22, 27, 13, 22, 37, 21, 44, 22, 30],
                },
                {
                  name: '2号分店',
                  type: 'area',
                  fill: 'gradient',
                  data: [44, 55, 41, 67, 22, 43, 21, 41, 56, 27, 43],
                },
                {
                  name: '3号分店',
                  type: 'line',
                  fill: 'solid',
                  data: [30, 25, 36, 30, 45, 35, 64, 52, 59, 36, 39],
                },
              ]}
            />
          </Grid>

          <Grid item xs={12} md={6} lg={4}>
            <AppCurrentVisits
              title="地区分布比例"
              chartData={[
                { label: '美洲', value: 4344 },
                { label: '亚洲', value: 5435 },
                { label: '欧洲', value: 1443 },
                { label: '非洲', value: 4443 },
              ]}
              chartColors={[
                theme.palette.primary.main,
                theme.palette.info.main,
                theme.palette.warning.main,
                theme.palette.error.main,
              ]}
            />
          </Grid>

          <Grid item xs={12} md={6} lg={8}>
            <AppConversionRates
              title="按国家增长数量"
              subheader="(+43%)比去年"
              chartData={[
                { label: '意大利', value: 400 },
                { label: '日本', value: 430 },
                { label: '中国', value: 448 },
                { label: '加拿大', value: 470 },
                { label: '法国', value: 540 },
                { label: '德国', value: 580 },
                { label: '韩国', value: 690 },
                { label: '朝鲜', value: 1100 },
                { label: '美国', value: 1200 },
                { label: '澳大利亚', value: 1380 },
              ]}
            />
          </Grid>
          <Grid item xs={12} md={6} lg={4}>
            <AppCurrentSubject
              title="用户使用语言种类数量"
              chartLabels={['阿拉伯语', '法语', '俄语', '德语', '汉语', '英语']}
              chartData={[
                { name: '1号分店', data: [80, 50, 30, 40, 100, 20] },
                { name: '2号分店', data: [20, 30, 40, 80, 20, 80] },
                { name: '3号分店', data: [44, 76, 78, 13, 43, 10] },
              ]}
              chartColors={[...Array(6)].map(() => theme.palette.text.secondary)}
            />
          </Grid>
          <Grid item xs={12} md={6} lg={8}>
            <AppTasks
              title="任务列表"
              list={[
                { id: '1', label: '创建FireStone徽标' },
                { id: '2', label: '如果需要，添加SCSS和JS文件' },
                { id: '3', label: '利益相关者会议' },
                { id: '4', label: '范围界定和估算' },
                { id: '5', label: 'Sprint展示' },
              ]}
            />
          </Grid>
            <Grid item xs={12} md={6} lg={4}>
            <AppOrderTimeline
                title="订单时间表"
                list={[...Array(5)].map((_, index) => ({
                    id: faker.datatype.uuid(),
                    title: [
                        '1983, 星际和平公司, ￥4220',
                        '12月竣工',
                        '￥37745 九月份已支付',
                        '来自璃月的￥520订单',
                        '来自稻妻的￥3000订单',
                    ][index],
                    type: `order${index + 1}`,
                    time: faker.date.past(),
                }))}
            />
        </Grid>
            <Grid item xs={12} md={6} lg={8}>
            <AppNewsUpdate
                title="新闻更新"
                list={[...Array(5)].map((_, index) => ({
                    id: faker.datatype.uuid(),
                    title: faker.name.jobTitle(),
                    description: faker.name.jobTitle(),
                    image: `/assets/images/covers/cover_${index + 1}.jpg`,
                    postedAt: faker.date.recent(),
                }))}
            />
        </Grid>
        </Grid>
      </Container>
    </>
  );
}
