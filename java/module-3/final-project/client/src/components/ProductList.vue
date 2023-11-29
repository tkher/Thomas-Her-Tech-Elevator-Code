<template>

    <div class="product-list">
      <Product-Card v-for='product of products' v-bind:key ="product.id" v-bind:product="product" />
    </div>

</template>

<script>
import ProductCard from '../components/ProductCard.vue'

export default {

    props: ['products'],
    components: {
        ProductCard
    },
    
}
</script>

<style scoped>



</style>