<template>
  <div class="container">
    <user-table />
    <user-actions />
    <button v-on:click="showForm = !showForm">Add New User</button>
    <new-user-form v-bind:show-form="showForm" />
  </div>
</template>

<script>
import UserTable from "./UserTable.vue";
import UserActions from "./UserTableActions.vue";
import NewUserForm from "./NewUserForm.vue";

export default {
  components: {
    UserTable,
    UserActions,
    NewUserForm,
  },
  data() {
    return {
      showForm: false,
    };
  }
};
</script>

<style>
input,
select {
  font-size: 16px;
}
button {
  margin-right: 5px;
}
</style>
