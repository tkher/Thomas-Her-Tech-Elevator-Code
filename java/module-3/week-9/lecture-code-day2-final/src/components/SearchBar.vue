<template >
  <div id="search-box">
    <input type="text" name="search-tb" 
           id="search-tb" placeholder="Search..."
           v-on:keyup="onKeyUp">
    <button class="icon-button" id="search-button">
      <font-awesome-icon class="icon" icon="fa-solid fa-magnifying-glass" />
    </button>
  </div>
</template>

<script>
export default {
  methods: {
    onKeyUp(event){
      // Change the array of bookmarks available
      const searchTerm = event.target.value;
      this.$store.commit('SET_SEARCH_TERM', searchTerm);
    }
  }
}
</script>
<style scoped>
/* Search Box Styles */
#search-box {
  display: inline-block;
  border: 1px solid darkgray;
  border-radius: 10px;
}

#search-tb {
  border: none;
  padding: 5px;
  min-width: 200px;
  background-color: transparent;
}

#search-tb:focus-visible {
  outline: none;
}

#search-button {
  color: gray;
}
/* END Search Box Styles */
</style>