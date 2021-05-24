import React from 'react';
import Todo from './Todo';

const TodoList = ({todoList}) =>{  
    
return (
    <>
        <ul>
            {
                todoList.map((item) => 
                <li key = {item.text}>
                <Todo
                    content = {JSON.stringify(item)}
                />
                </li>
                )
            }
        </ul>
    </>
);
}

export default TodoList;