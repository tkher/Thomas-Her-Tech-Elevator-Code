import axios from 'axios';

const http = axios.create({
    baseURL: 'http://localhost:9000'
});

export default {
    getProductList() {
        return http.get('/products');
    }
}