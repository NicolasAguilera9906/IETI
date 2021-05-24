module.exports = async function (context, req) {
    context.log('Adding a task to the planner');

    const task = req.body;
    const { v4: uuidv4 } = require('uuid');
    const description=task.description;
    const dueDate=task.dueDate;
    const state=task.state;
    const id= uuidv4();
    const responsible=task.responsible;
    const responseMessage = {id:id,description:description,dueDate:dueDate
        ,state:state,responsible:responsible};

    context.res = {
        status: 201,
        body: responseMessage
    };
}