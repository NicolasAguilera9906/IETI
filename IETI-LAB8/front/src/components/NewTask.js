import React, { useState } from "react";
import DateFnsUtils from '@date-io/date-fns';
import { MuiPickersUtilsProvider, KeyboardDatePicker } from "@material-ui/pickers";
import { Button, FormControlLabel, FormLabel, Grid, makeStyles, Radio, RadioGroup, TextField } from '@material-ui/core';
import Swal from 'sweetalert2';
import axios from 'axios';
import Moment from 'moment';




const useStyles = makeStyles((theme) => ({
    root: {
        '& .MuiTextField-root': {
            margin: theme.spacing(1),
            width: 200,
        },
    },
}));

export const NewTask = () => {


    const addTask = (task) => {
        task.date = task.date.toString();
        axios.post("http://localhost:8080/api/tasks", task, {
            headers: {
                Authorization: "Bearer " + localStorage.getItem("Authorization"),
            }
        })
        .then(response => {
            Swal.fire({
                title: 'Task added',
                text: 'Continue',
                icon: 'success',
                confirmButtonText: 'Cool'
            });
        })
        .catch(error => {
            alert("Error connecting to DB");
        })
    }


    const validateTokenAndAddTask = (task) => {
        axios.get("http://localhost:8080/api/security/login", {
            headers: {
                Authorization: "Bearer " + localStorage.getItem("Authorization"),
            }
        })
            .then(response => {
                addTask(task);
            })
            .catch(error => {
                alert("Invalid token");
                localStorage.setItem("Authorization", "");
                localStorage.setItem("isLoggedIn", "");
                window.location.reload(false);
            })
    }

    const classes = useStyles();

    const [selectedDate, setSelectedDate] = useState(new Date('2014-08-18T21:11:54'));
    const [taskDate, setTaskDate] = useState(Moment(new Date('2014-08-18T21:11:54')).format("YYYY-MM-DD"));
    const [status, setStatus] = useState("");
    const [Description, setDescription] = useState("");
    const [Responsible, setResponsible] = useState("");


    const handleStatusChange = (e) => {
        setStatus(e.target.value)

    }

    const handleDescriptionChange = (e) => {
        setDescription(e.target.value)
    }

    const handleResponsibleChange = (e) => {
        setResponsible(e.target.value)
    }

    const handleDateChange = (date) => {
        setTaskDate(Moment(new Date(date)).format("YYYY-MM-DD"));
        setSelectedDate(Moment(new Date(date)).format("YYYY/MM/DD"));
    };

    const handleReturn = () => {
        window.location.href = '/todo';
    }

    const handleSubmit = () => {

        let task = {
            description: Description,
            responsible: {
                email: null,
                password: null,
                firstname: Responsible,
                lastname: null
            },
            state: status,
            date: taskDate
        }
        validateTokenAndAddTask(task);

    }

    return (
        <form className={classes.root} noValidate autoComplete="off" align="center">
            <Grid>
                <div>
                    <h1>New Task</h1>
                </div>
                <br></br>
                <div>
                    <TextField
                        label="Description"
                        id="description"
                        size="small"
                        onChange={handleDescriptionChange}
                    />
                </div>
                <br></br>
                <div>
                    <TextField
                        label="Responsible"
                        id="responsible"
                        size="small"
                        onChange={handleResponsibleChange}
                    />
                </div>
                <br></br>
                <div>
                    <FormLabel component="legend">Status</FormLabel>
                    <RadioGroup aria-label="gender" name="gender" name="status"
                        style={{ display: 'initial' }}
                        onChange={handleStatusChange}
                    >
                        <FormControlLabel value="Ready" control={<Radio />} label="Ready" />
                        <FormControlLabel value="In progress" control={<Radio />} label="In progress" />
                        <FormControlLabel value="Done" control={<Radio />} label="Done" />
                    </RadioGroup>
                </div>
                <br></br>
                <div>
                    <MuiPickersUtilsProvider utils={DateFnsUtils}>
                        <KeyboardDatePicker
                            fullWidth
                            format="MM/dd/yyyy"
                            margin="normal"
                            id="date-picker-dialog"
                            label="Date picker dialog"
                            value={selectedDate}
                            onChange={handleDateChange}
                            KeyboardButtonProps={{
                                'aria-label': 'change date',
                            }}
                        />
                    </MuiPickersUtilsProvider>
                </div>
                <br></br>
                <div>
                    <Button variant="outlined" color="primary" href="#outlined-buttons" onClick={handleSubmit}>
                        Submit
                    </Button>
                    <br></br>
                    <br></br>
                    <Button variant="outlined" color="secondary" href="#outlined-buttons" onClick={handleReturn}>
                        Return
                    </Button>
                </div>
            </Grid>
        </form>
    );
}
