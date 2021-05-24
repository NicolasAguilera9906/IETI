import { useState , useEffect } from 'react'
import { getUsers } from '../helpers/getUsers'

export const useFetchUsers = () =>{

    const [state, setState] = useState({
        data:[],
        loading:true
    });
    
    useEffect ( () => {
        getUsers()
        .then(users => {
            setState({
                data:users,
                loading:false
            })
        })
    } , [])

    return state;

}