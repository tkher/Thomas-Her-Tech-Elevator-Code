<template>
  <form id="frmAddNewUser" v-show="showForm" v-on:submit.prevent="saveUser">
    <div class="field">
      <label for="firstName">First Name:</label>
      <input type="text" id="firstName" name="firstName" v-model="newUser.firstName" />
    </div>
    <div class="field">
      <label for="lastName">Last Name:</label>
      <input type="text" id="lastName" name="lastName" v-model="newUser.lastName" />
    </div>
    <div class="field">
      <label for="username">Username:</label>
      <input type="text" id="username" name="username" v-model="newUser.username" />
    </div>
    <div class="field">
      <label for="emailAddress">Email Address:</label>
      <input type="text" id="emailAddress" name="emailAddress" v-model="newUser.emailAddress" />
    </div>
    <button type="submit" class="btn save">Save User</button>
  </form>
</template>

<script>
export default {
  props: ['showForm'],
  data() {
    return {
      newUser: {
        id: null,
        firstName: "",
        lastName: "",
        username: "",
        emailAddress: "",
        status: "Active"
      },
    }
  },
  methods: {
    getNextUserId() {
      /*
       * TODO: Find better way to do this
       */
      const nextId = this.$store.state.nextUserId;
      this.$store.commit('INCREMENT_NEXT_USER_ID');
      return nextId;
    },
    saveUser() {
      this.newUser.id = this.getNextUserId();
      this.$store.commit('ADD_USER', this.newUser);
      this.clearNewUser();
    },
    clearNewUser() {
      this.newUser = {
        id: null,
        firstName: "",
        lastName: "",
        username: "",
        emailAddress: "",
        status: "Active"
      };
    }
  }
}
</script>

<style scoped>
form {
  margin: 20px;
  width: 350px;
}
.field {
  padding: 10px 0px;
}
label {
  width: 140px;
  display: inline-block;
}
.btn.save {
  margin: 20px;
  float: right;
}
</style>