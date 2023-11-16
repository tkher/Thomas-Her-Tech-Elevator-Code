<template>
    <article class="product-card">
            <div class="sku">{{product.productSku}}</div>
            <div class="price">{{product.price}}</div>
            <div class="product-name action" v-bind:data-id="{ product: product.productId}">{{product.name}}</div>
            <div class="product-image">
              <img v-bind:src ="{product: product.imageName}">
            </div>
            <div class="cart">
              <i class="fa-solid fa-cart-plus icon action" title="Add item to cart"></i>
            </div>
          </article>
</template>

<script>

export default {
    props: {
        product: Object,
        enableAdd: {
            type: Boolean,
            default: false
        }
        
    }
}
</script>
