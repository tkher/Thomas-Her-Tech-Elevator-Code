<template>
  <div class="home">

  <header class="view-header">
    <h2>
      These are my bookmarks
      <loading-spinner id="spinner" v-bind:spin="isLoading" />
    </h2>
  </header>

    <!-- My Bookmarks table -->
    <bookmarks-table v-if="!isLoading" v-bind:bookmarkData="myBookmarks" v-bind:canAdd="false" />

  </div>
</template>

<script>
import LoadingSpinner from '../components/LoadingSpinner.vue';
import BookmarkService from '../services/BookmarkService';
import BookmarksTable from '../components/BookmarksTable.vue';

export default {
  components: { BookmarksTable, LoadingSpinner },
  data() {
    return {
      myBookmarks: null,
      isLoading: false
    }
  },
  methods: {
    getBookmarks(){

      this.isLoading = true;

      BookmarkService
        .getMyBookmarks()
        .then( (response) => {
          /*
           * At this point, everything is OK!
           */
          this.myBookmarks = response.data;
        })
        .catch( (error) => {
          window.alert(`ERROR: ${error}`);
        })
        .finally( () => {
          this.isLoading = false;
        })
    }
  },
  created(){
    this.getBookmarks()
  }
};
</script>

<style scoped>
.home{
  width: 100%;
}
</style>