import React from 'react'
import ReactDOM from 'react-dom'
import TodoList from './TodoList'
import './index.css';

const todos = [{text:"Learn React", priority:5, dueDate: new Date() },
          {text:"Learn about APIs", priority:4, dueDate: new Date(2020,1,23) },
          {text:"write TODO App", priority:3, dueDate: new Date(2020,1,30) }];

ReactDOM.render(<TodoList todoList = {todos}/> , document.querySelector('#root'));


