import * as React from 'react';
import './Style/Navegation.css';
import Box from '@mui/material/Box';
import Drawer from '@mui/material/Drawer';
import CssBaseline from '@mui/material/CssBaseline';
import Toolbar from '@mui/material/Toolbar';
import List from '@mui/material/List';
import Divider from '@mui/material/Divider';
import ListItem from '@mui/material/ListItem';
import ListItemButton from '@mui/material/ListItemButton';
import ListItemIcon from '@mui/material/ListItemIcon';
import ListItemText from '@mui/material/ListItemText';
import ExpandLess from '@mui/icons-material/ExpandLess';
import ExpandMore from '@mui/icons-material/ExpandMore';
import MilitaryTechIcon from '@mui/icons-material/MilitaryTech';
import BarChartIcon from '@mui/icons-material/BarChart';
import GroupsIcon from '@mui/icons-material/Groups';
import FortIcon from '@mui/icons-material/Fort';
import Collapse from '@mui/material/Collapse';

const drawerWidth = 250;

const drawerMainMap = new Map([
  ['Factions Overview', <MilitaryTechIcon/>],
  ['Unit Statistics', <BarChartIcon/>],
  ['Battle Simulation', <FortIcon/>],
  ['My Armies', <GroupsIcon/>]
]);

let drawerMainList = Array.from(drawerMainMap.keys());

const factionsList = ['Chaos', 'Death', 'Destruction',  'Order', 'Compare Factions']


export default function NavDrawer() {

  const [open, setOpen] = React.useState(false);

  const handleClick = () => {
    setOpen(!open);
  };

  function createListItem(text){
    return (
      <ListItem key={text} disablePadding>
        <ListItemButton>
          <ListItemIcon> {drawerMainMap.get(text)} </ListItemIcon>
          <ListItemText primary={text} />
        </ListItemButton>
      </ListItem>
    )
  }
  
  function createCollapsedListItem(text, subList){
    return (
      <Box >
        <ListItemButton onClick={handleClick}>
          <ListItemIcon> {drawerMainMap.get(text)} </ListItemIcon>
          <ListItemText primary={text} />
          {open ? <ExpandLess /> : <ExpandMore />}
        </ListItemButton>
        <Collapse in={open} timeout="auto" unmountOnExit>
          <List component="div" disablePadding>{
            subList.map((subText, subIndex) => (
              <ListItemButton key={subText} sx={{ pl: 11 }}>
                <ListItemText primary={subText} />
              </ListItemButton>
            ))
          }</List>
        </Collapse>
      </Box >
    )
  }

  return (
    <Box sx={{ display: 'flex'}}>
      <CssBaseline/>

      <Drawer
        variant="permanent"
        sx={{
          display: 'block',
          width: drawerWidth,
          flexShrink: 0,
          [`& .MuiDrawer-paper`]: { width: drawerWidth, boxSizing: 'border-box' },
        }}
      >
      <Toolbar variant="dense"/>
      <Box sx={{ overflow: 'auto' }}>

        <List>{
          drawerMainList.map((text, index) => (
            index === 0 ? createCollapsedListItem(text, factionsList) : createListItem(text)
          ))
        }</List>

        <Divider />

      </Box>

    </Drawer>

    </Box>
  );
}