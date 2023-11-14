<template>
  <div class="home">
    <div id="heading-line">
      <h1>
        Bookmarks
        <loading-spinner id="spinner" v-bind:spin="isLoading" />
      </h1>
    </div>

    <input type="checkbox" name="loading" id="loading" v-model="isLoading" /> Is Loading

    <font-awesome-icon
      v-bind:class="{ 'view-icon': true, active: cardView }"
      v-on:click="cardView = true"
      icon="fa-solid fa-grip"
      title="View tiles"
    />
    <font-awesome-icon
      v-bind:class="{ 'view-icon': true, active: !cardView }"
      v-on:click="cardView = false"
      icon="fa-solid fa-table"
      title="View table"
    />
  </div>
</template>

<script>
import LoadingSpinner from "../components/LoadingSpinner.vue";
export default {
  components: {
    LoadingSpinner,
  },
  data() {
    return {
      isLoading: false,
      cardView: true,
    };
  },

  computed: {
    isLoggedIn() {
      return this.$store.state.token.length > 0;
    },
  },

  methods: {},

  created() {},
};
</script>

<style scoped>
#spinner {
  color: green;
}

.view-icon {
  font-size: 1.2rem;
  margin-right: 7px;
  padding: 3px;
  color: #444;
  border-radius: 3px;
}

.view-icon.active {
  background-color: lightgreen;
}

.view-icon:not(.active) {
  font-size: 1.2rem;
  margin-right: 7px;
  cursor: pointer;
}

.view-icon:not(.active):hover {
  color: blue;
  background-color: rgba(255, 255, 255, 0.7);
}
</style>