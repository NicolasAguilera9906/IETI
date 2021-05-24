import React , { useState } from 'react';
import TodoList from './TodoList';
import { Button , TextField , Card , CardContent , Typography , CardActions} from '@material-ui/core';




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
            id: Date.now()
        };
        setText("");
        setItem([...item,newItem])
    }

      return (
        <React.Fragment>
            <Card >
                <CardContent>
                    <Typography color="textSecondary" gutterBottom>
                    TODO
                    </Typography>
                    <TextField 
                        id="input-with-icon-grid" 
                        label="With a grid" 
                        onChange={handleChange}
                        value={text} 
                        color="primary"
                        size = "small"
                    />
                </CardContent>
                <CardActions>
                    <Button 
                    onClick={handleSubmit}
                    variant="contained" 
                    color="primary" 
                    size="large"
                >
                    Submit
                    </Button>
                </CardActions>
            </Card>
            <TodoList todoList={item} />
        </React.Fragment>
      );
  
  }

  export default TodoApp;