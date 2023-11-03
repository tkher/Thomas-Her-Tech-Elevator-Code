<template>
  <div>
    <h1 v-if="$store.getters.isStoreEmpty">Your cart is empty</h1>
    <div v-else>
      <h1>Here is your cart:</h1>
      <cart-table />
      <h2>Total Cost: ${{ totalCost.toFixed(2) }}</h2>
      <button v-on:click="onCheckout">Check out</button>
    </div>
  </div>
</template>

<script>
import CartTable from '@/components/CartTable.vue';

export default {
  components: { CartTable },
  computed: {
    totalCost(){
      const cartArr = Array.from(this.$store.state.cart);

      return cartArr.reduce( (runningTotal, eachCartItem) => {

        // Destructure [key, value]
        const [productId, quantity] = eachCartItem;
        const productData = this.$store.getters.findProductById(productId);
        const totalProductCost = productData.price * quantity;
        return runningTotal + totalProductCost;

      }, 0);
    }
  },
  methods: {
    onCheckout(){
      this.$store.commit('CLEAR_CART');
      window.alert('Thank you for your business');
    }
  },
  created(){
    this.$store.commit('CLEAR_RECENT_CART_ITEMS');
  }
};
</script>

<style scoped>
</style>