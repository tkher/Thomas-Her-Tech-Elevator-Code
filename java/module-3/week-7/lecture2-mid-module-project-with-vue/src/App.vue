<template>
  <site-header />
  <main>
    <router-view />
  </main>
  <site-footer />
</template>

<script>
import SiteHeader from './components/SiteHeader.vue'
import SiteFooter from './components/SiteFooter.vue'

export default {
  components: { SiteHeader, SiteFooter }
}

</script>

<style>
#app {
  height: 100%;
  display: grid;
  grid-template-rows: auto 1fr 25px;
  grid-template-areas:
    "header"
    "main"
    "footer";
}

main {
  grid-area: main;
  padding: 5px 20px;
  background: linear-gradient(rgba(153, 238, 168, 0.3), rgba(91, 158, 247, 0.3));
  overflow: auto;
}
</style>
