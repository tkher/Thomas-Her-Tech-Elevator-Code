<template>
  <div id="cart-app">
    <header class="header">
      <header-logo></header-logo>
    </header>
    <nav>
        <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token">
          Logout
        </router-link>
        <router-link v-bind:to="{ name: 'login' }" v-else>Login</router-link>
    </nav>
    <main>
      <router-view/>
    </main>
    <footer></footer>
  </div>
</template>

<script>
import HeaderLogo from './components/HeaderLogo.vue'

export default {
  components: {
    HeaderLogo,
  },
};
</script>


<style scoped>
.header {
  display: block;
  margin-left:auto;
  margin-right: auto;
  width: 50%;
}

</style>

