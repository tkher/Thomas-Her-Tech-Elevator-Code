<template>
  <div id="todo-app">
    <todo-list />
    <new-todo />
  </div>
</template>

<script>
import TodoList from './components/TodoList.vue';
import NewTodo from './components/NewTodo.vue';

export default {
  components: {
    TodoList,
    NewTodo
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
