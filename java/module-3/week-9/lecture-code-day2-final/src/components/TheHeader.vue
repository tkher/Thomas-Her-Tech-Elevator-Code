<template>
  <!-- Header -->
  <header id="app-header">
    <div id="app-info">
      <img class="app-logo" v-bind:src="getImageSrc" alt="app logo" />
      <h1>Bookmark Manager</h1>
    </div>
    <div id="user-info">
      <div id="user-logout">
        <div class="user-name">A. User</div>
        <a href="#">Logout</a>
      </div>
      <i class="img-profile fa-solid fa-user"></i>
    </div>
  </header>
</template>

<script>
export default {
  data() {
    return {

    }
  },
  computed: {
    getImageSrc() {
      const imgUrl = `/src/assets/images/logo.png`
      return new URL(imgUrl, import.meta.url);
    },
  }
};
</script>

<style scoped>
#app-header {
  display: grid;
  grid-template-columns: 3fr 50px minmax(150px, 1fr);
  grid-template-rows: 40px;
  background-color: rgb(136, 193, 231);
  padding: 5px;
}

#app-info {
  grid-column: 1 / 2;
  display: flex;
  align-items: center;
}

#user-info {
  display: flex;
  gap: 1rem;
  grid-column: 3 / 4;
  align-items: center;
  justify-content: flex-end;
  text-align: center;
}

#user-logout {
  display: flex;
  flex-flow: column nowrap;
  justify-content: center;
}

.user-name {
  margin-bottom: 0.25rem;
  font-size: 1.2rem;
}

.img-profile {
  height: 40px;
  margin-right: 1rem;
  border-radius: 50%;
}
</style>