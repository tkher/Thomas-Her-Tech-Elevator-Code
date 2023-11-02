<template>
  <nav>
    <div id="nav-left">
      <RouterLink v-bind:to="{name: 'home'}">Home</RouterLink>
      <RouterLink v-bind:to="{name: 'cart'}" class="cart-link">
        Cart
        <div v-show="recentItems !== 0" class="cart-badge">
          {{ recentItems }}
        </div>
      </RouterLink>
      <RouterLink v-bind:to="{name: 'products'}">Products</RouterLink>
    </div>
    <div id="message-bar" class="message">{{ $store.state.messageText }}</div>
    <div id="nav-right">
      <a href="#">Logout</a>
    </div>
  </nav>
</template>

<script>

export default {
  computed: {
    recentItems(){
      return this.$store.state.cartItemsRecentlyAdded;
    }
  }
};
</script>

<style scoped>
nav {
  background-color: rgb(91, 158, 247);
  grid-area: nav;
  display: flex;
  flex-direction: row;
  width: 100%;
  justify-content: space-between;
  align-content: center;
  border-top: 1px solid #777;
  border-bottom: 2px solid #777;
}

nav a {
  text-decoration: none;
  color: white;
  padding: 2px 3px;
}

#nav-left {
  display: flex;
}

#nav-left>a {
  margin-left: 20px;
}

#nav-right>a {
  margin-right: 20px;
}

nav>a:last-child {
  align-self: flex-end;
}

nav a.router-link-exact-active {
  color: var(--color-text);
}

nav a.router-link-exact-active:hover {
  background-color: transparent;
}

.cart-link{
  display: flex;
  align-items: center;
}

.cart-badge {
  font-size: 0.7rem;
  margin: 0 3px;
  padding: 3px;
  background-color: whitesmoke;
  color: blue;
  border-radius: 3px;
}
</style>