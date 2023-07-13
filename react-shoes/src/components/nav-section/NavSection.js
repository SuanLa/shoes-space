
import { NavLink as RouterLink } from 'react-router-dom'; // 导入NavLink组件

// @mui
import { Box, List, ListItemText } from '@mui/material';
//
import PropTypes from 'prop-types'; // 更新PropTypes的导入声明
import { StyledNavItem, StyledNavItemIcon } from './styles';


// ----------------------------------------------------------------------

NavSection.propTypes = {
  data: PropTypes.array,
};

export default function NavSection({ data = [], ...other }) {
  return (
    <Box {...other}>
      <List disablePadding sx={{ p: 1 }}>
        {data.map((item) => (
          <NavItem key={item.title} item={item} />
        ))}
      </List>
    </Box>
  );
}

// ----------------------------------------------------------------------

NavItem.propTypes = {
  item: PropTypes.object,
};

function NavItem({ item }) {
  const { title, path, icon, info } = item;

  return (
      <StyledNavItem
          component={RouterLink} // 使用RouterLink组件
          to={path} // 使用path作为to属性
          sx={{
              '&.active': {
                  color: 'text.primary',
                  bgcolor: 'action.selected',
                  fontWeight: 'fontWeightBold',
              },
          }}
      >

      <StyledNavItemIcon>{icon && icon}</StyledNavItemIcon>

      <ListItemText disableTypography primary={title} />

      {info && info}
    </StyledNavItem>
  );
}
