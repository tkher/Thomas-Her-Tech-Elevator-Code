<template>
  <section>
    <h2>Products</h2>
    <div class="product-list">
      <product-card v-bind:product="product" v-for="product in products"  v-bind:key="product.index"/>
    </div>
  </section>
</template>

<script>
import ProductCard from '../components/ProductCard.vue'
import ProductService from '../services/ProductService.js'

export default {
    data () {
        return{
            products: []
        }
        
    },
    methods: {
        getProducts() {
            ProductService.list().then(response => {
                this.products = response.data

      })
      .catch()
      .finally()
    }

    },
    components: {
        ProductCard
    },
    created() {
    this.getTopics();
  }
  
    
}
</script>
