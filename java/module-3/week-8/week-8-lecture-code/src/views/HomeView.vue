<template>
  <div>
    <h1>
      Home Page
      <loading-spinner id="spinner" v-bind:spin="isLoading" />
    </h1>
    <h2>Response status: <span v-bind:class="{success: responseStatus == 200}">{{ responseStatus }} {{ errorMessage }}</span></h2>
    <ul id="products">
      <li v-for="eachProduct in allProducts" v-bind:key="eachProduct.id">
        {{ eachProduct.name }}
        <ul>
          <li v-for="(eachValue, eachProperty) in eachProduct" v-bind:key="eachProperty">
            {{ eachProperty }}: {{ eachValue }}
          </li>
        </ul>
      </li>
    </ul>
  </div>
</template>

<script>
import ProductService from '@/services/ProductService.js'
import LoadingSpinner from "@/components/LoadingSpinner.vue";

export default {
  components: { LoadingSpinner },
  data() {
    return {
      allProducts: null,
      responseStatus: null,
      errorMessage: null,
      isLoading: false, // true to indicate a call in progress
    }
  },
  created(){
    console.log('Start of created()')
    
    this.isLoading = true;
    this.errorMessage = null;

    ProductService.getAllProducts()
      .then(response => {

        // Update any local Data
        console.log('Received Data from API')
        this.allProducts = response.data;
        this.responseStatus = response.status;

        // *IF* needed...
        // Update any VueX data needed by other components
        // this.store.commit('SET_PRODUCTS', this.allProducts);
      })
      .catch(error => {
        this.responseStatus = error.response.status;
        this.errorMessage = error.response.statusText;
      })
      .finally(() => {
        this.isLoading = false;
      });

    console.log('End of created()')
  }
};
</script>

<style scoped>
span {
  color: red;
}

.success {
  color: lightgreen;
}

#products > li {
  padding-top: 10px;
}
</style>