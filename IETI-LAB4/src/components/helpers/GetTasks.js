
import { useState } from 'react';
import fire from '../../fire';


export const GetTasks = async () => {

  const userRef = await fire.database().ref('ietilab4');  
  
  let finalTasks = [];

  const tasks = await userRef.on('value', (snapshot) => {
    snapshot.forEach(data => {
      finalTasks.push({
        description:data.val().description,
        responsible:data.val().responsible,
        status:data.val().status,
        date:data.val().date
      });
    })
  });

  return finalTasks;
}