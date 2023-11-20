<template>
  <div id="message-bar" 
       v-bind:class="{'message-text': $store.state.descriptionMessage}"
       v-on:click="onMessageTextClick">
    <p>{{ $store.state.descriptionMessage }}</p>
  </div>
</template>

<script>

export default {
  methods: {
    onMessageTextClick(){
      this.$store.commit('SET_DESCRIPTION_MESSAGE', '');
    }
  }
}
</script>
<style scoped>
/* Message bar Styles */
#message-bar {
  min-height: 2rem;
  padding: 5px;
  border-radius: 10px;
  width: fit-content;
  margin: auto;
}
#message-bar > p {
  margin: 0;
  padding: 0;
  color: azure;
}
.message-text {
  background-color: green;
  color: antiquewhite;
}

</style>