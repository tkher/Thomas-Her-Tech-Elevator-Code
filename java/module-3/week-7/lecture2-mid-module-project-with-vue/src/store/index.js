import { createStore as _createStore } from 'vuex';

export function createStore() {
  return _createStore({
    state: {
      cart: new Map(),
      cartItemsRecentlyAdded: 0,
      searchText: '',
      messageText: '',
      allProducts: [
        {
          "productId": 1,
          "productSku": "MUG-023",
          "name": "Solar Geeks coffee mug",
          "description": "Start your day off right!",
          "price": 14.99,
          "imageName": "https://via.placeholder.com/350x250.jpg"
        },
        {
          "productId": 2,
          "productSku": "YET-001",
          "name": "Solar Geeks Yeti",
          "description": "Keep cool all day long.",
          "price": 21.99,
          "imageName": "https://via.placeholder.com/350x250.jpg"
        },
        {
          "productId": 3,
          "productSku": "ART-256",
          "name": "Galactic poster",
          "description": "Beautiful view of a galaxy",
          "price": 9.59,
          "imageName": "https://via.placeholder.com/350x250.jpg"
        },
        {
          "productId": 4,
          "productSku": "TOY-978",
          "name": "Toy rocket",
          "description": "To infinite imagination",
          "price": 39.99,
          "imageName": "https://via.placeholder.com/350x250.jpg"
        },
        {
          "productId": 5,
          "productSku": "EAT-235",
          "name": "Astronaut ice cream",
          "description": "As cold as space",
          "price": 5.79,
          "imageName": "https://via.placeholder.com/350x250.jpg"
        },
        {
          "productId": 6,
          "productSku": "HAT-928",
          "name": "Solar Geeks baseball cap",
          "description": "Look stylish with our logo",
          "price": 16.89,
          "imageName": "https://via.placeholder.com/350x250.jpg"
        },
        {
          "productId": 7,
          "productSku": "LIT-612",
          "name": "Intro to Astrophysics",
          "description": "Learn about astrophysics",
          "price": 7.99,
          "imageName": "https://via.placeholder.com/350x250.jpg"
        }
      ],
    },
    mutations: {
      SET_SEARCH_TEXT(state, text){
        state.searchText = text;
      },
      SET_MESSAGE_TEXT(state, text){
        state.messageText = text;
      },
      CLEAR_RECENT_CART_ITEMS(state){
        state.cartItemsRecentlyAdded = 0;
      },
      CLEAR_CART(state){
        state.cart = new Map();
      },
      ADD_PRODUCT_CART(state, newProduct){

        const cart = state.cart;
        const newProductId = newProduct.productId;
        const isProductInCart = cart.has(newProductId);

        if(isProductInCart){

          const productQuantity = cart.get(newProductId);
          cart.set(newProductId, productQuantity + 1);

        } else {
          cart.set(newProductId, 1);
        }

        state.cartItemsRecentlyAdded += 1;
      }
    },
    // store computed properties
    getters: {
      getFilteredProducts(state){
        return state.allProducts.filter(product => {
          return product.name.toLowerCase().includes(state.searchText.toLowerCase());
        });
      },
      isStoreEmpty(state){
        return state.cart.size === 0;
      },
      // TODO: Crazy Vue syntax :``(
      findProductById: (state) => (idToFind) => {
        return state.allProducts.find(eachProduct => eachProduct.productId === idToFind);
      }
    }
  })
}
