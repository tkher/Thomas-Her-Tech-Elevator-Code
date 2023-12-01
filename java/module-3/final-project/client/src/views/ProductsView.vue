<template>
  <div class="home">
    <div id="heading-line">

      <h1>
        <loading-spinner id="spinner" v-bind:spin="isLoading" />
      </h1>
      
    </div>
    <h2>Loading spinner demonstration</h2>
    <p>
      This is a demonstration of how you can show or hide a "spinner" icon to
      let the user know something is happening. Before calling an API, you'd set
      the data property <code>isLoading</code> to <code>true</code>. When the
      call completes, set it to <code>false</code>.
    </p>
    <p>
      For this demonstration, clicking the checkbox below sets
      <code>isLoading</code> to <code>true</code>, so it simulates what the user
      would see when your app is accessing an API.
    </p>
    <input type="checkbox" name="loading" id="loading" v-model="isLoading" /> Is
    Loading
    <p id="login-message" v-if="!isLoggedIn">
      Welcome! You may browse anonymously as much as you wish,<br />
      but you must
      <router-link v-bind:to="{ name: 'login' }">Login</router-link> to add
      items to your shopping cart.
    </p>
    <h2>Font-awesome demonstration</h2>
    <p>
      This code shows you how you can include Font-awesome icons on your page. Below are two icons: 
      one to indicate a "tile" view of products, and another to indicate a "table" view. There's also a little bit
      of styling to get you started, but you can style it your own way. And there's a property to track which view is "active".
    </p>
    
  </div>
  <div id="product-section">
    
    <header class="header-products">
      <h1 id="title-products">
          Products
      </h1>
    <section id='display-icons'>
    <font-awesome-icon
      v-bind:class="{ 'view-icon': true, active: cardView }"
      v-on:click="cardView = true"
      icon="fa-solid fa-grip"
      title="View tiles"
    />
    <font-awesome-icon
      v-bind:class="{ 'view-icon': true, active: !cardView }"
      v-on:click="cardView = false"
      icon="fa-solid fa-table"
      title="View table"
    />
    </section>
    <div id="search-button">
      <button>
        <input name='Search' type='text' placeholder="Try Searching Here..."/>
      </button>
    </div>    
    </header>
    <section>
      {{test}}
      Break
      <product-list v-bind:products="products" class="grid-container"/>
    </section>
  </div>
</template>

<script>
import LoadingSpinner from "../components/LoadingSpinner.vue";
import ProductList from '../components/ProductList.vue';
import ProductService from '../services/ProductService';





export default {
  components: {
    LoadingSpinner,
    ProductList,
  
    
   
    
  },
  data() {
    return {
      isLoading: false,
      cardView: true,
      test: '*** This Test Works',
      products: []
    };
  },

  computed: {
    isLoggedIn() {
      return this.$store.state.token.length > 0;
    },
  },

  methods: {
   
   
  },

  created() {
    this.isLoading = true;
    ProductService
      .getProductList()
      .then( (response) => {
        this.products = response.data
        this.isLoading = false;
      })
      .catch( (error) => {
        this.isLoading = false;
        window.alert(`ERROR: ${error}`);
      })
  },
};
</script>

<style scoped>
#spinner {
  color: green;
}

.view-icon {
  font-size: 1.2rem;
  margin-right: 7px;
  padding: 3px;
  color: #444;
  border-radius: 3px;
}

.view-icon.active {
  background-color: lightgreen;
}

.view-icon:not(.active) {
  font-size: 1.2rem;
  margin-right: 7px;
  cursor: pointer;
}

.view-icon:not(.active):hover {
  color: blue;
  background-color: rgba(255, 255, 255, 0.7);
}

/*added code*/
.grid-container {
    display: grid;
    grid-template-columns: 1fr 1fr 1fr 1fr;
    grid-template-areas:
        "product        product         product         product";
    }



.header-products{
  display: flex;
  margin: 15px;
  padding: 5px;
}

#title-products {
  color: blue;
  font-size: 40px;
  text-decoration: underline;
  font-weight: bolder;
  font-family: cursive;
}

#display-icons {
  flex-basis:auto;
  margin-left: 75%;
  margin-top: 2%;
  font-size: 50px;
}

#search-button {
  margin-top: 4%;
}

  

</style>