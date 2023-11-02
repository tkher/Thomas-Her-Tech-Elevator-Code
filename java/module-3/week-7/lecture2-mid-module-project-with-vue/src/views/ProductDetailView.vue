<template>
  <div>
    <ul>
      <li v-for="(value, key) in productData" v-bind:key="key">
        {{ key }} : {{ value }}
      </li>
    </ul>
    <div>
      <button v-on:click="onAddToCart">add to cart</button>
    </div>
  </div>
</template>

<script>
export default {
  computed: {
    productData() {
      // 1. Get the current product id from route
      const id = parseInt(this.$route.params.id);

      // 2. From the VueX store, get the product
      //    data using the product id
      return this.$store.state.allProducts.find((eachProduct) => {
        return eachProduct.productId === id;
      });
    }
  },
  methods: {
    onAddToCart(){
      this.$store.commit('ADD_PRODUCT_CART', this.productData);
      
      const message = `Added '${this.productData.name}' to cart!`;
      this.$store.commit('SET_MESSAGE_TEXT', message);

      window.setTimeout(() => {
        this.$store.commit('SET_MESSAGE_TEXT', '');
      }, 3000);
    }
  }
};
</script>

<style scoped></style>