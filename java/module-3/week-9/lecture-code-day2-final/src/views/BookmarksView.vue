<template>
  <div class="home">

    <!-- Public bookmarks Header -->
    <header class="view-header">
      <h2>Public Bookmarks</h2>
      <search-bar />
    </header>

    <!-- Message Bar -->
    <bookmarks-menu-bar />

    <!-- Public bookmarks Table -->
    <bookmarks-table v-bind:bookmarkData="bookmarks" v-bind:canAdd="isLoggedIn" />

  </div>
</template>

<script>
import BookmarkService from "../services/BookmarkService";
import BookmarksTable from "../components/BookmarksTable.vue"
import BookmarksMenuBar from "../components/BookmarksMenuBar.vue";
import SearchBar from "../components/SearchBar.vue";

export default {
  components: {
    BookmarksTable, BookmarksMenuBar, SearchBar
  },
  data() {
    return {
      isLoading: false,
      cardView: true,
      bookmarks: [],
      searchText: '',
      descriptionText: ''
    };
  },

  computed: {

  },

  methods: {
    isLoggedIn() {
      return this.$store.state.token.length > 0;
    },
    onDescriptionClick(bookmarkDescription) {
      this.descriptionText = bookmarkDescription;
    },
    onMessageTextClick() {
      this.descriptionText = '';
    }
  },

  // When the page loads
  created() {

    BookmarkService
      .getBookmarks()
      .then((response) => {
        /*
         * At this point, everything is OK!
         */
        this.bookmarks = response.data;
      })
      .catch((error) => {
        window.alert(`ERROR: ${error}`);
      })
  },
};
</script>

<style scoped>

/* Public bookmarks Styles */
.view-header {
  display: flex;
  justify-content: space-between;
  align-items: flex-start;
  flex-wrap: wrap;
}


#spinner {
  color: green;
}


</style>