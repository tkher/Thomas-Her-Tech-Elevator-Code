<template>
  <div id="about-me-app">
    <nav>
      <router-link v-bind:to="{name: 'home'}">Home</router-link> |
      <router-link v-bind:to="{name: 'portfolio'}">Portfolio</router-link>
    </nav>
    <router-view />
  </div>
</template>

<style>
#about-me-app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

li {
  width: fit-content;
  margin: 0 auto;
}

nav {
  padding: 30px;
}

nav a {
  font-weight: bold;
  /* ??? */
}

/* nav a.????? {
  
} */
</style>
