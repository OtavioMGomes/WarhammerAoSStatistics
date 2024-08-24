import * as React from 'react';
import ListItemButton from '@mui/material/ListItemButton';
import ListItemIcon from '@mui/material/ListItemIcon';
import ListItemText from '@mui/material/ListItemText';
import ListSubheader from '@mui/material/ListSubheader';

// https://github.com/mui/material-ui/tree/v5.16.6/docs/data/material/getting-started/templates/dashboard

export default function NavegationBar(){
  return (
    <React.Fragment>
      <ListSubheader component="div" inset>
        Saved reports
      </ListSubheader>
      <ListItemButton>
        {/* <ListItemIcon>
          <DashboardIcon />
        </ListItemIcon> */}
        <ListItemText primary="Dashboard" />
      </ListItemButton>
      <ListItemButton>
        {/* <ListItemIcon>
          <ShoppingCartIcon />
        </ListItemIcon> */}
        <ListItemText primary="Orders" />
      </ListItemButton>
      <ListItemButton>
        {/* <ListItemIcon>
          <PeopleIcon />
        </ListItemIcon> */}
        <ListItemText primary="Customers" />
      </ListItemButton>
      <ListItemButton>
        {/* <ListItemIcon>
          <BarChartIcon />
        </ListItemIcon> */}
        <ListItemText primary="Reports" />
      </ListItemButton>
      <ListItemButton>
        {/* <ListItemIcon>
          <LayersIcon />
        </ListItemIcon> */}
        <ListItemText primary="Integrations" />
      </ListItemButton>
    </React.Fragment>
  )
};