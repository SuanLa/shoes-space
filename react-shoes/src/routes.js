// Router.js
import { Navigate, useRoutes } from 'react-router-dom';
// layouts
import DashboardLayout from './layouts/dashboard';
import SimpleLayout from './layouts/simple';
import LoginPage from './pages/LoginPage';
import Page404 from './pages/Page404';
import ProductsPage from './pages/ProductsPage';
import ConcreteProduct from './pages/ConcreteProduct';
import CartPage from "./pages/Cart";
import UserPage from "./pages/UserPage";
import DashboardAppPage from "./pages/DashboardAppPage";
import ProductsPage2 from "./pages/ProductsPage2";
import Order from "./pages/Order";

// ----------------------------------------------------------------------
export default function Router() {
    const routes = useRoutes([
        {
            path: '/dashboard',
            element: <DashboardLayout />,
            children: [
                { element: <Navigate to="products" replace /> },
                {path:'app', element: <DashboardAppPage />},
                {path:'user',element: <UserPage />},
                { path: 'products', element: <ProductsPage /> },
                { path: 'products2', element: <ProductsPage2 /> },
                { path: 'order', element: <Order />},
                { path: 'show', element: <ConcreteProduct /> },
                { path: 'cart',element: <CartPage/>},
                { path: '*', element: <Navigate to="/dashboard/products" replace /> }
            ],
        },
        {
            path: 'login',
            element: <LoginPage />,
        },
        {
            element: <SimpleLayout />,
            children: [
                { path: '/', element: <Navigate to="/dashboard/products" replace /> },
                { path: '404', element: <Page404 /> },
                { path: '*', element: <Navigate to="/404" replace /> },
            ],
        },
        {
            path: '*',
            element: <Page404 />,
        },
    ]);

    return routes;
}



/** *
export default function Router() {
  const routes = useRoutes([
    {
      path: '/dashboard',
      element: <DashboardLayout />,
      children: [
        { element: <Navigate to="/dashboard/products" />, index: true },
        { path: 'app', element: <DashboardAppPage /> },
        { path: 'user', element: <UserPage /> },
        { path: 'products', element: <ProductsPage /> },
        { path: 'cart',element: <CartPage/>},
        { path: 'show',element: <ConcreteProduct/>}
      ],
    },
    {
      path: 'login',
      element: <LoginPage />,
    },
    {
      element: <SimpleLayout />,
      children: [
        { element: <Navigate to="/dashboard/products" />, index: true },
        { path: '404', element: <Page404 /> },
        { path: '*', element: <Navigate to="/404" /> },
      ],
    },
    {
      path: '*',
      element: <Navigate to="/404" replace />,
    },
  ]);

  return routes;
}
* * */