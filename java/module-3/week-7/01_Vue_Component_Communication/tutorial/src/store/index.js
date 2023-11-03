/*This is the main vuex data store that will hold all data for the components*/

import { createStore as _createStore } from 'vuex';

export function createStore() {
  return _createStore({
    state: {
      todos: [
        { name: 'Wake up', done: false, category: 'Home' },
        { name: '5 Minute Morning Movement', done: false, category: 'Home' },
        { name: 'Meditate', done: false, category: 'Home' },
        { name: 'Brush teeth', done: false, category: 'Home' },
        { name: 'Shower', done: false, category: 'Home' },
        { name: 'Answer email', done: false, category: 'Work' },
        { name: 'Stand up meeting', done: false, category: 'Work' },
        { name: 'Fix a bug', done: false, category: 'Work' },
      ]
    },
    /*Step 3- This allows us the 2-way binding between the Newtodo component, 
    and storing in the vuex datastore*/
    mutations: {
      ADD_NEW_TODO(state, todo) {
        state.todos.push(todo);
      },
      /* the Add_new_todo take the new todo passed in by the component, 
      and pushes it to the State(data) array. */
      FLIP_DONE(state, todo) {
        todo.done = ! todo.done;
      }
    },
    actions: {},
    modules: {},
    // Strict should not be used in production code. It is used here as a
    // learning aid to warn you if state is modified without using a mutation.
    strict: true
  })
}
