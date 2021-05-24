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
            {console.log("llegué")}
            <Card className={classes.root}>
                <CardHeader
                    title={"Name: "+props.task.responsible}
                />
                <CardContent>
                    <Typography variant="body2">
                        {"Description: "+props.task.description}
                    </Typography>
                    <Typography variant="body2">
                        {"Status: "+ props.task.status}
                    </Typography>
                    <Typography variant="body2">
                        {"Due date: "+props.task.date}
                        {console.log("YA")}
                    </Typography>
                    
                </CardContent>
                <CardActions disableSpacing>
                </CardActions>
            </Card>
        </div>
    );
}