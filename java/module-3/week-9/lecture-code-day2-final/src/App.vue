<template>
  <div id="book-app">

    <!-- TheHeader.vue -->
    <the-header />

    <!-- TheNavigation.vue -->
    <the-navigation />

    <!-- Bookmarks/profile/detail -->
    <main id="main-content">
      <router-view />
    </main>

    <!-- TheFooter.vue -->
    <the-footer />
    
  </div>
</template>

<script>
import TheHeader from './components/TheHeader.vue';
import TheFooter from './components/TheFooter.vue';
import TheNavigation from './components/TheNavigation.vue';

export default {
  components: {
    TheHeader,
    TheFooter,
    TheNavigation
  }

}

</script>

<style scoped>

</style>