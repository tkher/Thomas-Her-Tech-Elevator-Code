//Doc services acts as the service to preform the get, post, put, delete request
//for this tutorial we are only preforming a get
//Doc services retrieves the list of documents from the web server api

import axios from 'axios';

const http = axios.create({
    baseURL: 'http://localhost:3000'
});

//step four - created docs service obj and export it
//once the get response is received, it is stored in the doc service and placed into this object. 
//axios return's a promise. 
export default {
    list() {
        return http.get('/docs');
    },


    get(id) {
        return http.get(`/docs/${id}`)
    }

}