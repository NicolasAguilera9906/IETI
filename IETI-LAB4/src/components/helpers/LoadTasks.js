import { useState , useEffect } from 'react';
import {GetTasks} from './GetTasks';


export const LoadTasks = () =>{

    const [tasks, setTasks] = useState({
        data:[],
        loading:true
    });

    useEffect ( () => {
        GetTasks()
        .then(tasks =>{
            setTasks({
                data:tasks,
                loading:false
            })
        })
    } , [])

    return tasks;
}