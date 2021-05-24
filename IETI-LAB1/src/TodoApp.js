import React , { useState } from 'react';
import TodoList from './TodoList';



const TodoApp = ({props}) =>{ 

    const [item, setItem] = useState([])
    const [text, setText] = useState("")
      
    const handleChange = (e) => {
        setText(e.target.value);
    }

    const handleSubmit = (e) =>{
        e.preventDefault();
        const newItem = {
            text: {text},
            id: new Date()
        };
        setText("");
        setItem([...item,newItem])
    }

      return (
        <>
          <h3>TODO</h3>
          <TodoList todoList={item} />
          <form onSubmit={handleSubmit}>
            <label htmlFor="new-todo">
              What needs to be done?
            </label>
            <input
              id="new-todo"
              onChange={handleChange}
              value={text}
            />
            <button>
              Add #{item.length + 1}
            </button>
          </form>
        </>
      );
  
  }

  export default TodoApp;