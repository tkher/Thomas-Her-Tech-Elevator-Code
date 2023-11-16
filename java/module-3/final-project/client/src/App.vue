<template>
  <div id="cart-app">
    <header class="header">
      <header-logo></header-logo>
    </header>
    <nav class="navigation-bar">
        <router-link to="/" class='nav-button'> Home </router-link>
        <router-link to="/cart" class='nav-button'> Cart </router-link>
        <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token" class='nav-button'>
          Logout
        </router-link>
        <router-link v-bind:to="{ name: 'login' }" v-else class='nav-button'>Login</router-link>
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
  position: sticky;
  margin-left:auto;
  margin-right: auto;
  width: 50%;
}

.navigation-bar {
    /*grid-area: nav-bar;*/
    position: sticky;
    top:200px;
    display: flex;
    flex-direction: row;
    padding: 5px;
    margin: 5px;
    gap: 10px;
    border-top: solid;
    border-bottom: solid;
    background-color: white;
}

.nav-button{
    text-decoration: none;
    color:black;
    font-family: fantasy;
}

.nav-button:last-child {
    margin-left: auto;
}

</style>

