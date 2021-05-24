import React from 'react';
import './index.css';
import {BrowserRouter as Router, Link, Route} from 'react-router-dom';
import DrawerComponent from './components/DrawerComponent';
import { NewTask } from './components/NewTask';

export const App = () => {


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
                    <Route exact path="/" component={TodoAppView}/>
                    <Route path="/todo" component={TodoAppView}/>
                    <Route path="/addTask" component={AddTaskView}></Route>
                </div>
            </div>
        </Router>
    </div>
    
    );
}

export default App;