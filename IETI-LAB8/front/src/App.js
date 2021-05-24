import React, { useState } from 'react'
import Login from './components/Login';
import './index.css';
import {BrowserRouter as Router, Link, Route} from 'react-router-dom';
import Swal from 'sweetalert2';
import DrawerComponent from './components/DrawerComponent';
import { NewTask } from './components/NewTask';

export const App = () => {


    const [isLoggedIn, setisLoggedIn] = useState(localStorage.getItem("isLoggedIn"));

    const setLogIn = (logged) => {
        Swal.fire({
            title: 'Successful login!',
            text: 'Continue',
            icon: 'success',
            confirmButtonText: 'Cool'
        });
        localStorage.setItem('isLoggedIn',logged);
        setisLoggedIn(logged);
    }

    const LoginView = () => (
        <Login setLogIn={setLogIn}/>
    );
    const TodoAppView = () => (
        <DrawerComponent></DrawerComponent> 
    );

    const AddTaskView = () => (
        <NewTask></NewTask> 
    );

    return (
        <div>
        <Router>
            <div className="App">
                <ul>
                    <li><Link to="/">Login</Link></li>
                    <li><Link to="/todo">Todo</Link></li>
                </ul>
                <div>
                    <Route exact path="/" component={isLoggedIn ? TodoAppView:LoginView}/>
                    <Route path="/todo" component={isLoggedIn ? TodoAppView:LoginView}/>
                    <Route path="/addTask" component={isLoggedIn ? NewTask:LoginView}></Route>
                </div>
            </div>
        </Router>
    </div>
    
    );
}

export default App;