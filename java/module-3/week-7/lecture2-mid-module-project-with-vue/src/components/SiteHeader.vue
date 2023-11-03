<template>
  <header id="site-header">
    <div id="hero">
      <img id="logo-image" class="logo" alt="Vue logo" src="@/assets/logo.svg" width="125" height="125" />
    </div>
    <site-navigation />
  </header>
</template>

<script>
import SiteNavigation from './SiteNavigation.vue'

export default {
  name: 'SiteHeader',
  components: { SiteNavigation },
  data() {
    return {

    }
  },
};
</script>

<style scoped>
#site-header {
  grid-area: header;
  display: flex;
  flex-direction: column;
}

#hero {
  flex-grow: 1;
  display: flex;
  align-items: center;
  justify-content: center;
  background-color: #bbb;
  padding: 0 20px;
}

#logo-image{
  max-width: 200px;
}
</style>