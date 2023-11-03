<template>
  <!-- TODO: programmatic nav on article -->
  <article class="product-card" v-on:click="onProductClick($event)">
    <div class="sku">{{ product.productSku }}</div>
    <div class="price">${{ product.price }}</div>
    <div class="product-name">
      <span class="action" data-id="1" v-on:click="onDescriptionClick">{{ product.name }}</span>
    </div>
    <div class="product-image">
      <img src="https://via.placeholder.com/350x250.jpg">
    </div>
    <div class="cart">
      <font-awesome-icon class="icon action" v-on:click="onCartClick" icon="fa-solid fa-cart-plus" title="Add item to cart" />
    </div>
  </article>
</template>

<script>
export default {
  props: ['product'],
  data() {
    return {
      timeoutId: null
    }
  },
  methods: {
    // TODO: Programmatic navigation $router
    onProductClick(event) {

      const isIconOrDescriptionClicked = event.target.matches('path') || event.target.classList.contains('action');

      if (!isIconOrDescriptionClicked) {
        this.$router.push({ name: 'productDetail', params: { id: this.product.productId } });
      }
    },

    // TODO: Posting message
    onCartClick() {
      // TODO: Adding item to cart
      this.$store.commit('ADD_PRODUCT_CART', this.product);
      this.setMessageText(`${this.product.name} added to cart!`);
    },
    onDescriptionClick() {
      this.setMessageText(this.product.name)
    },
    setMessageText(text) {
      this.$store.commit('SET_MESSAGE_TEXT', text);

      if (this.timeoutId) {
        window.clearTimeout(this.timeoutId);
      }

      this.timeoutId = window.setTimeout(() => {
        this.$store.commit('SET_MESSAGE_TEXT', '');
      }, 3000);
    }
  }
};
</script>

<style scoped>
.product-card {
  display: grid;
  grid-template-rows: 25px 40px 165px 20px;
  grid-template-areas: "sku price"
    "name name"
    "img img"
    " . cart"
  ;
  grid-template-columns: 7fr 3fr;
  min-width: 250px;
  min-height: 250px;
  padding: 5px;
  background-color: rgba(255, 255, 255, 0.4);
  border: 1px solid rgb(91, 158, 247);
  border-radius: 10px;
  cursor: pointer;
}

.product-card:hover {
  box-shadow: 5px 5px 4px rgba(91, 158, 247, 0.6);
}

div.sku {
  grid-area: sku;
}

div.price {
  grid-area: price;
  text-align: right;
  font-weight: 600;
}

div.product-name {
  grid-area: name;
  overflow: hidden;
}

div.product-image {
  grid-area: img;
  padding: 5px;
  text-align: center;
}

div.product-image>img {
  max-width: 100%;
  max-height: 100%;
  border-radius: 5px;
}

div.cart {
  grid-area: cart;
  text-align: right;
}

.action {
  cursor: pointer;
}

.icon.action {
  font-size: 1.2em;
  color: #444;
}

.action:hover {
  color: blue;
  font-weight: bold;
}
</style>