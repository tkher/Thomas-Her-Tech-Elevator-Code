<template>
  <div class="book-container">
    <book-card class="books" v-for="book in $store.state.books" :key="book.title"
    v-bind:book="book">
    </book-card>

  </div>
</template>

<script>
/*step 1*/
import BookCard from './BookCard.vue';


export default {
  components: { BookCard }
  
}
</script>

<style>
.book-container {
  display: flex;
  justify-content: space-evenly;
  flex-wrap: wrap;
}
</style>