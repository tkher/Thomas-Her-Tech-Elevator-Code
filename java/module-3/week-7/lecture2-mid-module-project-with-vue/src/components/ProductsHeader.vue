<template>
  <div id="heading-line">
    <h1>Products</h1>
    <!-- Search box -->
    <div id="search-box">
      <input type="text" name="search-tb" id="search-tb" placeholder="Search..." />
      <button class="icon-button" id="search-button" v-on:click="tryEmit" tabindex="-1">
        <font-awesome-icon class="icon action" icon="fa-solid fa-magnifying-glass" />
      </button>
    </div>
  </div>
  <p>
    Welcome to the Solar System Geeks online store! Buy something for yourself,<br />
    and something for a friend!
  </p>
</template>

<script>
export default {
  data() {
    return {
      
    }
  },
  methods: {
    // TODO: search
  }
};
</script>

<style scoped>
#heading-line {
    display: flex;
    flex-direction: row;
    justify-content: space-between;
    align-items: flex-start;
}

h1 {
    font-size: 1.5rem;
    margin-block-start: 0;
    margin-block-end: 0;
    margin-bottom: 0.5em;
}

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
    cursor: pointer;
    background-color: transparent;
    border: none;
}

/* // TODO: */
@media only screen and (max-width: 425px) {

  #heading-line {
    flex-direction: column;
    align-items: center;
  }

}
</style>