import axios from 'axios';

export default {

  getBookmarks() {
    return axios.get('/bookmarks/public');
  },
  
  addNewBookmark(newBookmark){
    const newBookmarkDto = {
      "userId": newBookmark.userId,
      "title": newBookmark.title,
      "url": newBookmark.url,
      "description": newBookmark.description,
      "allTags": newBookmark.allTags,
      "public": newBookmark.public
    }

    return axios.post('/bookmarks', newBookmarkDto)
  },

  getMyBookmarks() {
    return axios.get('/bookmarks');
  },

  deleteBookmark(bookmarkId) {
    return axios.delete(`/bookmarks/${bookmarkId}`);
  },

}
