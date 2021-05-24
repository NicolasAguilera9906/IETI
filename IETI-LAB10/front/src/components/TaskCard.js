import React, { useEffect, useState } from 'react';
import { Avatar, Button, CardMedia, Link, makeStyles } from '@material-ui/core';
import Card from '@material-ui/core/Card';
import CardHeader from '@material-ui/core/CardHeader';
import CardContent from '@material-ui/core/CardContent';
import CardActions from '@material-ui/core/CardActions';
import Typography from '@material-ui/core/Typography';
import axios from 'axios';







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

    const [image, setImage] = useState({})


    const classes = useStyles();




    return (
        <div>
            <Card className={classes.root}>
                <CardHeader
                    title={"Description: " + props.task.description}
                />
                <CardContent>
                    {props.task.fileUrl.endsWith(".pdf") ?
                        <Button
                            color="primary"
                            startIcon={<Avatar src={'https://upload.wikimedia.org/wikipedia/commons/thumb/8/87/PDF_file_icon.svg/833px-PDF_file_icon.svg.png'} />}
                            onClick={(e) => {
                                e.preventDefault();
                                window.location.href = `${props.task.fileUrl}`;
                            }}
                        >
                            Download
                        </Button>
                        :
                        <CardMedia
                            className={classes.media}
                            image={props.task.fileUrl}
                        />

                    }
                    <Typography variant="body2">
                        {"Name: " + props.task.responsible.firstname}
                    </Typography>
                    <Typography variant="body2">
                        {"Status: " + props.task.status}
                    </Typography>
                    <Typography variant="body2">
                        {"Due date: " + props.task.dueDate}
                    </Typography>

                </CardContent>
                <CardActions disableSpacing>
                </CardActions>
            </Card>
        </div>
    );
}