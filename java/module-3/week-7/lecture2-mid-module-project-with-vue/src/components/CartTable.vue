<template>
  <table>
    <thead>
      <tr>
        <th>Product</th>
        <th>Quantity</th>
      </tr>
    </thead>
    <tbody>
      <cart-table-row
        v-for="[eachCartProductId, quantity] in cart"
        v-bind:key="eachCartProductId"
        v-bind:productId="eachCartProductId"
        v-bind:quantity="quantity" />
    </tbody>
  </table>
</template>

<script>
import CartTableRow from './CartTableRow.vue';

export default {
  components: { CartTableRow },
  computed: {
    cart(){
      return this.$store.state.cart
    }
  }
};
</script>

<style scoped>
table {
  border: 1px solid black;
  min-width: 400px;
}
thead {
  background-color: lightgray;
}
</style>