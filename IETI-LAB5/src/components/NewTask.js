import React, { useState } from "react";
import DateFnsUtils from '@date-io/date-fns';
import { MuiPickersUtilsProvider, KeyboardDatePicker } from "@material-ui/pickers";
import { Button, FormControlLabel, FormLabel, Grid, makeStyles, Radio, RadioGroup, TextField } from '@material-ui/core';
import fire from '../fire';
import Swal from 'sweetalert2';


const useStyles = makeStyles((theme) => ({
    root: {
        '& .MuiTextField-root': {
            margin: theme.spacing(1),
            width: 200,
        },
    },
}));

export const NewTask = () => {


    const classes = useStyles();

    const [selectedDate, setSelectedDate] = useState(new Date('2014-08-18T21:11:54'));
    const [status, setStatus] = useState("");
    const [Description, setDescription] = useState("");
    const [Responsible, setResponsible] = useState("");


    const handleStatusChange = (e) => {
        setStatus(e.target.value)

    }

    const handleDescriptionChange = (e) => {
        setDescription(e.target.value)
        console.log(Description);
    }

    const handleResponsibleChange = (e) => {
        setResponsible(e.target.value)
        console.log(Responsible);
    }

    const handleDateChange = (date) => {
        setSelectedDate(date);
        console.log(date);
    };

    const handleReturn = () => {
        window.location.href = '/todo';
    }

    const handleSubmit = () => {

        Swal.fire({
            title: 'Task added',
            text: 'Continue',
            icon: 'success',
            confirmButtonText: 'Cool'
          });

        let task = {
            description : Description,
            responsible : Responsible,
            status : status,
            date : JSON.stringify(selectedDate)
        }

        fire.database().ref('ietilab4').orderByKey().limitToLast(100);
        fire.database().ref('ietilab4').push(task);

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
