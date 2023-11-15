<template>
  <!-- <div class="home"> -->
    <!-- Public bookmarks Header -->
    <header class="view-header">
      <h2>Public Bookmarks</h2>

      <div id="search-box">
        <input type="text" name="search-tb"
               id="search-tb" placeholder="Search..."
               v-model="searchText"/>
        <button class="icon-button" id="search-button">
          <i class="fa-solid fa-magnifying-glass" title="Search"></i>
        </button>
      </div>
    </header>

    <div id="message-bar" 
         v-bind:class="{'message-text': descriptionText}"
         v-on:click="onMessageTextClick">
      <p>{{ descriptionText }}</p>
    </div>

    <!-- Public bookmarks Table -->
    <div id="view-content">
      <table id="table-public-bookmarks">
        <thead>
          <tr>
            <th>Link</th>
            <th>Description</th>
            <th>Tags</th>
            <th>User</th>
            <th>&nbsp;</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="eachBookmark in filteredBookmarks"
              v-bind:key="eachBookmark.bookmarkId">
            <td>
              <a v-bind:href="eachBookmark.url" target="_blank">
                {{ eachBookmark.title }}
              </a>
            </td>
            <td v-on:click="onDescriptionClick(eachBookmark.description)">
              {{ eachBookmark.description }}
            </td>
            <td>{{ eachBookmark.allTags }}</td>
            <td><a href="#">{{ eachBookmark.userDisplayName }}</a></td>
            <td>
              <div class="icon-button" title="Reported as inappropriate">
                <i class="fa-solid fa-triangle-exclamation"></i>
              </div>
            </td>
          </tr>
        </tbody>
      </table>

      {{ bookmarks[0] }}
      <!-- {{ searchText }} -->

    </div>
  <!-- </div> -->
</template>

<script>
import BookmarkService from '../services/BookmarkService';

export default {
  components: {

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
    isLoggedIn() {
      return this.$store.state.token.length > 0;
    },
    filteredBookmarks(){
      //return this.bookmarks;
      return this.bookmarks.filter((eachBookmark) => {
        const title = eachBookmark.title.toLowerCase();
        const search = this.searchText.toLowerCase();

        return title.includes(search);
      });
    }
  },

  methods: {
    onDescriptionClick(bookmarkDescription){
      this.descriptionText = bookmarkDescription;
    },
    onMessageTextClick(){
      this.descriptionText = '';
    }
  },

  // When the page loads
  created() {

    BookmarkService
      .getBookmarks()
      .then( (response) => {
        /*
         * At this point, everything is OK!
         */
        this.bookmarks = response.data;
      })
      .catch( (error) => {
        window.alert(`ERROR: ${error}`);
      })
  },
};
</script>

<style scoped>

/* Message bar Styles */
#message-bar {
  min-height: 2rem;
  padding: 5px;
  border-radius: 10px;
}

#message-bar > p {
  margin: 0;
  padding: 0;
  color: azure;
}

.message-text {
  background-color: green;
  color: antiquewhite;
}

/* Public bookmarks Styles */
.view-header {
  display: flex;
  justify-content: space-between;
  align-items: flex-start;
  flex-wrap: wrap;
}

/* Public bookmarks Table Styles */
#table-public-bookmarks {
  width: 100%;
  border-collapse: collapse;
}

/* Search Box Styles */
#search-box {
  display: inline-block;
  border: 1px solid darkgray;
  border-radius: 10px;
}

#search-tb {
  border: none;
  padding: 5px;
  min-width: 200px;
  background-color: transparent;
}
#search-tb:focus-visible {
  outline: none;
}

#search-button {
  color: gray;
}
/* END Search Box Styles */



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
</style>