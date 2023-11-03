<template>
  <tr>
    <td>
      <p>
        {{ productData.name }}<span>${{ productData.price }}</span>
      </p>
    </td>
    <td>{{ quantity }}</td>
  </tr>
</template>

<script>
export default {
  props: ['productId', 'quantity'],
  computed: {
    productData(){
      return this.$store.state.allProducts.find( eachProduct => {
        return parseInt(this.productId) === eachProduct.productId;
      });
    }
  }
};
</script>

<style scoped>
p {
  margin: 0;
  display: flex;
  justify-content: space-between;
}

td:last-child{
  text-align: center;
}
</style>