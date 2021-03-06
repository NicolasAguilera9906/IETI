import React from 'react';
import { makeStyles } from '@material-ui/core/styles';
import Card from '@material-ui/core/Card';
import CardContent from '@material-ui/core/CardContent';
import Typography from '@material-ui/core/Typography';

const useStyles = makeStyles({
    root: {
      minWidth: 275,
    },
    bullet: {
      display: 'inline-block',
      margin: '0 2px',
      transform: 'scale(0.8)',
    },
    title: {
      fontSize: 14,
    },
    pos: {
      marginBottom: 12,
    },
  });
  
  export const UserCard = ({name,email,password}) => {
    const classes = useStyles();
  
    return (
      <Card className={classes.root}>
        <CardContent>
          <Typography variant="h5" component="h2">
              {"name: "+name}
          </Typography>
          <Typography variant="h5" component="h2">
              {"email: "+email}
          </Typography>
          <Typography variant="h5" component="h2">
              {"password: "+password}
          </Typography>
        </CardContent>
      </Card>
    );
  }
  