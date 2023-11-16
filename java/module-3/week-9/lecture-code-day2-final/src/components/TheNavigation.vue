<template>
  <nav class="nav-list">

    <div class="nav-link">
      <router-link v-bind:to="{ name: 'profile' }">Profile</router-link>
    </div>

    <div class="nav-link">
      <router-link v-bind:to="{ name: 'my-bookmarks' }">My Bookmarks</router-link>
    </div>

    <div class="nav-link">
      <router-link v-bind:to="{ name: 'bookmarks' }">Public Bookmarks</router-link>
    </div>

    <div class="nav-link">
      <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token">Logout</router-link>
      <router-link v-bind:to="{ name: 'login' }" v-else>Login</router-link>
    </div>

  </nav>
</template>

<script>
export default {
  data() {
    return {

    }
  },
};
</script>

<style scoped>
/* Navigation Styles */
.nav-link .router-link-exact-active {
  background-color: rgba(136, 193, 231, 0.5);
  color: black;
  font-weight: bold;
}
</style>