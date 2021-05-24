import React from 'react';
import Todo from './Todo';

const TodoList = ({todoList}) =>{  
    
return (
    <React.Fragment>
        <ul>
            {
                todoList.map((item) => 
                <li key = {item.id}>
                <Todo
                    content = {JSON.stringify(item)}
                />
                </li>
                )
            }
        </ul>
    </React.Fragment>
);
}

export default TodoList;