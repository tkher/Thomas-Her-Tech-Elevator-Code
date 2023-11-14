import axios from "axios";

const http = axios.create({
  baseURL: 'http://localhost:3000'
});

export default {

  getAllProducts() {
    return http.get('/allProducts');
  },

  getProductById(id){
    console.log(`/allProducts/${id}`);
    return http.get(`/allProducts/${id}`);
  }

};