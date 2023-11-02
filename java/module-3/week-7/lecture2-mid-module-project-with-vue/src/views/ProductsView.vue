<template>
  <products-header />
  <section id="product-cards">
    <product-card 
      v-for="eachProduct in filteredProducts"
      v-bind:key="eachProduct.productId"
      v-bind:product="eachProduct" />
  </section>
</template>

<script>
import ProductsHeader from '../components/ProductsHeader.vue'
import ProductCard from '../components/ProductCard.vue'

export default {
  components: { ProductsHeader, ProductCard },
  computed: {
    filteredProducts(){
      return this.$store.getters.getFilteredProducts;
    }
  }
};
</script>

<style scoped>
#product-cards {
    display: flex;
    flex-wrap: wrap;
    gap: 12px 20px;
}
</style>