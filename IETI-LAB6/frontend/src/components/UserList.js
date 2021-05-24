import React from 'react'
import { useFetchUsers } from '../Hooks/useFetchUsers'
import {UserCard} from './UserCard'
export const UserList = () => {

    const {data:users,loading} = useFetchUsers();

    return (
        <>
        <h3 className="animate__animated animate__fadeIn"> {} </h3>

        {loading && <p className="animate__animated animate__flash">Loading</p>}

        <div className="card-grid">
                {
                    users.map(  user=> 
                    <UserCard 
                        key={ user.id } 
                        {... user}
                    />
                    )
                }
            </div>
        </>
    )
}
