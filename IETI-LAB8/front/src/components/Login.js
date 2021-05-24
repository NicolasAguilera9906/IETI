import React, { useState } from 'react';
import Avatar from '@material-ui/core/Avatar';
import Button from '@material-ui/core/Button';
import CssBaseline from '@material-ui/core/CssBaseline';
import FormControl from '@material-ui/core/FormControl';
import Input from '@material-ui/core/Input';
import InputLabel from '@material-ui/core/InputLabel';
import LockIcon from '@material-ui/icons/LockOutlined';
import Paper from '@material-ui/core/Paper';
import Typography from '@material-ui/core/Typography';
import './Login.css';
import axios from 'axios';
import Swal from 'sweetalert2';


const Login = ({setLogIn}) => {

    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");

    const handlePasswordChange = (e) =>{
        setPassword(e.target.value)
    }

    const handleUsernameChange = (e) =>{
        setUsername(e.target.value)
    }


    const handleSubmit = (e) => {
        e.preventDefault();
        axios.post('http://localhost:8080/user/login', {
             email: username,
             password: password
         })
             .then(function (response) {
                 localStorage.setItem('Authorization', response.data.accessToken);
                 setUsername("");
                 setPassword("");
                 setLogIn(true);
             })
             .catch(function (error) {
                 console.log(error.response);
                 Swal.fire({
                    title: error.response.data,
                    text: 'Continue',
                    icon: 'error',
                    confirmButtonText: 'Cool'
                  });
             });
    }

    return (
        <React.Fragment>
                <CssBaseline />
                <main className="layout">
                    <Paper className="paper">
                        <Avatar className="avatar">
                            <LockIcon />
                        </Avatar>
                        <Typography variant="h2">Sign in</Typography>
                        <form className="form">
                            <FormControl margin="normal" required fullWidth>
                                <InputLabel htmlFor="email">Email Address</InputLabel>
                                <Input id="email" name="email" autoComplete="email" autoFocus onChange={handleUsernameChange} />
                            </FormControl>
                            <FormControl margin="normal" required fullWidth>
                                <InputLabel htmlFor="password">Password</InputLabel>
                                <Input
                                    name="password"
                                    type="password"
                                    id="password"
                                    autoComplete="current-password"
                                    onChange={handlePasswordChange}
                                />
                            </FormControl>
                            <Button
                                type="submit"
                                fullWidth
                                variant="contained"
                                color="primary"
                                className="submit"
                                onClick = {handleSubmit}
                            >
                                Sign in
                            </Button>
                        </form>
                    </Paper>
                </main>
            </React.Fragment>
      );
}

export default Login;