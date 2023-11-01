<template lang="">
  <div>
    <p>{{ propsData }}</p>
    <p>{{ productData }}</p>
  </div>
</template>

<script>
export default {
  props: ['prodData'],
  data(){
    return {
      productData: 'nothing yet :('
    }
  },
  // created() is called when this component loads
  created(){
    // If we can get the product id from the URL,
    // we can get the product information from the...
    // VueX Store

    const productId = parseInt(this.$route.params.id);
    const products = this.$store.state.allProducts;

    // Find product by product id...
    this.productData = products.find( (eachProduct) => {
      return eachProduct.productId === productId;
    });
  }
}
</script>
<style lang="">
  
</style>