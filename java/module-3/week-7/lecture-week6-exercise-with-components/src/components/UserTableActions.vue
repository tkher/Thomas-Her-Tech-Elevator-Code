<template>
  <div class="all-actions">
    <button v-on:click="activateSelectedUsers()" v-bind:disabled="!actionButtonEnabled">Activate Users</button>
    <button v-on:click="deactivateSelectedUsers()" v-bind:disabled="!actionButtonEnabled">Deactivate Users</button>
    <button v-on:click="deleteSelectedUsers()" v-bind:disabled="!actionButtonEnabled">Delete Users</button>
  </div>
</template>

<script>
export default {
  methods: {
    actionButtonEnabled() {
      return this.$store.state.selectedUserIDs.length > 0;
    },
    activateSelectedUsers() {
      this.$store.commit('ACTIVATE_SELECTED_USERS');
    },
    deactivateSelectedUsers() {
      this.$store.commit('DEACTIVATE_SELECTED_USERS');
    },
    deleteSelectedUsers() {
      this.$store.commit('DELETE_SELECTED_USERS');
    },
  }
};
</script>

<style scoped>
.all-actions {
  margin-bottom: 40px;
}
</style>