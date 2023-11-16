<template>
  <div id="cart-app">
    <header class="header">
      <header-logo></header-logo>
    </header>
    <nav class="navigation-bar">
        <router-link to="/" class='nav-button'> Home </router-link>
        <router-link to="/cart" class='nav-button'> Cart </router-link>
        <a class='nav-button'> Message(to be replaced w/ v-show) </a>
        <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token" class='nav-button'>
          Logout
        </router-link>
        <router-link v-bind:to="{ name: 'login' }" v-else class='nav-button'>Login</router-link>
    </nav>
    <main>
      <router-view/>
    </main>
    <footer class="footer">
      <footer-data></footer-data>
    </footer>
  </div>
</template>

<script>
import HeaderLogo from './components/HeaderData.vue'
import FooterData from './components/FooterData.vue'

export default {
  components: {
    HeaderLogo,
    FooterData,
  },
};
</script>


<style scoped>
.header {
  display: block;
  position: sticky;
  margin-left:auto;
  margin-right: auto;
  width: 40%;
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

.nav-button:nth-last-child(2){
    flex-basis:50%;
    margin-left: 40%;
}

.footer{
    position: fixed;
    bottom: 0;
}
</style>

