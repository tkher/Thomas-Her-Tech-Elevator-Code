<template>
  <div id="todo-app">
    <todo-summary />
    <todo-list />
    <new-todo /> <!-- new component must be added here as well-->
  
  </div>
</template>

<script> /*here is were we load the componets into the main app*/
import TodoList from './components/TodoList.vue';
import NewTodo from './components/NewTodo.vue';
import TodoSummary from './components/TodoSummary.vue';

export default {
  components: {
    TodoList,
    NewTodo,
    TodoSummary
  }
}
</script>

<style>
#todo-app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
