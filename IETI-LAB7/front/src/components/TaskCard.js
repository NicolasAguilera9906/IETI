import React from 'react';
import { makeStyles } from '@material-ui/core';
import Card from '@material-ui/core/Card';
import CardHeader from '@material-ui/core/CardHeader';
import CardContent from '@material-ui/core/CardContent';
import CardActions from '@material-ui/core/CardActions';
import Avatar from '@material-ui/core/Avatar';
import IconButton from '@material-ui/core/IconButton';
import Typography from '@material-ui/core/Typography';

import MoreVertIcon from '@material-ui/icons/MoreVert';



const useStyles = makeStyles((theme) => ({
    media: {
        height: 0,
        paddingTop: '56.25%', // 16:9
    },
    expand: {
        transform: 'rotate(0deg)',
        marginLeft: 'auto',
        transition: theme.transitions.create('transform', {
            duration: theme.transitions.duration.shortest,
        }),
    },
    expandOpen: {
        transform: 'rotate(180deg)',
    }
}));



export const TaskCard = (props) => {

    const classes = useStyles();


    return (
        <div>
            {console.log(props)}
            <Card className={classes.root}>
                <CardHeader
                    title={"Name: "+props.task.responsible.name}
                />
                <CardContent>
                    <Typography variant="body2">
                        {"Description: "+props.task.text}
                    </Typography>
                    <Typography variant="body2">
                        {"Status: "+ props.task.state}
                    </Typography>
                    <Typography variant="body2">
                        {"Due date: "+props.task.dueDate}
                        {console.log("YA")}
                    </Typography>
                    
                </CardContent>
                <CardActions disableSpacing>
                </CardActions>
            </Card>
        </div>
    );
}