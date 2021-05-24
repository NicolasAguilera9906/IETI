import React from 'react'
import { TaskCard } from './TaskCard';

export const TaskLists = (props) => {


    return (
       
            <div className="user-details">
            {console.log("hola")}
            {props.tasks.map(task => (
                <TaskCard key={task.id} task={task} />
            ))}
        </div>
            
        
    )
}