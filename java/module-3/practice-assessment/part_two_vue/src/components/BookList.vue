<template>
  <div id="card-container">
    <book-card v-for="book of bookList" v-bind:key="book.id" v-bind:book="book">
      {{JSON.stringify(book)}}
    </book-card>
  </div>
</template>

<script>
import BookCard from './BookCard.vue'

export default {
  props: ['bookList'],
  components: {BookCard}
}
</script>

<style scoped>
#card-container {
  display: flex;
  flex-wrap: wrap;
  gap: 1rem;
  justify-content: space-around;
}
</style>