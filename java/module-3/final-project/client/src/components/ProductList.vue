<template>
  <section>
    <h2>Products</h2>
    <div class="product-list">
      <Product-Card v-bind:productData="productList" />
    </div>
  </section>
</template>

<script>
import ProductCard from '../components/ProductCard.vue'
import ProductService from '../services/ProductService.js'

export default {
    data () {
        return{
            productList: []
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
    this.getProducts();
  }
  
    
}
</script>
