module.exports = async function (context, req) {
    const { v4: uuidv4 } = require('uuid');


    const task1={id:uuidv4(),text:"Test task 1",dueDate:new Date(),state: "Active",
                    responsible:{name:"Test User 1",email:"test@mail.com"}}
    const task2={id:uuidv4(),text:"Test task 2",dueDate:new Date(),state: "Active",
                    responsible:{name:"Test User 2",email:"test2@mail.com"}}
                    
    const tasks=[task1,task2]
    const responseMessage = { tasks: tasks};

    context.res = {
        status: 200,
        body: responseMessage
    };
}