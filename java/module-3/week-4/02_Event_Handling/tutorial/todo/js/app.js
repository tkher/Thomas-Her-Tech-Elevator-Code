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
  ];
}

function addPageTitle() {
  const heading = document.createElement('h1');
  heading.innerText = pageTitle;
  todoList.appendChild(heading);
}

function addTodos() {
  const ul = document.createElement('ul');
  todos.forEach((todo) => {
    const li = document.createElement('li');
    li.innerText = todo.task;
    const checkCircle = document.createElement('i');
    checkCircle.setAttribute('class', 'far fa-check-circle');
    li.appendChild(checkCircle);
    ul.appendChild(li);
  });
  todoList.appendChild(ul);
}

// Step 1 - Add an event listener 
document.addEventListener("DOMContentLoaded", () => {
  init();
  addPageTitle();
  addTodos();  


//step 2 - marking task complete - allowing uses to click on task feature

//  // first get a reference for each of the list items
const tasks = document.querySelectorAll('li');

// // second, loop over every task in the task array and add a click event listener  -- Before you add the completed class, check to make sure that it already isn't completed. 
tasks.forEach((task) => {
  task.addEventListener('click', () => {
    if (!task.classList.contains('completed')) {
      task.classList.add('completed');
      task.querySelector('i').classList.add('completed');
    }
  });
//Step 3 - marking a task incomplete -using double click
task.addEventListener('dblclick', () => {
  if (task.classList.contains('completed')) {
    task.classList.remove('completed');
    task.querySelector('i').classList.remove('completed');
    }
  });
});

//step -4  mark all task as complete 

// start by getting reference to the button and add a 'click" event listener. 
const completeAll = document.getElementById('btnCompleteAll');
completeAll.addEventListener('click', () => {

//loop over earch task and add them to "completed" class to list and complete. 
  tasks.forEach((task) => {
    task.classList.add('completed');
    task.querySelector('i').classList.add('completed');
  });
});



});


