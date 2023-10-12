
/*Step 1 - setting up page title and task */
const todoList = document.getElementById('todos');

let todos = [];
let pageTitle = '';

function init() {
    pageTitle = 'My Morning Routine';
    todos = [
      { id: 1, task: 'Wake up', completed: false },
      { id: 2, task: 'Brush Teeth', completed: false },
      { id: 3, task: 'Shower', completed: false },
      { id: 4, task: 'Get Dressed', completed: false },
      { id: 5, task: 'Drive to work', completed: false },
      { id: 6, task: 'Work', completed: false },
      { id: 7, task: 'Drive home from work', completed: false },
      { id: 8, task: 'Dinner', completed: false },
      { id: 9, task: 'Brush Teeth', completed: false },
      { id: 10, task: 'Go to bed', completed: false }
    ]
  }

  /*Step 2 - add a page title - adding the h1 element*/

  function addPageTitle() {
      const heading = document.createElement('h1')
      heading.innerText = pageTitle;
      todoList.appendChild(heading);

      
  }
  /* Step 3 - create a new unordered list (ul), get a reference to it and append it to your todo list*/

  function addTodos() {
      const ul = document.createElement('ul');
      todoList.appendChild(ul);

       /* use for each loop to iterate over each todo in the array -  we are adding every item in the tods array as a li item in it the html */
      todos.forEach(todo => {
        const li = document.createElement('li');
        li.innerText = todo.task;
        ul.appendChild(li);
    })
  }

 
 // set up your page title and tasks
init();
// // add page title to the DOM
addPageTitle();
// // add the task to the DOM
addTodos();



