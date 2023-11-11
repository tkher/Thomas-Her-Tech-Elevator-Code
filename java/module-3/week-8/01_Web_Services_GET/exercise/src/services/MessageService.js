import axios from 'axios';

const http = axios.create({
    baseURL: 'http://localhost:3000'
});

export default {
    getMessage(id) {
        return http.get(`/messages/${id}`)
    }
}