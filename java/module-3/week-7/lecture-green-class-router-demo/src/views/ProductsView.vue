<template>
  <div>
    <h1>This is the products Views</h1>
    <product-card v-for="eachProduct in $store.state.allProducts"
                  v-bind:key="eachProduct.productId"
                  v-bind:product-data="eachProduct" />
  </div>
</template>

<script>
import ProductCard from '../components/ProductCard.vue'

export default {
  components: { ProductCard }
}
</script>
<style>
  
</style>