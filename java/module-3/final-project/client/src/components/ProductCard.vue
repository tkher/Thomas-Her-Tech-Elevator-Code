<template>
  <section id="product-cards">
    <article class="product-card">
      <div class="sku">{{ product.productSku }}</div>
      <div class="price">{{ product.price }}</div>
      <div class="product-name action"
        v-bind:data-id="{ product: product.productId }">
        {{ product.name }}
      </div>
      <div class="product-image">
        <img v-bind:src="{ product: product.imageName }" />
      </div>
      <div class="cart">
        <i class="fa-solid fa-cart-plus icon action" title="Add item to cart"></i>
      </div>
  
    </article>
  </section>
</template>

<script>


export default {
  props: 
    ['product'],

  data() {
    return {
      
    }
  },
  
};
</script>

<style scoped>
#product-cards {
    grid-area: product;
    display: flex;
    flex-wrap: wrap;
    justify-content: flex-start;
};

.product-card{
    width: 350px;
    display: grid;
    grid-template-columns: 1fr 1fr 1fr;
    grid-template-areas: 
        "sku            .               price"
        "product-name   product-name    . "
        "product-image  product-image   product-image"
        ".              .               cart";
    margin: 20px;
    padding: 10px; 
    border-style: solid;
    justify-items: start;
}

.product-card {
    width: 350px;
    display: grid;
    grid-template-columns: 1fr 1fr 1fr;
    grid-template-areas: 
        "sku            .               price"
        "product-name   product-name    . "
        "product-image  product-image   product-image"
        ".              .               cart";
    margin: 20px;
    padding: 10px; 
    border-style: solid;
    justify-items: start;
}

.sku {
    grid-area: sku;
}

.price {
    grid-area: price;
    justify-self: end;

}

.product-name {
    grid-area: product-name;
    font-size: 85%;
}

.product-image {
    grid-area: product-image;
    justify-self: center;
}

.product-image > img {
    width: 100%;
    height: 100%;
    border-radius: 50px;
}

.cart {
    grid-area: cart;
    justify-self: end;
    
}

</style>
