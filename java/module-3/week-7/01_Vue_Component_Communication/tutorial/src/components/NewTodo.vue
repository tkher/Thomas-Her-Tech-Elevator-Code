<template>
  <section class="new-todo">
    <form v-on:submit.prevent="saveTodo"> <!-- the "v-on:submit.prevent="saveTodo", configures the form to call the 'saveTodo" method. 
                                                  (submit.prevent - submit event will no longer reload the page) -->
      <input type="text" name="input-name" placeholder="Name" v-model="newTodo.name">
      <select name="select-category" v-model="newTodo.category">
        <option value="" disabled>--- Select a category ---</option>
        <option value="Home">Home</option>
        <option value="Work">Work</option>
      </select>
      <button>Add</button>
    </form>
  </section>
</template>

<script>
export default {
  data() {
    return {
      newTodo: {}
    }
  },
  methods: {
    /*after the new Todo has been mutated to the state, this method gives a 'false/done' status 
    and "commits it" to the datastore - this allows the data to be cleared for the next todo*/
    saveTodo() {
      this.newTodo.done = false;
      this.$store.commit('ADD_NEW_TODO', this.newTodo);
      this.newTodo = {};
    }
  }
}
</script>



<style>
.new-todo {
  width:450px;
  background: #fff;
  margin: auto;
  font-family: 'Roboto Condensed', sans-serif;
  border-radius: 10px;
}
input, select, button {
  padding: 5px 5px;
  margin: 5px;
}
</style>