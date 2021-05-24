import React,{useState} from 'react';
import { makeStyles } from '@material-ui/core/styles';
import Drawer from '@material-ui/core/Drawer';
import AppBar from '@material-ui/core/AppBar';
import CssBaseline from '@material-ui/core/CssBaseline';
import Toolbar from '@material-ui/core/Toolbar';
import List from '@material-ui/core/List';
import Typography from '@material-ui/core/Typography';
import Divider from '@material-ui/core/Divider';
import ListItem from '@material-ui/core/ListItem';
import ListItemIcon from '@material-ui/core/ListItemIcon';
import ListItemText from '@material-ui/core/ListItemText';
import MailIcon from '@material-ui/icons/Mail';
import { ExitToApp } from '@material-ui/icons';
import { TaskLists } from './TaskLists';
import { Fab } from '@material-ui/core';
import AddIcon from '@material-ui/icons/Add';
import {LoadTasks} from './helpers/LoadTasks';








const drawerWidth = 240;

const useStyles = makeStyles((theme) => ({
  root: {
    display: 'flex',
  },
  appBar: {
    zIndex: theme.zIndex.drawer + 1,
  },
  drawer: {
    width: drawerWidth,
    flexShrink: 0,
  },
  drawerPaper: {
    width: drawerWidth,
  },
  drawerContainer: {
    overflow: 'auto',
  },
  content: {
    flexGrow: 1,
    padding: theme.spacing(3),
  },
  fab: {
    position: 'absolute',
    bottom: theme.spacing(2),
    right: theme.spacing(2),
  },
}));



export default function DrawerComponent() {

  const classes = useStyles();
  

  const fab = {
    color: 'primary',
    className: classes.fab,
    icon: <AddIcon />,
    label: 'Add',
  };

  const {data:tasks,loading} = LoadTasks();

    const redirectAddTaskPage = ()=>{
      window.location.href = '/addTask';
    }


  
  const handleSubmit = (e) =>{
      e.preventDefault();
      localStorage.removeItem("username");
      localStorage.removeItem("password");
      localStorage.removeItem("isLoggedIn");
      window.location.href = '/'
  }

  return (
    <div className={classes.root}>
      <CssBaseline />
      <AppBar position="fixed" className={classes.appBar}>
        <Toolbar>
          <Typography variant="h6" noWrap>
            Clipped drawer
          </Typography>
        </Toolbar>
      </AppBar>
      <Drawer
        className={classes.drawer}
        variant="permanent"
        classes={{
          paper: classes.drawerPaper,
        }}
      >
        <Toolbar />
        <div className={classes.drawerContainer}>
          <List>
              <ListItem button key="Profile">
                <ListItemIcon>{<MailIcon />}</ListItemIcon>
                <ListItemText primary="Profile" />
              </ListItem>
              <ListItem button key="Log Out" onClick = {handleSubmit}>
                <ListItemIcon>{<ExitToApp/>}</ListItemIcon>
                <ListItemText primary="Log Out" />
              </ListItem>
          </List>
          <Divider />
        </div>
      </Drawer>
      <main className={classes.content}>
        <h1>TASK LIST</h1><h3>(wait a moment while it loads from firebase database)</h3>
        <TaskLists tasks={tasks}></TaskLists>
        {console.log(tasks)};
      </main>
      <Fab aria-label={fab.label} className={fab.className} color={fab.color} onClick={redirectAddTaskPage}>
            {fab.icon}
          </Fab>
    </div>
  );
}
