<template>
  <section v-for="product in products"  v-bind:key="product.index">
    <div> {{product.name}} </div> 
  <!--<div class="sku">{{ product.productSku }}</div>
  <div class="price">{{ product.price }}</div>
  <div class="product-name action"
    v-bind:data-id="{ product: product.productId }"
  >
    {{ product.name }}
  </div>
  <div class="product-image">
    <img v-bind:src="{ product: product.imageName }" />
  </div>
  <div class="cart">
    <i class="fa-solid fa-cart-plus icon action" title="Add item to cart"></i>
  </div>-->
</template>

<script>


export default {
  props: {
    products:{
      type:Array,
    }
  },

  data() {
    return {
      productList: [], /* prob don't need*/
    }
  },
  
};
</script>
