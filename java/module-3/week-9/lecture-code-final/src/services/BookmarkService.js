import axios from 'axios';

export default {

  getBookmarks() {
    return axios.get('/bookmarks/public');
  }

}
